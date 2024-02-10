package seleniumTirgul;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SeleniumTargil5 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Navigate to MyTinyTodo page
        driver.get("https://www.mytinytodo.net/demo/#list/2");

        // Navigate to the "To do" tab
         WebElement toDoTab = driver.findElement(By.cssSelector("#list_1 > a > div.title-block > span.title"));
         toDoTab.click();
         Thread.sleep(500);

        // Add tasks
        String task1 = "Task D1";
        String task2 = "Task D2";
        WebElement newTaskField = driver.findElement(By.cssSelector("[id=\"task\"]"));
        newTaskField.sendKeys(task1 + "\n"); // Add task1 and press enter
        // Check if Clear field is needed
        newTaskField.sendKeys(task2 + "\n"); // Add task2 and press enter

        // Verify total tasks
        String totalTasksText = driver.findElement(By.cssSelector("[id=\"taskview\"] [id=\"total\"]")).getText();
        if (totalTasksText.equals("2")) {
            System.out.println("Total tasks correct: " + totalTasksText);
        } else {
            System.out.println("Error: Expected 2 tasks, found " + totalTasksText);
        }

        // Wait for page to load (Optional)
        Thread.sleep(2000);

        // Delete first task
        WebElement firstTaskCheckbox = driver.findElement(By.cssSelector("[id=\"taskrow_1\"] [type=\"checkbox\"]"));
        firstTaskCheckbox.click(); // Select the first task

        Actions actions = new Actions(driver);
        WebElement kebabMenu = driver.findElement(By.cssSelector("[class=\"taskactionbtn\"]"));

        // Wait for kebab menu to appear (Optional)
        Thread.sleep(1000);

        actions.moveToElement(kebabMenu).perform(); // Hover over kebab menu

        // Ensure you have a unique selector for the delete option within the kebab menu
        WebElement deleteOption = driver.findElement(By.cssSelector("[id=\"cmenu_delete\"]"));
        actions.moveToElement(deleteOption).click().perform(); // Click delete

        // Confirm deletion
        driver.findElement(By.cssSelector("[id=\"btnModalOk\"]")).click(); // Click OK

        // Verify updated total tasks
        totalTasksText = driver.findElement(By.cssSelector("[id=\"taskview\"] [id=\"total\"]")).getText();
        if (totalTasksText.equals("1")) {
            System.out.println("Total tasks updated correctly: " + totalTasksText);
        } else {
            System.out.println("Error: Expected 1 task, found " + totalTasksText);
        }

        // Close browser
        driver.quit();
    }
}
