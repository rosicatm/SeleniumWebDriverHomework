package searchtests;

import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
    public static WebDriver driver;
    public static final String GOOGLE_URL = "https://google.com";
    public static final String BING_URL = "https://bing.com";
    public static final String XPATH_AGREE_BUTTON_BING = "//button[@id='bnp_btn_accept']";
    public static final String XPATH_SEARCH_FIELD_BING = "//input[@id='sb_form_q']";
    public static final String XPATH_SEARCH_BUTTON_BING = "//label[@id='search_icon']";

    public static final String XPATH_FIRST_RESULT_BING = "//h2[@class=' b_topTitle']";

    public static final String EXPECTED_CONDITION_ONE = "IT Career Start in 6 Months - Telerik Academy Alpha";
    public static final String EXPECTED_CONDITION_TWO = "Telerik Academy Alpha - IT Career Start in 6 Months";
    public String searchTerm = "Telerik Academy Alpha";

    public static String XPATH_AGREE_BUTTON_GOOGLE = "//button[@id='L2AGLb']";
    public static final String XPATH_SEARCH_FIELD_GOOGLE = "//textarea[@type='search']";
    public static final String XPATH_SEARCH_BUTTON_GOOGLE = "(//input[@type='submit' and @name='btnK'])[2]";

    public static final String XPATH_FIRST_RESULT_GOOGLE = " (//a/h3)[1]";

    public static final String ERROR_MESSAGE = "Search result not found";

    public static WebDriverWait wait;

    public enum BrowserTypes {
        FIREFOX,
        CHROME,
        EDGE
    }

    public static WebDriver startBrowser(GoogleSearchByTermTests.BrowserTypes browserType) {
        WebDriver driver = null;
        // Setup browser
        switch (browserType) {
            case EDGE:
                driver = new EdgeDriver();
                break;
            case CHROME:
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
        }
        return driver;
    }

    @AfterAll
    public static void classTearDown() {
        driver.close();

    }
}
