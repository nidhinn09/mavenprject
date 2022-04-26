package mainTestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class TestNGIframe {
	WebDriver driver;
  @Test
  public void iFrame() {
	  JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement iframe= driver.findElement(By.xpath("//iframe[@id='a077aa5e']"));
		js.executeScript("arguments[0].scrollIntoView();",iframe);
		//iframe.click();

  }
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/guru99home/");
		driver.manage().window().maximize();
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
