package com.grittycoding.demo



import org.junit.*
import grails.test.mixin.*
import javax.servlet.http.HttpServletResponse

@TestFor(PartnerController)
@Mock(Partner)
class PartnerControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/partner/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.partnerInstanceList.size() == 0
        assert model.partnerInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.partnerInstance != null
    }

    void testSave() {
        controller.save()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.save()

        assert model.partnerInstance != null
        assert view == '/partner/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/partner/show/1'
        assert controller.flash.message != null
        assert Partner.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/partner/list'


        populateValidParams(params)
        def partner = new Partner(params)

        assert partner.save() != null

        params.id = partner.id

        def model = controller.show()

        assert model.partnerInstance == partner
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/partner/list'


        populateValidParams(params)
        def partner = new Partner(params)

        assert partner.save() != null

        params.id = partner.id

        def model = controller.edit()

        assert model.partnerInstance == partner
    }

    void testUpdate() {

        controller.update()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/partner/list'

        response.reset()


        populateValidParams(params)
        def partner = new Partner(params)

        assert partner.save() != null

        // test invalid parameters in update
        params.id = partner.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/partner/edit"
        assert model.partnerInstance != null

        partner.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/partner/show/$partner.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        partner.clearErrors()

        populateValidParams(params)
        params.id = partner.id
        params.version = -1
        controller.update()

        assert view == "/partner/edit"
        assert model.partnerInstance != null
        assert model.partnerInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/partner/list'

        response.reset()

        populateValidParams(params)
        def partner = new Partner(params)

        assert partner.save() != null
        assert Partner.count() == 1

        params.id = partner.id

        controller.delete()

        assert Partner.count() == 0
        assert Partner.get(partner.id) == null
        assert response.redirectedUrl == '/partner/list'
    }
}
