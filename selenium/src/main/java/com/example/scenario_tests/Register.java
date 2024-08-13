package com.example.scenario_tests;

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

import java.io.IOException;
import java.time.Duration;

public class Register {

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

        @Test(priority = 1, testName = "Register from CTA Link")
        public void testCase1() throws IOException, InterruptedException {
            String url = "https://qa-admin.beecowdeal.com/login";
            driver.get(url);
            wait.until(ExpectedConditions.urlToBe(url));
            //Click on CTA Register Trial
            WebElement linkTrialRegister = driver.findElement(By.xpath("//a[starts-with(@href, '/register-account')]"));
            linkTrialRegister.click();
            // Step1- Store name
            WebElement txtStoreName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='storeName']")));
            txtStoreName.sendKeys("Trial Store Dat 01");
            // Step 1- Country dropdown - search Canada
            WebElement countryDropdown = driver.findElement(By.id("//input[@id='countryId']"));
            countryDropdown.click();
            WebElement searchCountry = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='countryId']")));
            searchCountry.sendKeys("Canada");
            //Select Canada
            WebElement optionCanada = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("aria-owns=\"countryId_list\"")));




            Thread.sleep(5000);

        }
            @Test(priority = 1, testName = "Register from Button Link")
            public void testCase2 () throws IOException, InterruptedException {
                String url = "https://qa-admin.beecowdeal.com/login";
                driver.get(url);
                wait.until(ExpectedConditions.urlToBe(url));
                //Click on CTA Register Trial
                wait.until(ExpectedConditions.urlToBe(url));
                //Click on btn Register Trial
                WebElement btnRegisterTrial = driver.findElement(By.xpath("//span[contains(text(),'Register now!')]"));
                btnRegisterTrial.click();


                Thread.sleep(5000);
            }
        }
