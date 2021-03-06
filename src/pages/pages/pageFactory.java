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
	
	public static articleContentPage getArticleContentPage(WebDriver driver){
		return new articleContentPage(driver);
	}
	
	public static articleManagerArticlePage getArticleManagerArticlePage(WebDriver driver){
		return new articleManagerArticlePage(driver);
	}
	
	public static categoryContentPage getContentCategoryPage(WebDriver driver){
		return new categoryContentPage(driver);
	}
	
	public static categoryManagerPage getcategoryManagerPage(WebDriver driver){
		return new categoryManagerPage(driver);
	}
	
	public static joomlaHelpPage getJoomlaHelpPage(WebDriver driver){
		return new joomlaHelpPage(driver);
	}
	
	public static contactManagerPage getContactManagerPage(WebDriver driver){
		return new contactManagerPage(driver);
	}
	
	public static newContactPage getNewContactPage(WebDriver driver){
		return new newContactPage(driver);
	}
	
}
