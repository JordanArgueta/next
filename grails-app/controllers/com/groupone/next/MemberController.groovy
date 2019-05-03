package com.groupone.next

class MemberController {
//This controller contains all of the associated functionality that the member class requires.

    MemberService memberService
    AuthenticationService authenticationService
    //
    def index() {
        def response = memberService.list(params)
        [memberList: response.list, total:response.count]
    }
    //Shows friends of user
    def friends() {
        def response = memberService.list(params)
        [memberList: response.list, total:response.count]
    }
    //Show details of user
    def details(Integer id) {
        def response = memberService.getById(id)
        if (!response){
            redirect(controller: "member", action: "index")
        }else{
            [member: response]
        }
    }

    //Grabs the contents in the parameters and creates a new member object.
    def create() {
        [member: flash.redirectParams]
    }
    //Registers a member for an event.
    def register() {
        //println(authenticationService.getMember())
        [member: flash.redirectParams]

    }
    //Signs the member into the site.
    def signIn() {
        [member: flash.message]

    }
    //Tests authentication for logging a member into the site.
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
    //Logs the member out of the site.
    def logout() {
        session.user = null
        flash.message = "You have been logged out."
        redirect(action: "signIn")
    }

    //The action used to save a member.
    def save() {
        def response = memberService.save(params)
        if (!response.isSuccess) {
            flash.redirectParams = response.model
            redirect(controller: "member", action: "create")
        }else{
            redirect(controller: "member", action: "index")
        }
    }

    //brings index back up to edit a member
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

    //the action used for updating a member, redirects to edit page.
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

    // The action used to delete a member.
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
