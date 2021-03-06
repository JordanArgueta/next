package com.groupone.next

import grails.gorm.transactions.Transactional
import grails.web.servlet.mvc.GrailsParameterMap

@Transactional
class EventService {


    // Called whenever a new event is created
    def save(GrailsParameterMap params){
        Event event = new Event(params)
        println(event.eventString())
        def response = AppUtil.saveResponse(false, event)
        if (event.validate()){
            event.save(flush: true)
            if(!event.hasErrors()){
                response.isSuccess = true

            }

        }
        return response

    }

    //To show a list of the currently created events
    def list(GrailsParameterMap params) {
        params.max = params.max ?: GlobalConfig.itemsPerPage()
        List<Event> eventList = Event.createCriteria().list(params) {
            if (params?.colName && params?.colValue) {
                like(params.colName, "%" + params.colValue + "%")
            }
            if (!params.sort) {
                order("id", "desc")
            }
        }
        return [list: eventList, count: eventList.size()]
    }
    //To show a list of the currently created events
    def list2(GrailsParameterMap params) {
        params.max = params.max ?: GlobalConfig.itemsPerPage()
        List<Event> eventList = Event.createCriteria().list(params) {

            if (params?.colName && params?.colValue) {
                like(params.colName, "%" + params.colValue + "%")
            }
            if (!params.sort) {
                order("id", "desc")
            }
        }
        for(int i=0; i < eventList.size(); i++){
            if(eventList.get(i).getID() != 16)
                eventList.remove(i)
        }

        return [list: eventList, count: eventList.size()]
    }

    //Used to update any information about an event
    def update(Event event, GrailsParameterMap params){
        event.properties = params
        def response  = AppUtil.saveResponse(false, event)
        if (event.validate()){
            event.save(flush: true)
            if(!event.hasErrors()){
                response.isSuccess = true

            }

        }
        return response
    }

    //Used to delete an event entirely
    def delete(Event event) {
        try {
            event.delete(flush: true)
        } catch (Exception e) {
            println(e.getMessage())
            return false
        }
        return true
    }
    def getById(Serializable id){
        return Event.get(id)

    }


}
