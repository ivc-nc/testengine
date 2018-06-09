package testengine.interaction.sharedstate

import testengine.application.properties.PropertiesRead


/**
 * Contains fields that are shared between step scripts during execution of scenarios.
 * Field values are set sequentially during a test run.
 */
class SharedState {

    // DB main connection
    public static def connection

    // GEB browser
    public static def browser

    // REST request response data
    public static def restResponseData

    // INPUT from project testdata
    public static def data


}
