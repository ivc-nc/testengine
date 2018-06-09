package testengine.application.services.rest

import groovy.transform.ToString
import groovy.util.logging.Slf4j
import testengine.application.properties.PropertiesRead
import testengine.interaction.sharedstate.SharedState


@Slf4j
@ToString(includeNames = true, includePackage = false)
class RestService {

    static def getFromService(def endpoint, def input = "hello world") {

        log.info("HTTP request to: ${endpoint}")
        def data = new URL("${endpoint}").text
        SharedState.restResponseData = data
        data

    }

    static def getFromConfiguratedService(String service) {

        Properties properties = PropertiesRead.loadFromFile("restserviceStandard")
        String endpoint = "${properties.host}:${properties.port}/$service"

        getFromService(endpoint)

    }


}
