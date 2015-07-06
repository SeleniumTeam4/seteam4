package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import commonActions.commonActions;

public class newContactPage extends commonActions {
	WebDriver driver;
	public newContactPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void createNewContact(String contactTitle, String contactCategory){
		waitForControl(driver, titleTextbox);
		type(driver,titleTextbox,contactTitle);
		select(driver, categoryDropDown, contactCategory);
	}

	public contactManagerPage clickSaveAndCloseButton(){
		waitForControl(driver, saveAndCloseButton);
		driver.findElement(By.xpath(saveAndCloseButton)).click();
		return pageFactory.getContactManagerPage(driver);
	}
	
	public void editContact(String newTitle, String newCategory, String statusType){
		waitForControl(driver, titleTextbox);
		driver.findElement(By.xpath(titleTextbox)).clear();
		type(driver,titleTextbox,newTitle);
		select(driver, categoryDropDown, newCategory);
		select(driver, statusDropDown, statusType);
	}
	
	private String titleTextbox = "//input[@id='jform_name']";
	private String saveAndCloseButton = "//span[@class ='icon-32-save']";
	private String statusDropDown = "//select[@id='jform_published']";
	private String categoryDropDown = "//select[@id='jform_catid']";
}
