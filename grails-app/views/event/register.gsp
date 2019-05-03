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
                <th class="action-row"><g:message code="action"/></th>


            </tr>
            </thead>
            <tbody>
            <g:each in="${eventList}" var="info">
                <tr>
                    <td>${info?.eventName}</td>
                    <td>${info?.eventDesc}</td>
                    <td>${info?.address}</td>
                    <td>${info?.date}</td>
                    <td>${info?.time}</td>
                    %{--Table Actions --}%
                    <td>
                        <div class="btn-group">
                            <g:link controller="event" action="details" class="btn btn-secondary" id="${info.id}"><i class="fas fa-eye"></i></g:link>
                            <g:link controller="event" action="edit" class="btn btn-secondary" id="${info.id}"><i class="fas fa-edit"></i></g:link>
                            <g:link controller="event" action="delete" id="${info.id}" class="btn btn-secondary delete-confirmation"><i class="fas fa-trash"></i></g:link>
                        </div>
                    </td>
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