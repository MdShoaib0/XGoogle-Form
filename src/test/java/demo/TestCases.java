package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.sql.Wrapper;
import java.time.Duration;
import java.util.logging.Level;
// import io.github.bonigarcia.wdm.WebDriverManager;
import demo.wrappers.Wrappers;

public class TestCases {
    ChromeDriver driver;

    /*
     * TODO: Write your tests here with testng @Test annotation. 
     * Follow `testCase01` `testCase02`... format or what is provided in instructions
     */
    @Test
    public void testCase01() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform");
        WebElement nameInputBox = driver.findElement(By.xpath("(//input[@class=\"whsOnd zHQkBf\"])[1]"));
        System.out.println("wait 1");
        Thread.sleep(2000);
        Wrappers.enterText(nameInputBox, "Crio Learner");
        WebElement practicingAutomationTextArea = driver.findElement(By.xpath("//textarea[@class=\"KHxj8b tL9Q4c\"]"));
        String practicingAutomationText = "I want to be the best QA Engineer! 1710572021";
        String epochTimeString = Wrappers.getEpochTimeAsString();
        Thread.sleep(2000);
        System.out.println("wait 2");
        Wrappers.enterText(practicingAutomationTextArea, practicingAutomationText+" "+epochTimeString);
        Thread.sleep(2000);
        System.out.println("wait 3");
        Wrappers.radioButton(driver,"6 - 10");
        Thread.sleep(2000);
        System.out.println("wait 4");
        Wrappers.checkBox1(driver, "Java");
        Wrappers.checkBox2(driver, "Selenium");
        Wrappers.checkBox3(driver, "TestNG");

        WebElement dropDownElement = driver.findElement(By.xpath("//div[contains(@class,'DEh1R')]"));
        // Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(dropDownElement));
        System.out.println("wait 5");
        dropDownElement.click();
        // Wrappers.clickOnElement(driver, dropDownElement);
        Thread.sleep(3000);
        WebElement dropDownElementClick = driver.findElement(By.xpath("//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[5]/div/div/div[2]/div/div[2]/div[3]/span"));
        wait.until(ExpectedConditions.elementToBeClickable(dropDownElementClick));
        dropDownElementClick.click();
        // Wrappers.dropDownClick(driver, "Mr");

        WebElement dateInputBox = driver.findElement(By.xpath("//input[@type='date']"));
        String sevenDaysAgoDate = Wrappers.getdateSevenDaysAgo();
        Thread.sleep(2000);
        System.out.println("wait 6");
        Wrappers.enterText(dateInputBox, sevenDaysAgoDate);

        WebElement hourElement = driver.findElement(By.xpath("//input[@aria-label='Hour']"));
        WebElement miElement = driver.findElement(By.xpath("//input[@aria-label='Minute']"));

        WebElement submitBtn = driver.findElement(By.xpath("//div[@class='lRwqcd']/div"));
        Thread.sleep(2000);
        Wrappers.enterText(hourElement, "07");
        Wrappers.enterText(miElement, "30");
        Wrappers.clickOnElement(driver, submitBtn);

        Thread.sleep(2000);
        System.out.println("wait 7");
        WebElement successMsgElement = driver.findElement(By.xpath("//div[@class='vHW8K']"));
        String expectedSuccessMsg = "Thanks for your response, Automation Wizard!";
        Assert.assertEquals(successMsgElement.getText().trim(), expectedSuccessMsg);
        
    }
     
    /*
     * Do not change the provided methods unless necessary, they will help in automation and assessment
     */
    @BeforeTest
    public void startBrowser()
    {
        System.setProperty("java.util.logging.config.file", "logging.properties");

        // NOT NEEDED FOR SELENIUM MANAGER
        // WebDriverManager.chromedriver().timeout(30).setup();

        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("--remote-allow-origins=*");

        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log"); 

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
    }

    @AfterTest
    public void endTest()
    {
        driver.close();
        driver.quit();

    }
}