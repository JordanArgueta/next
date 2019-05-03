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

            </table>
        </g:if>
        <div class="form-action-panel">
            <g:link controller="event" action="index" class="btn btn-primary"><g:message code="cancel"/></g:link>
        </div>
    </div>
</div>
