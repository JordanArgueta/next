package com.groupone.next

class FriendController {

    FriendService friendService
    MemberService memberService

    def index() {
        def response = friendService.list(params)
        [friend: response.list, total:response.count]
    }

    def details(Integer id) {
        def response = friendService.get(id)
        if (!response){
            redirect(controller: "friend", action: "index")
        }else{
            [friend: response]
        }
    }

    def create() {
        [friend: flash.redirectParams]
    }

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
