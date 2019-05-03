<%--
  Created by IntelliJ IDEA.
  User: j09ar
  Date: 4/27/2019
  Time: 9:24 PM
--%>
%{--Include Main Layout--}%
<meta name="layout" content="main"/>

<div class="card">
    <div class="card-header">
        <g:message code="event" args="['Register']"/>
    </div>
    <div class="card-body">
    <g:form controller="event" action="register">
    <g:hiddenField name="id" value="${event.id}"/>
    </g:form>
        <g:if test="${event}">
            <table class="table">
                <tr>
                    <th class="text-right"><g:message code="event.name"/></th><td class="text-left">${event.eventName}</td>
                </tr>
                <tr>
                    <th class="text-right"><g:message code="event.desc"/></th><td class="text-left">${event.eventDesc}</td>
                </tr>
                <tr>
                    <th class="text-right"><g:message code="address"/></th><td class="text-left">${event.address}</td>
                </tr>
                <tr>
                    <th class="text-right"><g:message code="event.date"/></th><td class="text-left">${event.date}</td>
                </tr>
                <tr>
                    <th class="text-right"><g:message code="event.time"/></th><td class="text-left">${event.time}</td>
                </tr>
            </table>
        </g:if>
        <div class="form-action-panel">
            <g:link controller="event" action="index" class="btn btn-primary"><g:message code="cancel"/></g:link>
            <g:link controller="event" action="register" class="btn btn-primary"><g:message code="register"/></g:link>
        </div>
    </div>
</div>
