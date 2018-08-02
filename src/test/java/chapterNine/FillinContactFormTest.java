package chapterNine;

import org.testng.annotations.Test;
import pages.HomePage;

public class FillinContactFormTest extends test.example.TestShopScenario{

    @Test
    public void fillContactPage() throws InterruptedException {

        HomePage homePage = new HomePage(driver);
        String loginName = homePage.geefLogin();




    }
}
