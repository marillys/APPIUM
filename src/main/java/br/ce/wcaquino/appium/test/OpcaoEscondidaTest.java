package br.ce.wcaquino.appium.test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.core.DriverFactory;
import br.ce.wcaquino.appium.page.MenuPage;

public class OpcaoEscondidaTest extends BaseTest {
	MenuPage menu = new MenuPage();
	
	@Test
	public void deveEncontrarOpcaoEscondida() 
	{
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(),10);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@text='Formulário']")));
		
		menu.scrowDown();
		menu.clicarPorTexto("Opção bem escondida");
	
		assertEquals(menu.obterMensagemAlerta(), "Você achou essa opção");
		
		menu.clicarPorTexto("OK");
	}
}
