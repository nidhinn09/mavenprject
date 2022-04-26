package mainTestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class TestNGAlertmessage {
	WebDriver driver;
  @Test 
  public void alertMessageHandling() {
	  WebElement customerId= driver.findElement(By.name("cusid"));
		customerId.sendKeys("nnn");
		WebElement submitElement= driver.findElement(By.xpath("//*[@value='Submit']"));
		submitElement.click();
		driver.switchTo().alert().accept();
		//Thread.sleep(999);
		driver.switchTo().alert().accept();
  }
  @BeforeMethod
  public void beforeMethod() {
		driver.get("https://demo.guru99.com/test/delete_customer.php");
		driver.manage().window().maximize();
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
