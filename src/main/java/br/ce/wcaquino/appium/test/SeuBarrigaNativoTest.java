package br.ce.wcaquino.appium.test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.MenuPage;
import br.ce.wcaquino.appium.page.SeuBarriga.LoginPage;
import br.ce.wcaquino.appium.page.SeuBarriga.SeuBarigaMenuPage;
import br.ce.wcaquino.appium.page.SeuBarriga.SeuBarrigaContasPage;

public class SeuBarrigaNativoTest extends BaseTest {

	MenuPage menu = new MenuPage();
	LoginPage login = new LoginPage();
	SeuBarigaMenuPage home = new SeuBarigaMenuPage();
	SeuBarrigaContasPage contas = new SeuBarrigaContasPage();
	
	@BeforeTest
	public void deveRealizarLogin()
	{
		menu.acessarSeuBarrigaNativo();
		
		//Informar usuario
		login.preencherEmail("marilia@a");
		//informar senha
		login.preencherSenha("Marilia");
		//clicar Botao entrar
		login.clicarBotaoEntrar();
		assertTrue(home.isHome());
	}
	@Test
	public void inserirContaComSucesso() 
	{
		//ClicarAba de contas
		home.clicarAbaContas();
		//Informe um nome
		contas.preencherConta("TESTE25");
		//clique em salvar
		contas.clicarBotaoSalvar();
		//Verifica a mensagem
		assertTrue(contas.contaIncluida());
	}
	
	@Test
	public void excluirConta() 
	{
		//Aba contas
		home.clicarAbaContas();
		//selecionar uma conta - clique longo
		contas.selecionarItemLista();
		//Ela vem pra cima, podendo clicar no botão EXCLUIR
		//Validar mensagem
	}
}
