<div class="form-group">
    <label><g:message code="event.name"/></label>
    <g:textField name="eventName" class="form-control" value="${event?.eventName}" placeholder="Name of Event"/>
    <UIHelper:renderErrorMessage fieldName="eventName" model="${member}" errorMessage="please.enter.event.name"/>
</div>

<div class="form-group">
    <label><g:message code="event.desc"/></label>
    <g:textField name="eventDesc" class="form-control" value="${event?.eventDesc}" placeholder="Description"/>
    <UIHelper:renderErrorMessage fieldName="evenDesc" model="${event}" errorMessage="please.enter.event.desc"/>
</div>

<div class="form-group">
    <label><g:message code="event.address"/></label>
    <g:textField name="address" class="form-control" value="${event?.address}" placeholder="Address"/>
    <UIHelper:renderErrorMessage fieldName="address" model="${event}" errorMessage="please.enter.event.address"/>
</div>

<div class="form-group">
    <label><g:message code="event.date"/></label>
    <g:field type="date" name="date" class="form-control" value="${event?.date}"/>
</div>

<div class="form-group">
    <label><g:message code="event.time"/></label>
    <g:textField name="time" class="form-control" value="${event?.time}"/>
</div>

