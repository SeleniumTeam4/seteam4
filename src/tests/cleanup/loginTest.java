package cleanup;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.absPage;
import pages.browser;
import pages.homePage;
import pages.loginPage;
import variables.commonVariables;

public class loginTest {
	WebDriver driver;
	private loginPage objadminLogin = new loginPage(browser.getDriver());
	private homePage objhomepage;
	private absPage objAbsPage; 
	
	
	@BeforeMethod
	public void beforeMethod(){
		browser.getDriver();
		browser.open(variables.commonVariables.initialPage);
		//common.waitForControl(driver, adminLoginPage.userNameTextbox);
		//objadminLogin = PageFactory.getAdminLogin(driver);
		
		
	}
	
	@Test
	public void loginValidCredential(){
		objAbsPage = objadminLogin.login(commonVariables.userNameValid, commonVariables.passwordValid);
		objadminLogin = objAbsPage.logOut();
			
	}
	
	/*@AfterMethod
	public void afterMethod(){
		driver.close();
		driver.quit();
	}*/
}

