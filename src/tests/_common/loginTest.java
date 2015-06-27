package _common;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import _common.absPage;
import dataTest.commonVariables;

public class loginTest {
	WebDriver driver;
	private loginPage objadminLogin = new loginPage(absPage.browser.getDriver());
	private homePage objhomepage;
	
	
	@BeforeMethod
	public void beforeMethod(){
		absPage.browser.getDriver();
		absPage.browser.open(dataTest.commonVariables.initialPage);
		//common.waitForControl(driver, adminLoginPage.userNameTextbox);
		//objadminLogin = PageFactory.getAdminLogin(driver);
		
		
	}
	
	@Test
	public void loginValidCredential(){
		objhomepage = objadminLogin.login(commonVariables.userNameValid, commonVariables.passwordValid);
		objadminLogin = objhomepage.LogOut();
			
	}
	
	/*@AfterMethod
	public void afterMethod(){
		driver.close();
		driver.quit();
	}*/
}

