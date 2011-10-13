<%@ page import="com.grittycoding.demo.Course" %>



<div class="fieldcontain ${hasErrors(bean: courseInstance, field: 'basePrice', 'error')} required">
	<label for="basePrice">
		<g:message code="course.basePrice.label" default="Base Price" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="basePrice" required="" value="${fieldValue(bean: courseInstance, field: 'basePrice')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: courseInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="course.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${courseInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: courseInstance, field: 'length', 'error')} required">
	<label for="length">
		<g:message code="course.length.label" default="Length" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="length" required="" value="${fieldValue(bean: courseInstance, field: 'length')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: courseInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="course.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${courseInstance?.name}"/>
</div>

