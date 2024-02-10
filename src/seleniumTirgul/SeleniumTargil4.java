package seleniumTirgul;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

public class SeleniumTargil4 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // כאן אנחנו עולים רמה וכותבים את כל הלוקייטורים והמשתנים במרוכז למעלה
        String salesforceURL = "https://login.salesforce.com/";
        String usernameFieldLocator = "[id=\"username\"]";
        String passwordFieldLocator = "[id=\"password\"]";
        String rememberMeCheckboxLocator = "[id=\"rememberUn\"]";
        String loginButtonLocator = "[id=\"Login\"]";
        String errorMessageLocator = "[id=\"error\"]";
        String password = "12345";

        // Generate random number for username
        Random random = new Random();
        int randomNumber = random.nextInt(10000);
        String username = "david" + randomNumber;

        // Set expected error message
        String expectedErrorMessage = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";

        // Open Salesforce login page
        driver.get(salesforceURL);

        // Enter username
        //                       WebElement להסביר את השימוש ב -
        WebElement usernameField = driver.findElement(By.cssSelector(usernameFieldLocator));
        usernameField.sendKeys(username);

        // Enter password
        WebElement passwordField = driver.findElement(By.cssSelector(passwordFieldLocator));
        passwordField.sendKeys(password);

        // Check 'remember me' checkbox
        WebElement rememberMeCheckbox = driver.findElement(By.cssSelector(rememberMeCheckboxLocator));
        rememberMeCheckbox.click();

        // Verify checkbox is checked and click Login
        if (rememberMeCheckbox.isSelected()) {
            System.out.println("Remember me checkbox is checked.");
            WebElement loginButton = driver.findElement(By.cssSelector(loginButtonLocator));
            loginButton.click();
        } else {
            System.out.println("Error: Remember me checkbox is not checked.");
        }

        // Wait for a fixed time before checking for error message (potentially unreliable)
        // Problems with Tread.sleep:
        // Unreliable timing, can lead to flaky tests.
        // Potentially slows down tests if element loads quickly.
        Thread.sleep(1000);  // Wait for 1 second
        WebElement errorMessage = driver.findElement(By.cssSelector(errorMessageLocator));

        // Print error message and verify it matches expected message
        String actualErrorMessage = errorMessage.getText();
        System.out.println("Error message: " + actualErrorMessage);
        if (actualErrorMessage.equals(expectedErrorMessage)) {
            System.out.println("Error message matches expected message.");
        } else {
            System.out.println("Error message does not match expected message.");
        }

        // Close browser
        driver.quit();
    }
}