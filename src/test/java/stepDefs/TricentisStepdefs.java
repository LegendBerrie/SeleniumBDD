package stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TricentisStepdefs {

    WebDriver driver;

    @After
    public void teardown () {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("I open the webpage {string}")
    public void iOpenTheWebpage(String url) {
        driver = new ChromeDriver();
        driver.get(url);
    }

    @When("I click on the category {string}")
    public void iClickOnTheCategory(String category) {
        driver.findElement(By.linkText(category)).click();
    }

    @Then("I am sent to the page with the title {string}")
    public void iAmSentToThePageWithTheTitle(String expectedTitle) {
        String actual = driver.findElement(By.cssSelector(".page-title")).getText();
        assertEquals(expectedTitle, actual);

    }
}
