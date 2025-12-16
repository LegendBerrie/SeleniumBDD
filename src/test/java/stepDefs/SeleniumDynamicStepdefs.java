package stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SeleniumDynamicStepdefs {

    WebDriver driver;

    @After
    public void teardown () {
        if (driver != null) driver.quit();
    }

    @Given("I open the web page {string}")
    public void iOpenTheWebPage(String url) {
        driver = new ChromeDriver();
        driver.get(url);
    }

    @When("I click on {string}")
    public void iClickOn(String buttonText) {
        driver.findElement(By.cssSelector("input[value='" + buttonText + "']")).click();
    }

    @Then("A box appears")
    public void aBoxAppears() {
        WebElement box = waitForPresence(driver, (By.id("box0")));
        assertTrue(box.isDisplayed());
    }

    @Then("A new inputbox appears")
    public void aNewInputboxAppears() {
        WebElement inputBox = waitForVisibility(driver, By.id("revealed"));
        assertTrue(inputBox.isDisplayed());
    }

    private WebElement waitForVisibility(WebDriver driver, By locator) {
        WebDriverWait waitFor = new WebDriverWait(driver, Duration.ofSeconds(5));
        return waitFor.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private WebElement waitForPresence(WebDriver driver, By locator) {
        WebDriverWait waitFor = new WebDriverWait(driver, Duration.ofSeconds(5));
        return waitFor.until(ExpectedConditions.presenceOfElementLocated(locator));
    }


}
