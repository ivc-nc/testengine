package testengine.application.cookies

import geb.Browser
import org.openqa.selenium.Cookie


/**
 * Read and set Cookies via GEB (WebDriver)
 *
 */
class CookieEngine {

    /**
     * Grab all the cookies from a browser in a certain state
     * @param browser - the geb browser instance from which to grab all cookies in 'current' condition
     * @return all the cookies for the current domain.
     */
    static Set<Cookie> grabCookies(Browser browser) {
        browser.driver.manage().getCookies()
    }

    /**
     * Delete all cookies in session
     */
    static void deleteAllCookies(Browser browser) {
        browser.driver.manage().deleteAllCookies()
    }

    /**
     * Set a cookie in the geb browser webdriver
     * @param browser - the geb browser instance in which to set a cookie
     */
    static void addCookie(Browser browser, String name, String value) {

        // Create the cookie
        Cookie ck = new Cookie(name, value)
        browser.driver.manage().addCookie(ck)

    }


    /**
     * Check that a cookie with a specific name is set in the passed en browser
     * @param browser - the geb browser instance from which to get a cookie with name
     * @param name - the name of the cookie that must exist
     */
    static void cookieWithNameExists(Browser browser, String name) {

        assert grabCookies(browser).any {
            it.name == name
        }

    }


}
