package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
	
	public categoryManagerPage goToCategoryManagerPage(){
		click(driver, contentMenu);
		click(driver,categoryManager);
		return pageFactory.getcategoryManagerPage(driver);
	}
	
	public loginPage LogOut(){
		waitForControl(driver, logOutLink);
		click(driver, logOutLink);
		return pageFactory.getLoginPage(driver);
	}
	
	public newContactPage clickAddNewContact(){
		goToContactManagerPage();
		driver.findElement(By.xpath(newSpan)).click();
		return pageFactory.getNewContactPage(driver);
	}
	
	public contactManagerPage goToContactManagerPage(){
		click(driver, componentsMenu);
		click(driver, contactManagerMenuItem);
		return pageFactory.getContactManagerPage(driver);
	}
	//Interface lists:
	private String logOutLink= "//span[@class='logout']/a";
	private String contentMenu = "//a[contains(text(),'Content')]";
	private String componentsMenu = "//a[contains(text(),'Components')]";
	private String articleManagerMenuItem = "//a[contains(text(),'Article Manager')]";
	private String contactManagerMenuItem = "//a[contains(text(),'Contacts')]";
	private String newSpan = "//span[@class='icon-32-new']";
	private String categoryManager = "//a[.='Category Manager']";
		 
}
