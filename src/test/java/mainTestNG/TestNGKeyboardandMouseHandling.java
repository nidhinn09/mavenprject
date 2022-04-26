package mainTestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;

public class TestNGKeyboardandMouseHandling {
	WebDriver driver;
  @Test
  public void keyboardandMouseHandling() {
	  Actions action = new Actions(driver);
		WebElement message = driver.findElement(By.xpath("//input[@id='single-input-field']"));
		message.sendKeys("nidhin");
		action.sendKeys(Keys.TAB).build().perform();
		WebElement showMessage = driver.findElement(By.xpath("//*[@id='button-one']"));
		action.sendKeys(showMessage,Keys.ENTER).build().perform();
		WebElement yourMessage = driver.findElement(By.xpath("//*[@id='message-one']"));
		System.out.println(yourMessage.getText());
  }
  @BeforeMethod
  public void beforeMethod() {
	    driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
	  
  }

  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver_win32 (1)\\chromedriver.exe");
	  driver = new ChromeDriver();
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
