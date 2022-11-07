package cydeo.step_definitions;

import cydeo.pages.DropdownPage;
import cydeo.utilities.BrowserUtils;
import cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataTable_StepDefinitions {
    DropdownPage dropdownPage = new DropdownPage();

    /*
     */
    @Then("user should see fruit I like")
    public void user_should_see_fruit_i_like(List<String> fruits) {
        System.out.println(fruits);
        System.out.println(fruits.get(1));

    }
    @Given("User is on the dropdowns page of practice tool")
    public void user_is_on_the_dropdowns_page_of_practice_tool() {
        Driver.getDriver().get("https://practice.cydeo.com/dropdown");

    }
    @Then("User should see below info in month dropdown")
    public void user_should_see_below_info_in_month_dropdown(List<String> expectedMonths) {
        System.out.printf("expected months= "+ expectedMonths);
        //This method will return us the List of String of given dropdown's options
        List<String> actualsMonths=BrowserUtils.dropdownOptionsAsString(dropdownPage.dropdownMonth);
        Assert.assertEquals(expectedMonths,actualsMonths);
        //Assert will check the size of the lists first. If it is matching it will check content 1 by 1.


    }


}
 /*
    @Given("User is on the dropdowns page of practice tool")
    public void userIsOnTheDropdownsPageOfPracticeTool() {
        Driver.getDriver().get("https://practice.cydeo.com/dropdown");
    }



    @Then("User should see below info in month dropdown")
    public void userShouldSeeBelowInfoInDropdown(List<String> months) {
        List<String> expectedMonths=months;
        Select select=new Select(dropdownPage.dropdownMonth);
        List<WebElement> options = select.getOptions();


        //  List<WebElement> selectedOptions = select.getAllSelectedOptions();
        //  List<String> monthsOptions=selectedOptions.get();
        List<String> actualmonths = null;


     for (WebElement eachmonths:options) {
            actualmonths.add(eachmonths.getText());
            //  System.out.println(selectedOptions);
        }
        */



      //  System.out.println(actualmonths);




      //  Assert.assertTrue(expectedmonths.equals(actualmonths));



/*
TC#6: Data tables task
https://practice.cydeo.com/dropdown
Scenario: User should be able to see all 12 months in months
dropdown
  Given User is on the dropdowns page of practice tool
  Then User should see below info in month dropdown
    | January   |
    | February  |
    | March     |
    | April     |
    | May       |
    | June      |
    | July      |
    | August    |
    | September |
    | October   |
    | November  |
    | December  |



Note: Follow POM and BDD approach
 */