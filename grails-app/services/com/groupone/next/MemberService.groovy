package com.groupone.next

import grails.gorm.transactions.Transactional
import grails.web.servlet.mvc.GrailsParameterMap

@Transactional
class MemberService {
    //Saves member to database
    def save(GrailsParameterMap params){
        Member member = new Member(params)
        def response = AppUtil.saveResponse(false, member)
        if (member.validate()){
            member.save(flush: true)
            if(!member.hasErrors()){
                response.isSuccess = true

            }

        }
        return response

    }
    //Updates member info based on user input
    def update(Member member, GrailsParameterMap params){
        member.properties = params
        def response  = AppUtil.saveResponse(false, member)
        if (member.validate()){
            member.save(flush: true)
            if(!member.hasErrors()){
                response.isSuccess = true

            }

        }
        return response
    }
    //Grabs userID
    def getById(Serializable id){
        return Member.get(id)

    }
    //creates a list of current members
    def list(GrailsParameterMap params) {
        params.max = params.max ?: GlobalConfig.itemsPerPage()
        List<Member> memberList = Member.createCriteria().list(params) {
            if (params?.colName && params?.colValue) {
                like(params.colName, "%" + params.colValue + "%")
            }
            if (!params.sort) {
                order("id", "desc")
            }
        }
        return [list: memberList, count: Member.count()]
    }
    //Deletes the current member from the site and database
    def delete(Member member) {
        try {
            member.delete(flush: true)
        } catch (Exception e) {
            println(e.getMessage())
            return false
        }
        return true
    }
}
