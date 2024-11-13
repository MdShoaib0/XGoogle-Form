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

    // Method to print a greeting message
    public void getGreeting() {
        System.out.println("Hello Automation Wizards!");
    }

    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        // Greeting message
        new App().getGreeting();
        
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        // Set implicit wait for the driver (you may also use explicit waits for elements)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Navigate to the form URL
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform");
        
        // Fill out the form step by step
        fillName(driver);
        fillTextArea(driver);
        selectRadioButton(driver);
        selectCheckbox(driver);
        selectDropdown(driver);
        selectDate(driver);
        selectTime(driver);

        // Close the driver
        driver.quit();
    }

    // Method to fill name
    private static void fillName(WebDriver driver) {
        WebElement fill = driver.findElement(By.xpath("(//input[@class='whsOnd zHQkBf'])[1]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(fill));
        fill.sendKeys("Crio Learner");
    }

    // Method to fill the text area
    private static void fillTextArea(WebDriver driver) {
        WebElement fill2 = driver.findElement(By.xpath("//textarea[@class='KHxj8b tL9Q4c']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(fill2));
        fill2.sendKeys("I want to be the best QA Engineer! 1710572021");
    }

    // Method to select a radio button
    private static void selectRadioButton(WebDriver driver) {
        WebElement radiobutton = driver.findElement(By.xpath("(//div[@class='AB7Lab Id5V1'])[3]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(radiobutton));
        radiobutton.click();
    }

    // Method to select checkboxes
    private static void selectCheckbox(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement checkBox1 = driver.findElement(By.xpath("(//div[@class='uHMk6b fsHoPb'])[1]"));
        wait.until(ExpectedConditions.elementToBeClickable(checkBox1));
        checkBox1.click();

        WebElement checkBox2 = driver.findElement(By.xpath("(//div[@class='uHMk6b fsHoPb'])[2]"));
        wait.until(ExpectedConditions.elementToBeClickable(checkBox2));
        checkBox2.click();

        WebElement checkBox3 = driver.findElement(By.xpath("(//div[@class='uHMk6b fsHoPb'])[4]"));
        wait.until(ExpectedConditions.elementToBeClickable(checkBox3));
        checkBox3.click();
    }

    // Method to select an option from a dropdown
    private static void selectDropdown(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dropdownElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='e2CuFe eU809d']")));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByIndex(0); // Select the first option (0-based index)
    }

    // Method to select a date
    private static void selectDate(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        LocalDate dateMinus7Days = LocalDate.now().minusDays(7);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Adjust to match the required input format
        String dateToEnter = dateMinus7Days.format(formatter);

        WebElement date = driver.findElement(By.xpath("//input[@type='date']"));
        wait.until(ExpectedConditions.elementToBeClickable(date));
        date.clear();
        date.sendKeys(dateToEnter);
    }

    // Method to select time
    private static void selectTime(WebDriver driver) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement time = driver.findElement(By.xpath("(//input[@class='whsOnd zHQkBf'])[3]"));
        wait.until(ExpectedConditions.elementToBeClickable(time));
        time.sendKeys("07");

        time = driver.findElement(By.xpath("(//input[@class='whsOnd zHQkBf'])[4]"));
        wait.until(ExpectedConditions.elementToBeClickable(time));
        time.sendKeys("30");

        Thread.sleep(4000); // Just to ensure the time is selected
    }
}
