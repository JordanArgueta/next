package com.groupone.next

class FriendController {

    FriendService friendService
    MemberService memberService

    def index() {
        def response = friendService.list(params)
        [friend: response.list, total:response.count]
    }
    //Returns details corresponding to friend
    def details(Integer id) {
        def response = friendService.get(id)
        if (!response){
            redirect(controller: "friend", action: "index")
        }else{
            [friend: response]
        }
    }
    //creates a new friend
    def create() {
        [friend: flash.redirectParams]
    }
    //saves a friend
    def save() {
        def response = friendService.save(params, request)
        if (response.isSuccess) {
            flash.message = AppUtil.infoMessage(g.message(code: "saved"))
            redirect(controller: "friend", action: "index")
        } else {
            flash.redirectParams = response.model
            flash.message = AppUtil.infoMessage(g.message(code: "unable.to.save"), false)
            redirect(controller: "friend", action: "create")
        }
    }
    //Edits a friend
    def edit(Integer id) {
        if (flash.redirectParams) {
            [friend: flash.redirectParams]
        } else {
            def response = friendService.get(id)
            if (!response) {
                flash.message = AppUtil.infoMessage(g.message(code: "invalid.entity"), false)
                redirect(controller: "friend", action: "index")
            } else {
                [friend: response]
            }
        }
    }
    //Updates a friend
    def update() {
        def response = friendService.get(params.id)
        if (!response){
            flash.message = AppUtil.infoMessage(g.message(code: "invalid.entity"), false)
            redirect(controller: "friend", action: "index")
        }else{
            response = friendService.update(response, params, request)
            if (!response.isSuccess){
                flash.redirectParams = response.model
                flash.message = AppUtil.infoMessage(g.message(code: "unable.to.update"), false)
                redirect(controller: "friend", action: "edit")
            }else{
                flash.message = AppUtil.infoMessage(g.message(code: "updated"))
                redirect(controller: "friend", action: "index")
            }
        }
    }
    //Delete a friend
    def delete(Integer id) {
        def response = friendService.get(id)
        if (!response){
            flash.message = AppUtil.infoMessage(g.message(code: "invalid.entity"), false)
            redirect(controller: "friend", action: "index")
        }else{
            response = friendService.delete(response)
            if (!response){
                flash.message = AppUtil.infoMessage(g.message(code: "unable.to.delete"), false)
            }else{
                flash.message = AppUtil.infoMessage(g.message(code: "deleted"))
            }
            redirect(controller: "friend", action: "index")
        }
    }
}
