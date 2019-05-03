package com.groupone.next

import grails.testing.web.interceptor.InterceptorUnitTest
import spock.lang.Specification

class RedirectInterceptorSpec extends Specification implements InterceptorUnitTest<RedirectInterceptor> {

    def setup() {
    }

    def cleanup() {

    }

    void "Test redirect interceptor matching"() {
        when:"A request matches the interceptor"
            withRequest(controller:"redirect")

        then:"The interceptor does match"
            interceptor.doesMatch()
    }
}
