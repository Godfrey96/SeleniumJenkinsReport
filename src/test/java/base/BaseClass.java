package base;

import extentmanager.ExtentManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseClass {

    String sDefaultPath = System.getProperty("user.dir");
    public static WebDriver driver;

    @BeforeSuite
    public void BeforeSuite(){
        ExtentManager.setExtent();
    }

    @AfterSuite
    public void AfterSuite(){
        ExtentManager.endReport();;
    }

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", sDefaultPath + "\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    public static String screenShot(WebDriver driver, String fileName){
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "\\ScreenShot\\"+ fileName + "_" + dateName + ".png";
        File finalDestination = new File(destination);
        try {
            FileUtils.copyFile(source, finalDestination);
        } catch (Exception e) {
            e.getMessage();
        }
        return destination;
    }

    public static String getCurrentTime() {
        String currentDate = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
        return currentDate;
    }
}
