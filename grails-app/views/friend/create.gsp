<%--
  Created by IntelliJ IDEA.
  User: j09ar
  Date: 5/3/2019
  Time: 2:45 AM
--%>

<meta name="layout" content="main"/>
<div class="card">
    <div class="card-header">
        <g:message code="friend" args="['Create']"/>
    </div>
    <div class="card-body">
        <g:form controller="friend" action="save" enctype="multipart/form-data">
            <g:render template="form"/>
            <div class="form-action-panel">
                <g:submitButton class="btn btn-primary" name="login" value="${g.message(code: "save")}"/>
                <g:link controller="friend" action="index" class="btn btn-primary"><g:message code="cancel"/></g:link>
            </div>
        </g:form>
    </div>
</div>