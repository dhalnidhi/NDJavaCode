package stepdefinitions.automation_excercise_stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static com.automation.utils.AutomationExercise.*;

public class AutomationExcerciseSteps {

//    WebDriver driver;

    @Given("I am Login page")
    public void i_am_login_page() {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\JavaSeleniumMaven_Aug25\\JavaSeleniumMaven_Aug25\\src\\test\\resources\\webdriver\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://automationexercise.com/login");
    }
    @When("I entered user and password")
    public void i_entered_user_and_password() {
        driver.findElement(By.name("email")).sendKeys("dhalnidhi12@gmail.com");
        driver.findElement(By.name("password")).sendKeys("Luck2025");
        System.out.println("added username and password");
    }
    @When("Click on Login Button")
    public void click_on_login_button() {
        driver.findElement(By.xpath("//button[@type='submit' and text()='Login']")).click();
    }
    @Then("I should be logged in successfully.")
    public void i_should_be_logged_in_successfully() {
        WebElement logout = driver.findElement(By.xpath("//a[text()=' Logout']"));
        Assert.assertTrue("Test is failed..", logout.isDisplayed() );
    }

    /******************************ADD To CART *******************************************************/


    @Given("I am logged into application")
    public void i_am_logged_into_application() {
        loginToAutomationExercise();
    }

    @When("Add the item to card")
    public void add_the_item_to_card() {
        addToCartFirstProduct();

    }
    @When("Then the item should be added successfully to the cart")
    public void then_the_item_should_be_added_successfully_to_the_cart() {
        Assert.assertTrue("Product not added successfully to cart..", checkProductAddedSuccessfullyToCart());
    }
    @Then("I should be logged out of the application")
    public void i_should_be_logged_out_of_the_application() {
        logout();
    }
    @Then("I close the application")
    public void i_close_the_application() {
        closeApp();
    }

}
