package swagLabsFinalExcersize;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutCompletePageFinalEx {
    public static final String checkoutCompletePageUrl = SwagLabsFinalEx.sauceDemoBaseUrl + "checkout-complete.html"; // //https://www.saucedemo.com/checkout-complete.html
    // Locators -
    public static final String CheckoutCompleteThankYouHeaderLocator = "[class=\"complete-header\"]";
    public static final String CheckoutCompleteFullTextLocator = "[class=\"complete-text\"]";
    public static final String CheckoutCompleteBackToHomeButtonLocator = "[id=\"back-to-products\"]";


    public static void validateCheckoutCompleteTextFields(WebDriver driver, String thankYouHeader, String fullText) {
        WebElement thankYouHeaderElement = driver.findElement(By.cssSelector(CheckoutCompleteThankYouHeaderLocator));
        String actualThankYouHeader = thankYouHeaderElement.getText();
        if (actualThankYouHeader.equals(thankYouHeader)) {
            System.out.println("Thank You Header is as expected: " + thankYouHeader);
        } else {
            System.out.println("Thank You Header is NOT as expected! Actual Thank You Header is: " + actualThankYouHeader);
        }
        WebElement fullTextElement = driver.findElement(By.cssSelector(CheckoutCompleteFullTextLocator));
        String actualFullText = fullTextElement.getText();
        if (actualFullText.equals(fullText)) {
            System.out.println("Full Text is as expected: " + fullText);
        } else {
            System.out.println("Full Text  is NOT as expected! Actual Full Text  is: " + actualFullText);
        }
    }
}
