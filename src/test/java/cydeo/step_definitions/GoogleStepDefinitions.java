package cydeo.step_definitions;

import cydeo.pages.GoogleSearchPage;
import cydeo.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class GoogleStepDefinitions {
    GoogleSearchPage googleSearchPage = new GoogleSearchPage();

    @When("user type apple and clicks enter")
    public void user_type_and_clicks_enter2() {
        googleSearchPage.popUp.click();
        googleSearchPage.searchBox.sendKeys("apple" + Keys.ENTER);


    }

    @When("user type {string} and clicks enter")
    public void user_type_and_clicks_enter(String searchKeyword) {
        googleSearchPage.popUp.click();
        googleSearchPage.searchBox.sendKeys(searchKeyword + Keys.ENTER);


    }


    @Then("user sees {string} in the google title")
    public void user_sees_in_the_google_title(String searchKeyword) {
        String expectedTitle = searchKeyword+" - Google Suche";
        String actualTitle = Driver.getDriver().getTitle();



        //Junit assertion accepts first arg as expected, second arg as actual
        Assert.assertEquals("Title is not equal",expectedTitle, actualTitle);

    }
    @Then("user sees apple in the google title")
    public void user_sees_apple_in_the_google_title() {
        String expectedTitle = "apple"+" - Google Suche";
        String actualTitle = Driver.getDriver().getTitle();



        //Junit assertion accepts first arg as expected, second arg as actual
        Assert.assertEquals("Title is not equal",expectedTitle, actualTitle);

    }




    @When("user is on Google search page")
    public void user_is_on_google_search_page() {

        Driver.getDriver().get("https://www.google.com");
        System.out.println("User is on the google page ");
    }

    @Then("user should see title is Google")
    public void user_should_see_title_is_google() {
        String expectedTitle = "Google";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        Driver.closeDriver();
    }
}
