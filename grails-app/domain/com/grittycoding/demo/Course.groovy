package com.grittycoding.demo

class Course {

	String name 
	String description

	BigDecimal basePrice

	int length

	static belongsTo = Partner

	static hasMany = [classes:Class]

    static constraints = {
    }
}
