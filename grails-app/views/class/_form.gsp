<%@ page import="com.grittycoding.demo.Class" %>



<div class="fieldcontain ${hasErrors(bean: classInstance, field: 'priceAdjustment', 'error')} required">
	<label for="priceAdjustment">
		<g:message code="class.priceAdjustment.label" default="Price Adjustment" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="priceAdjustment" required="" value="${fieldValue(bean: classInstance, field: 'priceAdjustment')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: classInstance, field: 'startDate', 'error')} required">
	<label for="startDate">
		<g:message code="class.startDate.label" default="Start Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="startDate" precision="day"  value="${classInstance?.startDate}"  />
</div>

