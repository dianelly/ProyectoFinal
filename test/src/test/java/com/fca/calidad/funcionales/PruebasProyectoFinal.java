package com.fca.calidad.funcionales;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PruebasProyectoFinal {
	 private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

 @Before
 public void setUp() throws Exception {
   System.setProperty("webdriver.chrome.driver","C:\\Users\\Dianelly Noguera\\Documents\\calidad\\chromedriver.exe");
		driver = new ChromeDriver();
	    baseUrl = "https://mern-crud.herokuapp.com/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
  @Test
  public void AgregarElementoTest() throws Exception {
	    driver.get("https://mern-crud.herokuapp.com/");
	    driver.findElement(By.xpath("//div[@id='root']/div/div[2]/button")).click();
	    driver.findElement(By.name("name")).click();
	    driver.findElement(By.name("name")).clear();
	    driver.findElement(By.name("name")).sendKeys("AgregarElemento");
	    driver.findElement(By.name("email")).click();
	    driver.findElement(By.name("email")).clear();
	    driver.findElement(By.name("email")).sendKeys("agregar@hotmail.com");
	    driver.findElement(By.name("age")).clear();
	    driver.findElement(By.name("age")).sendKeys("18");
	    driver.findElement(By.xpath("//div[3]/div[2]/div")).click();
	    driver.findElement(By.xpath("//div[2]/span")).click();
	    driver.findElement(By.xpath("//form/button")).click();
	  pause(5000);
	  //verificaciÃ³n
	    WebElement elemento = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[4]/div/p"));
	    String textoEjecucion = elemento.getText();
	    String textoEsperado = "Successfully added!";
	    assertEquals(textoEsperado,textoEjecucion);
	  } 
 @Test
  public void EliminarElementoTest() throws Exception {
	    driver.get("https://mern-crud.herokuapp.com/");
	    driver.findElement(By.xpath("//div[@id='root']/div/div[2]/button")).click();
	    driver.findElement(By.name("name")).click();
	    driver.findElement(By.name("name")).clear();
	    driver.findElement(By.name("name")).sendKeys("EliminarElemento");
	    driver.findElement(By.name("email")).click();
	    driver.findElement(By.name("email")).clear();
	    driver.findElement(By.name("email")).sendKeys("Eliminar@gmail.com");
	    driver.findElement(By.name("age")).clear();
	    driver.findElement(By.name("age")).sendKeys("23");
	    driver.findElement(By.xpath("//div[3]/div[2]/div")).click();
	    driver.findElement(By.xpath("//div[2]/span")).click();
	    driver.findElement(By.xpath("//form/button")).click();
        pause(3000);
        driver.get("https://mern-crud.herokuapp.com/");
	  pause(2000);
		driver.findElement(By.xpath("//div[@id='root']/div/div[2]/table/tbody/tr/td[5]/button[2]")).click();
	  pause(3000);
	    driver.findElement(By.xpath("//div[3]/button")).click();
		 //verificaciÃ³n
	  String innerText = driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr/td[1]")).getText();
	   System.out.println(innerText);
	   driver.quit();
	   }
  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
	  private void pause(long mils) {
		  try {
			  Thread.sleep(mils);
		  }catch(Exception e) {
			  e.printStackTrace();
		  }
	  }
	

}
