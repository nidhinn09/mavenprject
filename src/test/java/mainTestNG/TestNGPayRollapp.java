package mainTestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class TestNGPayRollapp {
	WebDriver driver;
  @Test
  public void PayRollapp() {
	  WebElement login = driver.findElement(By.xpath("//*[@id='loginform-username']"));
		login.sendKeys("carol");
		WebElement password = driver.findElement(By.xpath("//*[@id='loginform-password']"));
		password.sendKeys("1q2w3e4r");
		WebElement rememberCheckbox = driver.findElement(By.xpath("//*[@id='loginform-rememberme']"));
		rememberCheckbox.isSelected();
		System.out.println("rememberCheckbox");
		WebElement submit = driver.findElement(By.cssSelector("Button.btn.btn-default"));
		submit.click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		  WebElement client = driver.findElement(By.xpath("//a[text()='Clients']"));
		  client.click();
		  WebElement searchClientName = driver.findElement(By.xpath("//*[@id='clientsearch-client_name']"));
		  searchClientName.sendKeys("diya");
		  System.out.println(searchClientName.isDisplayed());
		  WebElement SearchButtonClientName = driver.findElement(By.xpath("//*[@class='btn btn-primary']"));
		  SearchButtonClientName.click();
		  //WebDriverWait wait2 = new WebDriverWait(driver, 10);
		  WebElement carol = driver.findElement(By.xpath("//a[@class='dropdown-toggle']"));
		 // wait2.until(ExpectedConditions.elementToBeClickable(carol));
		  carol.click();
		  WebDriverWait wait = new WebDriverWait(driver, 10);
		  WebElement logout = driver.findElement(By.xpath("//*[text()='Logout']"));
		  wait.until(ExpectedConditions.elementToBeClickable(logout));
		  logout.click();
  }
  @BeforeMethod
  public void beforeMethod() {
	  driver.get("https://qabible.in/payrollapp/site/login");
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
