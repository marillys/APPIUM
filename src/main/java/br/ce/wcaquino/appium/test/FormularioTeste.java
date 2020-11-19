package br.ce.wcaquino.appium.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.core.DriverFactory;
import br.ce.wcaquino.appium.page.FormularioPage;
import br.ce.wcaquino.appium.page.MenuPage;
import io.appium.java_client.MobileBy;

public class FormularioTeste extends BaseTest {

	private MenuPage menu = new MenuPage();
	private FormularioPage formulario = new FormularioPage();

	@BeforeMethod
	private void inicializarAppium() throws MalformedURLException {
		menu.acessarFormulario();
	}

	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {
		formulario.escreverNome("MARILIA");

		String text = formulario.obterNome();

		assertEquals("MARILIA", text);
	}

	@Test
	public void deveInteragirCombo() throws MalformedURLException {
		formulario.selecionarCombo("Nintendo Switch");

		String text = formulario.obterValorCombo();

		assertEquals(text, "Nintendo Switch");
	}

	@Test
	public void deveInteragirSwitchCheckBox() throws MalformedURLException {
		// Verifica se está marcado
		// Inicia false, inicia true, respectivamente
		assertFalse(formulario.isCheckMarcado());
		assertTrue(formulario.isSwitchMarcado());

		formulario.clicarCheck();
		formulario.clicarSwitch();

		assertTrue(formulario.isCheckMarcado());
		assertFalse(formulario.isSwitchMarcado());
	}

	@Test
	public void preencherFormularioDesafio() throws MalformedURLException {
		String nome = "ANA";

		// Preencher nome
		formulario.escreverNome(nome);

		// Selecionar itens - segundo item da lista
		formulario.selecionarCombo("Nintendo Switch");

		formulario.clicarCheck();
		formulario.clicarSwitch();
		formulario.salvar();

		assertEquals(formulario.obterNomeCadastrado(), "Nome: " + nome);
	}

	@Test
	public void deveRealizarCadastro() throws MalformedURLException {
		String nome = "CAMILA";

		// preencher campos
		formulario.escreverNome(nome);

		formulario.clicarCheck();
		formulario.clicarSwitch();
		formulario.selecionarCombo("Nintendo Switch");

		formulario.salvar();

		// verificações
		String nomeObtido = formulario.obterNomeCadastrado();
		assertEquals(nomeObtido, "Nome: " + nome);

		String combo = formulario.obterConsoleCadastrado();
		assertEquals(combo, "Console: switch");

		String campoSwitch = formulario.obterSwitchCadastrado();
		assertTrue(campoSwitch.endsWith("Off"));

		String checkbox = formulario.obterCheckCadastrado();
		assertTrue(checkbox.endsWith("Marcado"));
	}
	
	@Test
	public void deveRealizarCadastroDemorado() throws MalformedURLException {
		String nome = "CAMILA";

		// preencher campos
		formulario.escreverNome(nome);

		DriverFactory.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		formulario.salvarDemorado();
		//esperar(5000);
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@text='Nome: "+nome+"']")));
		
		// verificações
		String nomeObtido = formulario.obterNomeCadastrado();
		assertEquals(nomeObtido, "Nome: " + nome);
	}
	
	@Test
	public void deveAlterarData() 
	{
		formulario.clicarPorTexto("01/01/2000");
		formulario.clicarPorTexto("20");
		formulario.clicarPorTexto("OK");
		
		assertTrue(formulario.existeElementoPorTexto("20/2/2000"));
	}
	
	@Test
	public void deveAlterarHora()
	{
		formulario.clicarPorTexto("06:00");
		formulario.clicar(MobileBy.AccessibilityId("5"));
		formulario.clicar(MobileBy.AccessibilityId("35"));
		formulario.clicarPorTexto("OK");
		
		assertTrue(formulario.existeElementoPorTexto("5:35"));
	}
	
	@Test
	public void deveInteragirComSeekbar() 
	{
		formulario.clicarSeekBar(0.56);
		formulario.salvar();
		
		assertEquals(formulario.obterSlider(), "Slider: 56");
		
	}
}