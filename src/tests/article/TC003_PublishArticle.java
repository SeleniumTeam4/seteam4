package article;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.absPage;
import pages.articleManagerArticlePage;
import pages.browser;
import pages.homePage;
import pages.loginPage;
import pages.newArticlePage;
import variables.commonVariables;

public class TC003_PublishArticle {
	WebDriver driver;
	private loginPage objadminLogin = new loginPage(browser.getDriver());
	private absPage objAbsPage = new absPage(driver);
	private homePage objhomepage;
	private newArticlePage objNewArticlePage;
	private articleManagerArticlePage objArticleManagerArticle;
	String currentDate = objAbsPage.getCurrentDate();
	
	@BeforeMethod
	public void beforeMethod(){
		browser.getDriver();
		browser.open(variables.commonVariables.initialPage);
				
	}
	
	@Test(description = "user can publish an unpublished article")
	public void publishedArticle(){
		/*Navigate to the URL: http://vntesters.com/Joomla/administrator
		Enter valid username into Username field
		Enter valid password into Password field
		Click on 'Log in' button*/
		objAbsPage = objadminLogin.login(commonVariables.userNameValid, commonVariables.passwordValid);
		
		/*Select Content > Article Manager
		Click on 'New' icon of the top right toolbar*/
		objNewArticlePage = objAbsPage.clickAddNewArticle();
		
		/*Enter a title on 'Title' field
		Select an item from the 'Category' dropdown list
		Select 'Unpublished' item from 'Status' dropdown list
		Enter value on 'Article Text' text area*/
		objNewArticlePage.createNewArticle("selenium team 4 tc3 "+currentDate,"Triet content","Unpublished");
		
		//Click on 'Save & Close' icon of the top right toolbar
		objArticleManagerArticle = objNewArticlePage.clickSaveAndCloseButton();
		
		//Verify the article is saved successfully
		//Verify saved message appear
		Assert.assertEquals(objArticleManagerArticle.checkArticleSavedMessageAppear(), true, "Article saved message appears");
		//objArticleManagerArticle.checkPageMessageDisplay(driver, "Article successfully saved");
		
		//Filter article by author
		objArticleManagerArticle.searchArticle(null,commonVariables.userNameValid,"All");
		
		//Verify article displays
		Assert.assertEquals(objArticleManagerArticle.checkArticleExists("selenium team 4 tc3 "+currentDate), true, "Article saved successfully");
		
		/*Check on the recently added article's checkbox
		Click on 'Publish' icon of the top right toolbar*/
		objArticleManagerArticle.publishArticle("selenium team 4 tc3 "+currentDate);
		
		//Verify the article is published successfully
		//Verify article published message displays
		Assert.assertEquals(objArticleManagerArticle.checkArticlePublishedMessageAppear(), true, "article published message appears");
		//objArticleManagerArticle.checkPageMessageDisplay(driver, "article published.");
				
		//Verify article status is published
		Assert.assertEquals(objArticleManagerArticle.getArticleState("selenium team 4 tc3 "+currentDate), "state publish", "article is published");
		
	}
	
	/*@Test(description = "user can publish an unpublished article")
	public void unPublishedArticle(){
		Navigate to the URL: http://vntesters.com/Joomla/administrator
		Enter valid username into Username field
		Enter valid password into Password field
		Click on 'Log in' button
		objhomepage = objadminLogin.login(commonVariables.userNameValid, commonVariables.passwordValid);
		
		Select Content > Article Manager
		Click on 'New' icon of the top right toolbar
		objNewArticlePage = objhomepage.clickAddNewArticle();
		
		Enter a title on 'Title' field
		Select an item from the 'Category' dropdown list
		Select 'Unpublished' item from 'Status' dropdown list
		Enter value on 'Article Text' text area
		objNewArticlePage.createNewArticle("selenium team 4 tc3 "+currentDate,"Triet content","Unpublished");
		
		//Click on 'Save & Close' icon of the top right toolbar
		objArticleManagerArticle = objNewArticlePage.clickSaveAndCloseButton();
		
		//Verify the article is saved successfully
		//Verify saved message appear
		Assert.assertEquals(objArticleManagerArticle.checkArticleSavedMessageAppear(), true, "Article saved message appears");
		//objArticleManagerArticle.checkPageMessageDisplay(driver, "Article successfully saved");
		
		//Filter article by author
		objArticleManagerArticle.searchArticle(null,commonVariables.userNameValid,"All");
		
		//Verify article displays
		Assert.assertEquals(objArticleManagerArticle.checkArticleExists("selenium team 4 tc3 "+currentDate), true, "Article saved successfully");
		
		Check on the recently added article's checkbox
		Click on 'Publish' icon of the top right toolbar
		objArticleManagerArticle.publishArticle("selenium team 4 tc3 "+currentDate);
		
		//Verify the article is published successfully
		//Verify article published message displays
		Assert.assertEquals(objArticleManagerArticle.checkArticlePublishedMessageAppear(), true, "article published message appears");
		//objArticleManagerArticle.checkPageMessageDisplay(driver, "article published.");
				
		//Verify article status is published
		Assert.assertEquals(objArticleManagerArticle.getArticleState("selenium team 4 tc3 "+currentDate), "state publish", "article is published");
		
	}*/
	
	@AfterMethod
	public void afterMethod(){
		driver = browser.getDriver();
		driver.manage().deleteAllCookies();
		//driver.quit();
	}
}