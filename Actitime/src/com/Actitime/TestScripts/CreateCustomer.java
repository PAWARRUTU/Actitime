package com.Actitime.TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Actitime.GenericLibrary.Baseclass;
import com.Actitime.GenericLibrary.FileLibrary;
import com.Actitime.GenericLibrary.ListnerImplementation;
import com.Actitime.pom.HomePage;
import com.Actitime.pom.TaskPage;

@Listeners(ListnerImplementation.class)
public class CreateCustomer extends Baseclass {
  
	@Test
	public void createCustomer() throws EncryptedDocumentException, IOException {
		HomePage hp=new HomePage(driver);//create object the element from homepage
		hp.getTasktab().click();
		
		TaskPage tp=new TaskPage(driver);//create object the element from taskpage
		tp.getAddnewcust().click();
		tp.getNewcust().click();
		
		FileLibrary f=new FileLibrary();//to use data of excel from fileliabrary
	    String name = f.readdatafromExcel("Sheet1", 1, 1);
		tp.getCustname().sendKeys(name);
		String desp = f.readdatafromExcel("Sheet1", 1, 2);
		tp.getCustdesp()
		..sendKeys(desp);
		tp.getCreatecust().click();
		
		// to verify the customer is created use assertion
		String expectedresult=name;
	    String actualresult = driver.findElement(By.xpath("(//div[.='"+name+"'])[2]")).getText();//Concatenation to use changeable customer name 
	                                  //(//div[.='Big Bang Company'])[2]
	    SoftAssert s=new SoftAssert();
	    s.assertEquals(expectedresult, actualresult);
	    s.assertAll();
	}
	
	

}
