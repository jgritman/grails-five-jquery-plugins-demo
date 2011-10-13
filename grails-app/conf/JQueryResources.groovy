modules = {

	application {
		resource url:'js/application.js'					
	}

	validation {
		dependsOn 'jquery'

		resource url: 'js/jquery.validate.js', disposition: 'head'
		resource url: 'js/jquery.formatCurrency-1.4.0.js', disposition: 'head'
		resource url: 'js/customValidations.js', disposition: 'head'
	}
}