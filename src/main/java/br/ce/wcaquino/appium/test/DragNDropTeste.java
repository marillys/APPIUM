package br.ce.wcaquino.appium.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.DragDropPage;
import br.ce.wcaquino.appium.page.MenuPage;

public class DragNDropTeste extends BaseTest {

	private MenuPage menu = new MenuPage();
	private DragDropPage page = new DragDropPage();
	
	private String[] estadoInicial = new String[] {"Esta", 
			"é uma lista", 
			"Drag em Drop!", 
			"Faça um clique longo,", 
			"e arraste para", 
			"qualquer local desejado."};
	
	private String[] estadoIntermediario = new String[] {"é uma lista", 
			"Drag em Drop!", 
			"Faça um clique longo,", 
			"e arraste para", 
			"Esta",
			"qualquer local desejado."};
	
	private String[] estadoFinal = new String[] {"Faça um clique longo,", 
			"é uma lista", 
			"Drag em Drop!", 			
			"e arraste para", 
			"Esta",
			"qualquer local desejado."};
	
	@Test
	public void deveEfetuarDragNDrop() 
	{
		menu.acessarDragNDrop();
		
		esperar(1000);
		//estadoInicial = page.obterLista();
		
		assertEquals(page.obterLista(), estadoInicial);
		page.arrastar("Esta", "e arraste para");
		
		assertEquals(page.obterLista(), estadoIntermediario);
		
		page.arrastar("Faça um clique longo,", "é uma lista");
		
		assertEquals(page.obterLista(), estadoFinal);
	}
}
