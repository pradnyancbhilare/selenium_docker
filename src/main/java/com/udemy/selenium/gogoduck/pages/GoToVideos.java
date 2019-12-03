package com.udemy.selenium.gogoduck.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoToVideos {

	//private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(linkText = "Videos")
	private WebElement videosLink;
	@FindBy (className = "tile--vid")
	private List<WebElement> allVideos;
	
	public GoToVideos(WebDriver driver) {
		//this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}
	
	public void goToVideos() {
		this.wait.until(ExpectedConditions.visibilityOf(this.videosLink));	
		this.videosLink.click();
	}
	
	public int printResult() {
		this.wait.until(ExpectedConditions.visibilityOfAllElements(this.allVideos));
		System.out.println("Number of Videos: " + this.allVideos.size());
		return this.allVideos.size();
	}
	
}
