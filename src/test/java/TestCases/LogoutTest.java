package TestCases;

import Base.BaseTest;
import Pages.InventoryPage;
import Pages.LoginPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LogoutTest extends BaseTest {

    String valid_username = "standard_user";
    String valid_password = "secret_sauce";

    SoftAssert softassert = new SoftAssert();

    @Test
    public void logoutFunctionality(){
        LoginPage.enterValidUsername(valid_username);
        LoginPage.enterValidPassword(valid_password);
        LoginPage.clickLoginButton();
        InventoryPage.clickLogoutButton();
        softassert.assertTrue(InventoryPage.isLogoutSuccessful());
        softassert.assertAll();
    }

}
