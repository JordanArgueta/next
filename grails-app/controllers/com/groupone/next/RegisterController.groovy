package com.groupone.next

class RegisterController {

    RegisterService registerService
    def index() {
        def response = registerService.list(params)
        [memberList: response.list, total:response.count]
    }
    def create() {
        [register: flash.redirectParams]
    }
}
