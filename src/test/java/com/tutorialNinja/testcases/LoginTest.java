package com.tutorialNinja.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialNinja.util.Utilities;
import com.tutorialsNinja.Base.BaseClass;
import com.tutorialsNinja.pageObjects.IndexPage;
import com.tutorialsNinja.pageObjects.LoginPage;

public class LoginTest extends BaseClass{
	public WebDriver driver=null;
	IndexPage indexPage;
	LoginPage loginPage;
	
	@BeforeMethod
	public void setup() {
		driver=launchAppliation(prop.getProperty("browserName"));
		indexPage=new IndexPage(driver);
		indexPage.clickMyAccountDropDown();
		indexPage.clickLoginLink();
		loginPage=new LoginPage(driver);
	
	}
	
	@Test(dataProvider="loginTestData")
	public void login_with_validCredentials(String email,String password) {
		
		loginPage.enterUserName(email);
		loginPage.enterPassword(password);
		loginPage.clickLoingBtn();
		Assert.assertTrue(driver.findElement(By.linkText("Account")).isDisplayed());
		
	}
	
	@Test
	public void loginwithInvalidCredentials() {
		indexPage.clickLoginLink();
		loginPage.enterUserName(prop.getProperty("username"));
		loginPage.enterPassword(dataProp.getProperty("invalidPassword"));
		loginPage.clickLoingBtn();
		Assert.assertTrue(driver.findElement(By.xpath("//div[text()=\" Warning: No match for E-Mail Address and/or Password.\"]")).isDisplayed());
	}
	
	@DataProvider
	public Object[][] loginTestData() {
		Object[][] data= Utilities.getExcelData("login");
		return data;
	}
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
}
