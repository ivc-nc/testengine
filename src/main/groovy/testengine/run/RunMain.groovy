package testengine.run

import groovy.util.logging.Slf4j

/**
 * If this should be changed to run as application, this would be the main class.
 * The main method is not used as such, since the Cucumber plugin handles running tests via gradle build.gradle
 */
@Slf4j
class RunMain {
    static main (args) {
        // application main class
        // println 'starting tests'
        log.info("Running application")

    }

}
