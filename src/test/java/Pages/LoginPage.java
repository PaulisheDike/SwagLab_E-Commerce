package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Objects;

public class LoginPage extends BaseTest {

    public static String username = "//input[@id='user-name']";
    public static String password = "//input[@id='password']";
    public static String login_btn = "//input[@id='login-button']";
    public static String hamburger_menu = "//button[@id='react-burger-menu-btn']";
    public static String logout_btn = "//a[@id='logout_sidebar_link']";
    public static String login_err_msg_locator = "//h3[@data-test='error']";

    public static void enterValidUsername(String myUser){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(username)));
        driver.findElement(By.xpath(username)).clear();
        driver.findElement(By.xpath(username)).sendKeys(myUser);
    }

    public static void enterValidPassword(String myPass){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(password)));
        driver.findElement(By.xpath(password)).clear();
        driver.findElement(By.xpath(password)).sendKeys(myPass);
    }

    public static void enterInvalidUsername(String myUser){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(username)));
        driver.findElement(By.xpath(username)).clear();
        driver.findElement(By.xpath(username)).sendKeys(myUser);
    }

    public static void enterInvalidPassword(String myPass){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(password)));
        driver.findElement(By.xpath(password)).clear();
        driver.findElement(By.xpath(password)).sendKeys(myPass);
    }

    public static void clickLoginButton(){
        driver.findElement(By.xpath(login_btn)).click();
    }

    public static boolean isLoginSuccessful(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(hamburger_menu)));
        driver.findElement(By.xpath(hamburger_menu)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(logout_btn)));
        return driver.findElement(By.xpath(logout_btn)).isDisplayed();
    }

    public static boolean isLoginFailed(){
        String expected_err_msg = "Epic sadface: Username and password do not match any user in this service";
        boolean err_msg_visibility = driver.findElement(By.xpath(login_err_msg_locator)).isDisplayed();
        String actual_err_msg = driver.findElement(By.xpath(login_err_msg_locator)).getText();

//        return err_msg_visibility && actual_err_msg.equals(expected_err_msg);

        return err_msg_visibility;

    }




}
