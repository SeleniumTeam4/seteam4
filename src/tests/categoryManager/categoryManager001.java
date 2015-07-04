package categoryManager;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.absPage;
import pages.addNewCategoryPage;
import pages.browser;
import pages.homePage;
import pages.loginPage;
import variables.commonVariables;
import categoryManager.*;


public class categoryManager001 {
	WebDriver driver;
	private loginPage objadminLogin = new loginPage(browser.getDriver());
	private absPage objAbsPage;
	private homePage objhomepage;
	private addNewCategoryPage objAddNewCategoryPage;
	
	@BeforeMethod
	public void beforeMethod(){
		//browser.getDriver();
		//browser.open(dataTest.commonVariables.initialPage);
	}	
	@Test
	public void addNewCategory(){
		
		/*objhomepage = objadminLogin.login(commonVariables.userNameValid, commonVariables.passwordValid);
		objAddNewCategoryPage = objhomepage.clickAddNewCategory();
		objAddNewCategoryPage.createNewArticle("selenium team 4"+currentDate,"Triet content");
		objNewArticlePage.clickSaveAndCloseButton();*/
			
	
		
	}
	
	
	
}
