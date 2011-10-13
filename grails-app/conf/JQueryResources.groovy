modules = {

	application {
		resource url:'js/application.js'					
	}

	jqueryui {
		dependsOn 'jquery'
		resource url: 'js/jquery-ui-1.8.16.custom.min.js'
		resource url: 'css/south-street/jquery-ui-1.8.16.custom.css'
	}

	validation {
		dependsOn 'jquery'
		resource url: 'js/jquery.validate.js'
		resource url: 'js/jquery.formatCurrency-1.4.0.js'
		resource url: 'js/customValidations.js'
		resource url: 'css/validation.css'
	}

	datatables {
		dependsOn 'jqueryui'
		resource url: 'js/jquery.dataTables.js'
		resource url: 'css/demo_table_jui.css'
	}

	fullcalendar {
		dependsOn 'jqueryui'
		resource url: 'js/fullcalendar.js'
		resource url: 'css/fullcalendar.css'
		resource url: 'css/fullcalendar.print.css', attrs: [media: 'print']
	}

	dynatree {
		dependsOn 'jquery'
		resource url: 'js/jquery.dynatree.js'
		resource url: 'css/dynatree/skin/ui.dynatree.css'
	}

	bbq {
		dependsOn 'jquery'
		resource url: 'js/jquery.ba-bbq.min.js'
	}

}