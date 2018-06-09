import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.firefox.FirefoxBinary
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxOptions
import org.openqa.selenium.remote.DesiredCapabilities

environments {
    chrome {
        driver = { new ChromeDriver() }
    }
    firefox {
        driver = { new FirefoxDriver() }
    }
    headless {
        driver = {
            FirefoxBinary firefoxBinary = new FirefoxBinary()
            firefoxBinary.addCommandLineOptions("--headless")
            FirefoxOptions firefoxOptions = new FirefoxOptions()
            firefoxOptions.setBinary(firefoxBinary)
            new FirefoxDriver(firefoxOptions)
        }
    }
    chromeNoWebSecurity {
        driver = {
            DesiredCapabilities capabilities = DesiredCapabilities.chrome()
            ChromeOptions options = new ChromeOptions()
            options.addArguments("--disable-web-security")
            options.addArguments("--allow-running-insecure-content")
            //capabilities.setCapability("chrome.binary","./src//lib//chromedriver")
            capabilities.setCapability(ChromeOptions.CAPABILITY, options)
            new ChromeDriver(capabilities)
        }
    }
}

baseUrl = "about:blank"
baseNavigatorWaiting = true
atCheckWaiting = true
reportsDir = "build/geb-reports"


waiting {
    timeout = 30

}
