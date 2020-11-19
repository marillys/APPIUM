package br.ce.wcaquino.appium.page;

import org.openqa.selenium.By;

import br.ce.wcaquino.appium.core.BasePage;
import br.ce.wcaquino.appium.core.DriverFactory;
import io.appium.java_client.TouchAction;

import org.openqa.selenium.interactions.touch.TouchActions;

public class CliquesPage extends BasePage {
	
	public void cliqueLongo() 
	{
		
		TouchActions action = new TouchActions(DriverFactory.getDriver());
		action.longPress(DriverFactory.getDriver().findElement(By.xpath("//*[@text = 'Clique Longo']")));
		action.release().perform();
		
	}
	
	public String obterTextoCampo() 
	{
		return DriverFactory.getDriver().findElement(By.xpath("(//android.widget.TextView)[3]")).getText();
	}
}
