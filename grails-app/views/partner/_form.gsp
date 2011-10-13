<%@ page import="com.grittycoding.demo.Partner" %>



<div class="fieldcontain ${hasErrors(bean: partnerInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="partner.name.label" default="Name" />
		
	</label>
	<g:textField name="name" maxlength="50" value="${partnerInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: partnerInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="partner.description.label" default="Description" />
		
	</label>
	<g:textArea name="description" cols="40" rows="5" maxlength="1000" value="${partnerInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: partnerInstance, field: 'website', 'error')} ">
	<label for="website">
		<g:message code="partner.website.label" default="Website" />
		
	</label>
	<g:field type="url" name="website" value="${partnerInstance?.website}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: partnerInstance, field: 'courses', 'error')} ">
	<label for="courses">
		<g:message code="partner.courses.label" default="Courses" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${partnerInstance?.courses?}" var="c">
    <li><g:link controller="course" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="course" action="create" params="['partner.id': partnerInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'course.label', default: 'Course')])}</g:link>
</li>
</ul>

</div>

