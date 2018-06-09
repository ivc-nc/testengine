package testengine.application.logging

import cucumber.api.Scenario
import groovy.util.logging.Slf4j


@Slf4j
class LogUtilities {

    /**
     * Log statement method run prior to each scenario
     * @param scenario
     */
    static void newScenario(Scenario scenario) {

        log.info "-----------------------------------------------------------------------------------"

        log.info "RUNNING SCENARIO: ${scenario.name}"
        log.info scenario.sourceTagNames.toString()

    }

    /**
     * Log statement method run after each scenario
     * @param scenario
     */
    static void afterScenario(Scenario scenario) {

        log.info("### Scenario status: ${scenario.status}")

        if (scenario.isFailed()) {

            log.error("### Scenario status: ${scenario.status}")

        }
    }

    /**
     * Log statement method run prior to each @frontend scenario
     * @param frontendScenario
     */
    static void newScenarioFrontend(Scenario frontendScenario) {

        log.info("Frontend scenario")

    }


    static void logSomething (String statement) {

        log.info(statement)

    }

}
