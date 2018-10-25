package com.qa;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class FrontEndTest_Selenium 
{
	public WebDriver driver = null;
	ExtentReports extent = new ExtentReports("C:\\Users\\Admin\\Documents\\Testing Assessment\\PetAssessmentFrontEnd.html",true);
	ExtentTest test;
	Constants con = new Constants();
	POM_For_Pet POM = PageFactory.initElements(driver, POM_For_Pet.class); 
	
	@Before
	public void setup() 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	@After
	public void teardown()
	{
		driver.quit();
	}
	
	@Test
	public void CreateUser()
	{
		test = extent.startTest("Verify application can post data ");
		
		test.log(LogStatus.INFO, "Loading Application in browser");
		driver.get("http://10.0.10.10:4200/petclinic/owners/add");
		test.log(LogStatus.INFO, "Adding Information to text boxes");
		POM.firstName(driver);
		POM.lastName(driver);
		POM.address(driver);
		POM.city(driver);
		POM.telephone(driver);
		
		test.log(LogStatus.INFO, "Submitting added Information");
		POM.submit(driver);
		try 
		{
			driver.findElement(By.linkText("test_front_end test_front_end"));
			test.log(LogStatus.PASS, "User Added Successfully");  
		}
		catch(NoSuchElementException e) 
		{
			test.log(LogStatus.FAIL, "User Not Added Successfully");  
		}
		extent.endTest(test);
		extent.flush();		
	}
	@Test
	public void SeeAllUsers()
	{
		driver.get("http://10.0.10.10:4200/petclinic/welcome");
		POM.ownersButton(driver);
		POM.seeAllButton(driver);
		
		assertEquals(driver.getCurrentUrl(),"http://10.0.10.10:4200/petclinic/owners");
	}
}
