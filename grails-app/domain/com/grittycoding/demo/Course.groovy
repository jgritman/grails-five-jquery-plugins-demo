package com.grittycoding.demo

class Course {

	String name 
	String description

	BigDecimal basePrice

	int days

	static belongsTo = Partner

	static hasMany = [classes:Class]

    static constraints = {
    	name maxSize: 40
    	description maxSize: 1000
    	basePrice min: 0.0
    	days min: 1
    }
}
