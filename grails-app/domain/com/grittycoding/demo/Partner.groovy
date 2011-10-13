package com.grittycoding.demo

class Partner {

	String name
	String description
	String website 
	static hasMany = [courses:Course]

    static constraints = {
    	name maxSize: 50, nullable:false
    	description maxSize: 1000
    	website url:true
    }

    String toString() {
    	name
    }
}
