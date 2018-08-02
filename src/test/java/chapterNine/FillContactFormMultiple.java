package chapterNine;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;

public class FillContactFormMultiple extends test.example.TestShopScenario {


    @Test
    public void fillContactPage() throws InterruptedException {

        HomePage homePage = new HomePage(driver);
        String loginName = homePage.geefLogin();
        System.out.println("nu:" + loginName);
        homePage.clickContactUS();
        ContactUsPage contactFiller = new ContactUsPage(driver);
        contactFiller.fillInContactForm("rklamer@gmail.com", "rklamer@gmail.com", "333333", "eeeee");
        String resultContact = contactFiller.validationMessage();
        System.out.println("goed groen gegaan bij " + resultContact);
        // opnieuw aanroepen contact
        homePage.clickContactUS();
        contactFiller.fillInContactForm("rklamer@gmail.com", "nope", "333333", "eeeee");
        resultContact = contactFiller.getInvalidEmailMessage();
        Assertions.assertThat(resultContact).as("emailcheck not correct").contains("        invalid");
        System.out.println("goed rood gegaan bij " + resultContact);
    }
}
