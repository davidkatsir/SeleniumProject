package swagLabsFinalExcersize;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPageFinalEx {
    public static final String inventoryPageUrl = SwagLabsFinalEx.sauceDemoBaseUrl + "inventory.html"; // "https://www.saucedemo.com/inventory.html"

    // Page Locators
    public static final String addToCart_SauceLabsBackpackButtonLocator = "[id=\"add-to-cart-sauce-labs-backpack\"]";
    public static final String removeFromCart_SauceLabsBackpackButtonLocator = "[id=\"remove-sauce-labs-backpack\"]";
    public static final String shoppingCartBadgeLocator = "[class=\"shopping_cart_badge\"]";

    // Clicks on the Add to Cart button of the selected item and verifies that the button is now - Remove
    public static void addItemToCartAndVerifyButtonCaption(WebDriver driver, String addItemToCart, String removeFromCartButton) {
        WebElement addItemToCartElement = driver.findElement(By.cssSelector(addItemToCart));
        addItemToCartElement.click();
        WebElement removeItemFromCartElement = driver.findElement(By.cssSelector(removeFromCartButton));
        String removeItemFromCartButtonActualCaption = removeItemFromCartElement.getText();
        String removeButtonExpectedCaption = "Remove";
        if (removeItemFromCartButtonActualCaption.equals(removeButtonExpectedCaption)) {
            System.out.println("Add to cart button's caption changed as expected and it is now: " + removeButtonExpectedCaption);
        } else {
            System.out.println("Add to cart button's caption DID NOT change as expected! Actual caption is: " + removeItemFromCartButtonActualCaption);
        }
    }
}
