package article;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import _common.absPage;
import _common.browser;
import _common.homePage;
import _common.loginPage;
import dataTest.commonVariables;

public class TC007_TrashArticle {
	WebDriver driver;
	private loginPage objadminLogin = new loginPage(browser.getDriver());
	private absPage objAbsPage = new absPage();
	private homePage objhomepage;
	private newArticlePage objNewArticlePage;
	private articleManagerArticlePage objArticleManagerArticle;
	String currentDate = objAbsPage.getCurrentDate();
	
	@BeforeMethod
	public void beforeMethod(){
		browser.getDriver();
		browser.open(dataTest.commonVariables.initialPage);
				
	}
	
	@Test(description = "user can trash articles")
	public void trashArticle(){
		/*Navigate to the URL: http://vntesters.com/Joomla/administrator
		Enter valid username into Username field
		Enter valid password into Password field
		Click on 'Log in' button*/
		objhomepage = objadminLogin.login(commonVariables.userNameValid, commonVariables.passwordValid);
		
		/*Select Content > Article Manager
		Click on 'New' icon of the top right toolbar*/
		objNewArticlePage = objhomepage.clickAddNewArticle();
		
		/*Enter a title on 'Title' field
		Select an item from the 'Category' dropdown list
		Select 'Published' item from 'Status' dropdown list
		Enter value on 'Article Text' text area*/
		objNewArticlePage.createNewArticle("selenium team 4 tc7 "+currentDate,"Triet content","Published");
		
		//Click on 'Save & Close' icon of the top right toolbar
		objArticleManagerArticle = objNewArticlePage.clickSaveAndCloseButton();
		
		//Verify the article is saved successfully
		//Verify saved message appear
		Assert.assertEquals(objArticleManagerArticle.checkArticleSavedMessageAppear(), true, "Article saved message appears");
		//objArticleManagerArticle.checkPageMessageDisplay(driver, "Article successfully saved");
		
		//Filter article by author
		objArticleManagerArticle.searchArticle(null,commonVariables.userNameValid,"All");
		
		//Verify article displays
		Assert.assertEquals(objArticleManagerArticle.checkArticleExists("selenium team 4 tc7 "+currentDate), true, "Article saved successfully");
		
		/*Check on the recently added article's checkbox
		Click on 'Trash' icon of the top right toolbar*/
		objArticleManagerArticle.deleteArticle("selenium team 4 tc7 "+currentDate);
		
		//Verify the article is deleted successfully
		//Verify the confirm message is displayed
		Assert.assertEquals(objArticleManagerArticle.checkArticleManagerPageMessage("article trashed."), true, "Article trashed message appears");
				
		//Select 'Archived' item of 'Status' dropdown list
		objArticleManagerArticle.searchArticleByStatus("Trashed");
		
		//Verify article displays
		Assert.assertEquals(objArticleManagerArticle.checkArticleExists("selenium team 4 tc7 "+currentDate), true, "Article trashed successfully");
				
	}
	
	@AfterMethod
	public void afterMethod(){
		driver = browser.getDriver();
		driver.manage().deleteAllCookies();
		//driver.quit();
	}
}
