package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class InventoryPage extends BaseTest {

    public static String hamburger_menu = "//button[@id='react-burger-menu-btn']";
    public static String logout_btn = "//a[@id='logout_sidebar_link']";
    public static String inventoryUrl = "https://www.saucedemo.com/inventory.html";
    public static String expected_logout_err = "Epic sadface: You can only access '/inventory.html' when you are logged in.";
    public static String logout_err_loc = "//h3[@data-test='error']";
    public static String actual_logout_err;
    public static String add_to_cart_loc1 = "//button[@id='add-to-cart-sauce-labs-backpack']";
    public static String remove_from_cart_loc1 = "//button[@id='remove-sauce-labs-backpack']";
    public static String add_to_cart_loc2 = "//button[@id='add-to-cart-sauce-labs-fleece-jacket']";
    public static String remove_from_cart_loc2 = "//button[@id='remove-sauce-labs-fleece-jacket']";
    public static String cart_badge = "//span[@class='shopping_cart_badge']";

    public static void clickAddToCartButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Add to cart')]")));
        List<WebElement> add_to_cart_botton = driver.findElements(By.xpath("//button[contains(text(), 'Add to cart')]"));
        for(WebElement button : add_to_cart_botton){
            button.click();
        }

//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(add_to_cart_loc1)));
//        driver.findElement(By.xpath(add_to_cart_loc1)).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(add_to_cart_loc2)));
//        driver.findElement(By.xpath(add_to_cart_loc2)).click();

    }

    public static boolean isProductAddedToCart(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(cart_badge)));
        return driver.findElement(By.xpath(cart_badge)).isDisplayed();

    }
    public static void clickRemoveButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Remove')]")));
        List<WebElement> remove_from_cart_botton = driver.findElements(By.xpath("//button[contains(text(), 'Remove')]"));
        for(WebElement button : remove_from_cart_botton){
            button.click();
        }
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(remove_from_cart_loc1)));
//        driver.findElement(By.xpath(remove_from_cart_loc1)).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(remove_from_cart_loc2)));
//        driver.findElement(By.xpath(remove_from_cart_loc2)).click();
    }
    public static boolean isProductRemovedFromCart(){
        try{
            WebElement element = driver.findElement(By.xpath(cart_badge));
            return element.isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }

    }
    public static void clickLogoutButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(hamburger_menu)));
        driver.findElement(By.xpath(hamburger_menu)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(logout_btn)));
        driver.findElement(By.xpath(logout_btn)).click();
    }

    public static boolean isLogoutSuccessful(){
        driver.get(inventoryUrl);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(logout_err_loc)));
        actual_logout_err=driver.findElement(By.xpath(logout_err_loc)).getText();
        assertEquals(expected_logout_err,actual_logout_err);
        return driver.findElement(By.xpath(logout_err_loc)).isDisplayed();

    }


}
