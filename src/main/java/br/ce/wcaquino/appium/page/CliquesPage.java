package br.ce.wcaquino.appium.page;

import org.openqa.selenium.By;

import br.ce.wcaquino.appium.core.BasePage;
import br.ce.wcaquino.appium.core.DriverFactory;

public class CliquesPage extends BasePage {
	
	public void cliqueLongo() 
	{	
		cliqueLongo(By.xpath("//*[@text='Clique Longo']"));
		
	}
	
	public String obterTextoCampo() 
	{
		return DriverFactory.getDriver().findElement(By.xpath("(//android.widget.TextView)[3]")).getText();
	}
}
