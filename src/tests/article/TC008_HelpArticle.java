package article;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.absPage;
import pages.articleManagerArticlePage;
import pages.browser;
import pages.homePage;
import pages.joomlaHelpPage;
import pages.loginPage;
import variables.commonVariables;


public class TC008_HelpArticle {
	WebDriver driver;
	private loginPage objadminLogin = new loginPage(browser.getDriver());
	private absPage objAbsPage = new absPage(driver);
	private articleManagerArticlePage objArticleManagerArticle;
	private joomlaHelpPage objJoomlaHelpPage;
		
	@BeforeMethod
	public void beforeMethod(){
		browser.getDriver();
		browser.open(variables.commonVariables.initialPage);
				
	}
	
	@Test(description = "user can archive articles")
	public void helpPage(){
		
		objAbsPage = objadminLogin.login(commonVariables.userNameValid, commonVariables.passwordValid);
		
		objArticleManagerArticle = objAbsPage.goToArticleManagerArticlePage();
				
		objJoomlaHelpPage = objArticleManagerArticle.goToJoomlaHelpPage();
		
		Assert.assertEquals(objJoomlaHelpPage.getPageTitle(), "Joomla! Help");
		
		//objAbsPage = objJoomlaHelpPage.returnMainPage();
		
		driver = driver.switchTo().defaultContent();
		
		objAbsPage.LogOut();
	}
	
	@AfterMethod
	public void afterMethod(){
		driver = browser.getDriver();
		driver.manage().deleteAllCookies();
		//driver.quit();
	}
}
