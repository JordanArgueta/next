package com.groupone.next

class Event {
    Integer id
    String eventName
    String eventDesc
    String address
    String date
    String time


    static constraints = {
        eventName(nullable: false, unique: true)
        eventDesc(nullable: false, blank: false)
        address(blank: false)
    }

    def eventString() {
        return "Name: " + eventName + " Desc: " + eventDesc + " Address: " + address + " Date: " + date
    }


}
