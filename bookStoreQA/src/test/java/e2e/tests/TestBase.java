package e2e.tests;

import e2e.pages.account.HomePage;
import e2e.pages.account.LoginPage;
import e2e.pages.account.ProfilePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.Arrays;

public class TestBase {

    HomePage homePage;
    LoginPage loginPage;
    ProfilePage profilePage;
    String userName = "PavelJH";
    String password = "Jeffry080%";

    static Logger logger = LoggerFactory.getLogger(TestBase.class);
    protected static ApplicationManager app = new ApplicationManager();


    @BeforeMethod
    public void setupTest() throws MalformedURLException {
        app.init(false);
    }

    @BeforeMethod()
    public void startTest(Method m, Object[] p) {
        logger.info("Start test " + m.getName() + " with data: " + Arrays.asList(p));
        homePage = new HomePage(app.driver);
        homePage.waitForLoading();
        homePage.clickLoginButton();

        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.userNameField(userName);
        loginPage.passwordField(password);
        loginPage.clickLoginButton();

        profilePage = new ProfilePage(app.driver);
        profilePage.waitForLoading();
        profilePage.clickGoToBookStore();
    }

    @AfterMethod
    public void tearDown() {
        app.stop();
    }

    @AfterMethod
    public void stopTest(ITestResult result) {
        if (result.isSuccess()) {
            logger.info("PASSED" + result.getMethod().getMethodName());
        } else {
            logger.info("FAILED" + result.getMethod().getMethodName());
        }

        logger.info("=========================================================================");
    }
}
