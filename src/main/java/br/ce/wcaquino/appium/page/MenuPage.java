package br.ce.wcaquino.appium.page;

import br.ce.wcaquino.appium.core.BasePage;

public class MenuPage extends BasePage{
	
	public void acessarFormulario() 
	{
		clicarPorTexto("Formulário");
	}
	
	public void acessarSeuBarrigaNativo()
	{
		clicarPorTexto("SeuBarriga Nativo");
	}
	
	public void acessarSeuBarrigaHibrido() 
	{
		clicarPorTexto("SeuBarriga Híbrido");
	}
	
	public void acessarSplash()
	{
		clicarPorTexto("Splash");
	}
	
	public void acessarAlertas()
	{
		clicarPorTexto("Alertas");
	}
	
	public void acessarAbas() 
	{
		clicarPorTexto("Abas");
	}
	
	public void acessarAccordion() 
	{
		clicarPorTexto("Accordion");
	}
	
	public void acessarCliques() 
	{
		clicarPorTexto("Cliques");
	}
	
	public void acessarSwipe()
	{
		scrollByText("Swipe");
		clicarPorTexto("Swipe");
	}
	
	public void acessarSwipeList()
	{
		scrollByText("Swipe List");
		clicarPorTexto("Swipe List");
	}
	
	public void acessarDragNDrop() 
	{
		scrollByText("Drag and drop");
		clicarPorTexto("Drag and drop");
	}
}
