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

public class TestNGRadioButton {
	WebDriver driver;
	@Test
	public void radioButton() {
		WebElement oneWayRadio = driver.findElement(By.xpath("(//input[@name='tripType'])[2]"));
		//oneWayRadio.isDisplayed();
		//System.out.println(oneWayRadio.isDisplayed());
		oneWayRadio.click();
		System.out.println(oneWayRadio.isSelected());

		WebElement 	agileProject = driver.findElement(By.xpath("//*[text()= 'Agile Project']"));
		System.out.println(agileProject.isDisplayed());
	}
	@BeforeMethod
	public void beforeMethod() {
		driver.get("https://demo.guru99.com/test/newtours/reservation.php");
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
