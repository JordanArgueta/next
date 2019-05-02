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
        <span class = "float-right">
            %{--Search Panel --}%
            <div class="btn-group">
                <g:form controller="event" action="index" method="GET">
                    <div class="input-group" id="search-area">
                        <g:select name="colName" class="form-control" from="[eventName: 'Event Name', address: 'Address']" value="${params?.colName}" optionKey="key" optionValue="value"/>
                        <g:textField name="colValue" class="form-control" value="${params?.colValue}"/>
                        <span class="input-group-btn">
                            <button class="btn btn-default" type="submit">Search</button>
                        </span>
                    </div>
                </g:form>
            </div>

            %{--Create and Reload Panel--}%
            <div class="btn-group">
                <g:link controller="event" action="create" class="btn btn-success"><g:message code="create"/></g:link>
                <g:link controller="event" action="index" class="btn btn-primary"><g:message code="reload"/></g:link>
            </div>
        </span>

    </div>




    %{--Table Panel--}%
    <div class="card-body">
        <table class="table table-bordered">
            <thead class="thead-dark">
            <tr>
                <g:sortableColumn property="eventName" title="${g.message(code: "event.name")}"/>
                <g:sortableColumn property="eventDesc" title="${g.message(code: "event.desc")}"/>
                <g:sortableColumn property="address" title="${g.message(code: "event.address")}"/>
                <g:sortableColumn property="date" title="${g.message(code: "event.date")}"/>
                <g:sortableColumn property="time" title="${g.message(code: "event.time")}"/>


            </tr>
            </thead>
            <tbody>
            <g:each in="${eventList}" var="info">
                <tr>
                    <td> <a href="/member/register" class="btn btn-default" role="button">
                        ${info?.eventName}</a></td>
                    <td>${info?.eventDesc}</td>
                    <td>${info?.address}</td>
                    <td>${info?.date}</td>
                    <td>${info?.time}</td>
                </tr>
            </g:each>
            </tbody>
        </table>
    %{--Pagination Area--}%
    <div class="paginate">
        <g:paginate total="${total ?: 0}" />
    </div>
    </div>
</div>