package com.softserve.edu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SearchWithExplicityWaitTest {
    private static final String BASE_URL = "https://devexpress.github.io/devextreme-reactive/react/grid/docs/guides/filtering/";

    @Test
    public void searchByLetterL() {
        WebDriverManager.chromedriver().setup();
        //
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.manage().window().maximize();

        driver.get(BASE_URL);

        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#gatsby-focus-wrapper > div > footer.cookie-module--cookie--pJvQ8 > div > div > div.col-md-4.align-self-center.d-flex.justify-content-center > button"))).click();
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Uncontrolled Mode")));

        driver.switchTo().frame(0);
        driver.findElement(By.cssSelector(".MuiTableRow-head:nth-child(2)")).click();
        driver.findElement(By.xpath("(//input[@value=\'\'])[3]")).sendKeys("L");

        WebElement searchLondon = driver.findElement(By.xpath("//td[contains(.,'London')]"));
        WebElement searchLasVegas = driver.findElement(By.xpath("//td[contains(.,'Las Vegas')]"));

        Assert.assertTrue(searchLondon.isDisplayed());
        Assert.assertTrue(searchLasVegas.isDisplayed());

        driver.quit(); // close browser, stop server
    }
}