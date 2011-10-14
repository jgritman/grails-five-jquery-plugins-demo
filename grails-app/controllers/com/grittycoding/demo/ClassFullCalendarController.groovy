package com.grittycoding.demo

class ClassFullCalendarController {

    def index() { 

    }

    def events() {
		def results = Class.list();

    	render(contentType: "text/json") {
		    	events = array {
		            for (e in results) {
	    				def endDate = (e.startDate + e.course.days).format("yyyy-MM-dd'T'HH:mm:ss")
	    				def startDate = e.startDate.format("yyyy-MM-dd'T'HH:mm:ss")	 
		                event start : startDate,
		                	end: endDate,
		                	title: it.course.name,
							allDay:true			                	
		            }
		        }
    	}
    }
}
