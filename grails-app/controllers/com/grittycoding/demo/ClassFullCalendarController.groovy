package com.grittycoding.demo

import grails.converters.*;

class ClassFullCalendarController {

    def index() { 
    }

    def events() {
	    render Class.list().collect {
	    				def startDate = it.startDate.format("yyyy-MM-dd'T'HH:mm:ss")
	    				def endDate = (it.startDate + it.course.days - 1).format("yyyy-MM-dd'T'HH:mm:ss")
		                [ start : startDate,
		                	end: endDate,
		                	title: it.course.name,
							allDay:true]
		} as JSON
    }
}
