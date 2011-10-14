<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<title>Full Calendar demo with Grails</title>
	</head>
	<body>

		<r:require module="fullcalendar"/>

		<r:script disposition="head">
		    $(function() {
				$.getJSON("classFullCalendar/events", function(events) {
			    	$('#calendar').fullCalendar({
			    		theme: true,
			    		events: events
			    	});
				});
		    });
		</r:script>

		<div id="calendar"/>
	</body>
</html>

