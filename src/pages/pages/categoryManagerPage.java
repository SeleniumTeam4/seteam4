package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import commonActions.commonActions;

public class categoryManagerPage extends commonActions {
	WebDriver driver;
	public categoryManagerPage(WebDriver driver){
		this.driver = driver;
	}
	
		public categoryContentPage goTocategoryContentPage(String categoryTitle, String type){
		if (type == "new"){
			click(driver,newSpan);
		}
		
		if (type=="edit"){
			clickTableCell(driver, String.format("//a[contains(text(),'%s')]/../preceding-sibling::td/input", categoryTitle));
			click(driver,editSpan);
		}
		
		waitForPageLoad(driver);
		return pageFactory.getContentCategoryPage(driver);
	}

	public void	checkCategoryExist(String CatName){
		By categoryName = By.xpath(String.format("//a[contains(text(),'%s')]", CatName));
		verifyElementExist(categoryName);		
	}
	
	public void selectCategoryRow(String CatName){
		By catCheckboxXpath = By.xpath(String.format("//td[following-sibling::td[contains(.,'%s')]]/input[@type='checkbox']",CatName));
		WebElement catCheckbox = driver.findElement(catCheckboxXpath);
		catCheckbox.click();
	}
	
	public void publishCategory(String CatName){
		filterCategoryByTextbox(CatName);
		selectCategoryRow(CatName);
		click(driver, publishButton);		
	}
	
	public void unPublishCategory(String CatName){
		filterCategoryByTextbox(CatName);
		selectCategoryRow(CatName);
		click(driver, unPublishButton);		
	}
	
	public void archiveCategory(String CatName){
		filterCategoryByTextbox(CatName);
		selectCategoryRow(CatName);
		click(driver, archiverButton);		
	}
	
	public void deleteCategory(String CatName){
		filterCategoryByTextbox(CatName);
		selectCategoryRow(CatName);
		click(driver, trashButton);		
	}
	
	public void resetFilterDropdown(){
		waitForControl(driver, filterTextbox);
		select(driver, lelvelCombobox, "- Select Max Levels -");
		select(driver, statusCombobox, "- Select Status -");
		select(driver, accessCombobox, "- Select Access -");
		select(driver, languageCombobox, "- Select Language -");
	}
	
	public void filterCategoryByTextbox (String CatName){
		waitForControl(driver, filterTextbox);
		click(driver,clearButton);
		type(driver, filterTextbox, CatName);
		click(driver, searchButton);
		waitForControl(driver, mainTable);
	}
	
	public void filterCategoryByDropdown(String maxLevel, String status, String access, String language){
		resetFilterDropdown();
		if (maxLevel!=null) {
			select(driver, lelvelCombobox, maxLevel);
		}
		if (status!=null) {
			select(driver, statusCombobox, status);
		}
		if (access!=null) {
			select(driver, accessCombobox, access);
		}
		if (language!=null) {
			select(driver, languageCombobox, language);
		}
	}
	
	public void searchCategory(String catName, String maxLevel, String status, String access, String language){
		if (catName != null) {
			filterCategoryByTextbox(catName);
		}
		filterCategoryByDropdown(maxLevel, status, access, language);
	}
	
//	public String getCategoryStatus(String CatName){
//		By catStatusXpath = By.xpath("//td[preceding-sibling::td[contains(.,'"+CatName+"')]]//span[@class='text']");
//		WebElement catStatus = driver.findElement(catStatusXpath);
//		String returnStatus = catStatus.getText();
//		return returnStatus;
//		
//	}
	
	public void checkCategoryStatus(String CatName, String expectedStatus){
		By catStatusXpath = By.xpath("//td[preceding-sibling::td[contains(.,'"+CatName+"')]]//span[.='"+expectedStatus+"']");
		verifyElementExist(catStatusXpath);
	}
	
	//Interface content.
	private String mainTable = "//form[@id='adminForm']/table/tbody";
	private String searchButton = "//button[.='Search']";
	private String clearButton = "//button[.='Clear']";
	private String filterTextbox = "//input[@id='filter_search']";
	private String newSpan = "//span[@class='icon-32-new']";
	private String editSpan = "//span[@class='icon-32-edit']";
	private String publishButton = "//span[contains(@class,'-publish')]";
	private String unPublishButton = "//span[contains(@class,'-unpublish')]";	
	private String archiverButton = "//span[contains(@class,'-archive')]";	
	private String trashButton = "//span[contains(@class,'-trash')]";	
	private String lelvelCombobox = "//select[@name='filter_level']";
	private String statusCombobox = "//select[@name='filter_published']";
	private String accessCombobox = "//select[@name='filter_access']";
	private String languageCombobox = "//select[@name='filter_language']";
	
}
