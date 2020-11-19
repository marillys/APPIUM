package br.ce.wcaquino.appium.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.CliquesPage;
import br.ce.wcaquino.appium.page.MenuPage;

public class CliquesTeste extends BaseTest {
	MenuPage menu = new MenuPage();
	CliquesPage page = new CliquesPage();
	
	@Test
	public void deveClicarLongo() 
	{
		menu.acessarCliques();
		page.cliqueLongo();
		esperar(5000);
		
		assertEquals(page.obterTextoCampo(), "Clique Longo");
	}
}
