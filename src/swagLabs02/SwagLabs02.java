package swagLabs02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwagLabs02 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String sauceDemoUrl = "https://www.saucedemo.com/";

        // Page Locators -
        String userNameLocator = "[data-test=\"username\"]";
        String passWordLocator = "[data-test=\"password\"]";
        String loginButtonLocator = "[id=\"login-button\"]";
        String loginErrorMessageLocator = "[data-test=\"error\"]";

        String validPassword = "secret_sauce";
        String invalidPassword = "12345";
        String nullPassword = "";

        String expectedWrongLoginErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        String nullPasswordLoginError = "Epic sadface: Password is required";

        // UserName options -
        String standardUser = "standard_user";


        // TC 02 - Failed Login: Valid Username & Invalid Password
        driver.get(sauceDemoUrl);

        // Insert User Name
        WebElement userName = driver.findElement(By.cssSelector(userNameLocator));
        userName.sendKeys(standardUser);

        // Insert Password
        WebElement passWord = driver.findElement(By.cssSelector(passWordLocator));
        passWord.sendKeys(invalidPassword);

        // Click Login
        WebElement loginButton = driver.findElement(By.cssSelector(loginButtonLocator));
        loginButton.click();

        // Get error message text
        WebElement errorMessage = driver.findElement(By.cssSelector(loginErrorMessageLocator));
        errorMessage.getText();

        // Print error message and verify it matches expected message
        String actualErrorMessage = errorMessage.getText();
        System.out.println("TC 02 - Actual error message is: " + actualErrorMessage);
        if (actualErrorMessage.equals(expectedWrongLoginErrorMessage)) {
            System.out.println("Error message matches expected message.");
        } else {
            System.out.println("Error message does not match expected message.");
        }

        //*************************************************************************

        // TC 03 - Failed login - Valid UserName & Null Password

        // Insert User Name
        userName.sendKeys(standardUser);

        // Insert Password
        passWord.sendKeys(nullPassword);

        // Click Login
        loginButton.click();

        // Get error message text
        errorMessage.getText();

        // Print error message and verify it matches expected message
        actualErrorMessage = errorMessage.getText();
        System.out.println("TC 03 - Actual error message is: " + actualErrorMessage);
        if (actualErrorMessage.equals(nullPasswordLoginError)) {
            System.out.println("Error message matches expected message.");
        } else {
            System.out.println("Error message does not match expected message.");
        }


        driver.quit();

        // יש לנו כאן המון כפילות קוד ולכן נשכתב
        // ונעבור ל- package swagLabs03
        // ו- class SwagLabs03
    }
}