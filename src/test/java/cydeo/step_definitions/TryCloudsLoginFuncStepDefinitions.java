package cydeo.step_definitions;

import cydeo.pages.TryCloudLoginPage;
import cydeo.utilities.ConfigurationReader;
import cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;

public class TryCloudsLoginFuncStepDefinitions {
TryCloudLoginPage tryCloudLoginPage=new TryCloudLoginPage();
    @Given("User is already on the login page")
    public void user_is_already_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("tryCloudLoginPage"));
    }
    @When("User enter a valid username")
    public void user_enter_a_valid_username() {
    tryCloudLoginPage.userInputBox.sendKeys(ConfigurationReader.getProperty("username"));
    }
    @When("User enter a valid password and click Enter key from keyboard")
    public void user_enter_a_valid_password_and_click_enter_key_fro_keyboard() {
        tryCloudLoginPage.passwordInputBox.sendKeys(ConfigurationReader.getProperty("password")+ Keys.ENTER);
    }
    @Then("User successfully login on the dashboard page")
    public void user_succesfully_login_on_the_dashboard_page() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Dashboard") );
      //  System.out.printf("title"+ Driver.getDriver().getTitle());
    }

    @When("User enter a valid password and click Login Button")
    public void user_enter_a_valid_password_and_click_login_button() {
        tryCloudLoginPage.passwordInputBox.sendKeys(ConfigurationReader.getProperty("password"));

        tryCloudLoginPage.loginButton.click();
    }

    @When("User enter invalid {string}")
    public void user_enter_invalid(String string) {
tryCloudLoginPage.userInputBox.sendKeys(string);
    }
    @When("User enter a invalid {string} and click Login Button")
    public void user_enter_a_invalid_and_click_login_button(String string) {
        tryCloudLoginPage.passwordInputBox.sendKeys(string);
        tryCloudLoginPage.loginButton.click();
    }
    @Then("Wrong username or password should be displayed")
    public void wrong_username_or_password_should_be_displayed() {
Assert.assertTrue(tryCloudLoginPage.warningMessage.isDisplayed());
    }
    @When("username is empty")
    public void username_is_empty() {
        tryCloudLoginPage.userInputBox.sendKeys("");
    }
    @Then("Please fill out this field should be displayed")
    public void please_fill_out_this_field_should_be_displayed() {

        Assert.assertTrue(tryCloudLoginPage.userInputBox.getAttribute("validationMessage").equalsIgnoreCase("Please fill out this field."));

    }
    @When("Password is empty and click Login Button")
    public void password_is_empty_and_click_login_button() {
        tryCloudLoginPage.passwordInputBox.sendKeys("");
        tryCloudLoginPage.loginButton.click();
    }

    @When("User types any {string} in the password input box")
    public void user_types_any_in_the_password_input_box(String string) {
        tryCloudLoginPage.passwordInputBox.sendKeys(string);

    }
    @Then("User can see the password in a form of dots")
    public void user_can_see_the_password_in_a_form_of_dots() {
        Assert.assertTrue(tryCloudLoginPage.passwordInputBox.getAttribute("type").equalsIgnoreCase("Password"));
    }
    @When("User clicks eye button in the password input box")
    public void user_clicks_eye_button_in_the_password_input_box() {
        tryCloudLoginPage.eyeIMG.click();
    }
    @Then("User see the password explicitly")
    public void user_see_the_password_explicitly() {

        Assert.assertTrue(tryCloudLoginPage.passwordInputBox.getAttribute("type").equalsIgnoreCase("text"));
    }
    @When("User see the Forgot Password? link")
    public void user_see_the_forgot_password_link() {
        Assert.assertTrue(tryCloudLoginPage.forgotPasswordLink.isDisplayed());
    }
    @When("User clicks the Forgot Password link")
    public void user_clicks_the_forgot_password_link() {
        tryCloudLoginPage.forgotPasswordLink.click();
    }
    @Then("User see the Reset Password button on the next page")
    public void user_see_the_reset_password_button_on_the_next_page() {
      Assert.assertTrue(tryCloudLoginPage.resetPasswordButton.isDisplayed());
    }

    @When("User see Username as a placeholders on username fields")
    public void user_see_username_as_a_placeholders_on_username_fields() {
        Assert.assertTrue( tryCloudLoginPage.userInputBox.getAttribute("placeholder").equalsIgnoreCase("Username or email"));

    }
    @When("User see Password as a placeholders on password fields")
    public void user_see_password_as_a_placeholders_on_password_fields() {
        Assert.assertTrue( tryCloudLoginPage.passwordInputBox.getAttribute("placeholder").equalsIgnoreCase("password"));

    }


}
