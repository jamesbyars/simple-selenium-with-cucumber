package com.ernesttech.example.steps;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StepDefs {

    private WebDriver webDriver = null;
    private WebElement webElement = null;

    @Before
    public void setup() {

        System.out.println("Setup");

        // Chrome
        System.setProperty("webdriver.chrome.driver", "chromedriver-osx");

        // Firefox
        System.setProperty("webdriver.gecko.driver", "geckodriver-osx");

        // PhantomJS
        System.setProperty("phantomjs.binary.path", "phantomjs-osx");
    }

    @After
    public void tearDown() {
        System.out.println("Tear Down");

        if (null != webDriver) {
            webDriver.quit();
        }

        webElement = null;
        webDriver = null;
    }

    @Given("^I am using chrome")
    public void iAmUsingChrome() {
        if (null != webDriver) {
            throw new RuntimeException("Driver already configured");
        }

        webDriver = new ChromeDriver();
    }

    @Given("^I am using firefox")
    public void iAmUsingFirefox() {
        if (null != webDriver) {
            throw new RuntimeException("Driver already configured");
        }

        webDriver = new FirefoxDriver();
    }

    @Given("^I am using phantom")
    public void iAmUsingPhantom() {
        if (null != webDriver) {
            throw new RuntimeException("Driver already configured");
        }

        webDriver = new PhantomJSDriver();
    }


    @Given("^I am not logged in$")
    public void iAmNotLoggedIn() throws Throwable {
        throw new PendingException();
    }

    @Given("^I am on the page with url \"([^\"]*)\"$")
    public void iAmOnThePageWithUrl(String url) throws Throwable {
        webDriver.navigate().to(url);
    }

    @When("^I get the element with id \"([^\"]*)\"$")
    public void iGetTheElementWithId(String elementId) throws Throwable {
        webElement = findElementBy(By.id(elementId), 1, 1);
    }

    @Then("^I should see the text \"([^\"]*)\"$")
    public void iShouldSeeTheText(String value) throws Throwable {
        assertThat(webElement.getText(), is(value));
    }


    private WebElement findElementBy(By by, int timeout, int pollingFrequency) {
        Wait<WebDriver> wait = new FluentWait<>(webDriver)
                .withTimeout(timeout, SECONDS)
                .pollingEvery(pollingFrequency, SECONDS)
                .ignoring(NoSuchElementException.class);

        return wait.until(driver -> driver.findElement(by));
    }


}
