package com.groupone.next

class RegisterController {

    RegisterService registerService
    def index() {
        def response = registerService.list(params)
        [memberList: response.list, total:response.count]
    }
    //Creates a new register
    def create() {
        [register: flash.redirectParams]
    }
}
