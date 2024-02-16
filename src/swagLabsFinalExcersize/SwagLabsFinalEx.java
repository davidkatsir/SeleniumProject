package swagLabsFinalExcersize;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwagLabsFinalEx {
    public static final String sauceDemoBaseUrl = "https://www.saucedemo.com/";

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String validUser = "standard_user";
        String validPassword = "secret_sauce";
//        String expectedWrongLoginErrorMessage = "Epic sadface: Username and password do not match any user in this service";
//        String nullPasswordLoginError = "Epic sadface: Password is required";
//        String nullUserNameLoginError = "Epic sadface: Username is required";

        driver.get(sauceDemoBaseUrl);

        // Step 01 - Successful Login: Valid Username & Valid Password
        successfulLogin(driver, validUser, validPassword, InventoryPageFinalEx.inventoryPageUrl);

        // Step 02 - in Inventory page, add item "Sauce Labs Backpack" to cart
        validateNavigation(driver, InventoryPageFinalEx.inventoryPageUrl);
        InventoryPageFinalEx.addItemToCart(driver, InventoryPageFinalEx.addToCart_SauceLabsBackpackButton);


        driver.quit();
    }

    // Login Method
    static void login(WebDriver driver, String userName, String passWord) {
        driver.navigate().refresh();
        WebElement userNameElement = driver.findElement(By.cssSelector(LoginPageFinalEx.userNameLocator));
        userNameElement.sendKeys(userName);

        WebElement passWordElement = driver.findElement(By.cssSelector(LoginPageFinalEx.passWordLocator));
        passWordElement.sendKeys(passWord);

        WebElement loginButtonElement = driver.findElement(By.cssSelector(LoginPageFinalEx.loginButtonLocator));
        loginButtonElement.click();
    }

    // Helper method to get error message
    static String getErrorMessage(WebDriver driver) {
        WebElement errorMessageElement = driver.findElement(By.cssSelector(LoginPageFinalEx.loginErrorMessageLocator));
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

    // Successful Login test cases
    public static void successfulLogin(WebDriver driver, String userName, String passWord, String expectedPageUrl) {
        login(driver, userName, passWord);
        validateNavigation(driver, expectedPageUrl);
    }

    public static void validateNavigation(WebDriver driver, String expectedPageUrl) {
        String currentUrl = driver.getCurrentUrl();
        if (expectedPageUrl.equals(currentUrl)) {
            System.out.println("Step Passed - Current URL matches expected URL: " + expectedPageUrl);
        } else {
            System.out.println("Step Failed - Current URL does not match! Actual URL is: " + currentUrl);
        }
    }
}