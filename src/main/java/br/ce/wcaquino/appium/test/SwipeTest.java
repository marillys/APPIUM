package br.ce.wcaquino.appium.test;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.MenuPage;

public class SwipeTest extends BaseTest {

	MenuPage menu = new MenuPage();

	@Test
	public void deveRealizarSwipe() {
		menu.acessarSwipe();

		assertTrue(menu.existeElementoPorTexto("a esquerda"));

		menu.swipeRight();

		assertTrue(menu.existeElementoPorTexto("E veja se"));

		menu.clicarPorTexto("›");

		assertTrue(menu.existeElementoPorTexto("Chegar até o fim!"));

		menu.swipeLeft();

		menu.clicarPorTexto("‹");
		assertTrue(menu.existeElementoPorTexto("a esquerda"));
	}
}
