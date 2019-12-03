package com.udemy.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewToursRegistrationPage {	
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(name = "firstName")
	private WebElement firstNameTxt;
	@FindBy(name = "lastName")
	private WebElement lastNameTxt;
	@FindBy(name = "email")
	private WebElement userNameTxt;	
	@FindBy(name = "password")
	private WebElement passwordTxt;
	@FindBy(name = "confirmPassword")
	private WebElement confirmPasswordTxt;
	@FindBy(name = "register")
	private WebElement submitBtn;
	
	public NewToursRegistrationPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}
	
	public void goTo() {
		driver.get("http://newtours.demoaut.com/mercuryregister.php");
		this.wait.until(ExpectedConditions.visibilityOf(this.firstNameTxt));
	}
	
	public void enterUserDetails(String firstName, String lastName) {
		this.firstNameTxt.sendKeys(firstName);
		this.lastNameTxt.sendKeys(lastName);
	}
	
	public void enterUserCredentials(String usernName, String password) {
		this.userNameTxt.sendKeys(usernName);
		this.passwordTxt.sendKeys(password);
		this.confirmPasswordTxt.sendKeys(password);
	}
	
	public void submitRegistrationPage() {
		this.submitBtn.click();
	}

}
