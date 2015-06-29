package article;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;

public class articleManagerArticlePage extends _common.absPage {
	WebDriver driver;
	public articleManagerArticlePage(WebDriver driver){
		this.driver = driver;
	}
	
	public void searchArticle(String articleTitle, String author, String displayNumber){
		waitForControl(driver, filterTextbox);
		select(driver, authorDropdown, author);
		select(driver, displayNumberDropdown, displayNumber);
		type(driver, filterTextbox, articleTitle);
		click(driver, searchButton);
		waitForControl(driver, "//form[@id='adminForm']/table/tbody");
	}
	
	public void searchArticleByStatus(String articleStatus){
		select(driver, statusDropdown, articleStatus);
		waitForPageLoad(driver);
	}
	
	public boolean checkArticleExists(String articleTitle){
		
		WebElement articleExist = driver.findElement(By.xpath("//a[contains(text(),'" + articleTitle+ "')]"));
		
		if (articleExist == null){
		
		return false;
		
		}
		
		else {
			return true;
		}
		
	}
	
	public boolean checkArticleSavedMessageAppear(){
		boolean messageExist = driver.getPageSource().contains("Article successfully saved");
		return messageExist;
	}
	
	public boolean checkArticlePublishedMessageAppear(){
		boolean messageExist =driver.getPageSource().contains("article published.");
		return messageExist;
	}
	
	public boolean checkArticleUnPublishedMessageAppear(){
		boolean messageExist =driver.getPageSource().contains("article unpublished.");
		return messageExist;
	}
	
	public void publishArticle(String articleName){
		clickTableCell(driver, "//a[contains(text(),'"+ articleName+ "')]/../following-sibling::td//a/span");
		waitForPageLoad(driver);
	}
	
	public void unPublishArticle(String articleTitle){
		clickTableCell(driver, "//a[contains(text(),'"+ articleTitle+ "')]/../following-sibling::td//a/span");
		waitForPageLoad(driver);
	}
	
	public void archiveArticle(String articleTitle){
		clickTableCell(driver, "//a[contains(text(),'"+ articleTitle+ "')]/../preceding-sibling::td/input");
		click(driver,archiveSpan);
		waitForPageLoad(driver);
	}
	
	public boolean checkArticleManagerPageMessage(String expectedMessage){
		boolean messageExist = driver.getPageSource().contains(expectedMessage);
		return messageExist;
	}
	
	public String getArticleState(String articleTitle){
		WebElement status = driver.findElement(By.xpath("//a[contains(text(),'"+ articleTitle+ "')]/../following-sibling::td//a/span"));
		String actualStatus = status.getAttribute("class");
		return actualStatus;
	}
	
	public void deleteAllArticles(){
		click(driver,checkAllArticlesCheckbox);
		click(driver,trashSpan);
		waitForPageLoad(driver);
	}
	
	private String filterTextbox = "//input[@id='filter_search']";
	private String searchButton = "//button[@class='btn']";
	private String authorDropdown = "//select[@name='filter_author_id']";
	private String displayNumberDropdown = "//select[@id='limit']";
	private String statusDropdown = "//select[@name='filter_published']";
	private String checkAllArticlesCheckbox = "//input[@title='Check All']";
	private String trashSpan = "//span[@class='icon-32-trash']";
	private String archiveSpan = "//span[@class='icon-32-archive']";
}
