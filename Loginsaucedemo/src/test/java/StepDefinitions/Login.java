package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Login {

    private WebDriver driver;
    private WebElement usernameField;
    private WebElement passwordField;
    private WebElement loginButton;
    private WebElement errorMessage;

    @Given("User navigates to the login page")
    public void userNavigatesToLoginPage() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @When("User enters {string} and {string}")
    public void userEntersUsernameAndPassword(String username, String password) {
        usernameField = driver.findElement(By.id("user-name"));
        passwordField = driver.findElement(By.id("password"));
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
    }

    @And("User clicks on the login button")
    public void userClicksOnLoginButton() {
        loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
    }

    @Then("{string} message is displayed")
    public void errorMessageDisplayed(String expectedMessage) {
        errorMessage = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));
        assertEquals(expectedMessage, errorMessage.getText());
        driver.quit();
    }



}
