package br.ce.wcaquino.appium.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class CalculadoraTesteASUS {

	@Test
	@Ignore
	public void deveSomarDoisValores() throws MalformedURLException {
		// Capacidades
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability("appPackage", "com.asus.calculator");
		desiredCapabilities.setCapability("appActivity", "com.asus.calculator.Calculator");

		AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);

		MobileElement el1 = (MobileElement) driver.findElementById("com.asus.calculator:id/digit2");
		el1.click();
		MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("mais");
		el2.click();
		MobileElement el3 = (MobileElement) driver.findElementById("com.asus.calculator:id/digit3");
		el3.click();
		MobileElement el4 = (MobileElement) driver.findElementByAccessibilityId("igual");
		el4.click();
		MobileElement el5 = (MobileElement) driver.findElementByAccessibilityId("5");
		System.out.println(el5.getText());

		Assert.assertEquals("5", el5.getText());

		driver.quit();
	}
}
