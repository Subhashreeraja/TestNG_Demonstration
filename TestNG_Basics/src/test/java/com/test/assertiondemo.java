package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class assertiondemo {
	
	@Test
	public void testAssertions() {
		
	
	String str1=new String("TestNG");
	String str2=new String("TestNG");
	String str3=null;
	String str4="TestNG";
	String str5="TestNG";
	String str6=new String("Not_TestNG");
	
	int val1=5;
	int val2=6;
	
	Assert.assertEquals(str1,str2);
	System.out.println("Equals Assertion is successful");
	
	Assert.assertNotEquals(str1,str6);
	System.out.println("NotEquals Assertion is successful");
	
	 //check that a condition is true
	  Assert.assertTrue(val1<val2);
	  System.out.println("True Assertion is successful");
	  
	  //check that a condition is false
	   Assert.assertFalse(val1>val2);
	   System.out.println("false Assertion is successful");
	   
	   //check that an object isn't null
	   Assert.assertNotNull(str1);
	   System.out.println("Not Null Assertion is successful");
	   
	  //check that an obj is null
	   Assert.assertNull(str3);
	
	   //check if two obj refernce point to the same obj
	   Assert.assertSame(str4, str5);
	   System.out.println("Same Assertion is successful");
	   
	   Assert.assertNotSame(str1, str3);
	   System.out.println("Not Same Assertion is successful");
	   
	   
	   
	}
}
