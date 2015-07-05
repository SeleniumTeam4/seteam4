package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import commonActions.commonActions;

public class absPage extends commonActions {
			
	WebDriver driver;
	public absPage(WebDriver driver){
		this.driver = driver;
	}
	
	public articleManagerArticlePage goToArticleManagerArticlePage(){
		click(driver, contentMenu);
		click(driver, articleManagerMenuItem);
		return pageFactory.getArticleManagerArticlePage(driver);
	}
	
	public articleContentPage goToArticleContentPage(String type){
		goToArticleManagerArticlePage();
		if (type == "new"){
			click(driver,newSpan);
		}
		
		if (type == "edit"){
			click(driver,editSpan);
		}
		
		return pageFactory.getArticleContentPage(driver);
	}
	
	public loginPage LogOut(){
		waitForControl(driver, logOutLink);
		click(driver, logOutLink);
		return pageFactory.getLoginPage(driver);
	}
	
	
	//Interface lists:
	private String logOutLink= "//span[@class='logout']/a";
	private String contentMenu = "//a[contains(text(),'Content')]";
	private String articleManagerMenuItem = "//a[contains(text(),'Article Manager')]";
	private String newSpan = "//span[@class='icon-32-new']";
	private String editSpan = "//span[@class='icon-32-edit']";
 
}
