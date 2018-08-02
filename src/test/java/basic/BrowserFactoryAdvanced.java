package basic;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserFactoryAdvanced {

    public enum BootCampBrowser {
        FIREFOX,
        IE,
        CHROME,
        EDGE;
    }
    WebDriver driver;
    public  WebDriver getDriver(BootCampBrowser browser) {

        switch ((browser)) {
            case FIREFOX:
                FirefoxDriverManager.getInstance().setup();
                driver = new FirefoxDriver();
                break;
            case IE:
                System.out.println(" to do later not now");
                break;
            case CHROME:
                ChromeDriverManager.getInstance().setup();
                driver = new ChromeDriver();
                break;
            //case "safari":
            case EDGE:
                EdgeDriverManager.getInstance().setup();
                driver = new EdgeDriver();
                break;
            default:
                ChromeDriverManager.getInstance().setup();
                driver = new ChromeDriver();
                break;
        }
        return driver ;

    }

    private static WebDriver createChromeBrowser() {
        // chrome options are chrome specific
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-infobar");
        options.addArguments("ignore-certificate-errors");
        options.setCapability("chrome.switches", "--verbose");
        ChromeDriverManager.getInstance().setup();
        return new ChromeDriver();
    }

    private static WebDriver createEdgeBrowser() {
        // edge options are edge specific
        EdgeOptions options = new EdgeOptions();
        options.setCapability("edge.switches", "--verbose");
        EdgeDriverManager.getInstance().setup();
        return new EdgeDriver();
    }

    private static WebDriver createIEBrowser() {
        InternetExplorerOptions options = new InternetExplorerOptions();
        options.introduceFlakinessByIgnoringSecurityDomains();
        DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
        capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        capabilities.setCapability("requireWindowFocus", true);
        return new InternetExplorerDriver();
    }


}



