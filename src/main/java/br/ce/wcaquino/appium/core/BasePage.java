package br.ce.wcaquino.appium.core;

import static br.ce.wcaquino.appium.core.DriverFactory.getDriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class BasePage {

	public void escrever(By by, String texto) {
		getDriver().findElement(by).sendKeys(texto);
	}

	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();
	}

	public void clicar(By by) {
		getDriver().findElement(by).click();
	}

	public void clicarPorTexto(String texto) {
		clicar(By.xpath("//*[@text='" + texto + "']"));
	}

	public void selecionarCombo(By by, String valor) {
		// clicar no combo
		getDriver().findElement(by).click();

		clicarPorTexto(valor);
	}

	public boolean isCheckMarcado(By by) {
		return getDriver().findElement(by).getAttribute("checked").equals("true");
	}

	public Boolean existeElementoPorTexto(String texto) {
		List<MobileElement> elementos = getDriver().findElements(By.xpath("//*[@text='" + texto + "']"));

		return elementos.size() > 0;
	}

	public String obterTituloAlerta() 
	{
		return obterTexto(By.id("android:id/alertTitle"));
	}
	
	public String obterMensagemAlerta() 
	{
		return obterTexto(By.id("android:id/message"));
	}
	
	public void tap(int x, int y) {
		new TouchAction(getDriver()).tap(PointOption.point(x, y)).perform();
	}

	public void scroll(double inicio, double fim) {
		Dimension size = getDriver().manage().window().getSize();

		// coletar a dimensão da tela
		// x na metade da tela - largura
		int x = size.width / 2;
		// de qual ponto da tela até qual ponto - subir ou descer
		int start_y = (int) (size.height * inicio);
		int end_y = (int) (size.height * fim);

		new TouchAction(DriverFactory.getDriver()).longPress(PointOption.point(x, start_y))
				.moveTo(PointOption.point(x, end_y)).release().perform();
	}

	public void scrollByText(String menuText) {

		try {
			DriverFactory.getDriver().findElement(
					MobileBy.AndroidUIAutomator(
							"new UiScrollable(new UiSelector().scrollable(true)"
									+ ".instance(0)).scrollIntoView(new UiSelector()"
									+ ".textMatches(\"" + menuText + "\").instance(0));"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}