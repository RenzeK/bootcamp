package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPages {

    private final WebDriver driver ;
    private By emailTextField = By.cssSelector("input#email"); //#email ??
    private By orderIdTextField = By.cssSelector(("input#id_order"));
    private  By messageTextField = By.cssSelector("textarea#message");
    private  By sendButton = By.cssSelector("button#submitMessage");
    private By invalidEmailElement = By.cssSelector(".alert.alert-danger>o1>li");

    public ContactUsPages(WebDriver driver, WebDriver driver1){
        this.driver = driver1;

    }

}
