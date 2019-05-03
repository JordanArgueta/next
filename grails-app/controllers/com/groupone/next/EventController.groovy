package com.groupone.next

import groovy.sql.Sql

class EventController {

    EventService eventService
    AuthenticationService authenticationService


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


    def register() {
        def id = authenticationService.getMember().getID()
        //def eveid = eventService.event.getID()

        def db = [url: 'jdbc:mysql://satoshi.cis.uncw.edu/eqa9745?useUnicode=yes&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC', user:'eqa9745', password: 'xbX4WnNh4', driver:'com.mysql.cj.jdbc.Driver']

        def sql = Sql.newInstance(db.url, db.user, db.password, db.driver)

        def q2 = "INSERT INTO `register`(memberID, eventID) VALUES(" + id + ",1)"
        def q = "SELECT * FROM `register` WHERE memberID = " + id


        sql.execute(q2)

        sql.eachRow(q) { row ->
            println(row)
        }
        sql.close()

        def response = eventService.list(params)
        [eventList: response.list, total:response.count]


    }
}
