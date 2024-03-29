package com.Actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	//declaration
	@FindBy(xpath="//div[.='Tasks']")
	private WebElement tasktab;
	
	@FindBy(xpath="//div[.='Reports']")
	private WebElement Reporttab;
	
	@FindBy(xpath="//div[.='Users']")
	private WebElement usertab;
	
	//Initialization
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//utilization
	
	public WebElement getTasktab() {
		return tasktab;
	}

	public WebElement getReporttab() {
		return Reporttab;
	}

	public WebElement getUsertab() {
		return usertab;
	}
	
	//utilization
	
	
}
