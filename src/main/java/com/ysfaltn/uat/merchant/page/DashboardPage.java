package com.ysfaltn.uat.merchant.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ysfaltn.uat.merchant.Config;

public class DashboardPage extends Page 
{
	public static final String PAGE_URL = Config.BASE_URL + "/dashboard";
	
	@FindBy(xpath = "//li[@class='dropdown user-profile']//span")
	private WebElement userInformationPanel;
	
	public DashboardPage() 
	{
		super(PAGE_URL);
	}
	
	public WebElement getUserInfoPanel()
	{
		return userInformationPanel;
	}
}
