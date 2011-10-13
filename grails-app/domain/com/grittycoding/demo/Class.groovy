package com.grittycoding.demo

class Class {

	Date startDate
	BigDecimal priceAdjustment
	Course course

    static constraints = {
    	priceAdjustment nullable:true
    }

    String toString() {
    	startDate.format('MM-dd-yyyy')
    }
}
