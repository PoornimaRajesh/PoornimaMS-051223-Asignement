package PracticeSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.QualitixSeleniumProject.util.Utilities;
import com.QualitrixSeleniumProject.base.Base;
import com.QualitrixSeleniumProject.pages.HomePage;
import com.QualitrixSeleniumProject.pages.RegisterPage;

public class Registration extends Base{
	
	public Registration()
	{
		super();
	}
	
		
		WebDriver driver;
		
		@BeforeMethod
		public void openApplication()
		{
			driver=launchBrowser(prop.getProperty("browserName"));
			
			HomePage homePage= new HomePage(driver);
			homePage.clickOnMyAccount();
			homePage.selectRegister();
			
		}
		
		@AfterMethod
		public void closeBrowser()
		{
			driver.quit();
		}
		
		
		@Test(priority=2)
		public void verifyRegistration() { 
			 //Registration	  
			 		  
			  //driver.findElement(By.linkText("Continue")).click();
			
			RegisterPage registerPage=new RegisterPage(driver);
			
			registerPage.firstName(prop1.getProperty("firstname"));
			registerPage.lastName(prop1.getProperty("lastname"));
		    String one=Utilities.generateEmailTimeStamp();
			registerPage.enterEmail(one);
			
			registerPage.enterTelephone(prop1.getProperty("phone"));
			registerPage.enterPassword(prop1.getProperty("password"));
			registerPage.confirmPWD(prop1.getProperty("password"));
			registerPage.clkAgree();
			registerPage.btnContinue();
			
			  String ActualString=registerPage.assertAccount();
			  String ExpectedString=prop.getProperty("AccountSuccessMessage");
			  
			  Assert.assertEquals(ActualString, ExpectedString);
			  }
		
		
		@Test(priority=1)
		public void verifyErrorMessagesInRegistration() {
			
			RegisterPage registerPage=new RegisterPage(driver);
			
			registerPage.btnContinue();
			
			String errorFN=registerPage.errorFN();
			String actualFN=prop.getProperty("FNMessage");
			Assert.assertEquals(errorFN,actualFN );
			
			String errorLN=registerPage.errorLN();
			String actualLN=prop.getProperty("LNMessage");
			Assert.assertEquals(errorLN,actualLN);
			
			String errorEmail=registerPage.errorEmail();
			String actualEmail=prop.getProperty("EmailMessage");
			Assert.assertEquals(errorEmail, actualEmail);
			
			String errorTelephone=registerPage.errorTelephone();
			String actualTelephone=prop.getProperty("TelephoneMessage");
			Assert.assertEquals(errorTelephone,actualTelephone);
			
			String errorPassword=registerPage.errorPassword();
			String actualPassword=prop.getProperty("PasswordMessage");
			Assert.assertEquals(errorPassword,actualPassword);
			
			
		}
	}

