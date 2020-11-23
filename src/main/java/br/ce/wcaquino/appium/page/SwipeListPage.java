package br.ce.wcaquino.appium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;

import br.ce.wcaquino.appium.core.BasePage;
import br.ce.wcaquino.appium.core.DriverFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class SwipeListPage extends BasePage {
	
	public void swipeElementLeft(String opcao) 
	{		
		swipeElement(DriverFactory.getDriver().findElement(By.xpath("//*[@text='"+opcao+"']/..")), 0.1, 0.9);
	}
	
	public void swipeElementRight(String opcao) 
	{		
		swipeElement(DriverFactory.getDriver().findElement(By.xpath("//*[@text='"+opcao+"']/..")), 0.9, 0.1);
	}
	
	public void clicarBotaoMais()
	{
		MobileElement botao = DriverFactory.getDriver().findElement(By.xpath("//*[@text='(+)']/.."));
		
		Point center = botao.getCenter();
		new TouchAction(DriverFactory.getDriver())
			.tap(PointOption.point(center.x - 50,center.y))
			.perform();
		
	}
	
}
