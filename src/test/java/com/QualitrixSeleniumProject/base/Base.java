package com.QualitrixSeleniumProject.base;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;



import com.QualitixSeleniumProject.util.Utilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Base {
	
	WebDriver driver;
	public Properties prop,prop1;
	public static ExtentReports extentreports;
	public static ExtentTest extentTest;
	
	public Base()
	{
		prop=new Properties();
		prop1=new Properties();
		File propFile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\QualitrixSeleniumProject\\qa\\Config\\Config.properties");
		File propFile1=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\QualitrixSeleniumProject\\qa\\testdata\\Testdata.properties");
		try {
		FileInputStream fis=new FileInputStream(propFile);
		prop.load(fis);
		
		FileInputStream fin=new FileInputStream(propFile1);
		prop1.load(fin);
		}
		
		catch(Throwable e)
		{
			e.printStackTrace();
		}
	}
	
	public WebDriver launchBrowser(String browserName)
	{
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
		driver=new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_LOAD_WAIT_TIME));
		
		driver.get(prop.getProperty("url"));
		
		return driver;
		
	}
	
	
	@BeforeTest
	public void getnameMethod(ITestContext context) {

		extentTest = extentreports.createTest(context.getName());
	}

	@BeforeSuite
	public void InitExentReport() {

		ExtentSparkReporter sr = new ExtentSparkReporter("ReportsFinal.html");
		extentreports = new ExtentReports();
		extentreports.attachReporter(sr);
		
		extentreports.setSystemInfo("Operating Sytsem : ", System.getProperty("os.name"));
		extentreports.setSystemInfo("JAVA Version : ", System.getProperty("java.version"));

	}

	// To Generate the extent report
	@AfterSuite
	public void generateReports() throws IOException {

		extentreports.flush();
		Desktop.getDesktop().browse(new File("ReportsFinal.html").toURI());
	}

	@AfterMethod
	public void generateStatus(Method m, ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {

			System.out.println("Caputre the screenshot on failure");
			extentTest.fail(result.getThrowable());

		} else if (result.getStatus() == ITestResult.SUCCESS) {

			extentTest.pass(m.getName() + "  is passed");
		}

	}

}
