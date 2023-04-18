package e2e.pages.account;

import e2e.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import e2e.wait.Wait;

public class RegisterPage extends PageBase {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }
    Wait wait;

    @FindBy(xpath = "//h4[normalize-space()='Register to Book Store']")
    WebElement registerToBookStoreText;
    @FindBy(xpath = "//input[@id='firstname']")
    WebElement firstNameField;
    @FindBy(xpath = "//input[@id='lastname']")
    WebElement lastNameField;
    @FindBy(xpath = "//input[@id='userName']")
    WebElement userNameField;
    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordField;
    @FindBy(xpath = "(//body)[1]")
    WebElement reCaptcha;
    @FindBy(xpath = "//button[@id='register']")
    WebElement registerButton;
    @FindBy(xpath = "//button[@id='gotologin']")
    WebElement backToLoginButton;
    public void waitForLoading() {
        wait = new Wait(driver);
        wait.forVisibility(registerToBookStoreText);
    }
    public void firstNameField(String firstNameText){
        firstNameField.sendKeys(firstNameText);
    }
    public void lastNameField(String lastNameText){
        lastNameField.sendKeys(lastNameText);
    }
    public void userNameField(String userNameText){
        userNameField.sendKeys(userNameText);
    }
    public void passwordField(String passwordText){
        passwordField.sendKeys(passwordText);
    }
    public void clickRecaptcha(){
        click(reCaptcha);
    }
    public void clickRegisterButton(){
        click(registerButton);
    }
    public void clickBackToLogin(){
        click(backToLoginButton);
    }
}
