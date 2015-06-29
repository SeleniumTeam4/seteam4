package _common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import article.newArticlePage;
import categoryManager.*;
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
	
	//trung.tran: add below line
	public addNewCategoryPage clickAddNewCategory(){
		driver.findElement(By.xpath(categoryManagerLink)).click();
		return pageFactory.getNewCategory(driver);
	}
	
	//Interface lists:
	private String logOutLink= "//span[@class='logout']/a";
	private String addNewArticleLink = "//span[contains(text(),'Add New Article')]";
	private String categoryManagerLink = "//a[.='Category Manager']";
	
}
