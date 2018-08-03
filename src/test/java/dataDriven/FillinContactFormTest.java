package dataDriven;

import com.beust.jcommander.Parameter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;
import testShopScenario.testShopScenarioParameters;

public class FillinContactFormTest extends testShopScenarioParameters {

    @Parameters({"subject", "email" ,"orderId","message", "result"})

    @Test
    public void fillContactPage(String subject,String email,String orderId,String message, String result) throws InterruptedException {

        HomePage homePage = new HomePage(driver);
        String loginName = homePage.geefLogin();
        System.out.println("nu:" + loginName);
        //check
        homePage.clickContactUS();
        ContactUsPage contactFiller = new ContactUsPage(driver);
        contactFiller.fillInContactForm(subject, email, orderId, message);
        String resultContact = contactFiller.validationMessage();
        if (resultContact.contains(result)) {

            System.out.println("goed groen gegaan bij " + resultContact);
        } else {
            System.out.println("fout groen gegaan bij " + resultContact);

        }

    }
}
