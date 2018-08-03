package chapterNine;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.assertj.core.api.Assertions;
import org.testng.Converter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.AuthenticationPage;
import pages.HomePage;
import testShopScenario.testShopScenarioParameters;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.FieldPosition;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class LoginTest extends testShopScenarioParameters {
    @DataProvider(name = "test")
    public Iterator<Object[]> provider() throws InterruptedException, IOException {

        String[] data = null;
        String csvFile = "C:\\Users\\Gebruiker\\IdeaProjects\\bootcamp\\src\\test\\java\\chapterNine\\dataLogin.csv"; //C:\Users\Gebruiker\IdeaProjects\bootcamp\src\test\java\chapterNine\dataLogin.csv
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        List<Object[]> testCases = new ArrayList<>();


        //this loop is pseudo code
        try {
            br = new BufferedReader(new FileReader(csvFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while ((line = br.readLine()) != null) {
            // use comma as separator
            data = line.split(cvsSplitBy);
            testCases.add(data);
        }

        return testCases.iterator();
    }

    //@Parameters({"user", "passwrd", "result"})
    @Parameters

    @Test(description = "Test", groups = "test", dataProvider = "test")
    public void fillLogin(String user, String passwrd, String result) throws InterruptedException {

        HomePage homePage = new HomePage(driver);
        String loginName = homePage.geefLogin();
        System.out.println("nu:" + loginName);
        homePage.clickLogIn();
        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        authenticationPage.login(user, passwrd);
        if (result.contains("success")) {
            Assertions.assertThat(result).as("succes").contains(" succesfull");//   authenticationPage.
        } else {
            Assertions.assertThat(result).as("not failing").contains("failed");//   authenticationPage.
        }
        Thread.sleep(3000);


    }

}
