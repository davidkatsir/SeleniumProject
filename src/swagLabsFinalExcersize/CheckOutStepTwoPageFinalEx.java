package swagLabsFinalExcersize;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutStepTwoPageFinalEx {
    public static final String checkoutStepTwoPageUrl = SwagLabsFinalEx.sauceDemoBaseUrl + "checkout-step-two.html"; // https://www.saucedemo.com/checkout-step-two.html
    // Locators -
    public static final String checkoutOverviewCartQuantityLocator = "[class=\"cart_quantity\"]";
    public static final String checkoutOverviewItemNameLocator = "[class=\"inventory_item_name\"]";
    public static final String checkoutOverviewItemPriceLocator = "[class=\"inventory_item_price\"]";
    public static final String checkoutOverviewPaymentInformationLocator = "[class=\"summary_info_label\"]:first-child + [class=\"summary_value_label\"]";
    public static final String checkoutOverviewShippingInformationLocator = "[class=\"summary_info\"] [class=\"summary_value_label\"]:nth-child(4)";
    public static final String checkoutOverviewItemTotalLocator = "[class=\"summary_subtotal_label\"]";
    public static final String checkoutOverviewItemTaxLocator = "[class=\"summary_tax_label\"]";
    public static final String checkoutOverviewSummaryTotalLabelLocator = "[class=\"summary_total_label\"]";
    public static final String checkoutOverviewFinishButtonLocator = "[id=\"finish\"]";

    public static void validateCheckoutOverviewDetails
            (WebDriver driver, String itemQty, String itemName,
             String itemPrice, String paymentInformation, String shippingInformation,
             String itemTotal, String itemTax, String summaryTotal) {
        WebElement itemQuantityElement = driver.findElement(By.cssSelector(checkoutOverviewCartQuantityLocator));
        String actualItemQuantity = itemQuantityElement.getText();
        if (actualItemQuantity.equals(itemQty)) {
            System.out.println("Checkout Overview - Item quantity is as expected: " + itemQty);
        } else {
            System.out.println("Checkout Overview - Item quantity is NOT as expected! Actual quantity is: " + actualItemQuantity);
        }

        WebElement itemNameDescriptionElement = driver.findElement(By.cssSelector(checkoutOverviewItemNameLocator));
        String actualItemNameDescription = itemNameDescriptionElement.getText();
        if (actualItemNameDescription.equals(itemName)) {
            System.out.println("Checkout Overview - Item's Name is as expected: " + itemName);
        } else {
            System.out.println("Checkout Overview - Item's Name is NOT as expected! Actual Name is: " + actualItemNameDescription);
        }

        WebElement itemPriceElement = driver.findElement(By.cssSelector(checkoutOverviewItemPriceLocator));
        String actualItemPrice = itemPriceElement.getText();
        if (actualItemPrice.equals(itemPrice)) {
            System.out.println("Checkout Overview - Item's Price is as expected: " + itemPrice);
        } else {
            System.out.println("Checkout Overview - Item's Price is NOT as expected! Actual price is: " + actualItemPrice);
        }

        WebElement paymentInformationElement = driver.findElement(By.cssSelector(checkoutOverviewPaymentInformationLocator));
        String actualPaymentInformation = paymentInformationElement.getText();
        if (actualPaymentInformation.equals(paymentInformation)) {
            System.out.println("Checkout Overview - Payment's Information is as expected: " + paymentInformation);
        } else {
            System.out.println("Checkout Overview - Payment's Information is NOT as expected! Actual Payment's Information is: " + actualPaymentInformation);
        }

        WebElement shippingInformationElement = driver.findElement(By.cssSelector(checkoutOverviewShippingInformationLocator));
        String actualShippingInformation = shippingInformationElement.getText();
        if (actualShippingInformation.equals(shippingInformation)) {
            System.out.println("Checkout Overview - Shipping Information is as expected: " + shippingInformation);
        } else {
            System.out.println("Checkout Overview - Shipping Information is NOT as expected! Actual Shipping Information is: " + actualShippingInformation);
        }

        WebElement itemTotalElement = driver.findElement(By.cssSelector(checkoutOverviewItemTotalLocator));
        String actualItemTotal = itemTotalElement.getText();
        if (actualItemTotal.equals(itemTotal)) {
            System.out.println("Checkout Overview - Item Total is as expected: " + itemTotal);
        } else {
            System.out.println("Checkout Overview - Item Total is NOT as expected! Actual Item Total is: " + actualItemTotal);
        }

        WebElement itemTaxElement = driver.findElement(By.cssSelector(checkoutOverviewItemTaxLocator));
        String actualItemTax = itemTaxElement.getText();
        if (actualItemTax.equals(itemTax)) {
            System.out.println("Checkout Overview - Item Tax is as expected: " + itemTax);
        } else {
            System.out.println("Checkout Overview - Item Tax is NOT as expected! Actual Item Tax is: " + actualItemTax);
        }

        WebElement summaryTotalElement = driver.findElement(By.cssSelector(checkoutOverviewSummaryTotalLabelLocator));
        String actualSummaryTotal = summaryTotalElement.getText();
        if (actualSummaryTotal.equals(summaryTotal)) {
            System.out.println("Checkout Overview - Summary Total is as expected: " + summaryTotal);
        } else {
            System.out.println("Checkout Overview - Summary Total is NOT as expected! Actual Summary Total is: " + actualSummaryTotal);
        }
    }
}
