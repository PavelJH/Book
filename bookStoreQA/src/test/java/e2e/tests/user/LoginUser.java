package e2e.tests.user;

import e2e.pages.Books.BooksPage;
import e2e.pages.account.HomePage;
import e2e.pages.account.LoginPage;
import e2e.tests.TestBase;
import org.testng.annotations.Test;

public class LoginUser extends TestBase {
    HomePage homePage;
    LoginPage loginPage;
    BooksPage booksPage;
    String userName = "PavelJH";
    String password = "Jeffry080%";

    @Test
    public void loginWithExistAccount(){
//        homePage = new HomePage(app.driver);
//        homePage.waitForLoading();
//        homePage.clickLoginButton();
//
//        loginPage = new LoginPage(app.driver);
//        loginPage.waitForLoading();
//        loginPage.userNameField(userName);
//        loginPage.passwordField(password);
//        loginPage.clickLoginButton();

        booksPage = new BooksPage(app.driver);
        booksPage.clickBackToBookStoreButton();



    }

}
