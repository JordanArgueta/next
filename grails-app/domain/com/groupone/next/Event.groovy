package com.groupone.next

class Event {

    String eventName
    String eventDesc
    String address
    String date

    static constraints = {
    }

    def eventString() {
        return "Name: " + eventName + " Desc: " + eventDesc + " Address: " + address + " Date: " + date
    }


}
