package com.grittycoding.demo



import org.junit.*
import grails.test.mixin.*
import javax.servlet.http.HttpServletResponse

@TestFor(ClassController)
@Mock(Class)
class ClassControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/class/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.classInstanceList.size() == 0
        assert model.classInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.classInstance != null
    }

    void testSave() {
        controller.save()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.save()

        assert model.classInstance != null
        assert view == '/class/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/class/show/1'
        assert controller.flash.message != null
        assert Class.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/class/list'


        populateValidParams(params)
        def class = new Class(params)

        assert class.save() != null

        params.id = class.id

        def model = controller.show()

        assert model.classInstance == class
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/class/list'


        populateValidParams(params)
        def class = new Class(params)

        assert class.save() != null

        params.id = class.id

        def model = controller.edit()

        assert model.classInstance == class
    }

    void testUpdate() {

        controller.update()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/class/list'

        response.reset()


        populateValidParams(params)
        def class = new Class(params)

        assert class.save() != null

        // test invalid parameters in update
        params.id = class.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/class/edit"
        assert model.classInstance != null

        class.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/class/show/$class.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        class.clearErrors()

        populateValidParams(params)
        params.id = class.id
        params.version = -1
        controller.update()

        assert view == "/class/edit"
        assert model.classInstance != null
        assert model.classInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/class/list'

        response.reset()

        populateValidParams(params)
        def class = new Class(params)

        assert class.save() != null
        assert Class.count() == 1

        params.id = class.id

        controller.delete()

        assert Class.count() == 0
        assert Class.get(class.id) == null
        assert response.redirectedUrl == '/class/list'
    }
}
