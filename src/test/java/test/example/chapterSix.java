package test.example;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.assertj.core.api.AbstractBooleanAssert;
import org.assertj.core.api.AbstractCharSequenceAssert;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class chapterSix extends TestShopScenario {
    public void chapterSix() {
    }


    @Test
    public void emptyCartTest() {

        String account = "";
        //String urlTest = "techblog.polteq.com/testshop/index.php";
        //ChromeDriverManager.getInstance().setup();
        //WebDriver driver = new ChromeDriver();
        //driver.get("https://" + urlTest);
        driver.manage().window().maximize();
        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys(new CharSequence[]{"renze.klamer@polteq.com"});
        driver.findElement(By.id("passwd")).sendKeys(new CharSequence[]{"Mijn-1956"});
        driver.findElement(By.id("SubmitLogin")).click();
        account = driver.findElement(By.className("account")).getText();
        ((AbstractCharSequenceAssert) Assertions.assertThat(account).as("user logged on", new Object[0])).contains(new CharSequence[]{"Renze"});
        //boolean emptyCar = driver.findElement(By.id("ajax_cart_no_product")).isDisplayed();
        //Assertions.assertThat(emptyCar).as("geenm lege car").isTrue();
        driver.findElement(By.cssSelector("[class='tag_level3 first_item']")).click();
        driver.findElement(By.cssSelector("[alt='iPod shuffle']")).click();
        driver.findElement(By.cssSelector("[id='add_to_cart']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("[class='continue btn btn-default button exclusive-medium']"))));
        driver.findElement(By.cssSelector("[class='continue btn btn-default button exclusive-medium']")).click();
        driver.findElement(By.cssSelector("[<span class='ajax_cart_quantity unvisible' style='display: inline;'>1</span>]")).click();
//<span class='ajax_cart_quantity unvisible' style='display: inline;'>1</span>
        //class="ajax_cart_quantity unvisible"

        //[class='continue btn btn-default button exclusive-medium']


    }

    @Test
    public void loginsuccesFull() throws InterruptedException {
        String account = "";
        boolean siteFound = false;

        //String urlTest = "techblog.polteq.com/testshop/index.php";
        //ChromeDriverManager.getInstance().setup();
        //WebDriver driver = new ChromeDriver();
        //driver.get("https://" + urlTest);
        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys(new CharSequence[]{"renze.klamer@polteq.com"});
        driver.findElement(By.id("passwd")).sendKeys(new CharSequence[]{"Mijn-1956"});
        driver.findElement(By.id("SubmitLogin")).click();
        account = driver.findElement(By.className("account")).getText();
        ((AbstractCharSequenceAssert) Assertions.assertThat(account).as("user logged on", new Object[0])).contains(new CharSequence[]{"Renze"});
        boolean signoutExists = false;
        signoutExists = driver.findElement(By.className("logout")).isDisplayed();
        Assertions.assertThat(signoutExists).as("logdout not done").isTrue();
        driver.findElement(By.className("logout")).click();
        boolean signInExists = false;
        signInExists = driver.findElement(By.className("logout")).isDisplayed();

        Assertions.assertThat(signInExists).as("logout not done").isTrue();

        driver.quit();
        System.out.println(account + " is het gelukt" + signInExists + signoutExists);
    }

}



