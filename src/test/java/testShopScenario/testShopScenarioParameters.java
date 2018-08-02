package testShopScenario;

import basic.BrowserFactoryAdvanced;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class testShopScenarioParameters {
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
    @Parameters("browser")

    @BeforeMethod(alwaysRun = true)
    public void setUp(String browser) {

        driver = BrowserFactoryAdvanced.getDriver(BrowserFactoryAdvanced.BootCampBrowser.valueOf(browser));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://techblog.polteq.com/testshop/index.php");
    }

    @AfterMethod(alwaysRun = true)
    public void tearmeDown(ITestResult ifFailure) {
        //  driver.quit();
        if (ifFailure.getStatus() == ITestResult.SUCCESS) {
            driver.quit();
        }

    }
}
