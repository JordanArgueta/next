package com.groupone.next

class AuthenticationController {
    //All of the associated functionality with authenication on the site
    AuthenticationService authenticationService
    MemberService memberService
    //redirects user from login screen to login screen
    def login() {
        if (authenticationService.isAuthenticated()) {
            redirect(controller: "home", action: "index")
        }
    }

    //redirects user from login screen to home screen on successeful login
    def doLogin() {
        if (authenticationService.doLogin(params.email, params.password)) {
            redirect(controller: "home", action: "index")
        } else {
            flash.message = AppUtil.infoMessage("Email Address or Password not Valid.", false)
            redirect(controller: "authentication", action: "login")
        }
    }

    //on user logout the authentication is deactivated
    def logout() {
        session.invalidate()
        redirect(controller: "authentication", action: "login")
    }

    //Redirects to signup
    def signup() {
        [member: flash.redirectParams]
    }

    //Allows for registration of an event
    def doRegistration() {
        def response = memberService.save(params)
        if (response.isSuccess) {
            authenticationService.setMemberAuthorization(response.model)
            redirect(controller: "home", action: "index")
        } else {
            flash.redirectParams = response.model
            redirect(controller: "member", action: "create")
        }
    }

}
