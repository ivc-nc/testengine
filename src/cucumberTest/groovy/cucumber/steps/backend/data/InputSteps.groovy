package cucumber.steps.backend.data

import testengine.application.logging.LogUtilities
import testengine.application.testdata.library.ReadFile
import testengine.interaction.sharedstate.SharedState

import static cucumber.api.groovy.EN.*

When(~/^I get the xml testdata from: (.*)$/) { def filename ->

    def xml = ReadFile.readXml(filename)
    SharedState.data = xml

}


When(~/^I get the json testdata from: (.*)$/) { def filename ->

    def json = ReadFile.readJson(filename)
    SharedState.data = json

}

Then(~/^I print testdata to the log$/) { ->

    LogUtilities.logSomething(SharedState.data.toString())

}


