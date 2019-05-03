<div class="form-group">
    <label><g:message code="first.name"/></label>
    <g:textField name="firstName" class="form-control" value="${friend?.firstName}" placeholder="Enter First Name"/>
    <UIHelper:renderErrorMessage fieldName="firstName" model="${friend}" errorMessage="please.enter.first.name"/>
</div>

<div class="form-group">
    <label><g:message code="last.name"/></label>
    <g:textField name="lastName" class="form-control" value="${friend?.lastName}" placeholder="Enter Last Name"/>
    <UIHelper:renderErrorMessage fieldName="lastName" model="${friend}" errorMessage="please.enter.last.name"/>
</div>
