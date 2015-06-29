package _common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import article.articleManagerArticlePage;
import article.newArticlePage;
import categoryManager.*;
import _common.pageFactory;

public class homePage extends _common.absPage {
	WebDriver driver;
	public homePage(WebDriver driver){
		this.driver = driver;
	}
	
	public articleManagerArticlePage goToArticleManagerArticlePage(){
		click(driver, contentMenu);
		click(driver, articleManagerMenuItem);
		return pageFactory.getArticleManagerArticlePage(driver);
	}
	
	public newArticlePage clickAddNewArticle(){
		goToArticleManagerArticlePage();
		driver.findElement(By.xpath(newSpan)).click();
		return pageFactory.getNewArticlePage(driver);
	}
	
	public loginPage LogOut(){
		waitForControl(driver, logOutLink);
		click(driver, logOutLink);
		return pageFactory.getLoginPage(driver);
	}
	
	//trung.tran: add below line
	public addNewCategoryPage clickAddNewCategory(){
		driver.findElement(By.xpath(categoryManagerLink)).click();
		return pageFactory.getNewCategory(driver);
	}
	
	//Interface lists:
	private String logOutLink= "//span[@class='logout']/a";
	private String contentMenu = "//a[contains(text(),'Content')]";
	private String articleManagerMenuItem = "//a[contains(text(),'Article Manager')]";
	private String newSpan = "//span[@class='icon-32-new']";
	private String categoryManagerLink = "//a[.='Category Manager']";
	
}
