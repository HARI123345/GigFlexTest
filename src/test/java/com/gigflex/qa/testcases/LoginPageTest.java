package com.gigflex.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.gigflex.qa.base.TestBase;
import com.gigflex.qa.pages.HomePage;
import com.gigflex.qa.pages.LoginPage;
import com.gigflex.qa.util.TestUtil;

public class LoginPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
    TestUtil testUtil;
     String sheetName = "LogTestData"; 
 	Logger log = Logger.getLogger(LoginPageTest.class);
public LoginPageTest () {
		
		super();
	}


@BeforeMethod

public void setUp() throws InterruptedException  {
	
	initialization();
	
 loginpage = new LoginPage();
 //homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
}


@DataProvider
public Object[][] getGigFlexTestData( ) {
	Object data[][] =TestUtil.getTestData(sheetName);
	return data;
}

//@Test(priority=1)
//public void validateGigFlexLogoImageTest() {
//	loginpage.validateGigFlexLogoImage();
//}

@Test(priority=1)
public void validateGigFlexLogo() {
	boolean flag =loginpage.validateGigFlexLogoImage();
	Assert.assertTrue(flag);
}

@Test(priority=2)
public void validateGigFlexPageTitle() {
	//Actual title
	String title = driver.getTitle();
	System.out.println("Title is "+title);
	//Excepted title
	//String expected_title ="Gig Exchange";
//	Assert.assertEquals(title,expected_title);
	Assert.assertTrue(title.contains("Gig Exchange"));
}


@Test(priority=2, dataProvider="getGigFlexTestData")
public void validateGigFlexLoginPage(String username, String password) throws InterruptedException {
  
	loginpage.login(username, password);
	Thread.sleep(5000);
	System.out.println(driver.getCurrentUrl());
	Assert.assertTrue(driver.getCurrentUrl().contains("http://18.223.158.6/organization/dashboard"), "User is not able to login- Invalid Credentails");
//	Assert.assertTrue(driver.getCurrentUrl().contains("http://18.223.158.6/organization/dashboard"), "User is not able to login- Invalid Credentails");
	System.out.println("Page url verified- user able to login successfully");
	
	
	//System.out.println(loginpage.login(username, password));
	//String sh =  sheetName;

}

@AfterMethod
public void tearDown() throws InterruptedException {
//	driver.quit();
}
					

}
