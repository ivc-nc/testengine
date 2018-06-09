package cucumber.hooks

import geb.Browser

import cucumber.api.groovy.EN
import cucumber.api.groovy.Hooks
import org.openqa.selenium.Dimension
import testengine.application.logging.LogUtilities
import testengine.interaction.sharedstate.SharedState

this.metaClass.mixin(Hooks)
this.metaClass.mixin(EN)


/**
 * These methods specify actions that are carried out prior to any scenario with the tag: @frontend.
 * Note that the browser session instance is reused.
 */
Before('@frontend') {

    // Start a new browser

    SharedState.browser = SharedState.browser ?: new Browser()
    SharedState.browser.driver.manage().window().setSize(new Dimension(1280,1000));


    // Log that this is a frontend scenario
    LogUtilities.newScenarioFrontend()

}

After('@frontend') {


}


