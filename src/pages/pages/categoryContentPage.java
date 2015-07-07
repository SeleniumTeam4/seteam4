package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import commonActions.commonActions;

public class categoryContentPage extends commonActions {
	WebDriver driver;
	public categoryContentPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void addCategoryContent(String title, String description,String statusType,String access,String parent){
		waitForControl(driver, titleTextbox);
		type(driver,titleTextbox,title);
		if (statusType != null) {
			select(driver, statusDropDown, statusType);
		}
		if (access != null) {
			select(driver, accessDropdown, access);
		}
		if (parent != null){
		select(driver,parentDropdown,parent);
		}
		if (description != null) {
			driver.findElement(By.xpath(toggleEditorLink)).click();
			type(driver,aritleContentTextbox,description);
		}
	}
	
	public categoryManagerPage clickSaveAndCloseButton(){
		waitForControl(driver, saveAndCloseButton);
		driver.findElement(By.xpath(saveAndCloseButton)).click();
		return pageFactory.getcategoryManagerPage(driver);
	}
	
	public categoryManagerPage clickSaveButton(){
		waitForControl(driver, saveButton);
		driver.findElement(By.xpath(saveButton)).click();
		return pageFactory.getcategoryManagerPage(driver);
	}
	
	private String titleTextbox = "//input[@id='jform_title']";
	private String aritleContentTextbox = "//textarea[@id='jform_description']";
	private String toggleEditorLink = "//a[@title='Toggle editor']";
	private String saveAndCloseButton = "//span[contains(@class,'-save')]";
	private String saveButton = "//span[contains(@class,'-apply')]";
	private String statusDropDown = "//select[@id='jform_published']";
	private String accessDropdown = "//select[@id='jform_access']";
	private String parentDropdown = "//select[@id='jform_parent_id']";
	
	

}
