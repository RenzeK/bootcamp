package test.example;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import basic.BrowserFactoryBasic;

import static java.lang.Thread.*;

public class TestShopScenario {

    protected WebDriver driver;

    public String logMeIn(String soortAccount) throws InterruptedException {
        String emailAccount = "renze.klamer@polteq.com";
        String passwordAccount = "Mijn-1956";

        if (soortAccount.contains("wish")) {
            emailAccount = "renze@klamer.com";
            passwordAccount = "1qazxsw2";

        }

        driver.manage().window().maximize();
        sleep(333); //tobe used for IE??
        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys(emailAccount);
        driver.findElement(By.id("passwd")).sendKeys(passwordAccount);
        driver.findElement(By.id("SubmitLogin")).click();
        //driver.manage().window().maximize();
        String myaccount = driver.findElement(By.className("account")).getText();
        return myaccount;
    }

    @BeforeMethod(alwaysRun = true)
    public void setmeUp() {
        driver = BrowserFactoryBasic.getDriver("chrome");
        //driver.manage().
        // open de website
        String urlTest = "https://techblog.polteq.com/testshop/index.php";
        driver.get(urlTest);

    }


    @AfterMethod(alwaysRun = true)
    public void tearmeDown(ITestResult ifFailure) {
        //  driver.quit();
        if (ifFailure.getStatus() == ITestResult.SUCCESS) {
            driver.quit();
        }

    }
}

