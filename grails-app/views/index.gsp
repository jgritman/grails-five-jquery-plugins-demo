<!doctype html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Welcome to Grails</title>
		<style type="text/css" media="screen">

			#page-body {
				margin: 2em 1em 1.25em 18em;
			}

			h2 {
				margin-top: 1em;
				margin-bottom: 0.3em;
				font-size: 1em;
			}

			p {
				margin: 0.25em 0;
			}

			#controller-list ul {
				list-style-position: inside;
			}

			#controller-list li {
				list-style-position: inside;
				margin: 0.25em 0;
			}

			@media screen and (max-width: 480px) {
				#page-body {
					margin: 0 1em 1em;
				}

				#page-body h1 {
					margin-top: 0;
				}
			}
		</style>
	</head>
	<body>
		<a href="#page-body" class="skip"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div id="page-body" role="main">
			<h1>Five jQuery Plugins Demo App</h1>

			<div id="controller-list" role="navigation">
				<ul>
					<li class="controller"><g:link controller="class">Class Scaffold (no jQuery)</g:link></li>
					<li class="controller"><g:link controller="course">Course Scaffold (no jQuery)</g:link></li>
					<li class="controller"><g:link controller="partnerin">Partner Scaffold (no jQuery)</g:link></li>
					<li class="controller"><g:link controller="courseValidate">Insert Course with jQuery validator</g:link></li>
					<li class="controller"><g:link controller="courseDataTable">Course List with DataTables</g:link></li>		
					<li class="controller"><g:link controller="classFullCalendar">Class Calendar with FullCalendar</g:link></li>					
					<li class="controller"><g:link controller="partnerDynatree">Partner tree with Dynatree</g:link></li>										
				</ul>
			</div>
		</div>
	</body>
</html>
