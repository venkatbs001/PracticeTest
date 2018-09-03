package com.sample.practiceTest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	@FindBy(xpath = "//*[@href='http://store.demoqa.com/products-page/your-account/']")
	WebElement myAccountLink;
	
	@FindBy(id = "log")
	WebElement usernameField;
	
	@FindBy(id = "pwd")
	WebElement passwordField;
	
	@FindBy(id = "login")
	WebElement loginButton;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	public void clickAccountLink() {
		myAccountLink.click();
	}
	
	public void enterUserName(String username) {
		usernameField.click();
		usernameField.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		passwordField.click();
		passwordField.sendKeys(password);
	}
	

	public void clickLogin() {
		loginButton.click();
	}
}
