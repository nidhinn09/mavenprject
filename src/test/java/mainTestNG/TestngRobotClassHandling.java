package mainTestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class TestngRobotClassHandling {
	WebDriver driver;
  @Test
  public void f() throws AWTException, InterruptedException {
	  WebElement browser= driver.findElement(By.xpath("//*[text()='Browse']"));
		browser.click();
		Robot rb = new Robot();
		StringSelection filePath = new StringSelection("D:\\Obsqura\\Selenium\\NOTE OF DROPDOWN.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);
		// press Contol+V for pasting
				rb.keyPress(KeyEvent.VK_CONTROL);
				Thread.sleep(4000);
				rb.keyPress(KeyEvent.VK_V);

				// release Contol+V for pasting
				rb.keyRelease(KeyEvent.VK_CONTROL);
				Thread.sleep(4000);
				rb.keyRelease(KeyEvent.VK_V);

				// for pressing and releasing Enter
				rb.keyPress(KeyEvent.VK_ENTER);
				Thread.sleep(4000);
				rb.keyRelease(KeyEvent.VK_ENTER);

		System.out.println("file uploaded..");
  }
  @BeforeMethod
  public void beforeMethod() {
	    driver.get("https://resume.naukri.com/resume-quality-score ");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
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
