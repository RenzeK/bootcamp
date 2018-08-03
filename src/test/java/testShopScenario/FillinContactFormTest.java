package testShopScenario;

import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;

public class FillinContactFormTest extends testShopScenarioParameters {

    @Test
    public void fillContactPage() throws InterruptedException {

        HomePage homePage = new HomePage(driver);
        String loginName = homePage.geefLogin();
        System.out.println("nu:" + loginName);
        //check
        homePage.clickContactUS();
        ContactUsPage contactFiller = new ContactUsPage(driver);
        String onderwerp = "oje beetje be";
        String email = "rklamer@gmail.com";
        String orderNr = "4345";
        String Onderwerp = "te laat en te veel";
        contactFiller.fillInContactForm(onderwerp, email, orderNr, Onderwerp);
        String resultContact = contactFiller.validationMessage();
        System.out.println("goed groen gegaan bij " + resultContact);
        // opnieuw aanroepen contact
        homePage.clickContactUS();
        email = "nope";
        contactFiller.fillInContactForm(onderwerp, email, orderNr, Onderwerp);
        resultContact = contactFiller.getInvalidEmailMessage();
        System.out.println("goed rood gegaan bij " + resultContact);


    }
}
