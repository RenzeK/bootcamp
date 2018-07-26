package test.example;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestShopScenario {

    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setmeUp() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();

        // open de website
        String urlTest = "https://techblog.polteq.com/testshop/index.php";
        driver.get(urlTest);

    }


    @AfterMethod(alwaysRun = true)
    public void tearmeDown() {
        driver.quit();
    }
}
