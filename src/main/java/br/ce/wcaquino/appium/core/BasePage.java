package br.ce.wcaquino.appium.core;

import static br.ce.wcaquino.appium.core.DriverFactory.getDriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
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

	public String obterTituloAlerta() {
		return obterTexto(By.id("android:id/alertTitle"));
	}

	public String obterMensagemAlerta() {
		return obterTexto(By.id("android:id/message"));
	}

	public void tap(int x, int y) {
		new TouchAction<>(getDriver()).tap(PointOption.point(x, y)).perform();
	}

	public void scroll(double inicio, double fim) {
		Dimension size = getDriver().manage().window().getSize();

		// coletar a dimensão da tela
		// x na metade da tela - largura
		int x = size.width / 2;
		// de qual ponto da tela até qual ponto - subir ou descer
		int start_y = (int) (size.height * inicio);
		int end_y = (int) (size.height * fim);

		new TouchAction<>(DriverFactory.getDriver()).longPress(PointOption.point(x, start_y))
				.moveTo(PointOption.point(x, end_y)).release().perform();
	}

	public void scrollByText(String menuText) {

		try {
			DriverFactory.getDriver()
					.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)"
							+ ".instance(0)).scrollIntoView(new UiSelector()" + ".textMatches(\"" + menuText
							+ "\").instance(0));"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void scrowDown() {
		scroll(0.9, 0.1);
	}

	public void scrowUp() {
		scroll(0.1, 0.9);
	}

	public void swipe(double inicio, double fim) {
		Dimension size = getDriver().manage().window().getSize();

		int start_x = (int) (size.width * inicio);
		int end_x = (int) (size.width * fim);
		int y = size.height / 2;

		new TouchAction<>(DriverFactory.getDriver()).longPress(PointOption.point(start_x, y))
				.moveTo(PointOption.point(end_x, y)).release().perform();
	}

	public void swipeLeft() {
		swipe(0.1, 0.9);
	}

	public void swipeRight() {
		swipe(0.9, 0.1);
	}

	public void swipeElement(MobileElement element, double inicio, double fim) {

		int start_x = (int) (element.getSize().width * inicio);
		int end_x = (int) (element.getSize().width * fim);
		int y = element.getLocation().y + (element.getSize().height / 2);

		new TouchAction<>(DriverFactory.getDriver()).longPress(PointOption.point(start_x, y))
				.moveTo(PointOption.point(end_x, y)).release().perform();
	}

	public void cliqueLongo(By elemento1) {
		MobileElement origem = DriverFactory.getDriver().findElement(elemento1);
		
		LongPressOptions lpOptions = LongPressOptions.longPressOptions().withDuration(Duration.ofMillis(500))
				.withElement(ElementOption.element(origem));

		new TouchAction<>(DriverFactory.getDriver()).longPress(lpOptions)
				// .moveTo(ElementOption.element(destino))
				// .release()
				.perform();

	}

	public void clicarLongoArrastar() {
		
		//Método não está 100%, pode passar por paramentro 2 by

		MobileElement origem = DriverFactory.getDriver().findElement(By.xpath("//*[@text='Clique Longo']"));
		MobileElement destino = DriverFactory.getDriver().findElement(By.xpath("(//android.widget.TextView)[3]"));

		LongPressOptions lpOptions = LongPressOptions.longPressOptions().withDuration(Duration.ofMillis(500))
				.withElement(ElementOption.element(origem));

		new TouchAction<>(DriverFactory.getDriver()).longPress(lpOptions).moveTo(ElementOption.element(destino))
				.release().perform();
	}
}