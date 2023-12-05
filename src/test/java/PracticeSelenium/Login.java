package PracticeSelenium;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.QualitixSeleniumProject.util.Utilities;
import com.QualitrixSeleniumProject.base.Base;
import com.QualitrixSeleniumProject.pages.HomePage;
import com.QualitrixSeleniumProject.pages.LoginPage;

public class Login extends Base {
	
	public Login()
	{
		super();
	}
	
	WebDriver driver;
	
	@BeforeMethod
	public void verifyLogin() {
		
		driver=launchBrowser(prop.getProperty("browserName"));
		
		HomePage homePage= new HomePage(driver);
		homePage.clickOnMyAccount();
		homePage.selectLogin();
		
		
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}

	
	  @Test(priority=2) 
	  public void verifyWithValidCredentials() {
	  
		  LoginPage loginPage=new LoginPage(driver);
		  Registration r=new Registration();
		  //loginPage.enterEmail(Utilities.getTestdataFromExcel("Credentials"));
		  loginPage.enterEmail(prop1.getProperty("email"));
		  loginPage.enterPassword(prop1.getProperty("password"));
	  	  loginPage.clickOnLogin();  
	  	  Assert.assertTrue(loginPage.myAccountAssert());
	  
	 	  }
	  
	  @Test(priority=1) 
	  public void verifyWithInvalidCredentials() {
		  
		  LoginPage loginPage=new LoginPage(driver);
		  loginPage.enterEmail(Utilities.generateEmailTimeStamp());
		  loginPage.enterPassword(prop1.getProperty("password"));
		  loginPage.clickOnLogin();
		  
		  String ActualString=loginPage.actualStringCompare();
		  String ExpectedString=prop.getProperty("WarningMessage");
		  Assert.assertTrue(ActualString.contains(ExpectedString));
		  
	  }
	 	  
	 	
	  @Test(priority=3)
	  public void assertAfterLogin() {
		  
		  LoginPage loginPage=new LoginPage(driver);
		  
		  loginPage.enterEmail(prop1.getProperty("email"));
		  loginPage.enterPassword(prop1.getProperty("password"));
	  	  loginPage.clickOnLogin(); 
		  
		  String as=loginPage.myAccountText();
		  String es=prop.getProperty("MyAccountText");
		  Assert.assertTrue(as.contains(es));
		  
		  String as1=loginPage.myAccountLink1();
		  String es1=prop.getProperty("MyAccountLink1");
		  Assert.assertTrue(as1.contains(es1));
		  
		  String as2=loginPage.myAccountLink2();
		  String es2=prop.getProperty("MyAccountLink2");
		  Assert.assertTrue(as2.contains(es2));
		  
		  String as3=loginPage.myAccountLink3();
		  String es3=prop.getProperty("MyAccountLink3");
		  Assert.assertTrue(as3.contains(es3));
		  
		  String as4=loginPage.myAccountLink4();
		  String es4=prop.getProperty("MyAccountLink4");
		  Assert.assertTrue(as4.contains(es4));
		  
		  String as5=loginPage.myOrdText();
		  String es5=prop.getProperty("MyOrders");
		  Assert.assertTrue(as5.contains(es5));
		  
		  String as6=loginPage.myOrdLink1();
		  String es6=prop.getProperty("MyOrdersLink1");
		  Assert.assertTrue(as6.contains(es6));
		  
		  String as7=loginPage.myOrdLink2();
		  String es7=prop.getProperty("MyOrdersLink2");
		  Assert.assertTrue(as7.contains(es7));
		  
		  String as8=loginPage.myOrdLink3();
		  String es8=prop.getProperty("MyOrdersLink3");
		  Assert.assertTrue(as8.contains(es8));
		  
		  String as9=loginPage.myOrdLink4();
		  String es9=prop.getProperty("MyOrdersLink4");
		  Assert.assertTrue(as9.contains(es9));
		  
		  String as10=loginPage.myOrdLink5();
		  String es10=prop.getProperty("MyOrdersLink5");
		  Assert.assertTrue(as10.contains(es10));
		  
		  String as11=loginPage.myOrdLink6();
		  String es11=prop.getProperty("MyOrdersLink6");
		  Assert.assertTrue(as11.contains(es11));
		  
		  String as12=loginPage.myAffiAccText();
		  String es12=prop.getProperty("MyAffiliateAccountText");
		  Assert.assertTrue(as12.contains(es12));
		  
		  String as13=loginPage.myAffiAccLink1();
		  String es13=prop.getProperty("MyAffiliateAccountLink");
		  Assert.assertTrue(as13.contains(es13));
		  
		  String as14=loginPage.newsLetterText();
		  String es14=prop.getProperty("NewsLetterText");
		  Assert.assertTrue(as14.contains(es14));
		  
		  String as15=loginPage.newsLetterLink1();
		  String es15=prop.getProperty("NewsletterLink");
		  Assert.assertTrue(as15.contains(es15));
	  }
}
