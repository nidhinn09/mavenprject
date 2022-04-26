package mainTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNGBasic {
	WebDriver driver;
	
	@BeforeClass
	public void BeforeMethod() {
		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver_win32 (1)\\chromedriver.exe");
	    driver = new ChromeDriver();
		driver.get("https://selenium.obsqurazone.com/javascript-alert.php");
		
		driver.manage().window().maximize();
	}
	@Test(priority= 0)
	public void getTheCurrentURL() {
		System.out.println(driver.getCurrentUrl());
	}
	@Test(priority = 1)
	public void getTheTitle() {
		System.out.println(driver.getTitle());
	}
	@Test(priority = 2)
	public void getTheClass() {
		System.out.println(driver.getClass());
	}
	@AfterClass
	public void afterMethod() {
		driver.quit();
	}
	

}
