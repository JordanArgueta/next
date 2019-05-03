<div class="form-group">
    <label><g:message code="friend.name"/> *</label>
    <g:textField name="name" class="form-control" value="${friend?.name}" placeholder="Please Enter Contact Name"/>
    <UIHelper:renderErrorMessage fieldName="name" model="${friend}" errorMessage="please.enter.name"/>
</div>

<div class="form-group">
    <label><g:message code="image"/></label>
    <g:field name="friendImage" class="form-control" type="file" placeholder="Please Upload Image"/>
    <g:if test="${friend?.image}">
        <img src="${resource(dir: "friend-image", file: "/${friend.id}-${friend.image}")}" class="img-thumbnail" style="margin-top: 10px; height: 100px; width: 100px;"/>
    </g:if>
</div>

