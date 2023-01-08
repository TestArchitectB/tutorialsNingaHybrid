package com.tutorialNinja.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialNinja.util.Utilities;
import com.tutorialsNinja.Base.BaseClass;
import com.tutorialsNinja.pageObjects.IndexPage;
import com.tutorialsNinja.pageObjects.RegisterPage;

public class RegisterTest extends BaseClass {
	
	public WebDriver driver=null;
	IndexPage indexPage;
	RegisterPage registerPage;
	
	public RegisterTest() {
		
	}
	@BeforeMethod
	public void setup() {
		driver=launchAppliation(prop.getProperty("browserName"));
		indexPage=new IndexPage(driver);
		registerPage=new RegisterPage(driver);
		indexPage.clickMyAccountDropDown();
	}
	
	@Test
	public void registration() {
		indexPage.clickRegisterLink();
		registerPage.enterFirstName(Utilities.getRandomString());
		registerPage.enterLastName(Utilities.getRandomString());
		registerPage.enterEmail(Utilities.getEmailWithTimeStamp());
		registerPage.enterTelephoneNumber(Integer.toString(Utilities.getRandomNumber()));
		registerPage.enterPassword(prop.getProperty("password"));
		registerPage.enterConfirmPassword(prop.getProperty("password"));
		registerPage.clickCheckBox();
		registerPage.clickContinueBtn();
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id=\"content\"]/h1")).isDisplayed());
		driver.findElement(By.linkText("Edit Account")).click();
		String emailId=driver.findElement(By.name("email")).getText();
		System.out.println(emailId);
	}

//	@AfterTest
//	public void tearDown() {
//		driver.quit();
//	}
	
	
}
