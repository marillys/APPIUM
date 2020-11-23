package br.ce.wcaquino.appium.page;

import java.util.List;

import org.openqa.selenium.By;

import br.ce.wcaquino.appium.core.BasePage;
import br.ce.wcaquino.appium.core.DriverFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;

public class DragDropPage extends BasePage {

	public void arrastar(String origem, String destino) {
		MobileElement inicio = DriverFactory.getDriver().findElement(By.xpath("//*[@text='"+origem+"']"));
		MobileElement fim = DriverFactory.getDriver().findElement(By.xpath("//*[@text='"+destino+"']"));
		
		new TouchAction(DriverFactory.getDriver())
			.longPress(ElementOption.element(inicio))
			.moveTo(ElementOption.element(fim))
			.release().
			perform();
	}

	public String[] obterLista() {
		List<MobileElement> elementos = DriverFactory.getDriver().findElements(By.className("android.widget.TextView"));

		String[] retorno = new String[elementos.size()];

		for (int i = 0; i < elementos.size(); i++) {
			retorno[i] = elementos.get(i).getText();
		}

		return retorno;
	}
}
