package categoryManager;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.absPage;
import pages.categoryContentPage;
import pages.browser;
import pages.loginPage;
import pages.categoryManagerPage;
import variables.commonVariables;

public class CM001_Create_Edit_Publish_Unpublish_Archive_Delete {
	WebDriver driver;
	private loginPage objadminLogin = new loginPage(browser.getDriver());
	private absPage objAbsPage = new absPage(driver);
	private categoryContentPage objCategoryContentPage;
	private categoryManagerPage objCategoryManagerPage = new categoryManagerPage(driver);
	String currentDate = objAbsPage.getCurrentDate();
	String CatTitle = "Selenium Team 4" + currentDate;
	
	@BeforeMethod
	public void beforeMethod(){
		browser.getDriver();

	}	
	
	@Test(description = "user can create new article with valid information and search article by title text", priority=1)
	public void TC001(){
		browser.open(variables.commonVariables.initialPage);		
		objAbsPage = objadminLogin.login(commonVariables.userNameValid, commonVariables.passwordValid);
		objCategoryManagerPage = objAbsPage.goToCategoryManagerPage();
		objCategoryContentPage = objCategoryManagerPage.goTocategoryContentPage(null,"new");
		objCategoryContentPage.addCategoryContent(CatTitle, "Trung", "Unpublished", "Registered", null);
		objCategoryManagerPage = objCategoryContentPage.clickSaveAndCloseButton();
		objCategoryManagerPage.checkPageMessageDisplay(driver, "Category successfully saved.");
//		Assert.assertEquals(objCategoryManagerPage.checkArticleSavedMessageAppear(), true);
		objCategoryManagerPage.searchCategory(CatTitle);
//		Assert.assertEquals(objCategoryManagerPage.checkArticleExists(articleTitle), true);		
	}
	
//	@Test(description = "user can change the status of articles using the Status column", priority=2)
//	public void TC015(){
//		objArticleManagerArticle.publishArticle(articleTitle,"status column");
//		Assert.assertEquals(objArticleManagerArticle.checkArticlePublishedMessageAppear(), true, "article published message appears");
//		Assert.assertEquals(objArticleManagerArticle.getArticleState(articleTitle), "state publish", "article is published");
//		objArticleManagerArticle.unPublishArticle(articleTitle,"status column");
//		Assert.assertEquals(objArticleManagerArticle.checkArticleUnPublishedMessageAppear(), true, "article unpublished message appears");
//		Assert.assertEquals(objArticleManagerArticle.getArticleState(articleTitle), "state unpublish", "article is unpublished");
//	}
//	
//	@Test(description = "user can publish an unpublished article", priority=4)
//	public void TC003(){
//		objArticleManagerArticle.publishArticle(articleTitle,"toolbar");
//		Assert.assertEquals(objArticleManagerArticle.checkArticlePublishedMessageAppear(), true, "article published message appears");
//		Assert.assertEquals(objArticleManagerArticle.getArticleState(articleTitle), "state publish", "article is published");
//	}
//	
//	@Test(description = "user can unpublish a published article", priority=6)
//	public void TC004(){
//		objArticleManagerArticle.unPublishArticle(articleTitle,"toolbar");
//		Assert.assertEquals(objArticleManagerArticle.checkArticleUnPublishedMessageAppear(), true, "article unpublished message appears");
//		Assert.assertEquals(objArticleManagerArticle.getArticleState(articleTitle), "state unpublish", "article is unpublished");
//	}
//	
//	@Test(description = "user can archive articles", priority=6)
//	public void TC005(){
//		objArticleManagerArticle.archiveArticle(articleTitle);
//		Assert.assertEquals(objArticleManagerArticle.checkArticleManagerPageMessage("article archived"), true, "Article archived successfully");
//		objArticleManagerArticle.searchArticleByStatus("Archived");
//		Assert.assertEquals(objArticleManagerArticle.checkArticleExists(articleTitle), true, "Article archived successfully");
//	}
//	
//	@Test(description = "user can trash articles", priority=6)
//	public void TC007(){
//		objArticleManagerArticle.deleteArticle(articleTitle);
//		Assert.assertEquals(objArticleManagerArticle.checkArticleManagerPageMessage("article trashed."), true, "Article trashed message appears");
//	}
}
