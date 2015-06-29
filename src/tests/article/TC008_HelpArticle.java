package article;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import _common.absPage;
import _common.browser;
import _common.homePage;
import _common.joomlaHelpPage;
import _common.loginPage;
import dataTest.commonVariables;

public class TC008_HelpArticle {
	WebDriver driver;
	private loginPage objadminLogin = new loginPage(browser.getDriver());
	private absPage objAbsPage = new absPage();
	private homePage objhomepage;
	private articleManagerArticlePage objArticleManagerArticle;
	private joomlaHelpPage objJoomlaHelpPage;
		
	@BeforeMethod
	public void beforeMethod(){
		browser.getDriver();
		browser.open(dataTest.commonVariables.initialPage);
				
	}
	
	@Test(description = "user can archive articles")
	public void helpPage(){
		
		objhomepage = objadminLogin.login(commonVariables.userNameValid, commonVariables.passwordValid);
		
		objArticleManagerArticle = objhomepage.goToArticleManagerArticlePage();
		
		objJoomlaHelpPage = objArticleManagerArticle.goToJoomlaHelpPage();
		
		Assert.assertEquals(objJoomlaHelpPage.getPageTitle(), "Joomla! Help");
		
		browser.backToMainWindow();
	}
	
	@AfterMethod
	public void afterMethod(){
		driver = browser.getDriver();
		driver.manage().deleteAllCookies();
		//driver.quit();
	}
}
