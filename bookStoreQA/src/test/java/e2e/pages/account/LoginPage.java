package e2e.pages.account;

import e2e.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import e2e.wait.Wait;

public class LoginPage extends PageBase {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    Wait wait;
    @FindBy(xpath = "//h5[normalize-space()='Login in Book Store']")
    protected WebElement loginInBookStoreText;
    @FindBy(xpath = "//input[@id='userName']")
    protected WebElement userNameField;
    @FindBy(xpath = "//input[@id='password']")
    protected WebElement passwordField;
    @FindBy(xpath = "//button[@id='login']")
    protected WebElement loginButton;
    @FindBy(xpath = "//button[@id='newUser']")
    protected WebElement newUserRegistration;


    public void waitForLoading() {
        wait = new Wait(driver);
        wait.forVisibility(loginInBookStoreText);
    }
    public void userNameField(String nameUser){
        userNameField.sendKeys(nameUser);
    }
    public void passwordField(String passwordUser){
        passwordField.sendKeys(passwordUser);
    }
    public void clickLoginButton(){
        loginButton.click();
    }
    public void clickNewUserRegistration(){
        newUserRegistration.click();
    }
}
