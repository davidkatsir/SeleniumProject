package seleniumTirgul;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTargil3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.ebay.com/sch/ebayadvsearch/");

        // Add ‘tent’ to the ‘Enter keywords or item number’ text box
        driver.findElement(By.cssSelector("[data-testid=\"_nkw\"]")).sendKeys("tent");

        // Add some words to the ‘Exclude words from your search’ text box
        driver.findElement(By.cssSelector("[data-testid=\"_ex_kw\"]")).sendKeys("tent1, tent2, tent3");

        // Check the ‘Buy It Now’ check box
        driver.findElement(By.cssSelector("[data-testid=\"s0-1-17-6[3]-[2]-LH_BIN\"]")).click();

        // Press the Search button on the bottom of the page
        driver.findElement(By.cssSelector("[class=\"adv-form__actions\"]>button")).click();

        // Navigate back
        driver.navigate().back();

        // Press on the search button on the top of the page (*Can you do it?)
        driver.findElement(By.cssSelector("[class=\"field adv-keywords__btn-help\"]>button")).click();

        driver.quit();
    }
}