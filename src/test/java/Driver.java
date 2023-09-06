import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Driver {

    @Test
    @DisplayName("Should open and close chrome browser")
    void shouldOpenAndCloseChromeBrowser() throws InterruptedException {
        WebDriverManager.chromedriver().setup(); //sets up a valid driver for Chrome.
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        Thread.sleep(1000); //1 sec of sleep
        driver.quit();
    }

    @Test
    @DisplayName("Should get the search bar from Google")
    void shouldGetTheSearchBarFromGoogle() {
        WebDriverManager.chromedriver().setup(); //sets up a valid driver for Chrome.
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        final WebElement searchBar = driver.findElement(By.className("gLFyf"));
        final String accessibleName = searchBar.getAccessibleName(); //gets the property
        System.out.println(accessibleName);
    }

    @Test
    @DisplayName("Should open Google and write in the bar")
    void shouldOpenGoogleAndWriteInTheBar() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        final WebElement searchBar = driver.findElement(By.className("gLFyf"));
        searchBar.sendKeys("Selenium WebDriver"); //sends the String content to the DOM object
        Thread.sleep(2000);
    }

    @Test
    @DisplayName("Should open Google and search")
    void shouldOpenGoogleAndSearch() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.findElement(By.className("gLFyf")).sendKeys("Selenium WebDriver");
        Thread.sleep(200);
        driver.findElement(By.className("gNO89b")).click();// the search button class is "gNO89b"
    }

    @Test
    @DisplayName("Should result page title start with searched text and end with Pesquisa Google")
    void shouldPageTitleStartWithSearchedTextAndEndWithPesquisaGoogle()throws InterruptedException {
        WebDriverManager.chromedriver().setup();;
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.findElement(By.className("gLFyf")).sendKeys("Selenium WebDriver");
        Thread.sleep(200);
        driver.findElement(By.className("gNO89b")).click();
        Thread.sleep(200);
        final String title = driver.getTitle(); // obtains the title of the page
        assertEquals(title, "Selenium WebDriver - Pesquisa Google");
    }

}
