<%@ page import="com.grittycoding.demo.Partner" %>



<div class="fieldcontain ${hasErrors(bean: partnerInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="partner.name.label" default="Name" />
		
	</label>
	<g:textField name="name" maxlength="40" value="${partnerInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: partnerInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="partner.description.label" default="Description" />
		
	</label>
	<g:textArea name="description" cols="40" rows="5" maxlength="1000" value="${partnerInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: partnerInstance, field: 'courses', 'error')} ">
	<label for="courses">
		<g:message code="partner.courses.label" default="Courses" />
		
	</label>
	<g:select name="courses" from="${com.grittycoding.demo.Course.list()}" multiple="multiple" optionKey="id" size="5" value="${partnerInstance?.courses*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: partnerInstance, field: 'website', 'error')} ">
	<label for="website">
		<g:message code="partner.website.label" default="Website" />
		
	</label>
	<g:textField name="website" value="${partnerInstance?.website}"/>
</div>

