package br.ce.wcaquino.appium.page.SeuBarriga;

import org.openqa.selenium.By;

import br.ce.wcaquino.appium.core.BasePage;

public class HomePage extends BasePage {
	
	public String obterSaldoConta(String conta) 
	{
		return obterTexto(By.xpath("//*[@text='" + conta + "']/following-sibling::android.widget.TextView"));
	}
	
	public void atualizarPaginaSaldos() 
	{
		scroll(0.3, 0.9);
	}
	
	public void clicarBotaoReset() 
	{
		clicarPorTexto("RESET");
	}
}
