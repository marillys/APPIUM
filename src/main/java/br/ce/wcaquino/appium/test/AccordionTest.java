package br.ce.wcaquino.appium.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.AccordionPage;
import br.ce.wcaquino.appium.page.MenuPage;

public class AccordionTest extends BaseTest{
	
	MenuPage menu = new MenuPage();
	AccordionPage page = new AccordionPage();
	
	@Test
	public void deveInteragirComAccordion() 
	{
		menu.acessarAccordion();
		
		page.clicarOpcao1();
		
		esperar(1000);
		assertEquals(page.obterValorOp1(), "Esta é a descrição da opção 1");
	}

}
