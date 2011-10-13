modules = {

	application {
		resource url:'js/application.js'					
	}

	validation {
		dependsOn 'jquery'
		resource url: 'js/jquery.validate.js'
		resource url: 'js/jquery.formatCurrency-1.4.0.js'
		resource url: 'js/customValidations.js'
		resource url: 'css/validation.css'
	}
}