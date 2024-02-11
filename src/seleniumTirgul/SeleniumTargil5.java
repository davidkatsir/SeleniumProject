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

        String myTinyTodoUrl = "https://www.mytinytodo.net/demo/#list/2";
        String toDoTabLocator = "#list_1 > a > div.title-block > span.title";
        String task1 = "Task D1";
        String task2 = "Task D2";
        String newTaskFieldLocator = "[id=\"task\"]";
        String addTaskButtonLocator = "[id=\"newtask_submit\"]";
        String totalTasksTextLocator = "[id=\"taskview\"] [id=\"total\"]";
        String kebabMenuLocator = "div.task-block > div.task-actions > div:nth-child(1)";
        String deleteOptionLocator = "[id=\"cmenu_delete\"]";
        String okButtonLocator = "[id=\"btnModalOk\"]";

        // Navigate to MyTinyTodo page
        driver.get(myTinyTodoUrl);

        // Navigate to the "To do" tab
        WebElement toDoTab = driver.findElement(By.cssSelector(toDoTabLocator));
        toDoTab.click();
        Thread.sleep(2000);

        // Add tasks
        WebElement newTaskField = driver.findElement(By.cssSelector(newTaskFieldLocator));
        newTaskField.sendKeys(task1); // Add task1
        WebElement addTaskButton = driver.findElement(By.cssSelector(addTaskButtonLocator));
        addTaskButton.click();
        Thread.sleep(300);
        newTaskField.sendKeys(task2); // Add task2
        addTaskButton.click();

        // Verify total tasks
        Thread.sleep(1000);
        String totalTasksText = driver.findElement(By.cssSelector(totalTasksTextLocator)).getText();
        if (totalTasksText.equals("2")) {
            System.out.println("Total tasks is correct: " + totalTasksText);
        } else {
            System.out.println("Error: Expected 2 tasks, found " + totalTasksText);
        }

        // Wait for page to load (Optional)
        Thread.sleep(1000);

        // Delete first task
        Actions actions = new Actions(driver);
        WebElement kebabMenu = driver.findElement(By.cssSelector(kebabMenuLocator));

        // Hover over kebab menu and click on it
        actions.moveToElement(kebabMenu).perform();
        Thread.sleep(1000); // Wait for kebab menu to appear
        actions.moveToElement(kebabMenu).click().perform();

        WebElement deleteOption = driver.findElement(By.cssSelector(deleteOptionLocator));
        actions.moveToElement(deleteOption).click().perform(); // Click delete

        // Confirm deletion
        WebElement okButton = driver.findElement(By.cssSelector(okButtonLocator));
        okButton.click(); // Click OK

        // Verify updated total tasks
        Thread.sleep(500);
        totalTasksText = driver.findElement(By.cssSelector(totalTasksTextLocator)).getText();
        if (totalTasksText.equals("1")) {
            System.out.println("Total tasks updated correctly: " + totalTasksText);
        } else {
            System.out.println("Error: Expected 1 task, found " + totalTasksText);
        }

        // Close browser
        driver.quit();
    }
}
