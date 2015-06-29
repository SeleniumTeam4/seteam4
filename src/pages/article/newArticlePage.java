package article;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import _common.pageFactory;

public class newArticlePage extends _common.absPage {
	WebDriver driver;
	public newArticlePage(WebDriver driver){
		this.driver = driver;
	}
	
	public void createNewArticle(String articleTitle, String articleContent){
		waitForControl(driver, titleTextbox);
		type(driver,titleTextbox,articleTitle);
		driver.findElement(By.xpath(toggleEditorLink)).click();
		type(driver,aritleContentTextbox,articleContent);
		driver.switchTo().defaultContent();
	}
	
	public articleManagerArticle clickSaveAndCloseButton(){
		waitForControl(driver, saveAndCloseButton);
		driver.findElement(By.xpath(saveAndCloseButton)).click();
		return pageFactory.getArticleManagerArticlePage(driver);
	}
	
	private String titleTextbox = "//input[@id='jform_title']";
	private String aritleContentTextbox = "//textarea[@id='jform_articletext']";
	private String toggleEditorLink = "//a[@title='Toggle editor']";
	private String saveAndCloseButton = "//span[@class ='icon-32-save']";
}
