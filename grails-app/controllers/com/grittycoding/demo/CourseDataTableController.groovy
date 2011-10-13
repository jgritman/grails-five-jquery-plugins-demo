package com.grittycoding.demo

class CourseDataTableController {

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        [courseInstanceList: Course.list(), courseInstanceTotal: Course.count()]
    }

}
