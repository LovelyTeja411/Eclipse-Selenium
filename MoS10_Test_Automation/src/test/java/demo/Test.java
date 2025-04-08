package demo;

import java.io.IOException;
//import java.time.Duration;


import org.testng.annotations.BeforeClass;

import baseResource.Base_Class;
import pom_Resources.Home_page;
import pom_Resources.LoginPage;

public class Test extends Base_Class {
//	LoginPage loginPage;
	Home_page homePage;
	@BeforeClass
	public void setup() throws IOException {
	executeBeforeClass();
//	loginPage = new LoginPage(driver);
	homePage = new Home_page(driver);
	}
@org.testng.annotations.Test
	 public void verifyLogin() throws IOException, Throwable {
//	        loginPage.enterusername(fileUtils.readTheDataFromPropertyFile("LoginId"));
//	        loginPage.enterPassword(fileUtils.readTheDataFromPropertyFile("Password"));
//	       	loginPage.clickLogin();
	LoginPage lp= new LoginPage(driver);
    lp.enterusername(fileUtils.readTheDataFromPropertyFile("LoginId"));
    lp.enterPassword(fileUtils.readTheDataFromPropertyFile("Password"));
   	lp.clickLogin();
	 }

//           (OR)

	@org.testng.annotations.Test
	public void verify_Home() {
		homePage.mb_Logo();
		homePage.clickRoomModule();
		homePage.navigateToRoomSubModule();
		
	}
}
