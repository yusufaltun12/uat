package com.ysfaltn.uat.merchant.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ysfaltn.uat.merchant.Config;

public class UserListPage extends Page
{
	private static final String PAGE_URL = Config.BASE_URL + "/usermanagement/list";
	
	@FindBy(xpath = "//div[@class='breadcrumb-env']")
	private WebElement addUser;
	
	public UserListPage() 
	{
		super(PAGE_URL);
	}
}
