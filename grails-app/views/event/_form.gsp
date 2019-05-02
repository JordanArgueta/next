<div class="form-group">
    <label><g:message code="event.name"/></label>
    <g:textField name="eventName" class="form-control" value="${event?.eventName}" placeholder="Name of Event"/>
</div>
</div>

<div class="form-group">
    <label><g:message code="event.desc"/></label>
    <g:textField name="eventDesc" class="form-control" value="${event?.eventDesc}" placeholder="Description"/>
</div>

<div class="form-group">
    <label><g:message code="event.address"/></label>
    <g:textField name="address" class="form-control" value="${event?.address}" placeholder="Address"/>
</div>
</div>
<div class="form-group">
    <label><g:message code="event.date"/></label>
    <g:field type="date" name="date" class="form-control" value="${event?.date}"/>
</div>

<div class="form-group">
    <label><g:message code="event.time"/></label>
    <g:textField name="time" class="form-control" value="${event?.time}"/>
</div>

