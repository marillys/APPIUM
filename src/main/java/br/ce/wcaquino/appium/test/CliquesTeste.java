package br.ce.wcaquino.appium.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.CliquesPage;
import br.ce.wcaquino.appium.page.MenuPage;

public class CliquesTeste extends BaseTest {
	MenuPage menu = new MenuPage();
	CliquesPage page = new CliquesPage();
	
	@BeforeMethod
	public void inicializar() 
	{
		menu.acessarCliques();
	}
	
	@Test
	public void deveClicarLongo() 
	{
		page.cliqueLongo();
		esperar(1000);
		
		assertEquals(page.obterTextoCampo(), "Clique Longo");
	}
	
	@Test
	public void deveRealizarCliqueDuplo() 
	{
		page.clicarPorTexto("Clique duplo");
		page.clicarPorTexto("Clique duplo");
		
		assertEquals(page.obterTextoCampo(), "Duplo Clique");
	}
}
