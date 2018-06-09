package cucumber.steps.backend

import groovy.json.JsonSlurper
import testengine.application.logging.LogUtilities
import testengine.interaction.sharedstate.SharedState
import static cucumber.api.groovy.EN.*


Then(~/^the response data contains: (.*)$/) { def statement ->

    def json = new JsonSlurper().parseText(SharedState.restResponseData)
    assert !(json.isEmpty())

    assert json.title.toString().contains(statement)

    LogUtilities.logSomething "found: ${statement}"

}
