<%--
  Created by IntelliJ IDEA.
  User: j09ar
  Date: 4/19/2019
  Time: 10:02 PM
--%>

%{--Include Main Layout--}%
<meta name="layout" content="main"/>

<div class="card">
   <h2> Successfully Registered</h2>
    </div>


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
        <g:form controller="event" action="update">
            <g:hiddenField name="id" value="${event.id}"/>
            <g:render template="form" model="[edit:'yes']"/>
            <div class="form-action-panel">
                <g:submitButton class="btn btn-primary" name="update" value="${g.message(code: "update")}"/>
                <g:link controller="event" action="index" class="btn btn-primary"><g:message code="cancel"/></g:link>
            </div>
        </g:form>

    </div>
</div>







