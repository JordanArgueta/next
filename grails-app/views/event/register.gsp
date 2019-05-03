<%--
  Created by IntelliJ IDEA.
  User: j09ar
  Date: 4/19/2019
  Time: 10:02 PM
--%>

%{--Include Main Layout--}%
<meta name="layout" content="main"/>

<div class="card">
   <h2> Successfully Registered</h2>
    </div>

%{--Table Panel--}%
<div class="card-body">
    <table class="table table-bordered">
        <thead class="thead-dark">
        <tr>
            <g:sortableColumn property="eventName" title="${g.message(code: "event.reg")}"/>



        </tr>
        </thead>
        <tbody>
        <g:each in="${eventList}" var="info">
            <tr>

                <td>${info?.eventName}</td>

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