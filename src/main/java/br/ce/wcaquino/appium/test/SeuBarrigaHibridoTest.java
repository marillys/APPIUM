package br.ce.wcaquino.appium.test;

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
		page.setEmail("marilia.borges01@outlook.com");
		page.setSenha("Marilia");
	}
	@AfterTest
	public void tearDown() 
	{
		page.sairContextoWeb();
	}
}
