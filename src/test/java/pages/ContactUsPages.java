package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static java.lang.Thread.*;

public class ContactUsPages {

    private final WebDriver driver;
    private By emailTextField = By.cssSelector("input#email"); //#email ??
    private By orderIdTextField = By.cssSelector(("input#id_order"));
    private By messageTextField = By.cssSelector("textarea#message");
    private By sendButton = By.cssSelector("button#submitMessage");
    private By invalidEmailElement = By.cssSelector(".alert.alert-danger>o1>li");

    public ContactUsPages(WebDriver driver) {
        this.driver = driver;

    }

    public void fillInContactForm(String subject, String email, String orderId, String message) throws InterruptedException {
        WebElement department = driver.findElement(By.cssSelector("[id='id_contact']"));
        new Select(department).selectByVisibleText("Customer service");

        driver.findElement(emailTextField).sendKeys(email);
        driver.findElement(orderIdTextField).sendKeys(orderId);
        driver.findElement(messageTextField).sendKeys(message);
        System.out.println("boodschap gedan");
        sleep(3000);
        driver.findElement(sendButton).click();
    }

}
