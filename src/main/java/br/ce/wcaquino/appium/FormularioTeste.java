package br.ce.wcaquino.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class FormularioTeste {
	
	@Test
	public void devePreencherCampoTexto() throws MalformedURLException 
	{
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		//instalar apk, caso ja esteja instalada =, dará um reset
		desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\maril\\Documentos\\Projetos\\CursoAppium\\src\\main\\resources\\CTAppium_1_2.apk");
		
		AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//selecionar formulário, digitar nome e checar o que foi escrito
		List<MobileElement> elementos = driver.findElements(By.className("android.widget.TextView"));
		
		/*Listar todos os itens da lista
		for(MobileElement elemento: elementos)
		{
			System.out.println(elemento.getText());
		}*/
		
		elementos.get(1).click();//clicar no segundo item, começa em 0
		
		MobileElement campoNome = driver.findElement(MobileBy.AccessibilityId("nome"));
		campoNome.sendKeys("MARILIA");
		
		String text = campoNome.getText();
		
		Assert.assertEquals("MARILIA", text);
		
		driver.quit();
	}
	
	@Test
	public void deveInteragirCombo() throws MalformedURLException 
	{
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		//instalar apk, caso ja esteja instalada =, dará um reset
		desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\maril\\Documentos\\Projetos\\CursoAppium\\src\\main\\resources\\CTAppium_1_2.apk");
		
		AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//selecionar formulário
		driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();
		
		//clicar no combo
		driver.findElement(MobileBy.AccessibilityId("console")).click();
		
		//selecionar uma opção 
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();
		
		//verificar a opção selecionado
		String text = driver.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView")).getText();
		
		Assert.assertEquals(text, "Nintendo Switch");
		
		driver.quit();
	}

	@Test
	public void deveInteragirSwitchCheckBox() throws MalformedURLException 
	{
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		//instalar apk, caso ja esteja instalada =, dará um reset
		desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\maril\\Documentos\\Projetos\\CursoAppium\\src\\main\\resources\\CTAppium_1_2.apk");
		
		AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//selecionar formulário
		driver.findElement(By.xpath("//*[@text='Formulário']")).click();//buscar qualquer elemento com texto formulário
		
		//verificar status dos elementos
		MobileElement check = driver.findElement(By.className("android.widget.CheckBox"));
		MobileElement botaoSwitch = driver.findElement(MobileBy.AccessibilityId("switch"));
		
		//Inicia false, inicia true, respectivamente
		Assert.assertTrue(check.getAttribute("checked").equals("false"));
		Assert.assertTrue(botaoSwitch.getAttribute("checked").equals("true"));
				
		//clicar nos elementos
		check.click();
		botaoSwitch.click();
		
		//verificar status novamente
		Assert.assertFalse(check.getAttribute("checked").equals("false"));
		Assert.assertFalse(botaoSwitch.getAttribute("checked").equals("true"));
		
		driver.quit();
	}
	
	@Test
	public void preencherFormularioDesafio() throws MalformedURLException 
	{
		String nome= "ANA";
		
		//Inicio 
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\maril\\Documentos\\Projetos\\CursoAppium\\src\\main\\resources\\CTAppium_1_2.apk");
				
		AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	

		//clicar em formulário
		driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();
		
		
		//Preencher nome
		driver.findElement(MobileBy.AccessibilityId("nome")).sendKeys(nome);
		
		//Selecionar itens - segundo item da lista
		driver.findElement(MobileBy.AccessibilityId("console")).click();		
		driver.findElement(By.xpath("//android.widget.ListView[1]")).click();
		
		//clicar no checkbox e no switch
		driver.findElement(By.className("android.widget.CheckBox")).click();
		driver.findElement(By.className("android.widget.Switch")).click();
		
		//clicar em Salvar
		driver.findElement(MobileBy.AccessibilityId("save")).click();
				
		//Não funcionou o assert
		Assert.assertEquals(driver.findElement(By.xpath("//android.widget.TextView[@text='Nome: "+nome+"']")).getText(), "Nome: "+nome);
	}
	
	@Test
	public void deveResolverDesafio() throws MalformedURLException 
	{
		String nome = "CAMILA";
		
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		//instalar apk, caso ja esteja instalada =, dará um reset
		desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\maril\\Documentos\\Projetos\\CursoAppium\\src\\main\\resources\\CTAppium_1_2.apk");
		
		AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//selecionar formulário
		driver.findElement(By.xpath("//*[@text='Formulário']")).click();//buscar qualquer elemento com texto formulário
		
		//preencher campos
		driver.findElement(By.className("android.widget.EditText")).sendKeys(nome);
		driver.findElement(By.className("android.widget.CheckBox")).click();
		driver.findElement(By.className("android.widget.Switch")).click();
		driver.findElement(By.className("android.widget.Spinner")).click();
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();
		driver.findElement(By.xpath("//*[@text='SALVAR']")).click();
		
		//verificações
		MobileElement nomeObtido= driver.findElement(By.xpath("//android.widget.TextView[@text='Nome: CAMILA']"));
		Assert.assertEquals(nomeObtido.getText(), "Nome: "+nome);

		MobileElement combo = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]"));
		Assert.assertEquals(combo.getText(), "Console: switch");
		
		MobileElement campoSwitch = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]"));
		Assert.assertTrue(campoSwitch.getText().endsWith("Off"));
		

		MobileElement checkbox = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]"));
		Assert.assertTrue(checkbox.getText().endsWith("Marcado"));
		
		driver.quit();
	}
}
