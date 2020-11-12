package br.ce.wcaquino.appium.core;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class BaseTest {

	@AfterMethod
	public void tearDown() {
		gerarScreenshot();
		DriverFactory.getDriver().resetApp();
	}

	@AfterClass
	public static void finalizaClasse() {
		DriverFactory.killDriver();
	}

	public void gerarScreenshot() {
		try {
			File imagem = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);

			//Até agora o nome está fixo 
			//Para modificar, é só usar os ouvintes do testng
			//Nesse ouvinte dá para coletar o resultado do teste, a imagem e gerar um relatório ainda
			FileUtils.copyFile(imagem, new File("target/screenshots/imagem.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void esperar(long tempo) 
	{
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
