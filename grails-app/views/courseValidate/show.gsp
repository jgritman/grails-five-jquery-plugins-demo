
<%@ page import="com.grittycoding.demo.Course" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'course.label', default: 'Course')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-course" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-course" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list course">
			
				<g:if test="${courseInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="course.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${courseInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${courseInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="property-label"><g:message code="course.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${courseInstance}" field="description"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${courseInstance?.basePrice}">
				<li class="fieldcontain">
					<span id="basePrice-label" class="property-label"><g:message code="course.basePrice.label" default="Base Price" /></span>
					
						<span class="property-value" aria-labelledby="basePrice-label"><g:fieldValue bean="${courseInstance}" field="basePrice"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${courseInstance?.days}">
				<li class="fieldcontain">
					<span id="days-label" class="property-label"><g:message code="course.days.label" default="Days" /></span>
					
						<span class="property-value" aria-labelledby="days-label"><g:fieldValue bean="${courseInstance}" field="days"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${courseInstance?.partner}">
				<li class="fieldcontain">
					<span id="partner-label" class="property-label"><g:message code="course.partner.label" default="Partner" /></span>
					
						<span class="property-value" aria-labelledby="partner-label"><g:link controller="partner" action="show" id="${courseInstance?.partner?.id}">${courseInstance?.partner?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${courseInstance?.classes}">
				<li class="fieldcontain">
					<span id="classes-label" class="property-label"><g:message code="course.classes.label" default="Classes" /></span>
					
						<g:each in="${courseInstance.classes}" var="c">
						<span class="property-value" aria-labelledby="classes-label"><g:link controller="class" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
		</div>
	</body>
</html>
