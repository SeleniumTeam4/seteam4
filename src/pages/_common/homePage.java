package _common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import article.newArticlePage;

import _common.pageFactory;

public class homePage extends _common.absPage {
	WebDriver driver;
	public homePage(WebDriver driver){
		this.driver = driver;
	}
	
	public newArticlePage clickAddNewArticle(){
		driver.findElement(By.xpath(addNewArticleLink)).click();
		return pageFactory.getNewArticlePage(driver);
	}
	
	public loginPage LogOut(){
		waitForControl(driver, logOutLink);
		click(driver, logOutLink);
		return pageFactory.getLoginPage(driver);
	}
	
	private String logOutLink= "//span[@class='logout']/a";
	private String addNewArticleLink = "//span[contains(text(),'Add New Article')]";
	
}
