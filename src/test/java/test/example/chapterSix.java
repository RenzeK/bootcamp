package test.example;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.assertj.core.api.AbstractBooleanAssert;
import org.assertj.core.api.AbstractCharSequenceAssert;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class chapterSix {

    public void chapterSix() {
    }

    @Test
    public void loginsuccesFull() throws InterruptedException {
        String account = "";
        boolean siteFound = false;

        String urlTest = "techblog.polteq.com/testshop/index.php";
        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://" + urlTest);
        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys(new CharSequence[]{"renze.klamer@polteq.com"});
        driver.findElement(By.id("passwd")).sendKeys(new CharSequence[]{"Mijn-1956"});
        driver.findElement(By.id("SubmitLogin")).click();
        account = driver.findElement(By.className("account")).getText();
        ((AbstractCharSequenceAssert) Assertions.assertThat(account).as("user logged on", new Object[0])).contains(new CharSequence[]{"Renze"});
        boolean signoutExists = false;
        signoutExists = driver.findElement(By.className("logout")).isDisplayed();
        Assertions.assertThat(signoutExists).as("logdout not done").isTrue();
        //driver.findElement(By.className("logout")).click();
        boolean signInExists = false;
        signInExists = driver.findElement(By.className("logout")).isDisplayed();

        Assertions.assertThat(signInExists).as("logout not done").isTrue();

        driver.quit();
        System.out.println(account + " is het gelukt");
    }
}



