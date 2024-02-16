package swagLabsFinalExcersize;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPageFinalEx {
    public static final String inventoryPageUrl = SwagLabsFinalEx.sauceDemoBaseUrl + "inventory.html"; // "https://www.saucedemo.com/inventory.html"

    // Page Locators
    public static final String addToCart_SauceLabsBackpackButton = "[id=\"add-to-cart-sauce-labs-backpack\"]";
    public static final String removeFromCart_SauceLabsBackpackButton = "[id=\"remove-sauce-labs-backpack\"]";
    public static final String shoppingCartBadge = "[class=\"shopping_cart_badge\"]";

    // Clicks on the Add to Cart button of the selected item
    public static void addItemToCart(WebDriver driver, String addItemToCart) {
        WebElement addItemToCartElement = driver.findElement(By.cssSelector(addItemToCart));
        addItemToCartElement.click();
    }
}
