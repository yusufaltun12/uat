package com.ysfaltn.uat.merchant.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ysfaltn.uat.merchant.Config;

public class MyProfilePage extends Page
{
	public static final String PAGE_URL = Config.BASE_URL + "/profile";
	
	@FindBy(id = "name")
	private WebElement name;
	
	@FindBy(id = "surname")
	private WebElement surname;
	
	@FindBy(id = "gsmNumber")
	private WebElement gsmNumber;
	
	@FindBy(xpath = "//button[text()='Güncelle']")
	private WebElement updateButton;
	
	public MyProfilePage() 
	{
		super(PAGE_URL);
	}

	
	public WebElement getName() {
		return name;
	}


	public void setName(WebElement name) {
		this.name = name;
	}


	public WebElement getSurname() {
		return surname;
	}

	public void setSurname(WebElement surname) {
		this.surname = surname;
	}

	public WebElement getGsmNumber() {
		return gsmNumber;
	}

	public void setGsmNumber(WebElement gsmNumber) {
		this.gsmNumber = gsmNumber;
	}

	public WebElement getUpdateButton() {
		return updateButton;
	}

	public void setUpdateButton(WebElement updateButton) {
		this.updateButton = updateButton;
	}
}
