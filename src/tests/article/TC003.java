package article;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import dataTest.commonVariables;
import _common.absPage;
import _common.browser;
import _common.homePage;
import _common.loginPage;

public class TC003 {
	WebDriver driver;
	private loginPage objadminLogin = new loginPage(browser.getDriver());
	private absPage objAbsPage = new absPage();
	private homePage objhomepage;
	private newArticlePage objNewArticlePage;
	private articleManagerArticle objArticleManagerArticle;
	String currentDate = objAbsPage.getCurrentDate();
	
	@BeforeMethod
	public void beforeMethod(){
		browser.getDriver();
		browser.open(dataTest.commonVariables.initialPage);
				
	}
	
	@Test
	public void createNewArticle(){
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
		Enter value on 'Article Text' text area*/
				
		objNewArticlePage.createNewArticle("selenium team 4 tc3 "+currentDate,"Triet content","Unpublished");
		
		//Click on 'Save & Close' icon of the top right toolbar
		
		objArticleManagerArticle = objNewArticlePage.clickSaveAndCloseButton();
		
		//Verify the article is saved successfully
		
		Assert.assertEquals(objArticleManagerArticle.checkArticleSavedMessageAppear(), true, "Article saved message appears");
		
		//objAbsPage.waitForPageLoad(driver);
		objArticleManagerArticle.searchArticle(null,commonVariables.userNameValid,"All");
		//objAbsPage.waitForPageLoad(driver);
		Assert.assertEquals(objArticleManagerArticle.checkArticleExists("selenium team 4 tc3 "+currentDate), true, "Article saved successfully");
		
		objArticleManagerArticle.publishArticle("selenium team 4 tc3 "+currentDate);
		
		Assert.assertEquals(objArticleManagerArticle.checkArticlePublishedMessageAppear(), true, "article published message appears");
		
		Assert.assertEquals(objArticleManagerArticle.getArticleState("selenium team 4 tc3 "+currentDate), "state publish", "article is published");
		
	}
	
	@AfterMethod
	public void afterMethod(){
		driver = browser.getDriver();
		driver.close();
		driver.quit();
	}
}