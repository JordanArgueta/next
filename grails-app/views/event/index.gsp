<%--
  Created by IntelliJ IDEA.
  User: j09ar
  Date: 4/19/2019
  Time: 10:29 PM
--%>

<meta name="layout" content="main"/>

<div class="card">
    <div class="card-header">
        <g:message code="event" args="['List Of']"/>

    </div>
    %{--Table Panel--}%
    <div class="card-body">
        <table class="table table-bordered">
            <thead class="thead-dark">
            <tr>
                <g:sortableColumn property="eventName" title="${g.message(code: "event.name")}"/>
                <g:sortableColumn property="eventDesc" title="${g.message(code: "event.desc")}"/>
                <g:sortableColumn property="address" title="${g.message(code: "event.address")}"/>
                <g:sortableColumn property="eventDate" title="${g.message(code: "event.date")}"/>
            </tr>
            </thead>
            <tbody>
            <g:each in="${eventList}" var="info">
                <tr>
                    <td>${info?.eventName}</td>
                    <td>${info?.eventDesc}</td>
                    <td>${info?.address}</td>
                    <td>${info?.eventDate}</td>
                </tr>
            </g:each>
            </tbody>
        </table>
    %{--Pagination Area--}%
    </div>
</div>