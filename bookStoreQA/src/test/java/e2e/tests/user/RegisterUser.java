package e2e.tests.user;

import com.github.javafaker.Faker;
import e2e.pages.account.HomePage;
import e2e.pages.account.LoginPage;
import e2e.pages.account.RegisterPage;
import e2e.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterUser extends TestBase {
    Faker faker = new Faker();
    HomePage homePage;
    LoginPage loginPage;
    RegisterPage registerPage;
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userName = faker.name().username();
    String password = faker.internet().password();

    @Test //Тест построен правильно, но из за капчи, невозможно его реализовать
    public void registerNewUser(){
        homePage = new HomePage(app.driver);
        homePage.waitForLoading();
        homePage.clickLoginButton();

        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.clickNewUserRegistration();

        registerPage = new RegisterPage(app.driver);
        registerPage.waitForLoading();
        registerPage.firstNameField(firstName);
        registerPage.lastNameField(lastName);
        registerPage.userNameField(userName);
        registerPage.passwordField(password);
        registerPage.clickRecaptcha();
        registerPage.clickRegisterButton();

       Assert.assertTrue(registerPage.getAlertText().contains("User Register Successfully."));

        registerPage.acceptAlert();
        registerPage.clickBackToLogin();

        loginPage.userNameField(userName);
        loginPage.passwordField(password);
        loginPage.clickLoginButton();
    }

}
