package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import commonActions.commonActions;



public class articleContentPage extends commonActions {
	WebDriver driver;
	public articleContentPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void articleContent(String articleTitle, String articleContent){
		waitForControl(driver, titleTextbox);
		type(driver,titleTextbox,articleTitle);
		driver.findElement(By.xpath(toggleEditorLink)).click();
		type(driver,aritleContentTextbox,articleContent);
	}
	
	public void articleContent(String articleTitle, String articleContent,String statusType,String access,String category){
		waitForControl(driver, titleTextbox);
		type(driver,titleTextbox,articleTitle);
		select(driver, statusDropDown, statusType);
		select(driver, accessDropdown, access);
		if (category != null){
		select(driver,categoryDropdown,category);
		}
		driver.findElement(By.xpath(toggleEditorLink)).click();
		type(driver,aritleContentTextbox,articleContent);
	}
	
	public articleManagerArticlePage clickSaveAndCloseButton(){
		waitForControl(driver, saveAndCloseButton);
		driver.findElement(By.xpath(saveAndCloseButton)).click();
		return pageFactory.getArticleManagerArticlePage(driver);
	}
	
	private String titleTextbox = "//input[@id='jform_title']";
	private String aritleContentTextbox = "//textarea[@id='jform_articletext']";
	private String toggleEditorLink = "//a[@title='Toggle editor']";
	private String saveAndCloseButton = "//span[@class ='icon-32-save']";
	private String statusDropDown = "//select[@id='jform_state']";
	private String accessDropdown = "//select[@id='jform_access']";
	private String categoryDropdown = "//select[@id='jform_catid']";
	
}
