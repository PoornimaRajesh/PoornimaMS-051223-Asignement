package com.QualitrixSeleniumProject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




public class LoginPage {

 WebDriver driver;
	
	
	//Objects
	@FindBy(xpath="//input[@value='Login']")
	private WebElement Login;

	@FindBy(id="input-email")
	private WebElement Email;

	@FindBy(name="password")
	private WebElement Password;
	
	@FindBy(xpath="//div/h2[text()='My Account']")
	private WebElement AssertMyAccount;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement actualString;

	
	@FindBy(xpath="(//*[contains(text(),'My Account')])[4]")
	private WebElement MyAccText;
	
	@FindBy(linkText="Edit your account information")
	private WebElement MyAccLink1;
	
	@FindBy(linkText="Change your password")
	private WebElement MyAccLink2;
	
	@FindBy(linkText="Modify your address book entries")
	private WebElement MyAccLink3;
	
	@FindBy(linkText="Modify your wish list")
	private WebElement MyAccLink4;
	
	
	@FindBy(xpath="//*[contains(text(),'My Orders')]")
	private WebElement MyOrdText;
	
	@FindBy(linkText="View your order history")
	private WebElement MyOrdLink1;
	
	@FindBy(linkText="Downloads")
	private WebElement MyOrdLink2;
	
	@FindBy(linkText="Your Reward Points")
	private WebElement MyOrdLink3;
	
	@FindBy(linkText="View your return requests")
	private WebElement MyOrdLink4;
	
	@FindBy(linkText="Your Transactions")
	private WebElement MyOrdLink5;
	
	@FindBy(linkText="Recurring payments")
	private WebElement MyOrdLink6;
	
	@FindBy(xpath="//*[contains(text(),'My Affiliate Account')]")
	private WebElement MyAffiAccText;
	
	@FindBy(linkText="Register for an affiliate account")
	private WebElement MyAffiAccLink1;
	
	@FindBy(xpath="(//*[contains(text(),'Newsletter')])[1]")
	private WebElement NewsLetterText;
	
	@FindBy(linkText="Subscribe / unsubscribe to newsletter")
	private WebElement NewsLetterLink1;
	
	
	
	
	
	
public LoginPage(WebDriver driver) {
	
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

//Actions

  public void clickOnLogin() {
	  Login.click();
  }
 
  public void enterEmail(String enterEmail) {
	  Email.sendKeys(enterEmail);
  }

    
  public void enterPassword(String enterPassword) {
	  Password.sendKeys(enterPassword);
	   }
  
  public String actualStringCompare( ) {
	  return actualString.getText();
  }
  
  public boolean myAccountAssert() {
		boolean assertMyAccount = AssertMyAccount.isDisplayed();
		return assertMyAccount;
	}
	
  public String myAccountText( ) {
	  return MyAccText.getText();
  }

  
  public String myAccountLink1( ) {
	  return MyAccLink1.getText();
  }
  
  public String myAccountLink2( ) {
	  return MyAccLink2.getText();
  }
  
  public String myAccountLink3( ) {
	  return MyAccLink3.getText();
  }
  
  public String myAccountLink4( ) {
	  return MyAccLink4.getText();
  }
  
  public String myOrdText( ) {
	  return MyOrdText.getText();
  }
  
  public String myOrdLink1( ) {
	  return MyOrdLink1.getText();
  }
  
  public String myOrdLink2( ) {
	  return MyOrdLink2.getText();
  }
  
  public String myOrdLink3( ) {
	  return MyOrdLink3.getText();
  }
  
  public String myOrdLink4( ) {
	  return MyOrdLink4.getText();
  }
  
  public String myOrdLink5( ) {
	  return MyOrdLink5.getText();
  }
  
  public String myOrdLink6( ) {
	  return MyOrdLink6.getText();
  }
  
  public String myAffiAccText( ) {
	  return MyAffiAccText.getText();
  }
  
  public String myAffiAccLink1( ) {
	  return MyAffiAccLink1.getText();
  }
  
  public String newsLetterText( ) {
	  return NewsLetterText.getText();
  }
  
  public String newsLetterLink1( ) {
	  return NewsLetterLink1.getText();
  }
  
}

