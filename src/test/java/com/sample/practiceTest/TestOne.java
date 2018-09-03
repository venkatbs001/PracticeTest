package com.sample.practiceTest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class TestOne {

	@BeforeClass
	public void beforeClass() {
		System.out.println("Before class");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method");
	}
	
	@Test(priority=1, enabled=false)
	public void f() {
		System.out.println("Test Mthod f");
	}

	@Test(priority=0)
	public void g() {
		System.out.println("Test Mthod g");
	}
	
	@Test(priority=2)
	public void h() {
		System.out.println("Test Mthod h");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("After Class");
	}

}
