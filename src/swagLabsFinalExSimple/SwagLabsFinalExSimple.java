package swagLabsFinalExSimple;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwagLabsFinalExSimple {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        tc110OrderProduct(driver, "standard_user", "secret_sauce", "Meytal", "Shitrit", "123456");

        driver.quit();

    }

    //login
    public static void login(WebDriver driver, String userName, String password) {
        //insert user name
        driver.findElement(By.cssSelector("#user-name")).sendKeys(userName);
        //insert password
        driver.findElement(By.cssSelector("#password")).sendKeys(password);
        //click login
        driver.findElement(By.cssSelector("#login-button")).click();
    }

    //fill info
    public static void fillInfo(WebDriver driver, String firstName, String lastName, String postalCode) {
        //insert user name
        driver.findElement(By.cssSelector("#first-name")).sendKeys(firstName);
        //insert password
        driver.findElement(By.cssSelector("#last-name")).sendKeys(lastName);
        //click login
        driver.findElement(By.cssSelector("#postal-code")).sendKeys("123456");
    }

    //click element
    public static void clickEl(WebDriver driver, String selector) {
        driver.findElement(By.cssSelector(selector)).click();
    }

    //get expected and actual and return string pass or failed
    public static String testStep(WebDriver driver, String expected, String actual) {
        if (expected.equals(actual)) {
            return " Pass";
        } else {
            return " Failed";
        }

    }

    //step 2 - perform login
    public static void step2(WebDriver driver, String userName, String password) {
        login(driver, userName, password);

        String expected = "Products";
        String actual = driver.findElement(By.cssSelector(".title")).getText();
        System.out.println("Step 2" + testStep(driver, expected, actual));

    }

    //step 3 - add product to cart
    public static void step3(WebDriver driver, String selector) {
        clickEl(driver, selector);

        String expected = "1";
        String actual = driver.findElement(By.cssSelector(".shopping_cart_badge")).getText();
        System.out.println("Step 3" + testStep(driver, expected, actual));
    }

    //step 4 - click cart element
    public static void step4(WebDriver driver, String selector) {
        clickEl(driver, selector);

        String expected = "Your Cart";
        String actual = driver.findElement(By.cssSelector(".title")).getText();
        System.out.println("Step 4" + testStep(driver, expected, actual));
    }

    //step 5 - click checkout
    public static void step5(WebDriver driver, String selector) {
        clickEl(driver, selector);

        String expected = "Checkout: Your Information";
        String actual = driver.findElement(By.cssSelector(".title")).getText();
        System.out.println("Step 5" + testStep(driver, expected, actual));
    }

    //step 6 - fill in your information + click continue
    public static void step6(WebDriver driver, String firstName, String lastName, String postalCode, String selector) {
        fillInfo(driver, firstName, lastName, postalCode);
        clickEl(driver, selector);

        String expected = "Checkout: Overview";
        String actual = driver.findElement(By.cssSelector(".title")).getText();
        System.out.println("Step 6" + testStep(driver, expected, actual));
    }

    //step 7 - click finish
    public static void step7(WebDriver driver, String selector) {
        clickEl(driver, selector);

        String expected = "Thank you for your order!";
        String actual = driver.findElement(By.cssSelector(".complete-header")).getText();
        System.out.println("Step 7" + testStep(driver, expected, actual));
    }

    //tc - order one product
    public static void tc110OrderProduct(WebDriver driver, String userName, String password, String firstName, String lastName, String postalCode) {

        step2(driver, userName, password);
        step3(driver, "#add-to-cart-sauce-labs-backpack");
        step4(driver, ".shopping_cart_link");
        step5(driver, "#checkout");
        step6(driver, firstName, lastName, postalCode, "#continue");
        step7(driver, "#finish");
    }
}
