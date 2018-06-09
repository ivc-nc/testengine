package testengine.model.frontend.modules.generic

import geb.Module

class LoginModule extends Module {

    static url

    static content = {

        usernameInput (required: true) {
            $('input')

        }

        passwordInput(required: true) {
            $('password')

        }

        loginButton (required: true) {
            $('input[type=submit]')[0]
        }
    }
}
