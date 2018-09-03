package com.sample.practiceTest;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sample.practiceTest.pages.AccountPage;
import com.sample.practiceTest.pages.HomePage;

public class TestTwo {
	WebDriver driver;

	@DataProvider(name="logincreds")
	public static Object[][] loginDetails(){
		return new Object[][] {
			{ "bs001", "Venkat@Raj01"},
			{ "bs002", "Venkat@Raj02"}
		};
	}

	@Test(dataProvider="logincreds")
	public void checkLogin(String username, String password) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\venkatrajesh\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.store.demoqa.com");
		// driver.findElement(By.xpath("//*[@id=\"account\"]/a")).click();
		//driver.findElement(By.className("account_icon")).click();
		HomePage homePageObj = new HomePage(driver);
		AccountPage accountPageObj = new AccountPage(driver);
		homePageObj.clickAccountLink();
		homePageObj.enterUserName(username);
		homePageObj.enterPassword(password);
		homePageObj.clickLogin();
		checkElementExist(By.linkText("Log out"), 20);
		assertTrue(accountPageObj.checkLogoutLink(), "Log out button not displayd");
		driver.quit();
	}

	public void checkElementExist(By locatorPath, int seconds) throws InterruptedException {

		for(int i=0; i<seconds;i++) {
			try{
				if(driver.findElement(locatorPath).isDisplayed())
					break;
			}catch(Exception e) {
				Thread.sleep(1000);
			}
		}

	}
}
