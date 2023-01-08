package com.tutorialsNinja.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//span[text()=\"My Account\"]")
	private WebElement myAccountdropdown;
	
	@FindBy(linkText="Login")
	private WebElement loginLink;
	
	@FindBy(linkText="Register")
	private WebElement registerLink;
	
	public IndexPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void clickMyAccountDropDown() {
		myAccountdropdown.click();
	}
	
	public void clickLoginLink() {
		loginLink.click();
	}
	
	public void clickRegisterLink() {
		registerLink.click();
	}
	

}
