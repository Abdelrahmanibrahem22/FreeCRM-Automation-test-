package com.freecrm.testcases;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class LoginPageTest {
	WebDriver driver;
	SoftAssert asser;

public void takeScreenShot(String name) throws IOException {
		
		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcfile, new File("C:\\Users\\SMART\\eclipse-workspace\\FreeCRMAApplication\\Snapshots\\"+name+".png"));
		
	}

	@Test(priority = 1)
public void titleTest(Method method) throws IOException {
	
	String expectedResults ="Free CRM - CRM software for customer relationship management, sales, and support.";
	String actualResult =driver.getTitle();
	System.out.println(actualResult);
	asser.assertEquals(actualResult, expectedResults);
    asser.assertAll();
   takeScreenShot(method.getName());
}
@Test(priority = 2)
	public void urlCheck(Method method) throws IOException {

		String expectedResults ="https://classic.freecrm.com/index.html?e=1";
		String actualResult =driver.getCurrentUrl();
		System.out.println(actualResult);
		asser.assertEquals(actualResult, expectedResults);
		asser.assertAll();
		takeScreenShot(method.getName());
	}
	@Test(priority = 3)
	public void logoCheck(Method method) throws IOException {
		
		WebElement logo =driver.findElement(By.xpath("//img[@src='https://classic.freecrm.com/img/logo.png']"));
		boolean expectedResults =true;
		boolean actualResult =logo.isDisplayed();
		System.out.println(actualResult);
		asser.assertEquals(actualResult, expectedResults);
		asser.assertAll();
		takeScreenShot(method.getName());
	}
	@Test(priority = 4)
	public void clickHomeCheck(Method method) throws IOException {
	
	driver.findElement(By.linkText("Home")).click();	
	String expectedResults="https://classic.freecrm.com/index.html";	
	String actualResult =driver.getCurrentUrl();	
	asser.assertEquals(actualResult, expectedResults);
	driver.findElement(By.xpath("//*[@id=\"carousel_intro\"]/button[2]")).click();
	asser.assertAll();	
	 takeScreenShot(method.getName());
	}
	@Test(priority = 5)
	public void clickSignUpCheck(Method method) throws IOException {
	
	driver.findElement(By.linkText("Sign Up")).click();	
	String expectedResults="https://classic.freecrm.com/register/";	
	String actualResult =driver.getCurrentUrl();	
	asser.assertEquals(actualResult, expectedResults);
	asser.assertAll();	
	takeScreenShot(method.getName());
	}
	@Test(priority = 6)
	public void clickPricingCheck(Method method) throws IOException {
	
	driver.findElement(By.linkText("Pricing")).click();	
	String expectedResults="https://classic.freecrm.com/pricing.html";	
	String actualResult =driver.getCurrentUrl();	
	asser.assertEquals(actualResult, expectedResults);
	asser.assertAll();	
	 takeScreenShot(method.getName());
	}
	@Test(priority = 7)
	public void clickFeaturesCheck(Method method) throws IOException {
	
	driver.findElement(By.linkText("Features")).click();	
	String expectedResults="https://classic.freecrm.com/features.html";	
	String actualResult =driver.getCurrentUrl();	
	asser.assertEquals(actualResult, expectedResults);
	asser.assertAll();	
	 takeScreenShot(method.getName());
	}
	@Test(priority = 8)
	public void clickCustomersCheck(Method method) throws IOException {
	
	driver.findElement(By.linkText("Customers")).click();	
	String expectedResults="https://classic.freecrm.com/customers.html";	
	String actualResult =driver.getCurrentUrl();	
	asser.assertEquals(actualResult, expectedResults);
	asser.assertAll();	
	takeScreenShot(method.getName());
	}
	@Test(priority = 9)
	public void clickContactCheck(Method method) throws IOException {
	
	driver.findElement(By.linkText("Contact")).click();	
	String expectedResults="https://classic.freecrm.com/contact.html";	
	String actualResult =driver.getCurrentUrl();	
	asser.assertEquals(actualResult, expectedResults);
	asser.assertAll();	
	takeScreenShot(method.getName());
	}
	
	//using Excel----------------------------------------------------
	@Test(dataProvider = "test_data")
	public void loginTest(String email,String password) throws InterruptedException, IOException {
		
				driver.findElement(By.name("username")).click();
				driver.findElement(By.name("username")).clear(); driver.findElement(By.name("username")).sendKeys(email);
				driver.findElement(By.name("password")).click();
				driver.findElement(By.name("password")).clear(); driver.findElement(By.name("password")).sendKeys(password);
				driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div/input")).click();
				takeScreenShot("loginTest");
	
		
		}
		
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SMART\\Downloads\\chromedriver_win32\\chromedriver.exe");
	     driver = new ChromeDriver();
	     driver.manage().window().maximize();
	     driver.get("https://classic.freecrm.com/index.html?e=1");
	     asser=new SoftAssert();
	}
	
	@AfterMethod
	public void quit() {
		driver.quit();
	}
	@DataProvider
	public String[][] test_data() throws InvalidFormatException, IOException{
		ReadExcel obj =new ReadExcel();
		return obj.read_sheet();
		
	}
}
