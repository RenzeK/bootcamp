package homework;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import test.example.TestShopScenario;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.List;

import static java.lang.Thread.sleep;

public class Homework extends TestShopScenario {
    @Test
    public void deleteWishList() throws InterruptedException {
        String accountName = logMeIn("wish");
        Assertions.assertThat(!accountName.contains("Klamer")).as("inlogAccount niet correct gegaan").isFalse();
        driver.findElement(By.className("icon-heart")).click();
        int noPainRow = 0;
        String teZoekenName = "No Pain";
        noPainRow = telStringInWish(teZoekenName, false);
        Assertions.assertThat(noPainRow).as("Geen wishes to deal with").isGreaterThan(0);

        if (noPainRow > 0) {
            noPainRow = telStringInWish(teZoekenName, true);
        }
        // opnieuw inlezen
        noPainRow = telStringInWish(teZoekenName, false);
        Assertions.assertThat(noPainRow).as("Not all wishes gone").isEqualTo(0);
        if (noPainRow == 0) {
            // geen No Pain meer over dus nieuwe voor de volgende keer
            driver.findElement(By.cssSelector("#name")).sendKeys(teZoekenName);
            driver.findElement(By.cssSelector("#submitWishlist")).click();
        }
        noPainRow = telStringInWish(teZoekenName, false);
        Assertions.assertThat(noPainRow).as("No wishes for the future").isGreaterThan(0);

        System.out.println("Klaar met opnieuw " + noPainRow + " in de wishlist");
    }


    public int telStringInWish(String zoekWaarde, boolean deleteWish) throws StaleElementReferenceException, InterruptedException {
        int maxLoop = 3;
        int aantalGevonden = 0;
        while (maxLoop > 0) {
            try {
                WebElement readWishTable = driver.findElement(By.cssSelector("[class='table table-bordered']"));
                List<WebElement> readRows = readWishTable.findElements(By.tagName("tr"));
                for (WebElement row : readRows) {
                    List<WebElement> cols = row.findElements(By.tagName("td"));
                    for (WebElement col : cols) {
                        if (col.getText().contains(zoekWaarde)) {
                            aantalGevonden++;
                            if (deleteWish) {
                                row.findElement(By.cssSelector("td.wishlist_delete > a > i")).click();
                                Alert alert = driver.switchTo().alert();

                                // Capturing alert message.
                                String alertMessage = driver.switchTo().alert().getText();

                                // Displaying alert message
                                System.out.println(alertMessage);
                                //      Thread.sleep(5000);

                                // Accepting alert
                                alert.accept();
                                break;
                            }
                        }
                    }
                    maxLoop = 0;
                }
            } catch (StaleElementReferenceException ex) {
                sleep(333);
                maxLoop--;
            }

        }
        System.out.println("aantal maal "+ zoekWaarde+ " : " + aantalGevonden);
        return aantalGevonden;
    }
/* //        WebElement wishTable = driver.findElement(By.cssSelector("[class='table table-bordered']"));
        //Get all headerinfo
  //      List<WebElement> columNames = wishTable.findElements(By.tagName("th"));
        //Get all rows
    //    List<WebElement> rows = wishTable.findElements(By.tagName("tr"));
   for (int i = 0; i < rows.size(); i++) {
            List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
            if (cols.size() > 0) {
                for (int j = 0; j < cols.size(); ++j) {
                    if (cols.size() > 0 && cols.get(j).getText().contains("No Pain")) {
                        System.out.println("gevoden bij row" + i + " staat" + cols.get(j).getText());
                        rows.get(i).findElement(By.cssSelector("td.wishlist_delete > a > i")).click();

                        // Switching to Alert
                        Alert alert = driver.switchTo().alert();
                      // Accepting alert
                        alert.accept();

                        break;
                    }
                }
            }
        } */
}

