package basics;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class busquedaviaje {
		
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//para usar Chrome en lugar de Firefox
		//WebDriver driver= new ChromeDriver();
			
		WebDriver driver= new FirefoxDriver();
				
		driver.get("http://www.avantrip.com");
		//imprime el titulo de la pagina
		System.out.println(driver.getTitle());
		//imprime la url
		
		System.out.println(driver.getCurrentUrl());
				
		WebElement desde = driver.findElement(By.id("txt_desde_0"));
		desde.click();
		desde.sendKeys("Uruguay");
		desde.sendKeys(Keys.DOWN);
		desde.sendKeys(Keys.TAB);
		
		WebElement hacia = driver.findElement(By.id("txt_hacia_0"));
		hacia.sendKeys("Paris");
		hacia.sendKeys(Keys.DOWN);
		hacia.sendKeys(Keys.TAB);
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement dia=driver.findElement(By.xpath("/html/body/div[3]/div[3]/table/tbody/tr[1]/td[1]/a"));  
		dia.click();
		
		WebElement hasta=driver.findElement(By.xpath("/html/body/div[3]/div[1]/table/tbody/tr[3]/td[3]/a"));
		hasta.click();
		
		WebElement buscar=driver.findElement(By.id("bttn_buscar"));
		buscar.click();
				
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);			
		WebElement buy = driver.findElement(By.id("goCheckout"));
		String ars= driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[2]/div[2]/div[4]/div[1]/ul/form[1]/li/div/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]/div/p[2]/span[1]")).getText();
		String moneda="ARS";
		
		if (ars.equals(moneda))
		{
			System.out.println("Son pesos argentinos");
		}
								
		if (buy.isDisplayed())
		{
			System.out.println("la busqueda trajo resultados");
		}
		
		if (buy.isEnabled())
		{
			System.out.println("El boton comprar esta habilitado");
		}
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		buy.click();
			
						
	}

}
