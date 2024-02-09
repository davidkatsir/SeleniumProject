package seleniumTirgul;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTargil2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://login.salesforce.com/");

        // Click ‘Forgot Your Password?’ link
        driver.findElement(By.cssSelector("[id=\"forgot_password_link\"]")).click();

        // Get the new page title
        String newPageTitle = driver.getTitle();

        // Check if the new title contains 'Forgot Your Password'
        if (newPageTitle.contains("Forgot Your Password")) {
            // Add your username
            driver.findElement(By.cssSelector("[id=\"un\"]")).sendKeys("david999");

            // Click the 'Continue' button
            driver.findElement(By.cssSelector("[id=\"continue\"]")).click();

            // Get the message and print it
            String message = driver.findElement(By.cssSelector("[class=\"mb16 error\"]")).getText();
            System.out.println(message);

            // Verifying that the Error message is as expected
            String expectedMessage = "We can’t find a username that matches what you entered. Verify that your username is an email address (for example, username@company.com).";
            if (message.equals(expectedMessage)) {
                System.out.println("Message is as expected");
            } else {
                System.out.println("Message is NOT as expected");
            }
        } else {
            System.out.println("The new title does not contain 'Forgot Your Password'");
        }
        Thread.sleep(1000);
        driver.quit();
    }
}