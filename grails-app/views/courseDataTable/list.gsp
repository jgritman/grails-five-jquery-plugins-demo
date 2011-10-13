
<%@ page import="com.grittycoding.demo.Course" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'course.label', default: 'Course')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>

		<r:require module="datatables"/>

		<r:script disposition="head">
		    $(function() {
		    	$('#listTable').dataTable({
		    	    "bJQueryUI": true
		    	});
		    });
		</r:script>
	</head>
	<body>
		<a href="#list-course" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-course" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table id="listTable">
				<thead>
					<tr>
					
						<th>${message(code: 'course.name.label', default: 'Name')}</th>
					
						<th>${message(code: 'course.description.label', default: 'Description')}</th>
					
						<th>${message(code: 'course.basePrice.label', default: 'Base Price')}</th>
					
						<th>${message(code: 'course.days.label', default: 'Days')}</th>
					
						<th><g:message code="course.partner.label" default="Partner" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${courseInstanceList}" status="i" var="courseInstance">
					<tr>
					
						<td>${fieldValue(bean: courseInstance, field: "name")}</td>
					
						<td>${fieldValue(bean: courseInstance, field: "description")}</td>
					
						<td>${fieldValue(bean: courseInstance, field: "basePrice")}</td>
					
						<td>${fieldValue(bean: courseInstance, field: "days")}</td>
					
						<td>${fieldValue(bean: courseInstance, field: "partner")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${courseInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
