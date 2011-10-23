package com.grittycoding.demo

import grails.converters.*

class PartnerDynatreeController {

    def index() { }

    def treeData() {
    	def partners = Partner.createCriteria().list{
    		join 'courses.classes'
    	}
    	render partners.collect {
    		[title:it.name, children: coursesChildren(it)]
	    } as JSON    	
    }

    def coursesChildren(Partner partner) {
    	partner.courses.collect {
    		[title:it.name, children: classesChildren(it)]
    	}
    }

    def classesChildren(Course course) {
    	course.classes.collect {
    		[title: it.startDate.format('MM/dd/yyyy')]
    	}
    }
}
