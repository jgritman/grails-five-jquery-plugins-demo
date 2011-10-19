modules = {

	application {
		resource url:'js/application.js', disposition: 'head'
	}

	jqueryui {
		dependsOn 'jquery'
		resource url: 'js/jquery-ui-1.8.16.custom.min.js', disposition: 'head'
		resource url: 'css/south-street/jquery-ui-1.8.16.custom.css'
	}

	validation {
		dependsOn 'jquery'
		resource url: 'js/jquery.validate.js', disposition: 'head'
		resource url: 'js/jquery.formatCurrency-1.4.0.js', disposition: 'head'
		resource url: 'js/customValidations.js', disposition: 'head'
		resource url: 'css/validation.css'
	}

	datatables {
		dependsOn 'jqueryui'
		resource url: 'js/jquery.dataTables.js', disposition: 'head'
		resource url: 'css/demo_table_jui.css'
	}

	fullcalendar {
		dependsOn 'jqueryui'
		resource url: 'js/fullcalendar.js', disposition: 'head'
		resource url: 'css/fullcalendar.css'
		resource url: 'css/fullcalendar.print.css', attrs: [media: 'print']
	}

	dynatree {
		dependsOn 'jqueryui'
		resource url: 'js/jquery.dynatree.js', disposition: 'head'
		resource url: 'css/dynatree/skin/ui.dynatree.css'
	}

	bbq {
		dependsOn 'jquery'
		resource url: 'js/jquery.ba-bbq.min.js', disposition: 'head'
	}

}