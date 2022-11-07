package cydeo.step_definitions;

import cydeo.pages.WebtablePage;
import cydeo.utilities.BrowserUtils;
import cydeo.utilities.ConfigurationReader;
import cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

public class WebTable_StepDefinitions {

    WebtablePage webtablePage = new WebtablePage();

    @Given("user is on the login page of web table app")
    public void user_is_on_the_login_page_of_web_table_app() {
        String url = ConfigurationReader.getProperty("web.table.url");
        Driver.getDriver().get(url);
    }

    @When("user enters username {string}")
    public void user_enters_username(String username) {
        webtablePage.userMame.sendKeys(username);

    }

    @When("user enters password {string}")
    public void user_enters_password(String password) {
        webtablePage.password.sendKeys(password);
    }

    @When("user clicks to login button")
    public void user_clicks_to_login_button() {
        webtablePage.loginButton.click();

    }

    @Then("user should see url contains orders")
    public void user_should_see_url_contains_orders() {
        BrowserUtils.verifyURLContains("orders");
    }


    @When("user enters username {string} password {string} and logins")
    public void userEntersUsernamePasswordAndLogins(String username, String password) {
       /* webtablePage.userMame.sendKeys(username);
        webtablePage.password.sendKeys(password);
        webtablePage.loginButton.click();
*/
        webtablePage.login(username, password);
    }

    @When("user enter below credentials")
    public void userEnterBelowCredentials(Map<String, String> credentials) {
webtablePage.login(credentials.get("username"),credentials.get("password") );
        //  webtablePage.userMame.sendKeys(credentials.get("username"));
        //  webtablePage.password.sendKeys(credentials.get("password"));
        // webtablePage.loginButton.click();
        // System.out.printf("credentials.get(\"username\")"+ credentials.get("username"));
        // System.out.println("credentials.get(\"password\") = " + credentials.get("password"));

    }
}
