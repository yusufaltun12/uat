package com.ysfaltn.uat.merchant.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ysfaltn.uat.merchant.Config;

public class LoginPage extends Page
{
	public static final String PAGE_URL = Config.BASE_URL + "/login";
	
	@FindBy(id="email")
	private WebElement email;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="login-button")
	private WebElement loginButton;
	
	public LoginPage()
	{
		super(PAGE_URL);
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
}
