package br.ce.wcaquino.appium.page;

import java.time.Duration;

import org.openqa.selenium.By;

import br.ce.wcaquino.appium.core.BasePage;
import br.ce.wcaquino.appium.core.DriverFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;

import org.openqa.selenium.interactions.touch.TouchActions;

public class CliquesPage extends BasePage {
	
	public void cliqueLongo() 
	{
		
		/*TouchActions action = new TouchActions(DriverFactory.getDriver());
		action.longPress(DriverFactory.getDriver().findElement(By.xpath("//*[@text='Clique Longo']")));
		action.release().perform();*/
		
		MobileElement origem = DriverFactory.getDriver().findElement(By.xpath("//*[@text='Clique Longo']"));
		MobileElement destino = DriverFactory.getDriver().findElement(By.xpath("(//android.widget.TextView)[3]"));
		
		LongPressOptions lpOptions = LongPressOptions.longPressOptions()
				.withDuration(Duration.ofMillis(500))
				.withElement(ElementOption.element(origem));
		
		new TouchAction<>(DriverFactory.getDriver())
				.longPress(lpOptions)
				.moveTo(ElementOption.element(destino))
				.release()
				.perform();
		
	}
	
	public String obterTextoCampo() 
	{
		return DriverFactory.getDriver().findElement(By.xpath("(//android.widget.TextView)[3]")).getText();
	}
}
