package sd.test.definition;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import sd.test.step.IngresarPortalFirma;


public class RealizarLoginDefinition {
	
	@Steps
	private IngresarPortalFirma ingresarPortalFirma;
	
	
	
	@Given("^inicio  la pagina del portal$")
	public void inicio_la_pagina_del_portal() {
	    // Write code here that turns the phrase above into concrete actions
		ingresarPortalFirma.ingresarPortal();
	}

	//@When("^ingreso el usuario \"(([^\"]*)\"$)")
	@When("^ingreso el usuario \"([^\"]*)\"$")
	public void ingreso_el_usuario(String usuario) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		ingresarPortalFirma.ingresarCredenciales(usuario);
	}

	@And("^selecciono continuar \"([^\"]*)\"$")
	public void selecciono_continuar(String arg1) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("entra");
		ingresarPortalFirma.seleccionarContinuar();
	}
	
	@When("^ingreso password \"([^\"]*)\"$")
	public void ingreso_el_password(String password) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		ingresarPortalFirma.ingresarPassword(password);
	}

	@And("^selecciono opcion \"([^\"]*)\"$")
	public void selecciono_opcion(String arg2) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		ingresarPortalFirma.seleccionarContinuar();
	}

	@Then("^se valida el correcto acceso$")
	public void se_valida_el_correto_acceso() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}



}
