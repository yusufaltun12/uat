package com.ysfaltn.uat.merchant.page;

public abstract class Page 
{
	private String pageUrl;
	
	public Page(String pageUrl)
	{
		this.pageUrl = pageUrl;
	}
	
	public String getUrl()
	{
		return pageUrl;
	}
}
