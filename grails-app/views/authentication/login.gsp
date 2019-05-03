<%--
  Created by IntelliJ IDEA.
  User: j09ar
  Date: 5/2/2019
  Time: 9:55 PM
--%>

<meta name="layout" content="public"/>

<div id="global-wrapper">
    <div id="content-wrapper">
        <div class="container">
            <div class="row">
                <div class="col-sm-6 col-md-4 mx-auto">
                    <h1 class="text-center login-title">NEXT Sign-in</h1>
                    <div class="account-wall">
                        <g:form controller="authentication" action="doLogin" class="form-signin">
                            <g:textField name="email" class="form-control" placeholder="Email" required="required" />
                            <g:passwordField name="password" class="form-control" placeholder="Password" required="required" />
                            <g:submitButton class="btn btn-lg btn-primary btn-block" name="login" value="Login"/>
                            <g:link controller="member" action="create" class="btn btn-lg btn-primary btn-block">Member Sign-up</g:link>
                        </g:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>