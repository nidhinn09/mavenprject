package mainTestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Newwindow {
	WebDriver driver;
  @Test
  public void f() {
		String newWindow = driver.getWindowHandle();
		System.out.println("Parent window Handle :"+ newWindow);
		WebElement newwindowopen = driver.findElement(By.id("newWindowBtn"));
		newwindowopen.click();
		Set<String> allWindows = driver.getWindowHandles();
		System.out.println(allWindows);
		Iterator<String> iterator= allWindows.iterator();
		while (iterator.hasNext()) {
			String childWindow = iterator.next();
			if (!newWindow.equalsIgnoreCase(childWindow)) {
				driver.switchTo().window(childWindow);
				WebElement firstName= driver.findElement(By.id("firstName"));
				firstName.sendKeys("nnn");
				
			}
			
		}
  }
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
