package com.grittycoding.demo

class Partner {

	String name
	String description
	URL website

	static hasMany = [courses:Course]

    static constraints = {
    	name maxSize: 40
    	description maxSize: 1000
    }
}
