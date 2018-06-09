package cucumber.steps.frontend.navigate

import testengine.model.frontend.modules.generic.LoginModule
import testengine.application.logging.LogUtilities
import testengine.interaction.sharedstate.SharedState

import static cucumber.api.groovy.EN.*

Given(~/^I open a browser$/) { ->
    //handled by @frontend
}

Then(~/^navigate to (.*)$/) { String url ->

    SharedState.browser.go("http://${url}")

}

Then(~/^I am at the (.*)$/) { String page  ->

    LogUtilities.logSomething("web: opened ${page.toString()}")

}

When(~/^I log in with user (.*)$/) { String page ->

    SharedState.browser.module(LoginModule).loginButton.click()
    LogUtilities.logSomething('clicked log in')
}


