package com.groupone.next

class EventController {

    EventService eventService

    def index() {
        def response = eventService.list(params)
        [eventList: response.list, total:response.count]
    }

    def create() {
        [event: flash.redirectParams]
    }


    def edit(Integer id) {
        if (flash.redirectParams) {
            [event: flash.redirectParams]
        } else {
            def response = eventService.getById(id)
            if (!response) {
                redirect(controller: "event", action: "index")
            } else {
                [event: response]
            }
        }
    }


    def update() {
        def response = eventService.getById(params.id)
        if (!response){

            redirect(controller: "event", action: "index")
        }else{
            response = eventService.update(response, params)
            if (!response.isSuccess){
                flash.redirectParams = response.model

                redirect(controller: "event", action: "edit")
            }else{

                redirect(controller: "event", action: "index")
            }
        }
    }

    def delete(Integer id) {
        def response = eventService.getById(id)
        if (!response){
            redirect(controller: "event", action: "index")
        }else{
            response = eventService.delete(response)
            redirect(controller: "event", action: "index")
        }
    }

    def save() {
        def response = eventService.save(params)
        println(params)
        if (!response.isSuccess) {
            flash.redirectParams = response.model
            redirect(controller: "event", action: "create")
        }else{
            redirect(controller: "event", action: "index")
        }
    }
}
