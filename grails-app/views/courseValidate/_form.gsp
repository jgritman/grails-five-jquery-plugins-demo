<%@ page import="com.grittycoding.demo.Course" %>

<r:require module="validation"/>

<r:script disposition="head">
    $(function() {
    	$('form').validate();
    });
</r:script>

<div class="fieldcontain ${hasErrors(bean: courseInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="course.name.label" default="Name" />
		
	</label>
	<g:textField name="name" class="required" maxlength="50" value="${courseInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: courseInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="course.description.label" default="Description" />
		
	</label>
	<g:textArea name="description" cols="40" rows="5" maxlength="1000" value="${courseInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: courseInstance, field: 'basePrice', 'error')} required">
	<label for="basePrice">
		<g:message code="course.basePrice.label" default="Base Price" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="text" name="basePrice" class="required positiveMoney" value="${fieldValue(bean: courseInstance, field: 'basePrice')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: courseInstance, field: 'days', 'error')} required">
	<label for="days">
		<g:message code="course.days.label" default="Days" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="days" class="required" value="${fieldValue(bean: courseInstance, field: 'days')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: courseInstance, field: 'partner', 'error')} ">
	<label for="partner">
		<g:message code="course.partner.label" default="Partner" />
		
	</label>
	<g:select id="partner" name="partner.id" from="${com.grittycoding.demo.Partner.list()}" optionKey="id" value="${courseInstance?.partner?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: courseInstance, field: 'classes', 'error')} ">
	<label for="classes">
		<g:message code="course.classes.label" default="Classes" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${courseInstance?.classes?}" var="c">
    <li><g:link controller="class" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="class" action="create" params="['course.id': courseInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'class.label', default: 'Class')])}</g:link>
</li>
</ul>

</div>

