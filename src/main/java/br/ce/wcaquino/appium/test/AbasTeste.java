package br.ce.wcaquino.appium.test;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.AbaPage;
import br.ce.wcaquino.appium.page.MenuPage;

public class AbasTeste extends BaseTest {
	
	MenuPage menu = new MenuPage();
	AbaPage page = new AbaPage();
	
	@Test
	public void deveInteragirComAbas() 
	{
		menu.acessarAbas();
		
		assertTrue(page.isAba1());
		
		page.selecionarAba2();
		
		assertTrue(page.isAba2());
	}

}
