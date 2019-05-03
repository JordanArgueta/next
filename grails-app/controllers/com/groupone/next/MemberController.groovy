package com.groupone.next

class MemberController {


    MemberService memberService
    AuthenticationService authenticationService
    FriendService friendService

    def index() {
        def response = memberService.list(params)
        [memberList: response.list, total:response.count]
    }

    def friends() {
        def response = memberService.list(params)
        [memberList: response.list, total:response.count]
    }

    def details(Integer id) {
        def response = memberService.getById(id)
        if (!response){
            redirect(controller: "member", action: "index")
        }else{
            [member: response]
        }
    }
    def follow(Integer id) {
        def response = memberService.getById(id)
        Member member = response.get
        if (!response){
            redirect(controller: "member", action: "index")
        }else{
            [member: response]
        }
    }

    def create() {
        [member: flash.redirectParams]
    }

    def register() {
        //println(authenticationService.getMember())
        [member: flash.redirectParams]

    }

    def signIn() {
        [member: flash.message]

    }

    def login() {

        if (params.email == "admin@uncw.edu" && params.password == "pass") {
            flash.message = "Login succeeded"
            session.user = "admin"
            redirect(action: "index")
        }
        else {
            flash.message = "Login failed"
            redirect(action: "signIn")
        }

    }

    def logout() {
        session.user = null
        flash.message = "You have been logged out."
        redirect(action: "signIn")
    }


    def save() {
        def response = memberService.save(params)
        if (!response.isSuccess) {
            flash.redirectParams = response.model
            redirect(controller: "member", action: "create")
        }else{
            redirect(controller: "member", action: "index")
        }
    }


    def edit(Integer id) {
        if (flash.redirectParams) {
            [member: flash.redirectParams]
        } else {
            def response = memberService.getById(id)
            if (!response) {
                redirect(controller: "member", action: "index")
            } else {
                [member: response]
            }
        }
    }


    def update() {
        def response = memberService.getById(params.id)
        if (!response){

            redirect(controller: "member", action: "index")
        }else{
            response = memberService.update(response, params)
            if (!response.isSuccess){
                flash.redirectParams = response.model

                redirect(controller: "member", action: "edit")
            }else{

                redirect(controller: "member", action: "index")
            }
        }
    }

    def delete(Integer id) {
        def response = memberService.getById(id)
        if (!response){
            redirect(controller: "member", action: "index")
        }else{
            response = memberService.delete(response)
            redirect(controller: "member", action: "index")
        }
    }



}
