package com.test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class parameterdemo {
  @Test@Parameters({"val1","val2"})
  public void sum(int v1,int v2) {
	  System.out.println("Sum:"+(v1+v2));
  }
  
  @Test@Parameters({"val1","val2"})
  public void sub(int v1,int v2) {
	  System.out.println("Sub:" + (v1-v2));
  }

}
