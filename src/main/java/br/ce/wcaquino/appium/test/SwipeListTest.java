package br.ce.wcaquino.appium.test;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.MenuPage;
import br.ce.wcaquino.appium.page.SwipeListPage;

public class SwipeListTest extends BaseTest {
	
	MenuPage menu = new MenuPage();
	SwipeListPage page = new SwipeListPage();
	
	@Test
	public void desafio() 
	{
		menu.acessarSwipeList();
		
		page.swipeElementRight("Opção 1");
		
		page.clicarBotaoMais();
		
		assertTrue(menu.existeElementoPorTexto("Opção 1 (+)"));
		
		page.swipeElementRight("Opção 4");
		page.clicarPorTexto("(-)");
		
		assertTrue(menu.existeElementoPorTexto("Opção 4 (-)"));
				
		page.swipeElementLeft("Opção 5 (-)");
		assertTrue(menu.existeElementoPorTexto("Opção 5"));
	}
}
