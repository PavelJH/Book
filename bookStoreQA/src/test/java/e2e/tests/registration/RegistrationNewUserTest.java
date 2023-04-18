package e2e.tests.registration;

import api.registration.RegistrationApi;
import e2e.pages.account.LoginPage;
import e2e.pages.account.ProfilePage;
import e2e.tests.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class RegistrationNewUserTest extends TestBase {

    RegistrationApi registrationApi;
    LoginPage loginPage;
    ProfilePage profilePage;
    Response response;

    @Test
    public void registerNewUserViaApiAndLoginViaUITest(){
        registrationApi = new RegistrationApi();
        response =registrationApi.registrationNewUserApi(201);
        String userName = response.jsonPath().getString("username");
        String password = registrationApi.randomDataForNewUser().getPassword();

        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.userNameField(userName);
        loginPage.passwordField(password);
        loginPage.clickLoginButton();

        profilePage = new ProfilePage(app.driver);
        profilePage.waitForLoading();
    }
}
