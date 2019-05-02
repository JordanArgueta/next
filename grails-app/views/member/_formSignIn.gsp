<div class="form-group">
    <label><g:message code="email.address"/> *</label>
    <g:field type="email" name="email" class="form-control" placeholder="Please Enter Email"/>
    <UIHelper:renderErrorMessage fieldName="email"  errorMessage="Your Email Address is not Valid / Already Exist in System"/>
</div>

<g:if test="${!edit}">
    <div class="form-group">
        <label><g:message code="password"/> *</label>
        <g:passwordField name="password" class="form-control"  placeholder="Please Enter Password"/>
        <UIHelper:renderErrorMessage fieldName="password"  errorMessage="Please Enter a Password."/>
    </div>
</g:if>