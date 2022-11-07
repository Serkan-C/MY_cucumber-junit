package cydeo.step_definitions;

import cydeo.pages.MyWikiSearchPage;
import cydeo.utilities.ConfigurationReader;
import cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class MyWikiSearchStepDefiniton {

    MyWikiSearchPage myWikiSearchPage=new MyWikiSearchPage();
    @Given("my User is on Wikipedia home page")
    public void my_user_is_on_wikipedia_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("wiki"));
       }
    @When("my User types Steve Jobs in the wiki search box")
    public void my_user_types_steve_jobs_in_the_wiki_search_box() {
myWikiSearchPage.myWikiSearchBox.sendKeys("Steve Jobs");
       }
    @When("my  User clicks wiki search button")
    public void my_user_clicks_wiki_search_button() {
myWikiSearchPage.myWikiSearchButton.click();
       }
    @Then("my  User sees Steve Jobs is in the wiki title")
    public void my_user_sees_steve_jobs_is_in_the_wiki_title() {
String actualTitle=Driver.getDriver().getTitle();
String expectedTitle="Steve Jobs – Wikipedia";
        Assert.assertEquals(expectedTitle,actualTitle);

    }


}
