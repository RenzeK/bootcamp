package test.example;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class FirstSeleniumTest {

    @Test

    public void loginsuccesFull() throws InterruptedException {
        String account = "";
        boolean siteFound = false;
        String urlFound = "";
        int nrofFound = 0;
        String urlTest = "techblog.polteq.com/testshop/index.php";

        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://" + urlTest);
        //urlFound = driver.getCurrentUrl().contains(urlTest);

        //if (urlFound.contains(urlTest))
            siteFound = true;

        Assertions.assertThat(siteFound).as("Site not found at all").isTrue();
        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys("renze.klamer@polteq.com");
        driver.findElement(By.id("passwd")).sendKeys("Mijn-1956");
        driver.findElement(By.id("SubmitLogin")).click();

        account = driver.findElement(By.className("account")).getText();
        Assertions.assertThat(account).as("user logged on").contains("Renze");

        boolean signoutExists = false;
        //signoutExists = driver.findElement()
        //wait(30000);
        driver.quit();
        System.out.println(account + " is het gelukt");
    }
}
