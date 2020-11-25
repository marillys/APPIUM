package br.ce.wcaquino.appium.page;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.ce.wcaquino.appium.core.BasePage;
import br.ce.wcaquino.appium.core.DriverFactory;

public class WebViewPage extends BasePage {

	public void entrarContextoWeb() {
		Set<String> contextHandles = DriverFactory.getDriver().getContextHandles();

		/*
		 * for (String string : contextHandles) { System.out.println(string +"-");
		 * 
		 * }
		 */
		DriverFactory.getDriver().context((String) contextHandles.toArray()[1]);
	}
	
	public void sairContextoWeb() {
		DriverFactory.getDriver().context((String) DriverFactory.getDriver().getContextHandles().toArray()[0]);
	}

	public void setEmail(String email) {

		DriverFactory.getDriver().findElement(By.xpath("//*[@id='email']")).sendKeys(email);

	}

	public void setSenha(String senha) {
		DriverFactory.getDriver().findElement(By.xpath("//*[@id='senha']")).sendKeys(senha);
	}
}
