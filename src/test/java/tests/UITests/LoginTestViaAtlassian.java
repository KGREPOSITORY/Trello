package tests.UITests;

import frame.pages.AtlassianLoginPage;
import frame.pages.BasePage;
import frame.pages.LoginPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tests.BaseTest;

public class LoginTestViaAtlassian extends BaseTest {

    @Test
    @Parameters({"login","password"})
    public void loginTestViaAtlassian(String login, String password){
        new BasePage()
                .clickLoginButton();
        new LoginPage()
                .enterLogin(login)
                .clickEneter();
        new AtlassianLoginPage()
                .enterPassword(password)
                .clickLogin();
    }
}
