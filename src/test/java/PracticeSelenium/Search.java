package PracticeSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.QualitrixSeleniumProject.base.Base;

public class Search extends Base {
	
	WebDriver driver;
	
	@BeforeMethod
	public void verifyLogin() {
		
		driver=launchBrowser(prop.getProperty("browserName"));
		
//		driver.findElement(By.xpath("//span[text()='My Account']")).click();
//		  driver.findElement(By.linkText("Login")).click();
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}

	
	@Test
	  public void verifysearchWithValidValue() {
		  
		  driver.findElement(By.name("search")).sendKeys("Hp");
		  driver.findElement(By.className("input-group-btn")).click();
		  String actualText=driver.findElement(By.linkText("HP LP3065")).getText();
		  
		  Assert.assertTrue(true, actualText);
	  }
	  
	  @Test
	  public void verifySearchWithInvalidValue() {
		  driver.findElement(By.name("search")).sendKeys("Car");
		  driver.findElement(By.className("input-group-btn")).click();
		  String actualText=driver.findElement(By.xpath("//p[contains(text(),\"There is no product that matches the search criteria.\")]")).getText();
		  
		  Assert.assertEquals(actualText, "There is no product that matches the search criteria.");
		  
	  }

}
