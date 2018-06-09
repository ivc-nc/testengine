package testengine.interaction.verification

import groovy.util.logging.Slf4j
import testengine.interaction.sharedstate.SharedState

@Slf4j
class VerifyXml {

    public final static String XML_VERIFICATION = "XML VERIFICATION"
    public final static String FAILURE = "FAILURE"


    static def evaluateFieldHasValue(def field, def value, def data = SharedState.data) {

        //todo ensure xml data integrity

        def fields = data.'**'.findAll {
            it.name() == "${field}"
        }

        try {

            assert fields.any { it == value }
            log.info "${XML_VERIFICATION}: Found a field ${field} with value ${value}"

        } catch (AssertionError error) {

            log.error "${XML_VERIFICATION} ${FAILURE}: Does note exist: field ${field} with value ${value}"
            fields.each { it -> log.debug it as String}
            throw error

        }


    }


}
