package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import commonActions.commonActions;

import pages.pageFactory;
import categoryManager.*;

public class homePage extends commonActions {
	WebDriver driver;
	public homePage(WebDriver driver){
		this.driver = driver;
	}
	
	public addNewCategoryPage clickAddNewCategory(){
		driver.findElement(By.xpath(categoryManagerLink)).click();
		return pageFactory.getNewCategory(driver);
	}
	
	//Interface lists:
	private String categoryManagerLink = "//a[.='Category Manager']";
	
}
