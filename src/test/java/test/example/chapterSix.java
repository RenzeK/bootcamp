package test.example;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.assertj.core.api.AbstractBooleanAssert;
import org.assertj.core.api.AbstractCharSequenceAssert;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;

public class chapterSix extends TestShopScenario {
    public void chapterSix() {
    }

    @Test

    public void ValidateSupplierProductTest() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String initialName = "Renze";
        String geheim = "Mijn-1956";
        String artTeZoeken = "MacBook Air";
        driver.manage().window().maximize();
        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys("renze.klamer@polteq.com");
        driver.findElement(By.id("passwd")).sendKeys(geheim);
        driver.findElement(By.id("SubmitLogin")).click();
        WebElement supplier = driver.findElement(By.cssSelector("[name='supplier_list']"));
        new Select(supplier).selectByVisibleText("AppleStore");
        WebElement articlesLijst = driver.findElement(By.cssSelector("[id='product_list']"));
        Boolean gevonden = false;
        List<WebElement> artikelen = articlesLijst.findElements(By.cssSelector("[class='product-container']"));
        for (WebElement art : artikelen){
            String artOms = art.findElement(By.cssSelector("[itemprop='name']")).getText();
            //System.out.println(" art: " + artOms);
            if (artOms.equals(artTeZoeken)) gevonden = true;
        }
        Assertions.assertThat(gevonden).as("Geen "+ artTeZoeken + " meer").isTrue();

    }

    @Test
    public void AdjustPersonalInfoTest() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String initialName = "Renze";
        String geheim = "Mijn-1956";
        String accountName = "";
        driver.manage().window().maximize();
        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys("renze.klamer@polteq.com");
        driver.findElement(By.id("passwd")).sendKeys(geheim);
        driver.findElement(By.id("SubmitLogin")).click();
        String account = driver.findElement(By.className("account")).getText();
        driver.findElement(By.className("account")).click();
        driver.findElement(By.className("icon-user")).click();
        WebElement firstName = driver.findElement(By.id("firstname"));
        String currentFirstName = firstName.findElement(By.id("firstname")).getAttribute("value");
        driver.findElement(By.id("firstname")).clear();
        //System.out.println("was:" + currentFirstName);

        if (currentFirstName.equals(initialName)) {
            driver.findElement(By.id("firstname")).sendKeys("ezneR");
        } else {
            driver.findElement(By.id("firstname")).sendKeys(initialName);
        }
        driver.findElement(By.cssSelector("[name='old_passwd']")).sendKeys(geheim);
        //Thread.sleep(3000);
        driver.findElement(By.cssSelector("[name='submitIdentity']")).click();
        String resultaat = driver.findElement(By.cssSelector(".alert.alert-success")).getText();
        Assertions.assertThat(resultaat.contains("successfully")).as("update failes").isTrue();
        //Thread.sleep(3000);
        Assertions.assertThat(account.contains(driver.findElement(By.className("account")).getText())).as("geen wijziging").isFalse();

    }

    @Test
    public void emptyCartTest() throws InterruptedException {

        String account = "";
        //String urlTest = "techblog.polteq.com/testshop/index.php";
        //ChromeDriverManager.getInstance().setup();
        //WebDriver driver = new ChromeDriver();
        //driver.get("https://" + urlTest);
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.manage().window().maximize();
        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys(new CharSequence[]{"renze.klamer@polteq.com"});
        driver.findElement(By.id("passwd")).sendKeys(new CharSequence[]{"Mijn-1956"});
        driver.findElement(By.id("SubmitLogin")).click();
        account = driver.findElement(By.className("account")).getText();
        ((AbstractCharSequenceAssert) Assertions.assertThat(account).as("user logged on", new Object[0])).contains(new CharSequence[]{"Klamer"});
        //boolean emptyCar = driver.findElement(By.id("ajax_cart_no_product")).isDisplayed();
        //Assertions.assertThat(emptyCar).as("geenm lege car").isTrue();
        driver.findElement(By.cssSelector("[class='tag_level3 first_item']")).click();
        driver.findElement(By.cssSelector("[alt='iPod shuffle']")).click();
        driver.findElement(By.cssSelector("[id='add_to_cart']")).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("[class='continue btn btn-default button exclusive-medium']"))));
        driver.findElement(By.cssSelector("[class='continue btn btn-default button exclusive-medium']")).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("[title='View my shopping cart']"))));
        driver.findElement(By.cssSelector("[title='View my shopping cart']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("[class='cart_quantity_delete']"))));
        driver.findElement(By.cssSelector("[class='cart_quantity_delete']")).click();
        //Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("[title='View my shopping cart']"))));
        driver.findElement(By.cssSelector("[title='View my shopping cart']")).click();
        String inhoudCart = driver.findElement(By.cssSelector("[title='View my shopping cart']")).getText();
        System.out.println(inhoudCart);
        Assertions.assertThat(inhoudCart).as("niet leeg").contains("empty");
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



