package swagLabsFinalExcersize;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutStepOnePageFinalEx {

    public static final String checkoutStepOnePageUrl = SwagLabsFinalEx.sauceDemoBaseUrl + "checkout-step-one.html"; // "https://www.saucedemo.com/checkout-step-one.html"

    // Page Locators
    public static final String firstNameFieldLocator = "[id=\"first-name\"]";
    public static final String lastNameFieldLocator = "[id=\"last-name\"]";
    public static final String postalCodeFieldLocator = "[id=\"postal-code\"]";
    public static final String continueButtonLocator = "[id=\"continue\"]";


    public static void addPersonalDetails(WebDriver driver, String firstName, String lastName, String postalCode) {
        WebElement firstNameElement = driver.findElement(By.cssSelector(firstNameFieldLocator));
        firstNameElement.sendKeys(firstName);
        WebElement lastNameElement = driver.findElement(By.cssSelector(lastNameFieldLocator));
        lastNameElement.sendKeys(lastName);
        WebElement postalCodeElement = driver.findElement(By.cssSelector(postalCodeFieldLocator));
        postalCodeElement.sendKeys(postalCode);
        System.out.println("First and Last Name + Postal Code - added");
    }
}
