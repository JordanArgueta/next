<%--
  Created by IntelliJ IDEA.
  User: j09ar
  Date: 4/19/2019
  Time: 10:02 PM
--%>

%{--Include Main Layout--}%
<meta name="layout" content="main"/>

<div class="card">
    <div class="card-header">
        <g:message code="event" args="['Create']"/>
    </div>
    <div class="card-body">
        <g:form controller="event" action="save">

        %{--Partial Templating--}%
            <g:render template="form"/>
            <div class="form-action-panel">
                <g:submitButton class="btn btn-primary" name="save" value="${g.message(code: "save")}"/>
                <g:link controller="event" action="index" class="btn btn-primary"><g:message code="cancel"/></g:link>
            </div>
        </g:form>
    </div>
</div>