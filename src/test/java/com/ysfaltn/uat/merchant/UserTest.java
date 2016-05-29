package com.ysfaltn.uat.merchant;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;

import com.ysfaltn.uat.merchant.page.CreateUserPage;
import com.ysfaltn.uat.merchant.page.DashboardPage;
import com.ysfaltn.uat.merchant.page.LoginPage;
import com.ysfaltn.uat.merchant.page.MyProfilePage;
import com.ysfaltn.uat.merchant.page.UserListPage;
import com.ysfaltn.uat.merchant.util.StringUtil;

import junit.framework.Assert;

public class UserTest extends BaseTest
{
	public Driver driver;
	String name = "yusuf" + StringUtil.randomString(5);
	String surname = "altun" + StringUtil.randomString(5);
	String gsmNumber = "5452881470";
	String email = "altuny71@gmail.com" ;
	String password = "A8230385a";
	String captcha = "test";
	String userId = "39685";
	
	@After
	public void after()
	{
		driver.close();
	}
	
	@Test
	public void loginTest()
	{
		
    	driver = Driver.create(Browser.CHROME)
    		.goTo(new LoginPage())
    		.setText("email", email)
    		.setText("password", password)
    		.click("loginButton")
    		.goTo(new DashboardPage());
    	
    	DashboardPage dashboardPage = (DashboardPage)driver.getPage();
    	Assert.assertTrue("When I login, my email as ", dashboardPage.getUserInfoPanel().getText().contains(email));
    	Assert.assertTrue("When I login, my id as ", dashboardPage.getUserInfoPanel().getText().contains(userId));
	}
	
	@Test
	public void updateMyInformationTest()
	{
    	driver = Driver.create(Browser.CHROME)
    		.goTo(new LoginPage())
    		.setText("email", email)
    		.setText("password", password)
    		.click("loginButton")
    		.goTo(new MyProfilePage())
    		.setText("name", name)
    		.setText("surname", surname)
    		.setText("gsmNumber", gsmNumber)
    		.click("updateButton");
    	
    	MyProfilePage myProfilePage = (MyProfilePage) driver.getPage();
    	
    	
    	Assert.assertTrue("When I update my info, my name as ", myProfilePage.getName().getText().contains(name));
    	Assert.assertTrue("When I update my info, my surname as ", myProfilePage.getSurname().getText().contains(surname));
    	Assert.assertTrue("When I update my info, my gsm number as ", myProfilePage.getGsmNumber().getText().contains(gsmNumber));
	}
	
	@Test
	public void addUserWithoutCaptcha()
	{
    	driver = Driver.create(Browser.CHROME)
    		.goTo(new LoginPage())
    		.setText("email", email)
    		.setText("password", password)
    		.click("loginButton")
    		.goTo(new UserListPage())
    		.click("addUser")
    		.switchPage(new CreateUserPage())
    		.setText("name", name)
    		.setText("surname", surname)
    		.setText("email", email)
    		.setText("gsmNumber", gsmNumber)
    		.setText("password", password)
    		.setText("confirmPassword", password)
    		.setText("captcha", captcha )
    		.click("save")
    		.waitForAjax();
    		
    	Assert.assertTrue("When I incorrect entry to captcha, should be error.", driver.elementIsExist(By.id("captcha-error")) );
	}
}
