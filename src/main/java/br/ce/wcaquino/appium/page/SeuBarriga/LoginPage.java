package br.ce.wcaquino.appium.page.SeuBarriga;

import org.openqa.selenium.By;

import br.ce.wcaquino.appium.core.BasePage;

public class LoginPage extends BasePage {

	public void preencherEmail(String email) 
	{
		escrever(By.xpath("//*[@text='Nome']"), email);
	}
	
	public void preencherSenha(String senha)
	{
		escrever(By.xpath("//*[@text='Senha']"), senha);
	}
	
	public void clicarBotaoEntrar() {
		clicarPorTexto("ENTRAR");
	}
}
