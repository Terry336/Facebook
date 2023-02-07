package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class StepDefinitions {

    public WebDriver driver;

    @Given("User opens to Facebook page")
    public void user_opens_to_facebook_page() {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        Actions actions = new Actions(driver);
        driver.manage().window().maximize();
        driver.navigate().to("https://www.facebook.com/");
        driver.findElement(By.xpath("//button[@title='Allow essential and optional cookies']")).click();
    }

    @When("User clicks on Create new account button")
    public void user_clicks_on_create_new_account_button(String string) throws InterruptedException {
        Thread.sleep(3000);
        driver.switchTo().frame(1);
        driver.findElement(By.xpath("//a[contains(.,'Create new account')]")).click();
    }

    @When("Fills in all the mandatory fields")
    public void fills_in_all_the_mandatory_fields() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("Clicks Sign Up button")
    public void clicks_button(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("User signs up successfully")
    public void user_signs_up_successfully() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();

    }
}
