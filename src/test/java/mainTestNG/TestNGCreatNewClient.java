package mainTestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class TestNGCreatNewClient {
	WebDriver driver;
  @Test
  public void creatNewClient() throws InterruptedException {
	  WebElement login = driver.findElement(By.xpath("//*[@id='loginform-username']"));
		login.sendKeys("carol");
		WebElement password = driver.findElement(By.xpath("//*[@id='loginform-password']"));
		password.sendKeys("1q2w3e4r");
		WebElement rememberCheckbox = driver.findElement(By.xpath("//*[@id='loginform-rememberme']"));
		System.out.println(rememberCheckbox.isSelected());
		WebElement submit = driver.findElement(By.cssSelector("Button.btn.btn-default"));
		submit.click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		  WebElement client = driver.findElement(By.xpath("//a[text()='Clients']"));
		  client.click();
		  WebElement createClient = driver.findElement(By.xpath("//*[text()='Create Client']"));
		  createClient.click();
		  WebElement branchField = driver.findElement(By.xpath("//*[@id='client-branch_id']"));
			branchField.click();
			Select select = new Select(branchField);
			select.selectByValue("1");
			  WebElement invoiceOrder = driver.findElement(By.xpath("//*[@id='client-invoice_order']"));
				invoiceOrder.click();
				Select select1 = new Select(invoiceOrder);
				select1.selectByValue("Single timesheet per client");
				 WebElement division= driver.findElement(By.xpath("//*[@id='client-division_id']"));
					division.click();
					Select select2 = new Select(division);
					select2.selectByValue("1");
					WebElement invoicContact= driver.findElement(By.xpath("//*[@id='client-invoice_contact']"));
					invoicContact.sendKeys("4558");
					WebElement invoiceDeliveryMethod= driver.findElement(By.xpath("//*[@id='client-invoice_delivery_method']"));
					invoiceDeliveryMethod.click();
					Select select3 = new Select(invoiceDeliveryMethod);
					select3.selectByValue("Electronic");
					WebElement name= driver.findElement(By.xpath("//*[@id='client-client_name']"));
					name.sendKeys("johnson");
					WebElement phoneNo= driver.findElement(By.xpath("//*[@id='client-phone']"));
					phoneNo.sendKeys("8987456");
					WebElement masterDocument= driver.findElement(By.xpath("//*[@id='client-master_document']"));
					masterDocument.click();
					Select select4 = new Select(masterDocument);
					select4.selectByValue("Print");
					WebElement address= driver.findElement(By.xpath("//*[@id='client-client_address']"));
					address.sendKeys("jpm tn");
					WebElement settlement= driver.findElement(By.xpath("//*[@id='client-settilement_days']"));
					settlement.sendKeys("88");
					WebElement email= driver.findElement(By.xpath("//*[@id='client-email']"));
					email.sendKeys("nn@gm.cm");
					WebElement vatRate= driver.findElement(By.xpath("//*[@id='client-vat_rate']"));
					vatRate.click();
					Select select5 = new Select(vatRate);
					select5.selectByValue("VAT 5.00%");
					WebElement postCode= driver.findElement(By.xpath("//*[@id='client-postcode']"));
					postCode.sendKeys("hjs");
					WebElement companyReg= driver.findElement(By.xpath("//*[@id='client-company_reg']"));
					companyReg.sendKeys("cdjs");
					
					  JavascriptExecutor js= (JavascriptExecutor)driver;
					  js.executeScript("window.scrollBy(0,1000)");
					 
					WebDriverWait wait = new WebDriverWait(driver, 20);
					WebElement save= driver.findElement(By.xpath("//*[text()='Save']"));
					wait.until(ExpectedConditions.elementToBeClickable(save));
					save.click();
					
					WebDriverWait wait1 = new WebDriverWait(driver, 10);
					  WebElement carol = driver.findElement(By.xpath("//a[@class='dropdown-toggle']"));
					  wait1.until(ExpectedConditions.elementToBeClickable(carol));
					  carol.click();
					  Thread.sleep(3000);
					  //WebDriverWait wait2 = new WebDriverWait(driver, 10);
					  WebElement logout = driver.findElement(By.xpath("//a[text()='Logout']"));
					  //wait2.until(ExpectedConditions.elementToBeClickable(logout));
					  logout.click();
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://qabible.in/payrollapp/site/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
