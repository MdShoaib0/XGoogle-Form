package demo.wrappers;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Wrappers {
    /*
     * Write your selenium wrappers here
     */
    public static void enterText(WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void radioButton(ChromeDriver driver, String radioButtonText) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement element = driver.findElement(By.xpath("//span[contains(@class,'OvPDhc') and contains(text(),'" +radioButtonText+"')]/../../..//div[@class='vd3tt']"));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void checkBox1(ChromeDriver driver, String checkboxText) {
        try {
            WebElement element = driver.findElement(By.xpath("//span[text()=\"Java\"]"));
            element.click(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void checkBox2(ChromeDriver driver, String checkboxText) {
        try {
            WebElement element = driver.findElement(By.xpath("//span[text()=\"Selenium\"]"));
            element.click(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void checkBox3(ChromeDriver driver, String checkboxText) {
        try {
            WebElement element = driver.findElement(By.xpath("//span[text()=\"TestNG\"]"));
            element.click(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void dropDownClick(ChromeDriver driver, String dropDownText) {
        try {
            WebElement element = driver.findElement(By.xpath("//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[5]/div/div/div[2]/div/div[2]/div[3]/span"));
            element.click(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void clickOnElement(ChromeDriver driver, WebElement element) {
        try{
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();",element);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getdateSevenDaysAgo() {

        LocalDate currDate = LocalDate.now();
        LocalDate dateMinus7Days = currDate.minusDays(7);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = dateMinus7Days.format(formatter);

        return formattedDate;
        
    }

    public static String getEpochTimeAsString(){
        long epochTime = System.currentTimeMillis()/1000;
        String epochTimeString = String.valueOf(epochTime);
        return epochTimeString;
    }

    public static boolean handleAlert(ChromeDriver driver) {
        boolean status = false;
        driver.switchTo().alert().dismiss();
        status = true;
        return status;
    }
}
