package TestCases;

import Base.BaseTest;
import Pages.CartPage;
import Pages.InventoryPage;
import Pages.LoginPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class    ShoppingCartTest extends BaseTest {

    String valid_username = "standard_user";
    String valid_password = "secret_sauce";
    String first_name = "Goddey";
    String last_name = "Paul";
    String postal_code = "10001";

    SoftAssert softassert = new SoftAssert();

    public void loginUser(){
        LoginPage.enterValidUsername(valid_username);
        LoginPage.enterValidPassword(valid_password);
        LoginPage.clickLoginButton();
    }
    public void checkoutUserInformation(){
        CartPage.enterFirstName(first_name);
        CartPage.enterLastName(last_name);
        CartPage.enterPostalCode(postal_code);
        CartPage.clickContinueButton();
    }


    @Test
    public void addProductToCart(){
        loginUser();
        InventoryPage.clickAddToCartButton();
        CartPage.clickShoppingCartButton();

        softassert.assertTrue(InventoryPage.isProductAddedToCart());
        softassert.assertAll();
    }

    @Test
    public void removeProductFromCart(){
        loginUser();
        InventoryPage.clickAddToCartButton();
        InventoryPage.clickRemoveButton();
        softassert.assertFalse(InventoryPage.isProductRemovedFromCart());
        softassert.assertAll();
    }

    @Test
    public void validateSubTotal(){
        loginUser();
        InventoryPage.clickAddToCartButton();
        CartPage.clickShoppingCartButton();
        CartPage.clickCheckoutButton();
        checkoutUserInformation();

        softassert.assertEquals(CartPage.calculateSubTotal(),CartPage.getActualSubTotal(), 0.01);
        softassert.assertAll();



    }
    @Test
    public void validateTax(){
        loginUser();
        InventoryPage.clickAddToCartButton();
        CartPage.clickShoppingCartButton();
        CartPage.clickCheckoutButton();
        checkoutUserInformation();

        double expectedTax = CartPage.calculateTax();
        double actualTax = CartPage.getActualTax();

        softassert.assertEquals(actualTax,expectedTax, 0.01);
        softassert.assertAll();

    }
    @Test
    public void validateGrandTotal(){
        loginUser();
        InventoryPage.clickAddToCartButton();
        CartPage.clickShoppingCartButton();
        CartPage.clickCheckoutButton();
        checkoutUserInformation();

        double expected_grand_total = CartPage.calculateGrandTotal();
        double actual_grand_total = CartPage.getActualGrandTotal();

        softassert.assertEquals(actual_grand_total,expected_grand_total, 0.01);
        softassert.assertAll();

    }

    @Test
    public void validateSuccessfulCheckout(){
        loginUser();
        InventoryPage.clickAddToCartButton();
        CartPage.clickShoppingCartButton();
        CartPage.clickCheckoutButton();
        checkoutUserInformation();
        CartPage.clickFinishButton();

        String actual_checkout_msg = "Thank you for your order!";
        softassert.assertEquals(CartPage.isCheckOutSuccessful(),actual_checkout_msg);
        softassert.assertAll();
    }


}
