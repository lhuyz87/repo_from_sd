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
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

//import com.sun.xml.xsom.impl.scd.Iterators.Map;

import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;

public class DriverProvided3 implements DriverSource {

    public WebDriver newDriver() {
        EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
        WebDriver driver = null;
    	ChromeDriverService service = null;
    	
//    	private WebDriver driver;
//    	ChromeOptions options;
        
        DesiredCapabilities capabilities = null;
//        Map<String, Object> chromeOptions = new HashMap<>();
       
       ChromeOptions options = new ChromeOptions();
       
//       try {
//			service = new ChromeDriverService.Builder().usingDriverExecutable(new File("src/test/resources/driver/chromedriver.exe")).usingAnyFreePort()
//				.build();
//			service.start();
//		} catch (IOException e) {
//			e.printStackTrace();
//			Assert.fail(e.getMessage());
//		}
       options.addArguments("--ignore-certificate-errors");
		capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//		driver = new RemoteWebDriver(service.getUrl(), capabilities);
     System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
      driver = new ChromeDriver(capabilities);
//      driver.execute_script("Object.defineProperty(navigator, 'webdriver', {get: () => undefined})");
      return driver;
       
       
    }

    public boolean takesScreenshots() {
        return true;
    }
}



