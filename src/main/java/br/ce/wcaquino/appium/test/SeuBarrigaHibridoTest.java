package br.ce.wcaquino.appium.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.MenuPage;
import br.ce.wcaquino.appium.page.WebViewPage;

public class SeuBarrigaHibridoTest extends BaseTest {
	MenuPage menu = new MenuPage();
	WebViewPage page = new WebViewPage();
	
	@Test
	public void deveFazerLogin() 
	{
		menu.acessarSeuBarrigaHibrido();
		esperar(1000);
		
		page.entrarContextoWeb();
		//esperar(5000);
		page.setEmail("marilia@a");
		page.setSenha("Marilia");
		page.entrar();
		
		assertEquals(page.getMensagem(), "Bem vindo, Marilia!");
	}
	@AfterTest
	public void tearDown() 
	{
		page.sairContextoWeb();
	}
}
