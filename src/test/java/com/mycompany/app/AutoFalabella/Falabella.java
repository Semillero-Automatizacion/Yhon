package com.mycompany.app.AutoFalabella;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Falabella {

	WebDriver driver;
	String url = "https://web.segurosfalabella.com/co/";

	@Test
	public void procesar() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		WebElement cotiz = driver.findElement(By.xpath("//*[@id=\"col-select-SOAT\"]/div/div"));
		cotiz.click();

		WebElement placa = driver.findElement(By.xpath("//*[@id=\"licence-plate\"]"));
		placa.sendKeys(Keys.TAB);
		placa.sendKeys("DNR327");
		
		Thread.sleep(2000);
		WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"material-group-habeas_data\"]/div"));
		checkbox.click();
		
		Thread.sleep(5000);
		WebElement documento = driver.findElement(By.xpath("//div[@class='uk-container box-form-soat']/div[2]/form/div/div/div[3]/div/input"));
		Thread.sleep(5000);
		for(int i = 1; i <= 3; i++) {
			documento.sendKeys(Keys.TAB);
		}
		documento.sendKeys("1022998201");
		
		Thread.sleep(5000);
		Select seleccion = new Select(driver.findElement(By.xpath("//*[@id=\"typeVehicles\"]")));
		seleccion.selectByVisibleText("AUTOMOVILES FAMILIARES");
		
		WebElement bQCotizar = driver.findElement(By.xpath("//*[@id=\"Step0Button\"]"));
		bQCotizar.click();
		//------------------------------------------------------------------
		Thread.sleep(2000);
		WebElement bContinuaR = driver.findElement(By.xpath("//*[@id=\"CheckoutStep_1\"]/div/div/form/div[7]/div/button"));
		bContinuaR.click();
		
		Thread.sleep(2000);
		WebElement bPago = driver.findElement(By.xpath("//*[@id=\"CheckoutStep_3\"]/div/div/form/ul/li[1]"));
		bPago.click();
		
		Thread.sleep(1000);
		Select seleccionBP = new Select(driver.findElement(By.xpath("//*[@id=\"bancos-selected\"]")));
		seleccionBP.selectByVisibleText("BANCOLOMBIA");
		
		Thread.sleep(1000);
		Select seleccionP = new Select(driver.findElement(By.xpath("//*[@id=\"tipopersona-selected\"]")));
		seleccionP.selectByVisibleText("PERSONA NATURAL");
		
		Thread.sleep(1000);
		WebElement regalo = driver.findElement(By.xpath("//*[@id=\"CheckoutStep_3\"]/div/div/form/div[5]/div[3]/label[1]/div"));
		regalo.click();
		
		Thread.sleep(1000);
		WebElement bCheck = driver.findElement(By.xpath("//*[@id=\"material-group-acceptTOS\"]/div"));
		bCheck.click();
		
		Thread.sleep(1000);
		WebElement bContinuar = driver.findElement(By.xpath("//*[@id=\"CheckoutStep_3\"]/div/div/form/div[10]/div[2]/button"));
		bContinuar.click();
	}

	@Before
	public void manejarDriver() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		Thread.sleep(500);
		driver.manage().window().maximize();
	}
}
