package com.groupone.next

class Friend {

    Integer id
    String name
    String image
    Member member

    static constraints = {
        image(nullable: true, blank: true)
    }

    static mapping = {
        version(false)
        friendDetails(cascade: 'all-delete-orphan')
    }

}
