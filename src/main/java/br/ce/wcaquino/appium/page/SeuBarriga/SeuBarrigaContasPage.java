package br.ce.wcaquino.appium.page.SeuBarriga;

import org.openqa.selenium.By;

import br.ce.wcaquino.appium.core.BasePage;

public class SeuBarrigaContasPage extends BasePage {

	public void clicarBotaoSalvar() 
	{
		clicarPorTexto("SALVAR");
	}
	
	public void preencherConta(String nome) 
	{		
		escrever(By.className("android.widget.EditText"), nome);
	}
	
	public Boolean contaIncluida() 
	{
		return existeElementoPorTexto("Conta adicionada com sucesso");
	}
	
	public void selecionarItemLista() 
	{
		cliqueLongo(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup"), 
				By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup"));		
	}
}
