package cydeo.pages;

import cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyWikiSearchPage {

    public MyWikiSearchPage() {

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(name = "q")
    public WebElement myWikiSearchBox;
    @FindBy(id = "cmdSearch")
    public WebElement myWikiSearchButton;


}
