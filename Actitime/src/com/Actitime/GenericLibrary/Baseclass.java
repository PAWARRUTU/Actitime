package com.Actitime.GenericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.Actitime.pom.LoginPage;

public class Baseclass {
	FileLibrary f=new FileLibrary();
public static WebDriver driver;	
	
@BeforeSuite
public void databaseConnect() {
	Reporter.log("database connected",true);
	
}

@BeforeClass
public void LaunchBrowser() throws IOException {
	 driver=new ChromeDriver();//driver variable globally created above
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	//driver.get("https://demo.actitime.com/login.do");
	//instead of above code use generic library
	//FileLibrary f=new FileLibrary(); create global variable
	String link = f.readDataFromProperty("url");
	driver.get(link);
	Reporter.log("Browser launched successfully",true);
	
}

@BeforeMethod
public void LoginToActitime() throws IOException {
	LoginPage lp=new LoginPage(driver);//use from pom class
	String un = f.readDataFromProperty("username");// use variable to store from generic library
	lp.getUntbx().sendKeys(un);   //instead of code driver.findElement(By.id("username")).sendKeys("admin");
	String pd = f.readDataFromProperty("password");
	lp.getPdtbx().sendKeys(pd);//instead of code driver.findElement(By.name("pwd")).sendKeys("manager");
	lp.getLgbtn().click();            //instead of hardcore driver.findElement(By.xpath("//div[.='Login ']")).click();
	Reporter.log("logged in successfully",true);
}

@AfterMethod
public void logoutfromActitime() {
	driver.findElement(By.id("logoutLink")).click();
	Reporter.log("logged out successfully",true);
}

@AfterClass
public void CloseBrowser() {
	driver.close();
	Reporter.log("Browser closed successfully",true);
}

@AfterSuite
public void databasedisConnect() {
	Reporter.log("database disconnected",true);
}
}
