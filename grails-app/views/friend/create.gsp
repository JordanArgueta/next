<%--
  Created by IntelliJ IDEA.
  User: j09ar
  Date: 5/3/2019
  Time: 2:45 AM
--%>

<div class="card">
    <div class="card-header">
        <g:message code="friend" args="['Create']"/>
    </div>
    <div class="card-body">
        <g:form controller="friend" action="create">

        %{--Partial Templating--}%
            <g:render template="form"/>
            <div class="form-action-panel">
                <g:submitButton class="btn btn-primary" name="save" value="${g.message(code: "save")}"/>
                <g:link controller="friend" action="index" class="btn btn-primary"><g:message code="cancel"/></g:link>
            </div>
        </g:form>
    </div>
</div>