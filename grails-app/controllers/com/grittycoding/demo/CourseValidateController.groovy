package com.grittycoding.demo

import org.springframework.dao.DataIntegrityViolationException
import java.text.NumberFormat

class CourseValidateController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "create", params: params)
    }

    def create() {
        [courseInstance: new Course(params),partnerList:Partner.list()]
    }

    def save() {
        params.basePrice = NumberFormat.getCurrencyInstance(Locale.US).parse(params.basePrice)
        def courseInstance = new Course(params)
        if (!courseInstance.save(flush: true)) {
            render(view: "create", model: [courseInstance: courseInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'course.label', default: 'Course'), courseInstance.id])
        redirect(action: "show", id: courseInstance.id)
    }

    def show() {
        [courseInstance: Course.get(params.id)]
    }


}
