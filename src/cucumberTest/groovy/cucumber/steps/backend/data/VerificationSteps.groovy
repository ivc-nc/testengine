package cucumber.steps.backend.data

import testengine.interaction.verification.VerifyXml

import static cucumber.api.groovy.EN.*

Then(~/^the xml field (.*) exists with value (.*)$/) { def field, def value ->

    VerifyXml.evaluateFieldHasValue(field, value)

}

