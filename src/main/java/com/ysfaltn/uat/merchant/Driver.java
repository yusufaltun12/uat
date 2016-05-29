package com.ysfaltn.uat.merchant;

import java.lang.reflect.Field;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ysfaltn.uat.merchant.page.Page;

public class Driver 
{
	private WebDriver webDriver;
	private Page currentPage;
	
	public static Driver create(Browser browser)
	{
		Driver driver = new Driver();
		
		switch (browser) {
		case CHROME:
			System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
			driver.webDriver = new ChromeDriver();
			break;
		default:
			break;
		}
		
		return driver;
	}
	
	public Page getPage()
	{
		return currentPage;
	}
	
	public Driver goTo(Page page)
	{
		this.currentPage = page;
		webDriver.get(page.getUrl());
		
		PageFactory.initElements(webDriver, currentPage);
		
		return this;
	}
	
	
	public Driver click(String name)
	{
		get(name).click();
		return this;
	}
	
	public Driver setText(String element, String text)
	{
		get(element).sendKeys(text);
		return this;
	}
	
	protected WebElement get (String fieldName)
    {
        WebElement element = null;
        Class<?> pageClass = this.currentPage.getClass();
        Field field = null;

        try {
            field = pageClass.getDeclaredField(fieldName);
            field.setAccessible(true);
            element = (WebElement) field.get(currentPage);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalStateException("Exception on accessing field {"+fieldName+"} of page");
        }

        return element;
    }
	
	public void close()
	{
		webDriver.close();
	}

	public Driver switchPage(Page page) 
	{
		this.currentPage = page;
		PageFactory.initElements(webDriver, currentPage);
		return this;
	}

	public boolean elementIsExist(By by) 
	{
		return  !webDriver.findElements(by).isEmpty();
	}
	
	public Driver waitForAjax () {
        try {

            WebDriverWait myWait = new WebDriverWait(webDriver, 5);


            ExpectedCondition<Boolean> conditionToCheck = new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver input) {
                    JavascriptExecutor jsDriver = (JavascriptExecutor) webDriver;
                    boolean stillRunningAjax = (Boolean) jsDriver
                            .executeScript("return window.jQuery != undefined && jQuery.active != 0");
                    return !stillRunningAjax;
                }
            };

            myWait.until(conditionToCheck);
        } catch (Throwable ex) {
        }
        return this;
    }
}
