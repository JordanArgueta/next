package com.groupone.next

import groovy.sql.Sql

class EventController {

    EventService eventService
    AuthenticationService authenticationService

    //
    def index() {
        def response = eventService.list(params)
        [eventList: response.list, total:response.count]
    }
    //Grabs the contents in the parameters and creates a new event object.
    def create() {
        [event: flash.redirectParams]
    }

    //brings index back up to edit an event
    def edit(Integer id) {
        println("EVENT ID " + id)
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

    // the action used for updating an event, redirects to edit page.
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

    // The action used to delete an event.
    def delete(Integer id) {
        def response = eventService.getById(id)
        if (!response){
            redirect(controller: "event", action: "index")
        }else{
            response = eventService.delete(response)
            redirect(controller: "event", action: "index")
        }
    }

    //The action used to save an event.
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
    //the action used to view all of the details of an event. This method pulls from the database where we stored user
    // data.
    def details(Integer id) {
        def response = eventService.getById(id)
        if (!response){
            redirect(controller: "event", action: "index")
        }else{
            println("REG ID " + id)
            def memid = authenticationService.getMember().getID()

            def db = [url: 'jdbc:mysql://satoshi.cis.uncw.edu/eqa9745?useUnicode=yes&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC', user:'eqa9745', password: 'xbX4WnNh4', driver:'com.mysql.cj.jdbc.Driver']

            def sql = Sql.newInstance(db.url, db.user, db.password, db.driver)

            //Hardcoded bs
            //def q2 = "INSERT INTO `register`(memberID, eventID) VALUES(" + id + ",1)"

            //Real Query
            def q2 = "INSERT INTO `register`(memberID, eventID) VALUES(" + memid + "," + id +")"
            def q = "SELECT * FROM `register` WHERE memberID = " + memid


            sql.execute(q2)

            sql.eachRow(q) { row ->
                println(row)
            }
            sql.close()


            [event: response]
        }
    }
    // Used to register a user to a specified event. Brings information from database about both the event and the member
    // to insert into another registered table.
    def register(Integer id1) {
        println("EVENT ID " + id1)
        if (flash.redirectParams) {
            [event: flash.redirectParams]
        } else {
            def response = eventService.getById(id1)
            if (!response) {
                redirect(controller: "event", action: "index")
            } else {
                println("REG ID " + eveid)
                def id = authenticationService.getMember().getID()

                def db = [url: 'jdbc:mysql://satoshi.cis.uncw.edu/eqa9745?useUnicode=yes&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC', user:'eqa9745', password: 'xbX4WnNh4', driver:'com.mysql.cj.jdbc.Driver']

                def sql = Sql.newInstance(db.url, db.user, db.password, db.driver)

                //Hardcoded bs
                //def q2 = "INSERT INTO `register`(memberID, eventID) VALUES(" + id + ",1)"

                //Real Query
                def q2 = "INSERT INTO `register`(memberID, eventID) VALUES(" + id + "," + eveid +")"
                def q = "SELECT * FROM `register` WHERE memberID = " + id


                sql.execute(q2)

                sql.eachRow(q) { row ->
                    println(row)
                }
                sql.close()

                [event: response]
            }
        }
    }

    def register1(Integer eveid) {
        println("REG ID " + eveid)
        def id = authenticationService.getMember().getID()

        def db = [url: 'jdbc:mysql://satoshi.cis.uncw.edu/eqa9745?useUnicode=yes&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC', user:'eqa9745', password: 'xbX4WnNh4', driver:'com.mysql.cj.jdbc.Driver']

        def sql = Sql.newInstance(db.url, db.user, db.password, db.driver)

        //Hardcoded bs
        //def q2 = "INSERT INTO `register`(memberID, eventID) VALUES(" + id + ",1)"

        //Real Query
        def q2 = "INSERT INTO `register`(memberID, eventID) VALUES(" + id + "," + eveid +")"
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
