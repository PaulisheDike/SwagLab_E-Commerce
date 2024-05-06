package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class CartPage extends BaseTest {

    public static String cart_btn = "//a[@class='shopping_cart_link']";
    public static String checkout_btn = "//button[@id='checkout']";
    public static String continue_shopping_btn = "//button[@id='continue-shopping']";
    public static String first_name = "//input[@id='first-name']";
    public static String last_name = "//input[@id='last-name']";
    public static String postal_code = "//input[@id='postal-code']";
    public static String continue_btn = "//input[@id='continue']";
    public static String item_price = "//div[@class='inventory_item_price'][contains(text(),'$')]";
    public static String sub_total = "//div[@class='summary_subtotal_label']";
    public static String tax = "//div[@class='summary_tax_label']";
    public static String grand_total = "//div[@class='summary_total_label']";
    public static double totalPrice = 0.000;
    public static double sub_total_price = 0.000;
    public static String finish_btn = "//button[@id='finish']";
    public static String order_complete_loc="//h2[@class='complete-header']";

    public static void clickShoppingCartButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(cart_btn)));
        driver.findElement(By.xpath(cart_btn)).click();
    }

    public static void clickCheckoutButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(checkout_btn)));
        driver.findElement(By.xpath(checkout_btn)).click();
    }
    public static void enterFirstName(String fn){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(first_name)));
        driver.findElement(By.xpath(first_name)).sendKeys(fn);
    }
    public static void enterLastName(String ln){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(last_name)));
        driver.findElement(By.xpath(last_name)).sendKeys(ln);
    }
    public static void enterPostalCode(String pc){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(postal_code)));
        driver.findElement(By.xpath(postal_code)).sendKeys(pc);
    }
    public static void clickContinueButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(continue_btn)));
        driver.findElement(By.xpath(continue_btn)).click();
    }

    public static double calculateSubTotal(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(item_price)));
        List<WebElement> cart_item = driver.findElements(By.xpath(item_price));

        for(WebElement price : cart_item){

            totalPrice += Double.parseDouble(price.getText().replaceAll("[^\\d.]", ""));

        }
        System.out.println(totalPrice);
        return totalPrice;

    }

    public static double getActualSubTotal(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sub_total)));
        WebElement actual_sub_total = driver.findElement(By.xpath(sub_total));
        sub_total_price = Double.parseDouble(actual_sub_total.getText().replaceAll("[^\\d.]",""));
        System.out.println(sub_total_price);
        return sub_total_price;
    }

    public static double calculateTax(){
        Double expected_tax = (calculateSubTotal() * 0.08);
        System.out.println(expected_tax);
        return expected_tax;
    }
    public static double getActualTax(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(tax)));
        WebElement actual_tax = driver.findElement(By.xpath(tax));
        System.out.println(actual_tax);
        return Double.parseDouble(actual_tax.getText().replaceAll("[^\\d.]",""));
    }
    public static double calculateGrandTotal(){
//        return calculateSubTotal()+calculateTax();
        return getActualSubTotal()+calculateTax();
    }
    public static double getActualGrandTotal(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(grand_total)));
        WebElement actual_grand_total = driver.findElement(By.xpath(grand_total));
        return Double.parseDouble(actual_grand_total.getText().replaceAll("[^\\d.]",""));
    }
    public static void clickFinishButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(finish_btn)));
        driver.findElement(By.xpath(finish_btn)).click();

    }
    public static String isCheckOutSuccessful(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(order_complete_loc)));
        return driver.findElement(By.xpath(order_complete_loc)).getText();
    }



//    public static boolean isCheckoutSuccessful(){
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(logout_err_loc)));
//        actual_logout_err=driver.findElement(By.xpath(logout_err_loc)).getText();
//        assertEquals(expected_logout_err,actual_logout_err);
//        return driver.findElement(By.xpath(logout_err_loc)).isDisplayed();
//
//    }


}
