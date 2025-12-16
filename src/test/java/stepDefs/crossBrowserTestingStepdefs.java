package stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class crossBrowserTestingStepdefs {

    WebDriver driver;

    @After
    public void teardown () {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("I use the browser {string}")
    public void iUseTheBrowser(String browser)  {
        switch (browser) {
            case "Chrome" -> driver = new ChromeDriver();
            case "Firefox" -> driver = new FirefoxDriver();
            case "Edge" -> driver = new EdgeDriver();
        }
    }

    @When("I search for {string} on the web page {string}")
    public void iSearchForOnTheWebPage(String searchText, String url) {
        driver.get(url);
        WebElement searchBox = waitForVisibility(driver, (By.id("searchbox_input")));
        searchBox.sendKeys(searchText + Keys.ENTER);
    }

    @And("I click on the first result")
    public void iClickOnTheFirstResult() {
        waitForVisibility(driver, (By.cssSelector("a[data-testid='result-title-a']"))).click();
    }

    @Then("I see a page with raincoats")
    public void iSeeAPageWithRaincoats() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        final String expectedTitle = "regn";

        wait.until((ExpectedCondition<Boolean>) webDriver -> {
            assert webDriver != null;
            return webDriver.getTitle().toLowerCase().contains(expectedTitle);
        });

        String pageTitle = driver.getTitle();
        assert pageTitle != null;
        assertTrue(pageTitle.toLowerCase().contains("regn"), "Page title does not match search input.");
    }

    private WebElement waitForVisibility (WebDriver driver, By locator) {
        WebDriverWait waitForVisibility = new WebDriverWait(driver, Duration.ofSeconds(4));
        return waitForVisibility.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

}
