package com.ysfaltn.uat.merchant.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ysfaltn.uat.merchant.Config;

public class CreateUserPage extends Page
{
	private static final String PAGE_URL = Config.BASE_URL + "/usermanagement/create";
	
	@FindBy(id = "name")
	private WebElement name;
	
	@FindBy(id = "surname")
	private WebElement surname;
	
	@FindBy(id = "gsmNumber")
	private WebElement gsmNumber;
	
	@FindBy(id = "email")
	private WebElement email;
	
	@FindBy(id = "password")
	private WebElement password;
	
	@FindBy(id = "confirmPassword")
	private WebElement confirmPassword;
	
	@FindBy(id = "captcha")
	private WebElement captcha;
	
	@FindBy(xpath = "//button[text()='Kaydet']")
	private WebElement save;
	
	
	public CreateUserPage() 
	{
		super(PAGE_URL);
	}
}
