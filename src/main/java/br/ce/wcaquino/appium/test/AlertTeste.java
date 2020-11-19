package br.ce.wcaquino.appium.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.AlertPage;
import br.ce.wcaquino.appium.page.MenuPage;

public class AlertTeste extends BaseTest {
	
	MenuPage menu = new  MenuPage();
	AlertPage page = new AlertPage();
	
	@BeforeMethod
	public void inicializar() 
	{
		menu.acessarAlertas();
	}
	
	@Test
	public void deveConfirmarAlerta() 
	{
		page.clicarAlertaConfirm();
		
		assertEquals(page.obterTituloAlerta(), "Info");
		assertEquals(page.obterMensagemAlerta(), "Confirma a operação?");
		
		page.confirmar();
		
		assertEquals(page.obterMensagemAlerta(), "Confirmado");
		
		page.sair();
	}
	
	@Test
	public void deveClicarForaAlerta() 
	{
		page.clicarAlertaSimples();
		esperar(1000);
		page.clicarForaCaixa();
		
		assertFalse(page.existeElementoPorTexto("Pode clicar no OK ou fora da caixa para sair"));
	}
}
