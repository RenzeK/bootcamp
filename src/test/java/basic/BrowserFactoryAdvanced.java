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
import org.openqa.selenium.firefox.FirefoxOptions;
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

    public static WebDriver getDriver(BootCampBrowser browser) {

        switch ((browser)) {
            case FIREFOX:
                return createFirfoxBrowser();
            case IE:
                System.out.println(" to do later not now");
                return createIEBrowser();
            case CHROME:
                return createChromeBrowser();
            //case "safari":
            case EDGE:
                return createEdgeBrowser();
            default:
                return createChromeBrowser();
        }

    }

    private static WebDriver createChromeBrowser() {
        // chrome options are chrome specific
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-infobar");
        options.addArguments("ignore-certificate-errors");
        options.setCapability("chrome.switches", "--verbose");
        ChromeDriverManager.getInstance().setup();
        return new ChromeDriver(options);
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

    private static WebDriver createFirfoxBrowser() {
        FirefoxOptions options = new FirefoxOptions();
        FirefoxDriverManager.getInstance().setup();
        return new FirefoxDriver();
    }

}



