package br.ce.wcaquino.appium.page.SeuBarriga;

import org.openqa.selenium.By;

import br.ce.wcaquino.appium.core.BasePage;

public class Movimentacoes extends BasePage {

	public void clicarBotaoSalvar()
	{
		clicarPorTexto("SALVAR");
	}
	
	public void preencherDescricao(String texto) 
	{
		escrever(By.xpath("//android.widget.EditText"), texto);
	}
	
	public void preencherInteressado(String texto) 
	{
		escrever(By.xpath("//android.widget.EditText[2]"), texto);
	}
	
	public void preencherValor(String valor)
	{
		escrever(By.xpath("//android.widget.EditText[3]"), valor);
	}
	
	public void selecionarConta(String conta) 
	{
		clicarPorTexto("Selecione uma conta...");
		
		clicar(By.xpath("//android.widget.CheckedTextView[@text='"+conta+"']"));
		/*"//android.widget.TextView[starts-with(@text, 'Checkbox:')]"
				cliqueLongo(By.xpath("//*[@text='"+conta+"']"));	
				android:id/select_dialog_listview*/
	}
}
