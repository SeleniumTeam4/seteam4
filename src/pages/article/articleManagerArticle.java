package article;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;

public class articleManagerArticle extends _common.absPage {
	WebDriver driver;
	public articleManagerArticle(WebDriver driver){
		this.driver = driver;
	}
	
	public void searchArticle(String articleTitle){
		waitForControl(driver, filterTextbox);
		type(driver, filterTextbox, articleTitle);
		click(driver, searchButton);
		waitForPageLoad(driver);
	}
	
	public boolean checkArticleExists(String articleTitle){
		boolean articleExist = driver.getPageSource().contains(articleTitle);
		return articleExist;
	}
	
	private String filterTextbox = "//input[@id='filter_search']";
	private String searchButton = "//button[@class='btn']";
	
}
