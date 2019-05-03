package com.groupone.next

import grails.web.servlet.mvc.GrailsParameterMap
import javax.servlet.http.HttpServletRequest

class FriendService {

    AuthenticationService authenticationService


    def save(GrailsParameterMap params, HttpServletRequest request) {
        Friend friend = new Friend(params)
        friend.member = authenticationService.getMember()
        def response = AppUtil.saveResponse(false, friend)
        if (friend.validate()) {
            friend.save(flush: true)
        }
        return response
    }


    def get(Serializable id) {
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
            eq("member", authenticationService.getMember())
        }
        return [list: friendList, count: friendList.totalCount]
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


    def uploadImage(Friend friend, HttpServletRequest request){
        if (request.getFile("friendImage") && !request.getFile("friendImage").filename.equals("")){
            String image = FileUtil.uploadFriendImage(friend.id, request.getFile("friendImage"))
            if (!image.equals("")){
                friend.image = image
                friend.save(flush:true)
            }
        }
    }

}
