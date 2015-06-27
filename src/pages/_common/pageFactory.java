package _common;

import org.openqa.selenium.WebDriver;

import article.newArticlePage;


public class pageFactory {
	public static loginPage getLoginPage(WebDriver driver){
		return new loginPage(driver);
	}
	
	public static homePage getHomePage(WebDriver driver){
		return new homePage(driver);
	}
	
	public static newArticlePage getNewArticlePage(WebDriver driver){
		return new newArticlePage(driver);
	}
}
