package pages;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import test.example.TestShopScenario;

public class sendContact extends TestShopScenario {
    @Test

    public void fillInForm() throws InterruptedException {
        driver.findElement(By.cssSelector("li#header_link_contact > a")).click();

        ContactUsPages contactNow = new ContactUsPages(driver);
        contactNow.fillInContactForm("retorunering", "rklamer@dumper.nl", "32345", "ivm blbla");
        String result = driver.findElement(By.cssSelector("[class='alert alert-success']")).getText();
        Assertions.assertThat(result.contains("successfully ")).as("aanmaken mislukt").isTrue();
        result = result + logMeIn("");
        System.out.println("ingelogd met " + result);
    }

    ;

}
