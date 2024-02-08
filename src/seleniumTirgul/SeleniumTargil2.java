package seleniumTirgul;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTargil2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("");



        Thread.sleep(1000);
        driver.quit();
    }
}


public class SalesforcePasswordResetTest {
    public static void main(String[] args) {

        // Initialize the Chrome driver
        WebDriver driver = new ChromeDriver();

        // Open the Salesforce login page
        driver.get("https://login.salesforce.com/");

        // Click on the 'Forgot Your Password?' link
        driver.findElement(By.linkText("Forgot Your Password?")).click();

        // Get the new page title
        String newPageTitle = driver.getTitle();

        // Check if the new title contains 'Forgot Your Password'
        if (newPageTitle.contains("Forgot Your Password")) {
            // Add your user name
            driver.findElement(By.id("username")).sendKeys("your_username");

            // Click the 'Continue' button
            driver.findElement(By.id("continue_button_id")).click();

            // Get the message and print it
            String message = driver.findElement(By.id("message_id")).getText();
            System.out.println(message);
        } else {
            System.out.println("The new title does not contain 'Forgot Your Password'");
        }

        // Close the browser
        driver.quit();
    }
}
