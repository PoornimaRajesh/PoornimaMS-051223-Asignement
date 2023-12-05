package com.QualitrixSeleniumProject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	
	//Objects
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement MyAccount;
	
	@FindBy(linkText="Login")
	private WebElement Login;

	@FindBy(linkText="Register")
	private WebElement Register;

	
	public HomePage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public void clickOnMyAccount() {
		MyAccount.click();
	}
	
	public void selectLogin() {
		Login.click();
	}
	
	public void selectRegister() {
		Register.click();
	}
	
	
	
}
