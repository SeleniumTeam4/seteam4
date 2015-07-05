package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import commonActions.commonActions;

public class articleManagerArticlePage extends commonActions {
	WebDriver driver;
	public articleManagerArticlePage(WebDriver driver){
		this.driver = driver;
	}
	
	public joomlaHelpPage goToJoomlaHelpPage(){
		click(driver,helpSpan);
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		return pageFactory.getJoomlaHelpPage(driver);
	}
	
	public void searchArticle(String articleTitle, String author, String displayNumber){
		waitForControl(driver, filterTextbox);
		select(driver, authorDropdown, author);
		select(driver, displayNumberDropdown, displayNumber);
		click(driver,clearButton);
		type(driver, filterTextbox, articleTitle);
		click(driver, searchButton);
		waitForControl(driver, articleTable);
	}
	
	public void searchArticleByStatus(String articleStatus){
		select(driver, statusDropdown, articleStatus);
		waitForPageLoad(driver);
	}
	
	public void searchArticleByCategory(String category){
		select(driver, categoryDropdown, category);
		waitForPageLoad(driver);
	}
	
	public void searchArticleByAccess(String access){
		select(driver, accessDropdown, access);
		waitForPageLoad(driver);
	}
	
	public boolean checkArticleExists(String articleTitle){
		
		WebElement articleExist = driver.findElement(By.xpath(String.format("//a[contains(text(),'%s')]", articleTitle)));
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
	
	public void publishArticle(String articleName, String use){
		if (use == "toolbar"){
			clickTableCell(driver, String.format("//a[contains(text(),'%s')]/../preceding-sibling::td/input", articleName));
			click(driver,publishIcon);
		}
		
		if (use == "status column") {
			clickTableCell(driver,String.format("//a[contains(text(),'%s')]/../following-sibling::td//a/span", articleName));
		}	
		waitForPageLoad(driver);
	}
	
	public void unPublishArticle(String articleTitle, String use){
		if (use == "toolbar"){
			clickTableCell(driver, String.format("//a[contains(text(),'%s')]/../preceding-sibling::td/input", articleTitle));
			click(driver,unPublishIcon);	
		}
		if (use == "status column") {
			clickTableCell(driver, String.format("//a[contains(text(),'%s')]/../following-sibling::td//a/span", articleTitle));
		}
		waitForPageLoad(driver);
	}
	
	public void archiveArticle(String articleTitle){
		clickTableCell(driver, String.format("//a[contains(text(),'%s')]/../preceding-sibling::td/input", articleTitle));
		click(driver,archiveSpan);
		waitForPageLoad(driver);
	}
	
	public boolean checkArticleManagerPageMessage(String expectedMessage){
		boolean messageExist = driver.getPageSource().contains(expectedMessage);
		return messageExist;
	}
	
	public String getArticleState(String articleTitle){
		WebElement status = driver.findElement(By.xpath(String.format("//a[contains(text(),'%s')]/../following-sibling::td//a/span", articleTitle)));
		String actualStatus = status.getAttribute("class");
		return actualStatus;
	}
	
	public void deleteArticle(String articleTitle){
		clickTableCell(driver, String.format("//a[contains(text(),'%s')]/../preceding-sibling::td/input", articleTitle));
		click(driver,trashSpan);
		waitForPageLoad(driver);
	}
	
	public void deleteAllArticles(){
		click(driver,checkAllArticlesCheckbox);
		click(driver,trashSpan);
		waitForPageLoad(driver);
	}
	
	//private String articleTitleLink = String.format("//a[contains(text(),'%s')]/../preceding-sibling::td/input", articleTitle) 
	private String articleTable = "//form[@id='adminForm']/table/tbody";
	private String filterTextbox = "//input[@id='filter_search']";
	private String searchButton = "//button[@class='btn']";
	private String clearButton = "//button[@type='button']";
	private String authorDropdown = "//select[@name='filter_author_id']";
	private String displayNumberDropdown = "//select[@id='limit']";
	private String statusDropdown = "//select[@name='filter_published']";
	private String checkAllArticlesCheckbox = "//input[@title='Check All']";
	private String trashSpan = "//span[@class='icon-32-trash']";
	private String archiveSpan = "//span[@class='icon-32-archive']";
	private String helpSpan = "//span[@class='icon-32-help']";
	private String categoryDropdown = "//select[@name='filter_category_id']";
	private String accessDropdown = "//select[@name='filter_access']";
	private String publishIcon = "//span[@class='icon-32-publish']";
	private String unPublishIcon = "//span[@class='icon-32-unpublish']";
}
