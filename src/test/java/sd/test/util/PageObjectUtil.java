package sd.test.util;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import io.appium.java_client.functions.ExpectedCondition;
import net.serenitybdd.core.pages.PageObject;
import java.util.List;


public class PageObjectUtil {
	
	
	public void seleniumClick(WebDriver webDriver, final String xpath, int pos) {
		
		By by = By.xpath(xpath);
		List<WebElement> lista = webDriver.findElements(by);
		if(!lista.isEmpty()) {
			WebElement we = lista.get(pos);
			if(we.isDisplayed()) {
				we.click();
				
			}
			
		}
		
	}
	
	public void seleniumIngresar(WebDriver webDriver, final String xpath, int pos ) {
		By by = By.xpath(xpath);
		List<WebElement> lista = webDriver.findElements(by);
		
		if(!lista.isEmpty()) {
			WebElement we = lista.get(pos);
			
			if(we.isDisplayed()) {
//				we.sendKeys(Keys.ENTER);
				we.click();
			}
		}
	}
	
	public void seleniumEscribir(WebDriver webDriver,  int pos, final String xpath, String valor) {
		
		By by = By.xpath(xpath);
		List<WebElement> lista = webDriver.findElements(by);
		
		if(!lista.isEmpty()) {
			WebElement we = lista.get(pos);
			we.sendKeys(valor);
		}
	}
	
	public boolean isClickable(WebElement el, WebDriver driver) {
		
		try {
			
			WebDriverWait wait = new WebDriverWait(driver, 6);
			wait.until(ExpectedConditions.elementToBeClickable(el));
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	public void clicJS(WebDriver webdriver, WebElement we) {
		JavascriptExecutor js =(JavascriptExecutor)webdriver;
		js.executeScript("arguments[0].click();", we);
		
		
	}
	
	public WebElement convertirXpathAWebElment(WebDriver driver , String xpath) {
		By by = By.xpath(xpath);
		return driver.findElement(by);
	}
	
	
	public void sleep(double seg) {
        long miliseg = (new Double(seg * 1000)).longValue();

        try {
            // System.out.println("sleep:\t\t" + seg + " seg... <--> " + miliseg +
            // "miliseg...");
            Thread.sleep(miliseg);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
	
	public WebElement seleniumWebElement(WebDriver webDriver, final String path, int pos) {
        By by = By.xpath(path);
        List<WebElement> lista = webDriver.findElements(by);

        if (!lista.isEmpty()) {
            return lista.get(pos);
        }

        return null;
    }
	
	public void paintXPath(WebDriver webDriver, String xpath, int pos) {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        WebElement element = seleniumWebElement(webDriver, xpath, pos);
//        js.executeScript("arguments[0].setAttribute('style', 'background: #F9F93E!important')", element);
    }

	
	
	 public void seleniumClickPaint(WebDriver webDriver, final String xpath, int pos) {
	        paintXPath(webDriver, xpath, pos);
	        By by = By.xpath(xpath);
	        List<WebElement> lista = webDriver.findElements(by);

	        if (!lista.isEmpty()) {
	            WebElement we = lista.get(pos);

	            if (we.isDisplayed()) {
	                we.click();
	                sleep(1.5);
	            }
	        }
	    }
	
	
	

}
