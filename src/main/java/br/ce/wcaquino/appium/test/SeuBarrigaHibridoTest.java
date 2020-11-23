package br.ce.wcaquino.appium.test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.MenuPage;

public class SeuBarrigaHibridoTest extends BaseTest {
	MenuPage menu = new MenuPage();
	
	public void webView() 
	{
		menu.acessarSeuBarrigaHibrido();
	}
}
