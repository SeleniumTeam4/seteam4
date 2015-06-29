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
	
	public void searchArticle(String articleTitle, String author, String displayNumber){
		waitForControl(driver, filterTextbox);
		select(driver, authorDropdown, author);
		select(driver, displayNumberDropdown, displayNumber);
		type(driver, filterTextbox, articleTitle);
		click(driver, searchButton);
		waitForControl(driver, "//form[@id='adminForm']/table/tbody");
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
	
	public String getArticleState(String articleTitle){
		WebElement status = driver.findElement(By.xpath("//a[contains(text(),'"+ articleTitle+ "')]/../following-sibling::td//a/span"));
		String actualStatus = status.getAttribute("class");
		return actualStatus;
	}
	
	private String filterTextbox = "//input[@id='filter_search']";
	private String searchButton = "//button[@class='btn']";
	private String authorDropdown = "//select[@name='filter_author_id']";
	private String displayNumberDropdown = "//select[@id='limit']";
	private String statusDropdown = "//select[@name='filter_published']";
	//private String articleSavedMessage = "//li[text()='Article successfully saved']";
}
