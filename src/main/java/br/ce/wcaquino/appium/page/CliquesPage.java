package br.ce.wcaquino.appium.page;

import java.time.Duration;

import org.openqa.selenium.By;

import br.ce.wcaquino.appium.core.BasePage;
import br.ce.wcaquino.appium.core.DriverFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;

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
