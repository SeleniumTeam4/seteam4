package _common;

import org.openqa.selenium.WebDriver;

import _common.pageFactory;

public class homePage extends _common.absPage {
	WebDriver driver;
	public homePage(WebDriver driver){
		this.driver = driver;
	}
	
	public loginPage LogOut(){
		waitForControl(driver, logOutLink);
		click(driver, logOutLink);
		
		return pageFactory.getLoginPage(driver);
	}
	
	private String logOutLink= "//span[@class='logout']/a";
	private String addNewArticleLink = "//span[contains(text(),'Add New Article')]";
	
}
