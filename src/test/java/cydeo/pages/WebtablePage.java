package cydeo.pages;

import cydeo.utilities.ConfigurationReader;
import cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebtablePage {

    public WebtablePage() {
        PageFactory.initElements(Driver.getDriver(), this);


    }

    @FindBy(xpath = "//input[@name='username']")
    public WebElement userMame;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    /**
     *
     */

    public void login() {
        this.userMame.sendKeys("Test");
        this.password.sendKeys("Tester");
        this.loginButton.click();
    }

    /**
     * this method will accept two arguments and login
     *
     * @param username
     * @param pswwrd
     */

    public void login(String username, String pswwrd) {
        userMame.sendKeys(username);
        password.sendKeys(pswwrd);
        loginButton.click();

    }

    public void loginWithsConfig() {
        userMame.sendKeys(ConfigurationReader.getProperty("web.table.username"));
        userMame.sendKeys(ConfigurationReader.getProperty("web.table.pw"));
        loginButton.click();
    }

}
