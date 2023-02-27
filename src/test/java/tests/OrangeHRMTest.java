package tests;

import base.BaseClass;
import extentmanager.ExtentManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrangeHRMTest extends BaseClass {

    @Test
    public void LoginPageTest() throws InterruptedException {
        Thread.sleep(2000);
        WebElement imgElement = driver.findElement(By.xpath("//img[@alt='company-branding']"));
        Assert.assertTrue(imgElement.isDisplayed());
    }

    @Test
    public void loginTest() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);

        String actualTitle = driver.getTitle();
        String expectedTitle = "OrangeHRM1";
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void sampleCaseTest() throws InterruptedException {
        Thread.sleep(2000);
        ExtentManager.test.createNode("Validation1");
        Assert.assertTrue(true);
        ExtentManager.test.createNode("Validation2");
        Assert.assertTrue(true);
        ExtentManager.test.createNode("Validation3");
        Assert.assertTrue(true);
        ExtentManager.test.createNode("Validation4");
        Assert.assertTrue(true);
    }
}
