package article;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.absPage;
import pages.articleManagerArticlePage;
import pages.browser;
import pages.loginPage;
import pages.articleContentPage;
import variables.commonVariables;

public class TM001_VerifyArticleCreationDeleteSearchAndPropertiesEditable {
	WebDriver driver;
	private loginPage objadminLogin = new loginPage(browser.getDriver());
	private absPage objAbsPage = new absPage(driver);
	private articleContentPage objArticleContentPage;
	private articleManagerArticlePage objArticleManagerArticle = new articleManagerArticlePage(driver);
	String currentDate = objAbsPage.getCurrentDate();
	String articleTitle = "Selenium Team 4" + currentDate;
	
	@BeforeMethod
	public void beforeMethod(){
		browser.getDriver();
						
	}
	
	/*@AfterMethod
	public void afterMethod(){
		driver = browser.getDriver();
		driver.manage().deleteAllCookies();
	}*/
	
	@Test(description = "user can create new article with valid information and search article by title text", priority=1)
	public void TC001(){
		browser.open(variables.commonVariables.initialPage);		
		objAbsPage = objadminLogin.login(commonVariables.userNameValid, commonVariables.passwordValid);
		objArticleManagerArticle = objAbsPage.goToArticleManagerArticlePage();
		objArticleContentPage = objArticleManagerArticle.goToArticleContentPage(null,"new");
		objArticleContentPage.articleContent(articleTitle,"Triet","Unpublished","Registered",null);
		objArticleManagerArticle = objArticleContentPage.clickSaveAndCloseButton();
		Assert.assertEquals(objArticleManagerArticle.checkArticleSavedMessageAppear(), true, "Article saved message appears");
		objArticleManagerArticle.searchArticle(articleTitle,commonVariables.userNameValid,"All");
		Assert.assertEquals(objArticleManagerArticle.checkArticleExists(articleTitle), true, "Article saved successfully");		
	}
	
	@Test(description = "user can change the status of articles using the Status column", priority=2)
	public void TC015(){
		objArticleManagerArticle.publishArticle(articleTitle,"status column");
		Assert.assertEquals(objArticleManagerArticle.checkArticlePublishedMessageAppear(), true, "article published message appears");
		Assert.assertEquals(objArticleManagerArticle.getArticleState(articleTitle), "state publish", "article is published");
		objArticleManagerArticle.unPublishArticle(articleTitle,"status column");
		Assert.assertEquals(objArticleManagerArticle.checkArticleUnPublishedMessageAppear(), true, "article unpublished message appears");
		Assert.assertEquals(objArticleManagerArticle.getArticleState(articleTitle), "state unpublish", "article is unpublished");
	}
	
	@Test(description = "user can publish an unpublished article", priority=4)
	public void TC003(){
		objArticleManagerArticle.publishArticle(articleTitle,"toolbar");
		Assert.assertEquals(objArticleManagerArticle.checkArticlePublishedMessageAppear(), true, "article published message appears");
		Assert.assertEquals(objArticleManagerArticle.getArticleState(articleTitle), "state publish", "article is published");
	}
	
	@Test(description = "user can unpublish a published article", priority=6)
	public void TC004(){
		objArticleManagerArticle.unPublishArticle(articleTitle,"toolbar");
		Assert.assertEquals(objArticleManagerArticle.checkArticleUnPublishedMessageAppear(), true, "article unpublished message appears");
		Assert.assertEquals(objArticleManagerArticle.getArticleState(articleTitle), "state unpublish", "article is unpublished");
	}
	
	@Test(description = "user can archive articles", priority=6)
	public void TC005(){
		objArticleManagerArticle.archiveArticle(articleTitle);
		Assert.assertEquals(objArticleManagerArticle.checkArticleManagerPageMessage("article archived"), true, "Article archived successfully");
		objArticleManagerArticle.searchArticleByStatus("Archived");
		Assert.assertEquals(objArticleManagerArticle.checkArticleExists(articleTitle), true, "Article archived successfully");
	}
	
	@Test(description = "user can trash articles", priority=6)
	public void TC007(){
		objArticleManagerArticle.deleteArticle(articleTitle);
		Assert.assertEquals(objArticleManagerArticle.checkArticleManagerPageMessage("article trashed."), true, "Article trashed message appears");
	}
	
	@Test(description = "user can search articles", priority=6)
		public void TC009(){
		objArticleManagerArticle.searchArticleByStatus("Trashed");
		objArticleManagerArticle.searchArticle(articleTitle,commonVariables.userNameValid,"All");
		Assert.assertEquals(objArticleManagerArticle.checkArticleExists(articleTitle), true, "Article exists in trash folder");
	}
	
	@Test(description = "user can search for articles using the filter dropdown lists",priority = 3)
	public void TC010(){
		objArticleManagerArticle.searchArticleByAccess("Registered");
		objArticleManagerArticle.searchArticleByCategory("Sample Data-Articles");
		objArticleManagerArticle.searchArticle(null,commonVariables.userNameValid,"All");
		Assert.assertEquals(objArticleManagerArticle.checkArticleExists(articleTitle), true, "Article exists");
	}
}
