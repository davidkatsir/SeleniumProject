package swagLabsFinalExcersize;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YourCartPageFinalEx {
    public static final String yourCartPageUrl = SwagLabsFinalEx.sauceDemoBaseUrl + "cart.html"; // "https://www.saucedemo.com/cart.html"

    // Locators -
    public static final String cartQuantityLocator = "[class=\"cart_quantity\"]";
    public static final String inventoryItemNameLocator = "[class=\"inventory_item_name\"]";
    public static final String inventoryItemPriceLocator = "[class=\"inventory_item_price\"]";
    public static final String checkoutButtonLocator = "[id=\"checkout\"]";

    public static void validateYourCartItems(WebDriver driver, String itemQty, String itemName, String itemPrice) {
        WebElement itemQuantityElement = driver.findElement(By.cssSelector(cartQuantityLocator));
        String actualItemQuantity = itemQuantityElement.getText();
        if (actualItemQuantity.equals(itemQty)) {
            System.out.println("Item quantity is as expected: " + itemQty);
        } else {
            System.out.println("Item quantity is NOT as expected! Actual quantity is: " + actualItemQuantity);
        }

        WebElement itemNameDescriptionElement = driver.findElement(By.cssSelector(inventoryItemNameLocator));
        String actualItemNameDescription = itemNameDescriptionElement.getText();
        if (actualItemNameDescription.equals(itemName)) {
            System.out.println("Item's Name is as expected: " + itemName);
        } else {
            System.out.println("Item's Name is NOT as expected! Actual Name is: " + actualItemNameDescription);
        }

        WebElement itemPriceElement = driver.findElement(By.cssSelector(inventoryItemPriceLocator));
        String actualItemPrice = itemPriceElement.getText();
        if (actualItemPrice.equals(itemPrice)) {
            System.out.println("Item's Price is as expected: " + itemPrice);
        } else {
            System.out.println("Item's Price is NOT as expected! Actual price is: " + actualItemPrice);
        }
    }

}
