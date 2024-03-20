package seleniumTirgul;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTargil1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://prd.canvusapps.com/signup/");

        // Insert Full Name
        driver.findElement(By.cssSelector("[id=\"user_name\"]")).sendKeys("David Katsir");

        // Insert Email
        driver.findElement(By.cssSelector("[id=\"user_email\"]")).sendKeys("david@gmail.com");

        // Insert Password
        driver.findElement(By.cssSelector("[id=\"user_password\"]")).sendKeys("12345");

        // Confirm Password
        driver.findElement(By.cssSelector("[id=\"user_password_confirmation\"]")).sendKeys("12345");

        // Insert Company Name
        driver.findElement(By.cssSelector("[id=\"company_name\"]")).sendKeys("David Katsir ltd");

        // Click Sign Up
//        driver.findElement(By.cssSelector("[name=\"commit\"]")).click();                   // Name can be used
        driver.findElement(By.cssSelector("[class=\"submit btn btn-primary\"]")).click();  // Class is stronger

        // Read and print Error message
        String erroMessage = driver.findElement(By.cssSelector("[class=\"alert alert-error alert-block error\"]")).getText();
        System.out.println(erroMessage);

        // Verifying that the Error message is as expected
        String expectedErrorMessage = "We couldn't set up that account, sorry. Please try again, or contact an admin (link is above).";
        if (erroMessage.equals(expectedErrorMessage)) {
            System.out.println("Error message is as expected");
        } else {
            System.out.println("Error message is NOT as expected");
        }
        Thread.sleep(1000);
        driver.quit();
    }
}