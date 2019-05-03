<%--
  Created by IntelliJ IDEA.
  User: j09ar
  Date: 5/2/2019
  Time: 11:51 PM
--%>

<meta name="layout" content="public"/>

<div class="card">
    <div class="card-header">
        Member Registration
    </div>
    <div class="card-body">
        <g:form controller="authentication" action="doRegistration">
            <g:render template="/member/form"/>
            <g:submitButton name="signup" value="Sign-up" class="btn btn-primary"/>
            <g:link controller="authentication" action="login" class="btn btn-primary"><g:message code="back.to.login"/></g:link>
        </g:form>
    </div>
</div>
© 2019 NEXT, Inc.