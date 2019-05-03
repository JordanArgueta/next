package com.groupone.next

import grails.web.servlet.mvc.GrailsParameterMap

class FriendService {

    AuthenticationService authenticationService

    def save(Member member){
        Friend friend = new Friend ()
        friend.firstName = member.firstName
        friend.lastName = member.lastName
        friend.email = member.email
        def response = AppUtil.saveResponse(false, friend)
        if (friend.validate()){
            friend.save(flush: true)
            if(!friend.hasErrors()){
                response.isSuccess = true

            }

        }
        return response

    }

    def update(Friend friend, GrailsParameterMap params){
        friend.properties = params
        def response  = AppUtil.saveResponse(false, friend)
        if (friend.validate()){
            friend.save(flush: true)
            if(!friend.hasErrors()){
                response.isSuccess = true

            }

        }
        return response
    }

    def getById(Serializable id){
        return Friend.get(id)

    }

    def list(GrailsParameterMap params) {
        params.max = params.max ?: GlobalConfig.itemsPerPage()
        List<Friend> friendList = Friend.createCriteria().list(params) {
            if (params?.colName && params?.colValue) {
                like(params.colName, "%" + params.colValue + "%")
            }
            if (!params.sort) {
                order("id", "desc")
            }
        }
        return [list: friendList, count: Friend.count()]
    }
    def delete(Friend friend) {
        try {
            friend.delete(flush: true)
        } catch (Exception e) {
            println(e.getMessage())
            return false
        }
        return true
    }


}
