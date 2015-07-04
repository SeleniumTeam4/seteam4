package pages;

import org.openqa.selenium.WebDriver;

import categoryManager.*;


public class pageFactory {
	
	public static absPage getAbsPage(WebDriver driver){
		return new absPage(driver);
	}
	
	public static loginPage getLoginPage(WebDriver driver){
		return new loginPage(driver);
	}
	
	public static homePage getHomePage(WebDriver driver){
		return new homePage(driver);
	}
	
	public static newArticlePage getNewArticlePage(WebDriver driver){
		return new newArticlePage(driver);
	}
	
	public static articleManagerArticlePage getArticleManagerArticlePage(WebDriver driver){
		return new articleManagerArticlePage(driver);
	}
	
	public static addNewCategoryPage getNewCategory(WebDriver driver){
		return new addNewCategoryPage(driver);
	}
	
	public static joomlaHelpPage getJoomlaHelpPage(WebDriver driver){
		return new joomlaHelpPage(driver);
	}
}