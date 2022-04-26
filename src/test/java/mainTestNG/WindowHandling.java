package mainTestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class WindowHandling {
	WebDriver driver;

	@BeforeClass
	public void beforeClass(){
		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
	}


	@BeforeMethod
	public void beforeMethod() {

		driver.get("https://demoqa.com/browser-windows");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	@Test
	public void windowHandling() throws InterruptedException {
		String parentWindow = driver.getWindowHandle();
		System.out.println("Parent window Handle :"+ parentWindow);
		WebElement newTab= driver.findElement(By.id("tabButton"));
		newTab.click();
		Set<String> allWindows = driver.getWindowHandles();
		System.out.println(allWindows);
		Iterator<String> iterator= allWindows.iterator();
		while (iterator.hasNext()) {
			String childwindow = iterator.next();
			if (!parentWindow.equalsIgnoreCase(childwindow)) {
				driver.switchTo().window(childwindow);
				WebElement textwindow = driver.findElement(By.id("sampleHeading"));
				System.out.println(textwindow.getText());
				Thread.sleep(2000);

			}

		}

	}


	@AfterMethod
	public void afterMethod() {
		driver.close();
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}


}
