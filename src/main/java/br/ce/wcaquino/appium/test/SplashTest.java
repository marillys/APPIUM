package br.ce.wcaquino.appium.test;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.MenuPage;
import br.ce.wcaquino.appium.page.SplashPage;

public class SplashTest extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private SplashPage page = new SplashPage();
	
	@Test
	public void deveAguardarSplashSumir() 
	{
		menu.acessarSplash();
		page.isTelaSplashVisivel();	
		
		page.aguardarSplashSumir();
		
		assertTrue(page.existeElementoPorTexto("Formulário"));
	}

}
