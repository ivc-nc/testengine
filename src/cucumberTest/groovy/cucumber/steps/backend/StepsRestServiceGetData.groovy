package cucumber.steps.backend

import testengine.application.services.rest.RestService
import static cucumber.api.groovy.EN.*


Given(~/^I load the testdata via REST: (.*)$/) { def endpoint ->

    RestService.getFromService(endpoint)
}

Given(~/^I call: (.*)$/) { def endpoint ->

    RestService.getFromService(endpoint)
}

Given(~/^I call the service: (.*)$/) { String service ->

    //service defind as rest service via configuration properties file
    RestService.getFromConfiguratedService(service)

}

