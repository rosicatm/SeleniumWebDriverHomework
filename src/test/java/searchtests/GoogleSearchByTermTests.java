package searchtests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleSearchByTermTests extends BaseClass {

    @BeforeAll
    public static void classSetup() {

        // Setup browser
        // In order to test it on different browsers, please change the name of the browser to EDGE, FIREFOX or CHROME
        driver = startBrowser(BrowserTypes.CHROME);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Navigate to Google.com
        driver.get(GOOGLE_URL);

        //Agree to consent
        WebElement agreeButton = driver.findElement(By.xpath(XPATH_AGREE_BUTTON_GOOGLE));
        agreeButton.click();
    }

    @BeforeEach
    public void testSetup() {
        // Navigate to Google.com
        driver.get(GOOGLE_URL);
    }

    @Test
    public void resultFound_when_searchTermProvided_telerikAcademyAlpha() {

        // Type Text in search field
        WebElement searchField = driver.findElement(By.xpath(XPATH_SEARCH_FIELD_GOOGLE));
        searchField.sendKeys(searchTerm);
        // Click search button
        WebElement searchButton = driver.findElement(By.xpath(XPATH_SEARCH_BUTTON_GOOGLE));
        wait.until(ExpectedConditions.visibilityOf(searchButton));
        searchButton.submit();
        // Assert Result found
        WebElement firstResult = driver.findElement(By.xpath(XPATH_FIRST_RESULT_GOOGLE));
        String resultText = firstResult.getText();

        boolean isCondition1Met = resultText.equals(EXPECTED_CONDITION_ONE);
        boolean isCondition2Met = resultText.equals(EXPECTED_CONDITION_TWO);
        Assertions.assertTrue(isCondition1Met || isCondition2Met, ERROR_MESSAGE);
    }
}
