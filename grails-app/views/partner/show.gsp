
<%@ page import="com.grittycoding.demo.Partner" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'partner.label', default: 'Partner')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-partner" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-partner" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list partner">
			
				<g:if test="${partnerInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="partner.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${partnerInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${partnerInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="property-label"><g:message code="partner.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${partnerInstance}" field="description"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${partnerInstance?.website}">
				<li class="fieldcontain">
					<span id="website-label" class="property-label"><g:message code="partner.website.label" default="Website" /></span>
					
						<span class="property-value" aria-labelledby="website-label"><g:fieldValue bean="${partnerInstance}" field="website"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${partnerInstance?.courses}">
				<li class="fieldcontain">
					<span id="courses-label" class="property-label"><g:message code="partner.courses.label" default="Courses" /></span>
					
						<g:each in="${partnerInstance.courses}" var="c">
						<span class="property-value" aria-labelledby="courses-label"><g:link controller="course" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${partnerInstance?.id}" />
					<g:link class="edit" action="edit" id="${partnerInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
