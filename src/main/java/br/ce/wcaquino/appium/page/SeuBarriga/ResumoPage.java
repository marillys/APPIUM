package br.ce.wcaquino.appium.page.SeuBarriga;

import org.openqa.selenium.By;

import br.ce.wcaquino.appium.core.BasePage;
import br.ce.wcaquino.appium.core.DriverFactory;
import io.appium.java_client.MobileElement;

public class ResumoPage extends BasePage {
	
	public void clicarBotaoAtualizar() 
	{
		clicarPorTexto("ATUALIZAR");
	}
	
	public void excluirElemento(String desc) 
	{
		MobileElement elemento = DriverFactory.getDriver().findElement(By.xpath("//*[starts-with(@text, '"+desc+"')]/../.."));
		
		swipeElement(elemento, 0.9, 0.5);
		clicarPorTexto("Del");
	}
}
