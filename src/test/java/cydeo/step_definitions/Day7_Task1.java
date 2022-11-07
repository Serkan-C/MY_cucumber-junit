package cydeo.step_definitions;

import cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

public class Day7_Task1 {


    @Given("Go to amazon web site")
    public void go_to_amazon_web_site() {
        Driver.getDriver().get("https://www.amazon.com");
    }
    @When("user create multiple Tabs")
    public void user_create_multiple_tabs() {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("window.open('http://google.com','_blank');");
        ((JavascriptExecutor) Driver.getDriver()).executeScript("window.open('http://etsy.com','_blank');");
        ((JavascriptExecutor) Driver.getDriver()).executeScript("window.open('http://facebook.com','_blank');");

    }
    @When("user switch to the tab where Etsy.com is open")
    public void user_switch_to_the_tab_where_etsy_com_is_open() {
        for (String eachTab : Driver.getDriver().getWindowHandles()) {
           if( Driver.getDriver().switchTo().window(eachTab).getTitle().contains("Google")){
               break;
           }

        }


    }
    @Then("user should see Title contains Etsy")
    public void user_should_see_title_contains_etsy() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Google"));
    }


}
