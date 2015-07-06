package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

	public void searchCategory (String title){
		waitForControl(driver, filterTextbox);
		click(driver,clearButton);
		type(driver, filterTextbox, title);
		click(driver, searchButton);
		waitForControl(driver, mainTable);
	}
	
	//Interface content.
	private String mainTable = "//form[@id='adminForm']/table/tbody";
	private String searchButton = "//button[@class='btn']";
	private String clearButton = "//button[@type='button']";
	private String filterTextbox = "//input[@id='filter_search']";
	private String newSpan = "//span[@class='icon-32-new']";
	private String editSpan = "//span[@class='icon-32-edit']";
	
}
