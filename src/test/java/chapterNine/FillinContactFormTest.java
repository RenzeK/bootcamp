package chapterNine;

import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.ContactUsPages;
import pages.HomePage;

public class FillinContactFormTest extends test.example.TestShopScenario{

    @Test
    public void fillContactPage() throws InterruptedException {

        HomePage homePage = new HomePage(driver);
        String loginName = homePage.geefLogin();
        System.out.println("nu:" + loginName);
        homePage.clickContactUS();
        ContactUsPage contactFiller = new ContactUsPage(driver);
        contactFiller.fillInContactForm("rklamer@gmail.com","rklamer@gmail.com","333333", "eeeee");
        String resultContact = contactFiller.validationMessage();
        System.out.println("goed groen gegaan bij "+ resultContact);
        homePage.clickContactUS();
        contactFiller.fillInContactForm("rklamer@gmail.com","rklamer@gmail","333333", "eeeee");
        resultContact  = contactFiller.getInvalidEmailMessage();
        System.out.println("goed rood gegaan bij "+ resultContact);


    }
}
