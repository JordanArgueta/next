package com.groupone.next

import grails.gorm.transactions.Transactional
import grails.web.servlet.mvc.GrailsParameterMap

@Transactional
class RegisterService {

    def getById(Serializable id){
        return Register.get(id)

    }

    def list(GrailsParameterMap params) {
        params.max = params.max ?: GlobalConfig.itemsPerPage()
        List<Register> regList = Register.createCriteria().list(params) {
            if (params?.colName && params?.colValue) {
                like(params.colName, "%" + params.colValue + "%")
            }
            if (!params.sort) {
                order("id", "desc")
            }
        }
        return [list: regList, count: Register.count()]
    }

    def save(GrailsParameterMap params){
        Register register = new Register(params)
        println(register.eventString())
        def response = AppUtil.saveResponse(false, register)
        if (register.validate()){
            register.save(flush: true)
            if(!register.hasErrors()){
                response.isSuccess = true

            }

        }
        return response

    }
}
