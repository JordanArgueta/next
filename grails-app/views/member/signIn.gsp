<%--
  Created by IntelliJ IDEA.
  User: Dillon
  Date: 2019-05-02
  Time: 14:49
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<meta name="layout" content="main"/>

<div class="card">
    <div class="card-header">
        <g:message code="member" args="['Sign In']"/>
    </div>
    ${flash.message}
    <div class="card-body">


        <g:form controller="member" action="login">

        %{--Partial Templating--}%
            <g:render template="formSignIn"/>
            <div class="form-action-panel">
                <g:submitButton class="btn btn-primary" name="Login" value="${g.message(code: "login")}"/>
                <g:link controller="member" action="create" class="btn btn-primary"><g:message code="signUp"/></g:link>
            </div>
        </g:form>
    </div>
</div>