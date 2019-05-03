<%--
  Created by IntelliJ IDEA.
  User: j09ar
  Date: 5/3/2019
  Time: 10:10 AM
--%>

<meta name="layout" content="main"/>

<div class="card">
    <div class="card-header">
        <g:message code="friend.details" args="['Details']"/>
    </div>
    <div class="card-body">
        <g:if test="${friend}">
            <table class="table">
                <tr>
                    <th class="text-right"><g:message code="first.name"/></th><td class="text-left">${friend.firstName}</td>
                </tr>
                <tr>
                    <th class="text-right"><g:message code="last.name"/></th><td class="text-left">${friend.lastName}</td>
                </tr>
                <tr>
                    <th class="text-right"><g:message code="email"/></th><td class="text-left">${member.email}</td>
                </tr>

            </table>
        </g:if>
        <div class="form-action-panel">
            <g:link controller="friend" action="delete" class="btn btn-primary"><g:message code="unfollow"/></g:link>
            <g:link controller="member" action="index" class="btn btn-primary"><g:message code="cancel"/></g:link>
        </div>
    </div>
</div>
