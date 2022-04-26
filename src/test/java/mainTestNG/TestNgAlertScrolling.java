package mainTestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class TestNgAlertScrolling {
	WebDriver driver;
  @Test
  public void alertScrolling() {
	  WebElement clickme=
			  driver.findElement(By.cssSelector("button.btn.btn-success"));
			  clickme.click(); driver.switchTo().alert().accept();
			 
			JavascriptExecutor js= (JavascriptExecutor)driver;
			WebElement clickme1= driver.findElement(By.cssSelector("button.btn.btn-warning"));
			js.executeScript("arguments[0].scrollIntoView();", clickme1);
			clickme1.click();
			driver.switchTo().alert().accept();
			WebDriverWait wait = new WebDriverWait(driver,3000);
			
			WebElement clickPromptBox= wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[text()='Click for Prompt Box']")))); //driver.findElement(By.xpath("//*[text()='Click for Prompt Box']"));
			js.executeScript("arguments[0].scrollIntoView();", clickPromptBox);
			clickPromptBox.click();
			
			driver.switchTo().alert().sendKeys("nidhinn");
			driver.switchTo().alert().accept();
			WebElement message = driver.findElement(By.xpath("//*[@id='prompt-demo']"));
			System.out.println(message.getText());
  }
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://selenium.obsqurazone.com/javascript-alert.php");
		driver.manage().window().maximize();
	  
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
