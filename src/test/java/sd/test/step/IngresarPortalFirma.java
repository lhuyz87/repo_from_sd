package sd.test.step;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import sd.test.page.LoginPage;


public class IngresarPortalFirma {
	
	@Steps
	private LoginPage loginPage;
	
	@Step
	public void ingresarPortal() {
		loginPage.ingresaPagina();
	}
	
	@Step
	public void ingresarCredenciales(String usuario) throws InterruptedException {
		
		loginPage.ingresarUsuario(usuario);
//		loginPage.opcionContinuar();
		
	}
	@Step
	public void seleccionarContinuar() throws InterruptedException {
		loginPage.opcionContinuar();
//		loginPage.opcionContinuarEnter();
	}
	@Step
	public void ingresarPassword(String password) throws InterruptedException {
		
		loginPage.ingresarPassword(password);
		loginPage.opcionIngresar();
	}

}
