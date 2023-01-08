package com.tutorialsNinja.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class RegisterPage {
	
	WebDriver driver;
	
	@FindBy(linkText="Register")
	private WebElement registerLink;
	
	@FindBy(name="firstname")
	private WebElement firstName;
	
	@FindBy(name="lastname")
	private WebElement lastName;
	
	@FindBy(name="email")
	private WebElement emailId;
	
	@FindBy(name="telephone")	
	private WebElement telephoneId;
	
	@FindBy(name="password")	
	private WebElement passwordId;
	
	@FindBy(name="confirm")
	private WebElement confirmId;
	
	@FindBy(name="agree")
	private WebElement agreeCheckBox;
	
	@FindBy(xpath="//input[@value=\"Continue\"]")
	private WebElement continueBtn;
	
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	
	public void enterFirstName(String fname) {
		firstName.sendKeys(fname);
	}
	
	
	public void enterLastName(String lname) {
		lastName.sendKeys(lname);
	}
	
	public void enterEmail(String email) {
		emailId.sendKeys(email);
	}
	
	public void enterTelephoneNumber(String phoneNumber) {
		telephoneId.sendKeys(phoneNumber);
	}
	
	public void enterPassword(String pwd) {
		passwordId.sendKeys(pwd);
	}
	
	public void enterConfirmPassword(String cPwd) {
		confirmId.sendKeys(cPwd);
	}
	
	public void clickCheckBox() {
		agreeCheckBox.click();
	}
	
	public void clickContinueBtn() {
		continueBtn.click();
	}
	
	
}
