package categoryManager;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
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
	private categoryContentPage objCategoryContentPage = new categoryContentPage(driver);
	private categoryManagerPage objCategoryManagerPage = new categoryManagerPage(driver);
	String currentDate = objAbsPage.getCurrentDate();
	String CatTitle = "Selenium Team 4" + currentDate;
//	String CatTitle = "Test_001";
	
	@BeforeMethod
	public void beforeMethod(){
		browser.getDriver();
	}	
	
	@Test(description = "user can create new category and search category by using filter textbox", priority=1)
	public void TC001_and_TC008(){	
		browser.open(variables.commonVariables.initialPage);		
		objAbsPage = objadminLogin.login(commonVariables.userNameValid, commonVariables.passwordValid);
		objCategoryManagerPage = objAbsPage.goToCategoryManagerPage();
		objCategoryContentPage = objCategoryManagerPage.goTocategoryContentPage(null,"new");
		objCategoryContentPage.addCategoryContent(CatTitle, "Trung", "Unpublished", "Registered", null);
		objCategoryManagerPage = objCategoryContentPage.clickSaveAndCloseButton();
		objCategoryManagerPage.checkPageMessageDisplay("Category successfully saved");
		objCategoryManagerPage.filterCategoryByTextbox(CatTitle);
		objCategoryManagerPage.checkCategoryExist(CatTitle);
	}
	
	@Test(description = "user can publish category", priority=2)
	public void TC003(){
		objCategoryManagerPage.publishCategory(CatTitle);
		objCategoryManagerPage.checkPageMessageDisplay("1 category successfully published");
		objCategoryManagerPage.checkCategoryStatus(CatTitle, "Published");
	}
	
	@Test(description = "user can unpublish category", priority=3)
	public void TC004(){
		objCategoryManagerPage.unPublishCategory(CatTitle);
		objCategoryManagerPage.checkPageMessageDisplay("1 category successfully unpublished");
		objCategoryManagerPage.checkCategoryStatus(CatTitle, "Unpublished");
	}
	
	@Test(description = "user can archive category", priority=4)
	public void TC005(){
		objCategoryManagerPage.archiveCategory(CatTitle);
		objCategoryManagerPage.checkPageMessageDisplay("1 category successfully archived");
		objCategoryManagerPage.filterCategoryByDropdown(null, "Archived", null, null);
		objCategoryManagerPage.checkCategoryExist(CatTitle);
	}

	@Test(description = "user can trash category", priority=5)
	public void TC006(){
		objCategoryManagerPage.deleteCategory(CatTitle);
		objCategoryManagerPage.checkPageMessageDisplay("1 category successfully trashed");
		objCategoryManagerPage.searchCategory(CatTitle, null, "Trashed", null, null);
		objCategoryManagerPage.checkCategoryExist(CatTitle);
	}

	@Test(description = "user can edit a category", priority=6)
	public void TC002(){
		objCategoryContentPage = objCategoryManagerPage.goTocategoryContentPage(null,"new");
		objCategoryContentPage.addCategoryContent(CatTitle+"_2", "Trung", "Unpublished", "Registered", null);
		objCategoryContentPage.clickSaveButton();
		objCategoryContentPage.checkPageMessageDisplay("Category successfully saved");
		objCategoryContentPage.addCategoryContent(CatTitle+"_2Edited", null, null, null, null);
		objCategoryManagerPage = objCategoryContentPage.clickSaveAndCloseButton();
		objCategoryManagerPage.checkPageMessageDisplay("Category successfully saved");
		objCategoryManagerPage.searchCategory(CatTitle+"_2Edited", null, null, null, null);
		objCategoryManagerPage.checkCategoryExist(CatTitle+"_2Edited");
	}
	
	@AfterClass
	public void afterClass(){
		objAbsPage.logOut();
	}
}
