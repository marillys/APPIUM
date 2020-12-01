package br.ce.wcaquino.appium.page.SeuBarriga;

import org.openqa.selenium.By;

import br.ce.wcaquino.appium.core.BasePage;
import br.ce.wcaquino.appium.core.DriverFactory;

public class ResumoPage extends BasePage {
	
	public void clicarBotaoAtualizar() 
	{
		clicarPorTexto("ATUALIZAR");
	}
	
	public void excluirElemento(String opcao) 
	{
		swipeElement(DriverFactory.getDriver().findElement(By.xpath("//android.widget.TextView[starts-with(@text, '"+opcao+"')]/../..")), 0.9, 0.5);
		clicarPorTexto("Del");
	}
}
