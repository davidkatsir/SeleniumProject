package swagLabs05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwagLabs05 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String sauceDemoUrl = "https://www.saucedemo.com/";
        String inventoryPageUrl = "https://www.saucedemo.com/inventory.html";
        String validUser = "standard_user";
        String inValidUser = "qwertyqwer";
        String validPassword = "secret_sauce";
        String invalidPassword = "12345";
        String expectedWrongLoginErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        String nullPasswordLoginError = "Epic sadface: Password is required";
        String nullUserNameLoginError = "Epic sadface: Username is required";

        driver.get(sauceDemoUrl);

        // TC 02 - Failed Login: Valid Username & Invalid Password
        failedLogin(driver, validUser, invalidPassword, expectedWrongLoginErrorMessage);

        // TC 03 - Failed Login: Valid Username & Null Password
        failedLogin(driver, validUser, "", nullPasswordLoginError);

        // TC 04 - Failed Login: Invalid Username & Valid Password
        failedLogin(driver, inValidUser, validPassword, expectedWrongLoginErrorMessage);

        // TC 05 - Failed Login: Invalid Username & Invalid Password
        failedLogin(driver, inValidUser, invalidPassword, expectedWrongLoginErrorMessage);

        // TC 06 - Failed Login: Invalid Username & Null Password
        failedLogin(driver, inValidUser, "", nullPasswordLoginError);

        // TC 07 - Failed Login: Null Username & Valid Password
        failedLogin(driver, "", validPassword, nullUserNameLoginError);

        // TC 08 - Failed Login: Null Username & Invalid Password
        failedLogin(driver, "", invalidPassword, nullUserNameLoginError);

        // TC 09 - Failed Login: Null Username & Null Password
        failedLogin(driver, "", "", nullUserNameLoginError);

        // TC 01 - Successful Login: Valid Username & Valid Password
        successfulLogin(driver, validUser, validPassword, inventoryPageUrl);

        driver.quit();
    }

    // Login Method
    static void login(WebDriver driver, String userName, String passWord) {
        driver.navigate().refresh();      // זה מנקה לנו את הטופס לפני תחילת כל לוגין ובכך מונע את נפילת טסט 03
        WebElement userNameElement = driver.findElement(By.cssSelector(LoginPage05.userNameLocator));
        userNameElement.sendKeys(userName);

        WebElement passWordElement = driver.findElement(By.cssSelector(LoginPage05.passWordLocator));
        passWordElement.sendKeys(passWord);

        WebElement loginButtonElement = driver.findElement(By.cssSelector(LoginPage05.loginButtonLocator));
        loginButtonElement.click();
    }

    // Helper method to get error message
    static String getErrorMessage(WebDriver driver) {
        WebElement errorMessageElement = driver.findElement(By.cssSelector(LoginPage05.loginErrorMessageLocator));
        return errorMessageElement.getText();
    }

    // Helper method for assertions
    static void verifyErrorMessage(String expectedMessage, String actualMessage) {
        if (expectedMessage.equals(actualMessage)) {
            System.out.println("TC Passed - Error message matches expected message: " + expectedMessage);
        } else {
            System.out.println("TC Failed - Error message does not match! Actual message is: " + actualMessage);
        }
    }

    // Failed Login test cases
    public static void failedLogin(WebDriver driver, String userName, String passWord, String expectedErrorMessage) {
        login(driver, userName, passWord);
        verifyErrorMessage(expectedErrorMessage, getErrorMessage(driver));
    }

    // Successful Login test cases
    public static void successfulLogin(WebDriver driver, String userName, String passWord, String inventoryPageUrl) {
        login(driver, userName, passWord);
        String currentUrl = driver.getCurrentUrl();
        if (inventoryPageUrl.equals(currentUrl)) {
            System.out.println("TC Passed - Current URL matches expected URL: " + inventoryPageUrl);
        } else {
            System.out.println("TC Failed - Current URL does not match! Actual URL is: " + currentUrl);
        }
    }
}