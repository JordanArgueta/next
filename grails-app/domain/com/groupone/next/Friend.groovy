package com.groupone.next

class Friend {

    Integer id
    String firstName
    String lastName
    String email

    static constraints = {
        image(nullable: true, blank: true)
    }
    def getID() {
        return id
    }

}
