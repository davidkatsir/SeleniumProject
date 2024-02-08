package swagLabs01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwagLabs01 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        // עכשיו אנחנו רוצים לעשות לוגין לאתר
        // Insert User Name
        driver.findElement(By.cssSelector("[data-test=\"username\"]")).sendKeys("standard_user");
        // אפשר גם לכתוב את אותו הדבר ע"י שימוש ב- ID, לדוגמא -
//        driver.findElement(By.cssSelector("[id=\"user-name\"]")).sendKeys("standard_user");
        // אבל אם אנחנו מקבלים 'data-test' מוכנים, זה תמיד יהיה הכי טוב
        // כי זה ייעודי עבור אוטומציה
        // לא לשכוח לעטוף עם []
        // אפשר גם לכתוב את זה ב- CSS טהור - user-name# במקום "id="user-name
        // אני מעדיף לכתוב בצורת - [id=\"user-name\"]
        // ז"א כ- Attribute

        // שאלה - למה אנחנו רואים פה תוספת של '\' ?
        // התשובה היא Escaping ואפשר להימנע מזה ע"י שימוש בגרש יחיד (') במקום כפול (")
        Thread.sleep(1000);  // על מנת שנוכל לראות את הפעולות בינתיים בהילוך איטי יותר

        // Insert Password
        driver.findElement(By.cssSelector("[data-test=\"password\"]")).sendKeys("secret_sauce");
        Thread.sleep(1000);  // על מנת שנוכל לראות את הפעולות בינתיים בהילוך איטי יותר

        // לא תמיד יהיה לנו ID או data-test או NAME שנוכל להתשתמש בהם
        // במצב כזה ננסה לחפש ברמה גבוהה יותר למשל ה- CLASS
        //במקרה שלנו - [class="input_error form_input"] (זה שני קלאסים - יש שם רווח)
        //וזה גם לא חד ערכי, לכן זה לא טוב לנו

        // Click Login
        driver.findElement(By.cssSelector("[id=\"login-button\"]")).click();

        Thread.sleep(2000);  // על מנת שנוכל לראות את הפעולות בינתיים בהילוך איטי יותר
        driver.quit();
    }
}