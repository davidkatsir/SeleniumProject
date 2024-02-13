package swagLabs04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwagLabs04 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String sauceDemoUrl = "https://www.saucedemo.com/";
        String standardUser = "standard_user";
        String validPassword = "secret_sauce";
        String invalidPassword = "12345";
        String expectedWrongLoginErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        String nullPasswordLoginError = "Epic sadface: Password is required";

        driver.get(sauceDemoUrl);

        // TC 02 - Failed Login: Valid Username & Invalid Password
        tc02_FailedLoginValidUsrInvalidPWD(driver, standardUser, invalidPassword, expectedWrongLoginErrorMessage);

//        // TC 03 - Failed Login: Valid Username & Null Password
        tc03_FailedLoginValidUsrNullPWD(driver, standardUser, "", nullPasswordLoginError);

        driver.quit();
    }

    // Login Method
    static void login(WebDriver driver, String userName, String passWord) {
        WebElement userNameElement = driver.findElement(By.cssSelector(LoginPage04.userNameLocator));
        userNameElement.sendKeys(userName);

        WebElement passWordElement = driver.findElement(By.cssSelector(LoginPage04.passWordLocator));
        passWordElement.sendKeys(passWord);

        WebElement loginButtonElement = driver.findElement(By.cssSelector(LoginPage04.loginButtonLocator));
        loginButtonElement.click();
    }

    // Helper method to get error message
    static String getErrorMessage(WebDriver driver) {
        WebElement errorMessageElement = driver.findElement(By.cssSelector(LoginPage04.loginErrorMessageLocator));
        return errorMessageElement.getText();
    }

    // Helper method for assertions
    static void verifyErrorMessage(String expectedMessage, String actualMessage) {
        if (expectedMessage.equals(actualMessage)) {
            System.out.println("Error message matches expected message: " + expectedMessage);
        } else {
            System.out.println("Error message does not match! Actual message is: " + actualMessage);
        }
    }

    // Test Case Methods:

    // TC 02 - Failed Login: Valid Username & Invalid Password
    public static void tc02_FailedLoginValidUsrInvalidPWD(WebDriver driver, String userName, String passWord, String expectedErrorMessage) {
        login(driver, userName, passWord);
        verifyErrorMessage(expectedErrorMessage, getErrorMessage(driver));
    }

    // TC 03 - Failed Login: Valid Username & Null Password
    public static void tc03_FailedLoginValidUsrNullPWD(WebDriver driver, String userName, String passWord, String expectedErrorMessage) {
        login(driver, userName, passWord);
        verifyErrorMessage(expectedErrorMessage, getErrorMessage(driver));
    }
}