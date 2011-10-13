package com.grittycoding.demo

class Course {

	String name 
	String description
	BigDecimal basePrice
	int days
	Partner partner

	static hasMany = [classes:Class]

    static constraints = {
    	name maxSize: 50,nullable:false
    	description maxSize: 1000
    	basePrice min: 0.0
    	days min: 1
    	partner nullable:true
    }

    String toString() {
    	name
    }
}
