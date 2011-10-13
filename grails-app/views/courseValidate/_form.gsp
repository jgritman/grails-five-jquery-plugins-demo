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
	<g:textField name="name" maxlength="40" value="${courseInstance?.name}"/>
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
	<g:field type="number" name="basePrice" class="required positiveMoney" value="${fieldValue(bean: courseInstance, field: 'basePrice')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: courseInstance, field: 'days', 'error')} required">
	<label for="days">
		<g:message code="course.days.label" default="Days" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="days" min="1" class="required" value="${fieldValue(bean: courseInstance, field: 'days')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: courseInstance, field: 'classes', 'error')} ">
	<label for="classes">
		<g:message code="course.classes.label" default="Classes" />
		
	</label>
	<g:select name="classes" from="${com.grittycoding.demo.Class.list()}" multiple="multiple" optionKey="id" size="5" value="${courseInstance?.classes*.id}" class="many-to-many"/>
</div>

