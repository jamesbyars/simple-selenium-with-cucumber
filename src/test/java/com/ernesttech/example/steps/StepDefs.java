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
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import static java.util.concurrent.TimeUnit.SECONDS;

public class StepDefs {

    private WebDriver webDriver;
    private WebElement webElement;

    @Before
    public void setup() {

        System.out.println("Setup");

        // Chrome
        System.setProperty("webdriver.chrome.driver", "chromedriver-osx");

        // Firefox
        System.setProperty("webdriver.gecko.driver", "geckodriver-osx");

        webDriver = new ChromeDriver();

        webElement = null;
    }

    @After
    public void tearDown() {
        System.out.println("Tear Down");

        if (null != webDriver) {
            webDriver.quit();
        }
    }

    @Given("^I am not logged in$")
    public void iAmNotLoggedIn() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^I am on the page with url \"([^\"]*)\"$")
    public void iAmOnThePageWithUrl(String url) throws Throwable {
        webDriver.navigate().to(url);
    }

    @When("^I get the \"([^\"]*)\" of the element with \"([^\"]*)\" \"([^\"]*)\"$")
    public void iGetTheOfTheElementWith(String elementAttribue, String htmlAttribute, String identifier) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        webElement = findElementBy(By.id(identifier), 20, 1);
    }

    @Then("^I should see the \"([^\"]*)\" \"([^\"]*)\"$")
    public void iShouldSeeThe(String arg1, String value) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
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
