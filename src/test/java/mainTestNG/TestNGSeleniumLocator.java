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

public class TestNGSeleniumLocator {
	WebDriver driver;
  @Test
  public void seleniumLocator() {
	  WebElement login= driver.findElement(By.xpath("//input[@id='txtUsername']"));
		login.sendKeys("Admin");
		WebElement paswrd= driver.findElement(By.xpath("//input[@id='txtPassword']"));
		paswrd.sendKeys("admin123");
		WebElement sbmit= driver.findElement(By.xpath("//input[@id='btnLogin']"));
		sbmit.click();
		WebElement info= driver.findElement(By.xpath("//*[text()='My Info']"));
		info.click();
		WebElement contact= driver.findElement(By.xpath("(//*[text()='Contact Details'])[1]"));
		contact.click();
		WebElement emegencyContact= driver.findElement(By.xpath("//*[text()='Emergency Contacts']"));
		emegencyContact.click();
  }
  @BeforeMethod
  public void beforeMethod() {
	  driver.get("https://opensource-demo.orangehrmlive.com/");
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
