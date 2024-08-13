package com.example.scenario_tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class login {

    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeTest
    public void beforeTest() throws IOException, InterruptedException {
        ChromeOptions options = new ChromeOptions();
        System.out.println(options);
        // options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver","src/main/java/com/example/webdriver/chromedriver-win64/chromedriver.exe");
        /*Chổ này quên nhấn tổ hợp copy-paste của Link Path */
        //Hàm Watting
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //Set full screen
        driver.manage().window().maximize();

    }

    @AfterTest
    public void afterTest() {
        // driver.close();
        driver.quit();
    }

    @Test(priority = 1, testName = "Login Successfully")
    public void testCase1() throws IOException, InterruptedException {
        String url = "https://qa-admin.beecowdeal.vn/login";
        driver.get(url);
        wait.until(ExpectedConditions.urlToBe(url));
        //Enter valid Email
        WebElement USERNAME = driver.findElement(By.id("basic_userName"));
        USERNAME.sendKeys("datbuithanh155@gmail.com");
        //Enter valid Password
        WebElement PASSWORD = driver.findElement(By.id("basic_password"));
        PASSWORD.sendKeys("Dat1505");
        //Click on button LOGIN
        WebElement btnLogin = driver.findElement(By.xpath("//button[contains(@class, 'button')]"));
        btnLogin.click();
        //Select Branch on list
        WebElement selectBranch = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'GuGiHouse của Đạt')]")));
        selectBranch.click();
        // Verify Toast message Login Successfully
        WebElement toastLoginSuccessfully = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'You have been logged in successfully.')]")));
        String toastmgs = toastLoginSuccessfully.getText();
        System.out.println("Show toast mgs là=" + toastmgs);


        Thread.sleep(5000);

       
    }
}
