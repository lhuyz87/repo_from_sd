package sd.test.driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.vavr.collection.HashMap;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

//import com.sun.xml.xsom.impl.scd.Iterators.Map;

import org.openqa.selenium.chrome.ChromeDriver;
import java.net.URL;
import java.util.Iterator;

public class DriverProvided implements DriverSource {

    public WebDriver newDriver() {
        EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
        WebDriver driver = null;
        DesiredCapabilities capabilities = null;
//        Map<String, Object> chromeOptions = new HashMap<>();
       
       ChromeOptions options = new ChromeOptions();
       
       options.setAcceptInsecureCerts(true);
//      options.addArguments("--disable-dev-shm-usage");
      options.addArguments("--disable-extensions");
//      options.addArguments("--webdriver.chrome.silentOutput");
      options.addArguments("--auto-open-devtools-for-tabs");

      options.addArguments("start-maximized"); // https://stackoverflow.com/a/26283818/1689770
      //options.addArguments("enable-automation"); // https://stackoverflow.com/a/43840128/1689770
      //options.addArguments("--no-sandbox"); //https://stackoverflow.com/a/50725918/1689770
//      options.addArguments("--disable-infobars"); //https://stackoverflow.com/a/43840128/1689770
//      options.addArguments("--disable-dev-shm-usage"); //https://stackoverflow.com/a/50725918/1689770
//      options.addArguments("--disable-browser-side-navigation"); //https://stackoverflow.com/a/49123152/1689770
//      options.addArguments("--disable-gpu"); //https://stackoverflow.com/questions/51959986/how-to-solve-selenium-chromedriver-timed-out-receiving-message-from-renderer-exc
      options.addArguments("--incognito");
//      options.addArguments("--profile-directory=Default");
//      options.addArguments("--ignore-certificate-errors");
      System.out.println("++++++++++++++++++++++++++++"+options.toJson());
//      options.addArguments("--disable-blink-features=AutomationControlled");
      options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
      options.setExperimentalOption("useAutomationExtension", false);
      options.addArguments("f'user-agent={userAgent}'");
      
//      chrome_options.add_argument(f'user-agent={userAgent}')
      capabilities = DesiredCapabilities.chrome();
      capabilities.setCapability(ChromeOptions.CAPABILITY, options);
      System.out.println("....");
//      options.addArguments("user-agent=\"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.97 Safari/537.36\"");
      System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
      driver = new ChromeDriver(capabilities);
//      driver.execute_script("Object.defineProperty(navigator, 'webdriver', {get: () => undefined})");
      return driver;
       
       
    }

    public boolean takesScreenshots() {
        return true;
    }
}



