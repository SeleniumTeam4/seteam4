package article;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.absPage;
import pages.articleManagerArticlePage;
import pages.browser;
import pages.loginPage;
import pages.articleContentPage;
import variables.commonVariables;

public class TM002_VerifyArticleCreationAndFeatureProperties {
	WebDriver driver;
	private loginPage objadminLogin = new loginPage(browser.getDriver());
	private absPage objAbsPage = new absPage(driver);
	private articleContentPage obArticleContentPage;
	private articleManagerArticlePage objArticleManagerArticle = new articleManagerArticlePage(driver);
	String currentDate = objAbsPage.getCurrentDate();
	String articleTitle = "Selenium Team 4" + currentDate;
	String modifiedArticleTile = "Modified "+articleTitle;
	
	@BeforeMethod
	public void beforeMethod(){
		browser.getDriver();
	}
	
	@Test(description = " user can create a new article with 'Public' Access Level property", priority = 1)
	public void TC017(){
		browser.open(variables.commonVariables.initialPage);		
		objAbsPage = objadminLogin.login(commonVariables.userNameValid, commonVariables.passwordValid);
		objArticleManagerArticle = objAbsPage.goToArticleManagerArticlePage();
		obArticleContentPage = objArticleManagerArticle.goToArticleContentPage("new");
		obArticleContentPage.articleContent(articleTitle,"Triet","Unpublished","Public");
		objArticleManagerArticle = obArticleContentPage.clickSaveAndCloseButton();
		Assert.assertEquals(objArticleManagerArticle.checkArticleSavedMessageAppear(), true, "Article saved message appears");
		objArticleManagerArticle.searchArticle(null,commonVariables.userNameValid,"All");
		objArticleManagerArticle.searchArticleByAccess("Public");
		Assert.assertEquals(objArticleManagerArticle.checkArticleExists(articleTitle), true, "Article exists");
	}
	
	@Test(description = "  user can edit an article", priority = 2)
	public void TC002(){
		
	}
}
