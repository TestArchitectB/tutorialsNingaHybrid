package com.tutorialsNinja.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(name="email")
	private WebElement userName;
	
	@FindBy(name="password")
	private WebElement passWord;
	
	@FindBy(xpath="//input[@type=\"submit\"]")
	private WebElement loginBtn;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	public void enterUserName(String uname ) {
		userName.sendKeys(uname);
	}
	
	public void enterPassword(String pwd) {
		passWord.sendKeys(pwd);
	}
	
	public void clickLoingBtn() {
		loginBtn.click();
	}
	

}
