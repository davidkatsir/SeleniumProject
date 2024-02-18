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
        String firstName = "David";
        String lastName = "Katsir";
        String postalCode = "12456987";
        String cartBadgeQty = "1";
        String inventoryItemQty = "1";
        String inventoryItemName = "Sauce Labs Backpack";
        String inventoryItemPrice = "$29.99";
        String checkoutOverviewItemQty = "1";
        String checkoutOverviewItemName = "Sauce Labs Backpack";
        String checkoutOverviewItemPrice = "$29.99";
        String checkoutOverviewPaymentInformation = "SauceCard #31337";
        String checkoutOverviewShippingInformation = "Free Pony Express Delivery!";
        String checkoutOverviewItemTotal = "Item total: $29.99";
        String checkoutOverviewItemTax = "Tax: $2.40";
        String checkoutOverviewSummaryTotal = "Total: $32.39";
        String checkoutCompleteThankYouHeader = "Thank you for your order!";
        String checkoutCompleteFullText = "Your order has been dispatched, and will arrive just as fast as the pony can get there!";

        // Test case: Order Product (E2E)
        driver.get(sauceDemoBaseUrl);

        // Step 01 - Successful Login: Valid Username & Valid Password + Validate navigation to Inventory page
        login(driver, validUser, validPassword);
        validateNavigation(driver, InventoryPageFinalEx.inventoryPageUrl);

        // Step 02 - in Inventory page, add item "Sauce Labs Backpack" to cart and validate that
        // the Add to Cart button is now - Remove
        InventoryPageFinalEx.addItemToCartAndVerifyButtonCaption
                (driver, InventoryPageFinalEx.addToCart_SauceLabsBackpackButtonLocator, InventoryPageFinalEx.removeFromCart_SauceLabsBackpackButtonLocator);
        // Validate Cart bubble value
        validateCartBadgeValue(driver, cartBadgeQty, InventoryPageFinalEx.shoppingCartBadgeLocator);

        // Step 03 - Press on the cart icon
        clickElement(driver, InventoryPageFinalEx.shoppingCartBadgeLocator);
        // "YOUR CART" screen and product details will be displayed
        validateNavigation(driver, YourCartPageFinalEx.yourCartPageUrl);
        // verify details are correct
        YourCartPageFinalEx.validateYourCartItems(driver, inventoryItemQty, inventoryItemName, inventoryItemPrice);

        // Step 04 - Press "CHECKOUT" button => "CHECKOUT: YOUR INFORMATION" screen will appear successfully
        clickElement(driver, YourCartPageFinalEx.checkoutButtonLocator);
        validateNavigation(driver, CheckoutStepOnePageFinalEx.checkoutStepOnePageUrl);

        // Step 05 - Insert FIRST NAME , LAST NAME , ZIP(pre-con)   and press "CONTINUE" button
        CheckoutStepOnePageFinalEx.addPersonalDetails(driver, firstName, lastName, postalCode);
        clickElement(driver, CheckoutStepOnePageFinalEx.continueButtonLocator);
        // CHECKOUT OVERVIEW SCREEN WILL appear successfully.
        validateNavigation(driver, CheckOutStepTwoPageFinalEx.checkoutStepTwoPageUrl);
        // verify details are correct
        CheckOutStepTwoPageFinalEx.validateCheckoutOverviewDetails(driver, checkoutOverviewItemQty, checkoutOverviewItemName,
                checkoutOverviewItemPrice, checkoutOverviewPaymentInformation, checkoutOverviewShippingInformation,
                checkoutOverviewItemTotal, checkoutOverviewItemTax, checkoutOverviewSummaryTotal);

        // Step 06 - Press "FINISH" button
        clickElement(driver, CheckOutStepTwoPageFinalEx.checkoutOverviewFinishButtonLocator);
        //CHECKOUT: COMPLETE!  Screen will appear
        validateNavigation(driver, CheckoutCompletePageFinalEx.checkoutCompletePageUrl);
        //with a confirmation message "THANK YOU FOR YOUR ORDER!"
        CheckoutCompletePageFinalEx.validateCheckoutCompleteTestFields(driver, checkoutCompleteThankYouHeader, checkoutCompleteFullText);
        //verify cart bubble disappear ==> Will not be tested in this test
        clickElement(driver, CheckoutCompletePageFinalEx.CheckoutCompleteBackToHomeButtonLocator);
        validateNavigation(driver, InventoryPageFinalEx.inventoryPageUrl);

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

    // Validate Navigation
    public static void validateNavigation(WebDriver driver, String expectedPageUrl) {
        String currentUrl = driver.getCurrentUrl();
        if (expectedPageUrl.equals(currentUrl)) {
            System.out.println("Validation Passed - Current URL matches expected URL: " + expectedPageUrl);
        } else {
            System.out.println("Validation Failed - Current URL does not match! Actual URL is: " + currentUrl);
        }
    }

    // Validate Cart Badge Value
    public static void validateCartBadgeValue(WebDriver driver, String cartBadgeExpectedValue, String cartBadgeSelector) {
        WebElement cartBadgeElement = driver.findElement(By.cssSelector(cartBadgeSelector));
        String cartBadgeActualValue = cartBadgeElement.getText();
        if (cartBadgeExpectedValue.equals(cartBadgeActualValue)) {
            System.out.println("Validation Passed - Cart badge value matches expected value: " + cartBadgeExpectedValue);
        } else {
            System.out.println("Validation failed - Cart badge value Does Not match expected value! Actual value is: " + cartBadgeActualValue);
        }
    }

    // Click Element
    public static void clickElement(WebDriver driver, String elementSelectorToClick) {
        WebElement elementToClick = driver.findElement(By.cssSelector(elementSelectorToClick));
        elementToClick.click();
    }
}