package br.ce.wcaquino.appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CalculadoraTeste {
	
	@Test
	public void deveSomarDoisValores() throws MalformedURLException {
		//Capacidades
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability("appPackage", "com.android.calculator2");
		desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
		
		AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
		
		MobileElement el4 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_2");
	    el4.click();
	    MobileElement el5 = (MobileElement) driver.findElementByAccessibilityId("plus");
	    el5.click();
	    MobileElement el6 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_3");
	    el6.click();
	    MobileElement el7 = (MobileElement) driver.findElementById("com.android.calculator2:id/result");
	    System.out.println(el7.getText());
	    
	    Assert.assertEquals("6", el7.getText());
	    
	    driver.quit();
		/*

public class SampleTest {

  private AndroidDriver driver;

  @Before
  public void setUp() throws MalformedURLException {

    URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

    driver = new AndroidDriver(remoteUrl, desiredCapabilities);
  }

  @Test
  public void sampleTest() {
    
  }

  @After
  public void tearDown() {
    driver.quit();
  }
}*/
	}
	
}
