package com.freecrm.testcases;

import static org.testng.Assert.assertEquals;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageTest {
WebDriver driver;
SoftAssert asser;
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SMART\\Downloads\\chromedriver_win32\\chromedriver.exe");
	     driver = new ChromeDriver();
	     asser= new SoftAssert();
	     driver.get("https://classic.freecrm.com/index.html?e=1");
	     driver.manage().window().maximize();
	     driver.findElement(By.name("username")).sendKeys("hat2003");
	     driver.findElement(By.name("password")).sendKeys("Test@123");
	     driver.findElement(By.xpath("//input[@value='Login']")).click();
	
	}
	@AfterMethod
	public void close() {
		driver.quit();
	}
	@Test(priority = 1)
	public void urlCheck() {
		String expectedResults ="https://classic.freecrm.com/index.cfm?CFID=2102726&CFTOKEN=823b7dcc29de5e26-87F7B7DD-BF3F-6DE4-EBD85681188A5C8C&jsessionid=a630b2c92f5d9626563e1110d23674de3b31";
		String actualResult =driver.getCurrentUrl();
		asser.assertEquals(actualResult,expectedResults);
		asser.assertAll();
	}
	@Test(priority = 2)
	public void titleTest() {
		
		String expectedResults ="CRMPRO";
		String actualResult =driver.getTitle();
		System.out.println(actualResult);
		asser.assertEquals(actualResult, expectedResults);
	    asser.assertAll();
	}
	
	
	
	
}
