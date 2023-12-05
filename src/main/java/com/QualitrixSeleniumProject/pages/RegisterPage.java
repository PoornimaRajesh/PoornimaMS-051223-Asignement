package com.QualitrixSeleniumProject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	WebDriver driver;
	
	//Objects
	@FindBy(id="input-firstname")
	private WebElement FirstName;
	
	@FindBy(id="input-lastname")
	private WebElement LastName;
	
	@FindBy(id="input-email")
	private WebElement Email;
	
	@FindBy(id="input-telephone")
	private WebElement Telephone;
	
	@FindBy(name="password")
	private WebElement Password;
	
	@FindBy(name="confirm")
	private WebElement ConfirmPWD;
	
	@FindBy(name="agree")
	private WebElement ClkAgree;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement BtnContinue;
	
	@FindBy(xpath="//input[@id='input-firstname']//following-sibling::div")
	private WebElement ErrorFN;
	
	@FindBy(xpath="//input[@id='input-lastname']//following-sibling::div")
	private WebElement ErrorLN;
	
	@FindBy(xpath="//input[@id='input-email']//following-sibling::div")
	private WebElement ErrorEmail;
	
	@FindBy(xpath="//input[@id='input-telephone']//following-sibling::div")
	private WebElement ErrorTelephone;
	
	@FindBy(xpath="//input[@id='input-password']//following-sibling::div")
	private WebElement ErrorPassword;
	
	@FindBy(xpath="//div//h1[text()=\"Your Account Has Been Created!\"]")
	private WebElement AssertAccount;
	
	public RegisterPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public void firstName(String FN)	{
		FirstName.sendKeys(FN);
	}
	
	public void lastName(String LN)	{
		LastName.sendKeys(LN);
	}
	
	public void enterEmail(String enterEmail)	{
		 Email.sendKeys(enterEmail);
	}
	
	public void enterTelephone(String enterTP)	{
		Telephone.sendKeys(enterTP);
	}
	
	public void enterPassword(String enterPWD)	{
		Password.sendKeys(enterPWD);
	}
	
	public void confirmPWD(String confirmPWD)	{
		ConfirmPWD.sendKeys(confirmPWD);
	}
	
	public void clkAgree()	{
		ClkAgree.click();
	}
	
	public void btnContinue()	{
		BtnContinue.click();
	}
	
	public String assertAccount() {
		  return AssertAccount.getText();
	  }
	
	public String errorFN() {
		return ErrorFN.getText();
	}
	
	public String errorLN() {
		return ErrorLN.getText();
	}
	
	public String errorEmail() {
		return ErrorEmail.getText();
	}
	
	public String errorTelephone() {
		return ErrorTelephone.getText();
	}
	
	public String errorPassword() {
		return ErrorPassword.getText();
	}
}
