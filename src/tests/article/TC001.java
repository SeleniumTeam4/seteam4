package article;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import dataTest.commonVariables;
import _common.absPage;
import _common.browser;
import _common.homePage;
import _common.loginPage;

public class TC001 {
	WebDriver driver;
	private loginPage objadminLogin = new loginPage(browser.getDriver());
	private absPage objAbsPage = new absPage();
	private homePage objhomepage;
	private newArticlePage objNewArticlePage;
	String currentDate = objAbsPage.getCurrentDate();
	
	@BeforeMethod
	public void beforeMethod(){
		browser.getDriver();
		browser.open(dataTest.commonVariables.initialPage);
		
	}
	
	@Test
	public void createNewArticle(){
		
		objhomepage = objadminLogin.login(commonVariables.userNameValid, commonVariables.passwordValid);
		objNewArticlePage = objhomepage.clickAddNewArticle();
		objNewArticlePage.createNewArticle("selenium team 4"+currentDate,"Triet content");
		objNewArticlePage.clickSaveAndCloseButton();
			
	}
	
	/*@AfterMethod
	public void afterMethod(){
		driver.close();
		driver.quit();
	}*/
}
