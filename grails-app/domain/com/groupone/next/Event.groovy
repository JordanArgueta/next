package com.groupone.next

class Event {
    //These are all attributes of a said event
    Integer id
    String eventName
    String eventDesc
    String address
    String date
    String time

    //There can't be events with the same name nor empty descriptions
    static constraints = {
        eventName(nullable: false, unique: true)
        eventDesc(nullable: false, blank: false)
        address(blank: false)
    }
    //Used to display event details
    def eventString() {
        return "Name: " + eventName + " Desc: " + eventDesc + " Address: " + address + " Date: " + date
    }

    //Used to identify a unique events and assign it to anyone who has registered.
    def getID(){
        return id
    }


}
