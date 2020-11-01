package br.ce.wcaquino.appium;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.ce.wcaquino.appium.core.DSL;
import br.ce.wcaquino.appium.core.DriverFactory;
import io.appium.java_client.MobileBy;

public class FormularioTeste {
	
	private DSL dsl = new DSL();

	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {
		dsl.escrever(MobileBy.AccessibilityId("nome"), "MARILIA");
		
		String text = dsl.obterTexto(MobileBy.AccessibilityId("nome"));

		assertEquals("MARILIA", text);
	}

	@Test
	public void deveInteragirCombo() throws MalformedURLException {
		dsl.selecionarCombo(MobileBy.AccessibilityId("console"), "Nintendo Switch");

		// verificar a opção selecionado
		String text = dsl.obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));

		assertEquals(text, "Nintendo Switch");
	}

	@Test
	public void deveInteragirSwitchCheckBox() throws MalformedURLException {
		// Verifica se está marcado 
		//Inicia false, inicia true, respectivamente
		assertFalse(dsl.isCheckMarcado(By.className("android.widget.CheckBox")));
		assertTrue(dsl.isCheckMarcado(MobileBy.AccessibilityId("switch")));

		// clicar nos elementos
		dsl.clicar(By.className("android.widget.CheckBox"));
		dsl.clicar(MobileBy.AccessibilityId("switch"));

		// verificar status novamente
		assertTrue(dsl.isCheckMarcado(By.className("android.widget.CheckBox")));
		assertFalse(dsl.isCheckMarcado(MobileBy.AccessibilityId("switch")));
	}

	@Test
	public void preencherFormularioDesafio() throws MalformedURLException {
		String nome = "ANA";

		// Preencher nome
		dsl.escrever(MobileBy.AccessibilityId("nome"), nome);

		// Selecionar itens - segundo item da lista
		dsl.clicar(MobileBy.AccessibilityId("console"));
		dsl.clicar(By.xpath("//android.widget.ListView[1]"));

		// clicar no checkbox e no switch
		dsl.clicar(By.className("android.widget.CheckBox"));
		dsl.clicar(By.className("android.widget.Switch"));

		// clicar em Salvar
		dsl.clicar(MobileBy.AccessibilityId("save"));
		
		assertEquals(dsl.obterTexto(By.xpath("//android.widget.TextView[@text='Nome: " + nome + "']")),
				"Nome: " + nome);
	}

	@Test
	public void deveRealizarCadastro() throws MalformedURLException {
		String nome = "CAMILA";

		// preencher campos
		dsl.escrever(By.className("android.widget.EditText"), nome);
		
		dsl.clicar(By.className("android.widget.CheckBox"));
		dsl.clicar(By.className("android.widget.Switch"));
		dsl.selecionarCombo(By.className("android.widget.Spinner"),"Nintendo Switch");
		dsl.clicarPorTexto("SALVAR");

		// verificações
		String nomeObtido = dsl.obterTexto(By.xpath("//android.widget.TextView[@text='Nome: CAMILA']"));
		assertEquals(nomeObtido, "Nome: " + nome);

		String combo = dsl.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]"));
		assertEquals(combo, "Console: switch");

		String campoSwitch = dsl.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]"));
		assertTrue(campoSwitch.endsWith("Off"));

		String checkbox = dsl.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]"));
		assertTrue(checkbox.endsWith("Marcado"));
	}

	@BeforeMethod
	private void inicializarAppium() throws MalformedURLException {
		/*
		 * Formas de acessar o item de meu formaulário - LISTA
		 * 
		 * 
		 * //selecionar formulário, digitar nome e checar o que foi escrito
		 * 
		 * List<MobileElement> elementos =
		 * driver.findElements(By.className("android.widget.TextView"));
		 * 
		 * /*Listar todos os itens da lista for(MobileElement elemento: elementos) {
		 * System.out.println(elemento.getText()); }
		 * 
		 * elementos.get(1).click();//clicar no segundo item, começa em 0
		 */

		/*
		 * 2° Forma //selecionar formulário -
		 * 
		 * driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();
		 */

		//3°Forma
		//selecionar formulário
		//driver.findElement(By.xpath("//*[@text='Formulário']")).click();// buscar qualquer elemento com texto formulário

		dsl.clicarPorTexto("Formulário");
	}

	@AfterMethod
	public void finalizar() {
		DriverFactory.killDriver();
	}
}