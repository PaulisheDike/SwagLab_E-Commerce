package TestCases;

import Base.BaseTest;
import Pages.LoginPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {
    String valid_username = "standard_user";
    String valid_password = "secret_sauce";
    String invalid_username = "typeanything";
    String invalid_password = "typesomething";

    SoftAssert softassert = new SoftAssert();

    @Test
    public void validUsername_and_validPassword(){
        LoginPage.enterValidUsername(valid_username);
        LoginPage.enterValidPassword(valid_password);
        LoginPage.clickLoginButton();
        softassert.assertTrue(LoginPage.isLoginSuccessful());
        softassert.assertAll();

//        assertTrue(LoginPage.isLoginSuccessful());
    }

    @Test
    public void validUsername_and_invalidPassword(){
        LoginPage.enterValidUsername(valid_username);
        LoginPage.enterInvalidPassword(invalid_password);
        LoginPage.clickLoginButton();
        softassert.assertTrue(LoginPage.isLoginFailed());
        softassert.assertAll();
    }

    @Test
    public void invalidUsername_and_validPassword(){
        LoginPage.enterInvalidUsername(invalid_username);
        LoginPage.enterValidPassword(valid_password);
        LoginPage.clickLoginButton();
        softassert.assertTrue(LoginPage.isLoginFailed());
        softassert.assertAll();
    }

    @Test
    public void invalidUsername_and_invalidPassword(){
        LoginPage.enterInvalidUsername(invalid_username);
        LoginPage.enterInvalidPassword(invalid_password);
        LoginPage.clickLoginButton();
        softassert.assertTrue(LoginPage.isLoginFailed());
        softassert.assertAll();
    }
}
