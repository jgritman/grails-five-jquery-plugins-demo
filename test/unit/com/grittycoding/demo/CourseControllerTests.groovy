package com.grittycoding.demo



import org.junit.*
import grails.test.mixin.*
import javax.servlet.http.HttpServletResponse

@TestFor(CourseController)
@Mock(Course)
class CourseControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/course/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.courseInstanceList.size() == 0
        assert model.courseInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.courseInstance != null
    }

    void testSave() {
        controller.save()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.save()

        assert model.courseInstance != null
        assert view == '/course/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/course/show/1'
        assert controller.flash.message != null
        assert Course.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/course/list'


        populateValidParams(params)
        def course = new Course(params)

        assert course.save() != null

        params.id = course.id

        def model = controller.show()

        assert model.courseInstance == course
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/course/list'


        populateValidParams(params)
        def course = new Course(params)

        assert course.save() != null

        params.id = course.id

        def model = controller.edit()

        assert model.courseInstance == course
    }

    void testUpdate() {

        controller.update()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/course/list'

        response.reset()


        populateValidParams(params)
        def course = new Course(params)

        assert course.save() != null

        // test invalid parameters in update
        params.id = course.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/course/edit"
        assert model.courseInstance != null

        course.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/course/show/$course.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        course.clearErrors()

        populateValidParams(params)
        params.id = course.id
        params.version = -1
        controller.update()

        assert view == "/course/edit"
        assert model.courseInstance != null
        assert model.courseInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/course/list'

        response.reset()

        populateValidParams(params)
        def course = new Course(params)

        assert course.save() != null
        assert Course.count() == 1

        params.id = course.id

        controller.delete()

        assert Course.count() == 0
        assert Course.get(course.id) == null
        assert response.redirectedUrl == '/course/list'
    }
}
