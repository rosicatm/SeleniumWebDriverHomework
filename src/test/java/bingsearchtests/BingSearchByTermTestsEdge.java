package bingsearchtests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class BingSearchByTermTestsEdge {
    private static WebDriver driver;

    @BeforeAll
    public static void classSetup() {
        // Setup browser

        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Navigate to Bing.com
        driver.get("https://bing.com");

        //Agree to consent
        WebElement agreeButton = driver.findElement(By.xpath("//button[@id='bnp_btn_accept']"));
        agreeButton.click();
    }

    @AfterAll
    public static void classTearDown() {
        // Setup browser
        driver.close();
    }

    @BeforeEach
    public void testSetup() {
        // Navigate to Google.com
        driver.get("https://bing.com");
    }

    @Test
    public void resultFound_when_searchTermProvided_telerikAcademyAlpha() {
        String searchTerm = "Telerik Academy Alpha";
        // Type Text in search field
        WebElement searchField = driver.findElement(By.xpath("//input[@id='sb_form_q']"));
        searchField.sendKeys(searchTerm);
        // Click search button
        WebElement searchButton = driver.findElement(By.xpath("//label[@id='search_icon']"));
        searchButton.click();
        // Assert Result found
        WebElement firstResult = driver.findElement(By.xpath("//h2[@class=' b_topTitle']"));
        Assertions.assertEquals("IT Career Start in 6 Months - Telerik Academy Alpha", firstResult.getText(), "Search result not found");
    }
}
