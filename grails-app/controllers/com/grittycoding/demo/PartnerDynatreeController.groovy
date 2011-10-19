package com.grittycoding.demo

import grails.converters.*

class PartnerDynatreeController {

    def index() { }

    def treeData() {
    	render Partner.list().collect {
    		[title:it.name]
    	} as JSON
    }
}
