package _common;

import org.openqa.selenium.WebDriver;


public class pageFactory {
	public static loginPage getLoginPage(WebDriver driver){
		return new loginPage(driver);
	}
	
	public static homePage getHomePage(WebDriver driver){
		return new homePage(driver);
	}
}
