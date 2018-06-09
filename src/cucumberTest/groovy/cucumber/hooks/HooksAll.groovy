package cucumber.hooks

import cucumber.api.Scenario
import cucumber.api.groovy.EN
import cucumber.api.groovy.Hooks
import testengine.application.logging.LogUtilities

this.metaClass.mixin(Hooks)
this.metaClass.mixin(EN)


/**
 * These methods specify actions that are carried out prior to any scenario!
 */
Before { Scenario scenario ->

    // Log the scenario start
    LogUtilities.newScenario(scenario)

}

After { Scenario scenario ->

    // Log the scenario end
    LogUtilities.afterScenario(scenario)

}