package com.ysfaltn.uat.merchant.util;

import java.util.Random;

public class StringUtil 
{
	public static String randomString(final int length) 
	{
	    Random r = new Random();
	    StringBuilder sb = new StringBuilder();
	    for(int i = 0; i < length; i++) 
	    {
	        char c = (char)(r.nextInt((int)(Character.MAX_VALUE)));
	        sb.append(c);
	    }
	    
	    return sb.toString();
	}
}
