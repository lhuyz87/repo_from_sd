package sd.test.page;

import sd.test.xpath.LoginXpath;
import sd.test.util.PageObjectUtil;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.ClearCookiesPolicy;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Managed;
import net.serenitybdd.core.Serenity;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
//@DefaultUrl("https://192.168.0.152:8512/Portal_Firma_RNE_Web/")
//@DefaultUrl("https://192.168.0.25:2347/Portal_Firma_RNE_Web/")
@DefaultUrl("https://200.66.66.214:8612/Portal_Firma_RNE_Web/")
public class LoginPage extends PageObject {
	
	
	LoginXpath loginXpath = new LoginXpath();
	PageObjectUtil pageObjectUtil = new PageObjectUtil();
	
	@Managed(clearCookies = ClearCookiesPolicy.BeforeEachTest)
	private WebDriverWait wdw = null;
	private long wdwTimeOut = 300L;
	
	public void ingresaPagina() {
		
//		open();
//		getDriver().get("https://192.168.0.152:8512/Portal_Firma_RNE_Web/");
//		getDriver().get("https://192.168.0.25:2347/Portal_Firma_RNE_Web/");
		getDriver().get("https://200.66.66.214:8612/Portal_Firma_RNE_Web/");
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().navigate().refresh();
		getDriver().manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
        Serenity.takeScreenshot();
		
	}
	
	public void ingresarUsuario(String usuario) throws InterruptedException {
		Thread.sleep(1000);
		pageObjectUtil.seleniumEscribir(getDriver(), 0,loginXpath.txtUsuario, usuario);
		Thread.sleep(2000);
	}
	
	public void opcionContinuar() throws InterruptedException {
		Thread.sleep(1000);
		pageObjectUtil.seleniumClickPaint(getDriver(), loginXpath.btnLogin, 0);
		pageObjectUtil.sleep(5);
	}
	
	public void opcionContinuarEnter() throws InterruptedException {
		pageObjectUtil.sleep(10);
		pageObjectUtil.seleniumIngresar(getDriver(), loginXpath.btnLogin, 0);
//		pageObjectUtil.clicJS(getDriver(), pageObjectUtil.convertirXpathAWebElment(getDriver(), loginXpath.btnLogin2));
		pageObjectUtil.sleep(30);
	}
	
	public void ingresarPassword(String password) throws InterruptedException {
		
		pageObjectUtil.seleniumEscribir(getDriver(), 0,loginXpath.txtPassword, password);
		
	}
	
	public void opcionIngresar() throws InterruptedException {
		pageObjectUtil.seleniumClick(getDriver(), loginXpath.btnLogin, 0);
		Thread.sleep(2000);
	}

}
