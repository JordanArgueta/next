package com.groupone.next

class UIHelperTagLib {
    static namespace = "UIHelper"

    AuthenticationService authenticationService

    def renderErrorMessage = { attrs, body ->
        def model = attrs.model
        String fieldName = attrs.fieldName
        String errorMessage = attrs.errorMessage? g.message(code: attrs.errorMessage): g.message(code: "invalid.input")
        if (model && model.errors && model.errors.getFieldError(fieldName)){
            out << "<small class='form-text text-danger''><strong>${errorMessage}</strong></small>"
        }
    }

    def memberActionMenu = { attrs, body ->
        out << '<li class="nav-item dropdown show">'
        def name = authenticationService.getMember()
        if (name != null) {
            out << g.link(class: "nav-link dropdown-toggle", "data-toggle": "dropdown") {
                    authenticationService.getMemberName()
            }
            out << '<div class="dropdown-menu">'
            out << g.link(controller: "authentication", action: "logout", class: "dropdown-item") {
                g.message(code: "logout")
            }
            out << g.link(controller: "event", action: "register", class: "dropdown-item") {
                g.message(code: "Registered Events")
            }
            out << "</div></li>"
        }
    }

    def memberName = { attrs, body ->
        def name = authenticationService.getMember()
        if (name != null) {
            out << authenticationService.getMemberName()
        }
    }


}
