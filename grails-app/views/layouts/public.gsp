<%--
  Created by IntelliJ IDEA.
  User: j09ar
  Date: 5/2/2019
  Time: 9:47 PM
--%>

<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="NEXT"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>

    <asset:stylesheet src="application.css"/>

    <g:layoutHead/>
</head>

<body>
<header>
    <nav class="navbar navbar-expand-lg navbar-dark fixed-top bg-dark rounded">
        <a class="navbar-brand" href="http://localhost:8080/">NEXT</a>
        <g:link controller="member" action="login" class="navbar-brand"><g:message code="login"/></g:link>
        <a class="navbar-brand" href="http://localhost:8080/member/create">Create a Profile</a>
        <g:link controller="member" action="logout" class="navbar-brand"><g:message code="logout"/></g:link>
        <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse"
                data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false"
                aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

    </nav>
</header>

<div class="container-fluid">
    <div class="row">
        <main role="main" class="col-sm-12 ml-sm-auto col-md-12 pt-3">
            <g:layoutBody/>
        </main>
    </div>
</div>

<asset:javascript src="application.js"/>

</body>
</html>
