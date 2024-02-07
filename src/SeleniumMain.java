import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumMain {
    //    public static void main(String[] args) {
    public static void main(String[] args) throws InterruptedException {
        // 'throws InterruptedException' is added for the 'Thread.sleep(1000);'

//        System.setProperty("webdriver.chrome.driver", "c:\\automation\\drivers\\chromedriver.exe");
        // השורה הזו היום כבר לא נדרשת
        // בעקרון צריך את הדרייבר בשביל לתרגם את הפקודות בקוד לשפה שהדפדפן מבין
        // בעבר היו מורידים לבד את הדרייבר (בגרסת סלניום ישנה 3.141 למשל
        // אנחנו בגרסת סלניום 4.16.1)
        //  זה גורם לבעיה של אי תאימות גרסאות די מהר
        // סלניום מימשו את זה כחלק מהספריה
        // אתה אומר באיזה דפדפן אתה הולך להשתמש - סלניום עושה בשבילך את כל השאר
        // ניגש לרשת - מבקש גרסת דרייבר מדויקת או קרובה לגרסת הדפדפן ומשתמש בו
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        // למה חשוב לעבוד עם Maximize?
        // לתת כדוגמא את ההמבורגר שמופיע ב- w3school ברגע שמקטינים את המסך

        // עד כאן זה יהיה תמיד זהה
        // מכאן מתחילים הצעדים של הטסטים שלנו

        driver.get("https://www.ebay.com/");        // Navigating to eBay
        Thread.sleep(1000);                    // השהיה של 1 שניה, כאן זה מיועד רק לנו שנספיק לראות מה קורה
        System.out.println(driver.getTitle());       // מביא את הכותרת של הטאב
        System.out.println(driver.getCurrentUrl());  // מביא את כתובת האתר הנוכחי
//        System.out.println(driver.getPageSource()); // מביא את כל ה- HTML

        driver.get("https://www.google.com/");  // Navigating to Google
        Thread.sleep(1000);
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.navigate().back(); // Navigating back to eBay
        Thread.sleep(1000);
        System.out.println(driver.getCurrentUrl());

        driver.navigate().forward(); // Navigating forward again to Google
        Thread.sleep(1000);
        System.out.println(driver.getCurrentUrl());

        driver.navigate().refresh(); // Will refresh Google (current site)
        Thread.sleep(1000);
        System.out.println(driver.getCurrentUrl());

        driver.quit();
    }
}