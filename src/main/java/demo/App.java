package demo;

import java.net.MalformedURLException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class App {
    public void getGreeting() throws InterruptedException, MalformedURLException {
        System.out.println("Hello Autmation Wizards!");
    }

    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        new App().getGreeting();
        WebDriver driver = new ChromeDriver();
        System.out.println("Start testCase01");
        driver.get(
                "https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform");
        System.out.println("End testCase01");

        System.out.println("Start testCase02");

        WebElement fill = driver.findElement(By.xpath("(//input[@class=\"whsOnd zHQkBf\"])[1]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(fill));
        fill.sendKeys("Crio Learner");
        System.out.println("End testCase02");

        System.out.println("Start testCase03");

        WebElement fill2 = driver.findElement(By.xpath("//textarea[@class=\"KHxj8b tL9Q4c\"]"));
        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(fill2));
        fill2.sendKeys("I want to be the best QA Engineer! 1710572021");
        System.out.println("End testCase03");

        System.out.println("End testCase04");

        WebElement radiobutton = driver.findElement(By.xpath("(//div[@class=\"AB7Lab Id5V1\"])[3]"));
        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(radiobutton));
        radiobutton.click();
        System.out.println("End testCase04");

        System.out.println("End testCase04");

        WebElement checkBox = driver.findElement(By.xpath("(//div[@class=\"uHMk6b fsHoPb\"])[1]"));
        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(checkBox));
        checkBox.click();

        checkBox = driver.findElement(By.xpath("(//div[@class=\"uHMk6b fsHoPb\"])[2]"));
        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(checkBox));
        checkBox.click();

        checkBox = driver.findElement(By.xpath("(//div[@class=\"uHMk6b fsHoPb\"])[4]"));
        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(checkBox));
        checkBox.click();
        System.out.println("End testCase04");

        // System.out.println("Start testCase05");

        // // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // WebElement dropdownElement =
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"e2CuFe
        // eU809d\"]"))); // Replace with actual ID
        // dropdownElement.clear();
        // Select dripdown = new Select(dropdownElement);

        // dripdown.selectByIndex(0);
        // // Initialize the Select object with the dropdown WebElement
        // // dropdownElement.click();
        // // Thread.sleep(3000);

        // // WebElement options =
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"Dr\"]")));
        // // options.click();
        // Thread.sleep(3000);
        // // driver.close();
        // // driver.quit();
        // System.out.println("End testCase05");




        System.out.println("Start testCase06");

        LocalDate dateMinus7Days = LocalDate.now().minusDays(7);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy"); // Adjust to match the required input format
        String dateToEnter = dateMinus7Days.format(formatter);

        // Locate the date input field
        WebElement date = driver.findElement(By.xpath("//input[@type='date']"));
        wait.until(ExpectedConditions.elementToBeClickable(date));

        // Clear any existing date and enter the calculated date
        date.clear();
        date.sendKeys("10-11-2024");

        // Optionally, verify if the correct date is entered
        String enteredDate = date.getAttribute("value");
        if (enteredDate.equals(dateToEnter)) {
            System.out.println("Test passed. Correct date entered: " + enteredDate);
        } else {
            System.out.println("Test failed. Incorrect date entered: " + enteredDate);
        }
        Thread.sleep(5000);

        System.out.println("End testCase06");
        driver.close();
        driver.quit();




    // System.out.println("Start testCase07");

    // WebElement time = driver.findElement(By.xpath("(//input[@class=\"whsOnd
    // zHQkBf\"])[3]"));
    // // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    // wait.until(ExpectedConditions.elementToBeClickable(time));
    // time.sendKeys("07");

    // time = driver.findElement(By.xpath("(//input[@class=\"whsOnd
    // zHQkBf\"])[4]"));
    // // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    // wait.until(ExpectedConditions.elementToBeClickable(time));
    // time.sendKeys("30");
    // Thread.sleep(4000);
    // System.out.println("End testCase07");
    }
}
