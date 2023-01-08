package com.tutorialNinja.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsNinja.Base.BaseClass;

public class SearchProductTest extends BaseClass {
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		driver=launchAppliation(prop.getProperty("browserName"));
	}
	
	@Test()
	public void searchProduct() {
		driver.findElement(By.name("search")).sendKeys("iphone");
		driver.findElement(By.xpath("//span[@class=\"input-group-btn\"]")).click();
		Assert.assertFalse(driver.findElement(By.linkText("iPhone")).isDisplayed());
	}
	
	@Test(dependsOnMethods={"searchProduct"})
	public void searchforNonExistingProduct() {
		driver.findElement(By.name("search")).sendKeys("car");
		driver.findElement(By.xpath("//span[@class=\"input-group-btn\"]")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//p[text()=\"There is no product that matches the search criteria.\"]")).isDisplayed());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}

