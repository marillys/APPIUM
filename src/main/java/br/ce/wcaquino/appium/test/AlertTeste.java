package br.ce.wcaquino.appium.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.AlertPage;
import br.ce.wcaquino.appium.page.MenuPage;

public class AlertTeste extends BaseTest {
	
	MenuPage menu = new  MenuPage();
	AlertPage page = new AlertPage();
	
	@Test
	public void deveConfirmarAlerta() 
	{
		menu.acessarAlertas();
		
		page.clicarAlertaConfirm();
		
		assertEquals(page.obterTituloAlerta(), "Info");
		assertEquals(page.obterMensagemAlerta(), "Confirma a operação?");
		
		page.confirmar();
		
		assertEquals(page.obterMensagemAlerta(), "Confirmado");
		
		page.sair();
	}
}
