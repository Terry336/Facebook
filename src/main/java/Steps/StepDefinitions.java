package Steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.an.Y;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StepDefinitions {
    public WebDriver driver;
    public WebDriverWait wait;
    public Actions actions;

    @Before
    public void SetUp() {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/src/main/resources/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @After
    public void After() {
        driver.quit();
    }


    @Given("User opens to Facebook page")
    public void user_opens_to_facebook_page() {
        driver.navigate().to("https://www.facebook.com/");
        driver.findElement(By.xpath("//button[@title='Allow essential and optional cookies']")).click();
    }

    @When("User clicks on Create new account button")
    public void user_clicks_on_create_new_account_button()  {
        driver.findElement(By.xpath("//a[contains(.,'Create new account')]")).click();
    }

    @When("Fills in all the mandatory fields")
    public void fills_in_all_the_mandatory_fields() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Teresa");
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Rodriges");
        driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("tersy543@gmail.com");
        driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys("tersy543@gmail.com");
        driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("123456tR!");
        WebElement Month = driver.findElement(By.xpath("//select[@id='month']"));
        Actions actions= new Actions(driver);
        actions.moveToElement(Month).perform();
        driver.findElement(By.xpath("//select[@aria-label='Month']//option[@value='4']")).click();
        WebElement Day = driver.findElement(By.xpath("//select[@id='day']"));
        driver.findElement(By.xpath("//select[@aria-label='Day']//option[@value='7']")).click();
        actions.moveToElement(Day).perform();
        WebElement Year = driver.findElement(By.xpath("//select[@id='year']"));
        driver.findElement(By.xpath("//select[@aria-label='Year']//option[@value='1996']")).click();
        actions.moveToElement(Year).perform();
        driver.findElement(By.xpath("//label[contains(text(), 'Female')]")).click();


    }

    @When("Clicks Sign Up button")
    public void clicks_sign_up_button() throws InterruptedException {
    Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@name='websubmit']")).click();
    }

    @When("Fills in all the mandatory fields but with invalid password")
    public void fills_in_all_the_mandatory_fields_but_with_invalid_password() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Teresa");
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Rodriges");
        driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("tersy543@gmail.com");
        driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys("tersy543@gmail.com");
        driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("123456");
        WebElement Month = driver.findElement(By.xpath("//select[@id='month']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(Month).perform();
        driver.findElement(By.xpath("//select[@aria-label='Month']//option[@value='4']")).click();
        WebElement Day = driver.findElement(By.xpath("//select[@id='day']"));
        driver.findElement(By.xpath("//select[@aria-label='Day']//option[@value='7']")).click();
        actions.moveToElement(Day).perform();
        WebElement Year = driver.findElement(By.xpath("//select[@id='year']"));
        driver.findElement(By.xpath("//select[@aria-label='Year']//option[@value='1996']")).click();
        actions.moveToElement(Year).perform();
        driver.findElement(By.xpath("//label[contains(text(), 'Female')]")).click();
    }

    @When("Fills in all the mandatory fields but with incorrect email")
    public void fills_in_all_the_mandatory_fields_but_with_incorrect_email() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Teresa");
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Rodriges");
        driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("tersy");
        driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("123456tR!");
        WebElement Month = driver.findElement(By.xpath("//select[@id='month']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(Month).perform();
        driver.findElement(By.xpath("//select[@aria-label='Month']//option[@value='4']")).click();
        WebElement Day = driver.findElement(By.xpath("//select[@id='day']"));
        driver.findElement(By.xpath("//select[@aria-label='Day']//option[@value='7']")).click();
        actions.moveToElement(Day).perform();
        WebElement Year = driver.findElement(By.xpath("//select[@id='year']"));
        driver.findElement(By.xpath("//select[@aria-label='Year']//option[@value='1996']")).click();
        actions.moveToElement(Year).perform();
        driver.findElement(By.xpath("//label[contains(text(), 'Female')]")).click();
    }


    @Then("User signs up successfully")
    public void user_signs_up_successfully() throws InterruptedException {
        Thread.sleep(8000);
       WebElement WeNeedMoreInfo= driver.findElement(By.xpath("//span[contains(text(), 'We need more information')]"));
        Assertions.assertEquals(WeNeedMoreInfo.getText(), "We need more information");
    }

    @Then("User is not signed up and remains on the same page")
    public void user_is_not_signed_up_and_remains_on_the_same_page() throws InterruptedException {
        Thread.sleep(8000);
        WebElement SignUp= driver.findElement(By.xpath("//div[contains(text(), 'Sign Up')]"));
        Assertions.assertEquals(SignUp.getText(), "Sign Up");
    }
}
