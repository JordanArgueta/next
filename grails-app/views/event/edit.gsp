<%--
  Created by IntelliJ IDEA.
  User: j09ar
  Date: 4/27/2019        println("yeet")
  Time: 9:18 PM
--%>

%{--Include Main Layout--}%
<meta name="layout" content="main"/>

<div class="card">
    <div class="card-header">
        <g:message code="event" args="['Update']"/>
    </div>
    <div class="card-body">
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