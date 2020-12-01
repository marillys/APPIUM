package br.ce.wcaquino.appium.page.SeuBarriga;

import org.openqa.selenium.By;

import br.ce.wcaquino.appium.core.BasePage;

public class SeuBarigaMenuPage extends BasePage {

	public Boolean isHome() 
	{
		return existeElementoPorTexto("HOME");
	}
	
	public void clicarAbaContas() 
	{
		clicarPorTexto("CONTAS");
	}
	
	public void clicarAbaMov() 
	{
		clicarPorTexto("MOV...");
	}
	
	public void clicarAbaResumo() 
	{
		clicarPorTexto("RESUMO");
	}
	
	public void clicarAbaHome()
	{
		clicarPorTexto("HOME");
	}
}
