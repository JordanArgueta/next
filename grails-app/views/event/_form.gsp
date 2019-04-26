<div class="form-group">
    <label><g:message code="event.name"/> *</label>
    <g:textField name="eventName" class="form-control" value="${event?.eventName}" placeholder="Please Enter Name of Event"/>
    <UIHelper:renderErrorMessage fieldName="eventName" model="${event}" errorMessage="please.enter.event.name"/>
</div>

<div class="form-group">
    <label><g:message code="event.desc"/></label>
    <g:textField name="eventDesc" class="form-control" value="${event?.eventDesc}" placeholder="Description"/>
</div>

<div class="form-group">
    <label><g:message code="event.address"/> *</label>
    <g:field type="address" name="address" class="form-control" value="${event?.address}" placeholder="Please Enter Address"/>
    <UIHelper:renderErrorMessage fieldName="address" model="${event}" errorMessage="Your Address is not Valid"/>
</div>
<div class="form-group">
    <label><g:message code="event.date"/> *</label>
    <g:field type="date" name="eventDate" class="form-control" value="${event?.date}" placeholder="Please Enter Date of Event"/>
</div>

