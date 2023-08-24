package googlesearchtests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleSearchByTermTests {
        private static WebDriver driver;
        private static WebDriverWait wait;

        @BeforeAll
        public static void classSetup() {
            // Setup browser
            driver = new ChromeDriver();
            wait = new WebDriverWait(driver, Duration.ofSeconds(1000));

            // Navigate to Google.com
            driver.get("https://google.com");

            //Agree to consent
            WebElement agreeButton = driver.findElement(By.xpath("//button[@id='L2AGLb']"));
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
            driver.get("https://google.com");
        }

        @Test
        public void resultFound_when_searchTermProvided_telerikAcademyAlpha() {
            String searchTerm = "Telerik Academy Alpha";
            // Type Text in search field
            WebElement searchField = driver.findElement(By.xpath("//textarea[@type='search']"));
            searchField.sendKeys(searchTerm);
            // Click search button
            WebElement searchButton = driver.findElement(By.xpath("(//input[@type='submit' and @name='btnK'])[2]"));
            wait.until(ExpectedConditions.visibilityOf(searchButton));
            searchButton.click();
            // Assert Result found
            WebElement firstResult = driver.findElement(By.xpath(" (//a/h3)[1]"));
            Assertions.assertEquals("IT Career Start in 6 Months - Telerik Academy Alpha", firstResult.getText(), "Search result not found");
        }
}
