package test.example;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestShopScenario {

    protected WebDriver driver;
    public String logMeIn () {
        driver.manage().window().maximize();
        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys("renze.klamer@polteq.com");
        driver.findElement(By.id("passwd")).sendKeys("Mijn-1956");
        driver.findElement(By.id("SubmitLogin")).click();
        String myaccount = driver.findElement(By.className("account")).getText();
return myaccount;
    }

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
     //  driver.quit();
    }
}
