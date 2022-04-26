package mainTestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class TestNGScrolling {
	WebDriver driver;
  @Test
  public void scrollingDown() {
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.MINUTES);
		JavascriptExecutor js= (JavascriptExecutor)driver;
		  js.executeScript("window.scrollBy(0,1000)");
			  WebElement document=driver.findElement(By.xpath("//*[text()='Customer Support']"));
			  js.executeScript("arguments[0].scrollIntoView();",document);
  }

  @BeforeMethod
  public void beforeMethod() {
		driver.get("https://www.freecrm.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.MINUTES);
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
