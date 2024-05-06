package TestCases;

import Base.BaseTest;
import Pages.InventoryPage;
import Pages.LoginPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ShopingProductTest extends BaseTest {

    String valid_username = "standard_user";
    String valid_password = "secret_sauce";

    SoftAssert softassert = new SoftAssert();

    @Test
    public void addProductToCart(){
        LoginPage.enterValidUsername(valid_username);
        LoginPage.enterValidPassword(valid_password);
        LoginPage.clickLoginButton();
        InventoryPage.clickAddToCartButton();
        softassert.assertTrue(InventoryPage.isProductAddedToCart());
        softassert.assertAll();
    }

    @Test
    public void removeProductFromCart(){
        LoginPage.enterValidUsername(valid_username);
        LoginPage.enterValidPassword(valid_password);
        LoginPage.clickLoginButton();
        InventoryPage.clickAddToCartButton();
        InventoryPage.clickRemoveButton();
        softassert.assertFalse(InventoryPage.isProductRemovedFromCart());
        softassert.assertAll();
    }


}
