<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<title>Full Calendar demo with Grails</title>
	</head>
	<body>
		
		<h1>FullCalendar with drag and drop support</h1>

		<r:require module="fullcalendar"/>

		<r:script disposition="head">
		    $(function() {
				$.getJSON("${createLink(action:'events')}", function(events) {
			    	$('#calendar').fullCalendar({
			    		theme: true,
			    		editable: true,
			    		disableResizing: true,
			    		events: events,
			    		    eventDrop: function(event,dayDelta,minuteDelta,allDay,revertFunc) {
			    		    	$.post("${createLink(action:'updateEvent')}", {id:event.id,dateDiff:dayDelta}, function(data) {
			    		    		if (data != 'OK') {
			    		    			alert("An error has occured");
			    		    			revertFunc();
			    		    		}
			    		    	});

						    }
			    	});
				});
		    });
		</r:script>

		<div id="calendar"/>
	</body>
</html>

