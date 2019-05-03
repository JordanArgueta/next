package com.groupone.next

class AuthenticationService {
    //Authorized is the single variable needed
    private static final String AUTHORIZED = "AUTHORIZED"
    //Gives member authorization on successful login
    def setMemberAuthorization(Member member) {
        def authorization = [isLoggedIn: true, member: member]
        AppUtil.getAppSession()[AUTHORIZED] = authorization
    }
    //searches database for username and password
    def doLogin(String email, String password){
        password = password.encodeAsMD5()
        Member member = Member.findByEmailAndPassword(email, password)
        if (member){
            setMemberAuthorization(member)
            return true
        }
        return false
    }
    //Sets authentication to true if usernae and passwrod can be found.
    boolean isAuthenticated(){
        def authorization = AppUtil.getAppSession()[AUTHORIZED]
        if (authorization && authorization.isLoggedIn){
            return true
        }
        return false
    }

    //grabs the instance of the member.
    def getMember(){
        def authorization = AppUtil.getAppSession()[AUTHORIZED]
        return authorization?.member
    }

    //grabs current user's name
    def getMemberName(){
        def member = getMember()
        return "${member.firstName} ${member.lastName}"
    }

}
