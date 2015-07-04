package pages;

import org.openqa.selenium.WebDriver;

import commonActions.commonActions;

public class joomlaHelpPage extends commonActions {
	WebDriver driver;
	public joomlaHelpPage(WebDriver driver){
		this.driver = driver;
	}
	
	public String getPageTitle(){
		String title = driver.getTitle();
		return title;
	}
	
	public absPage returnMainPage(){
		driver.switchTo().defaultContent();
		return pageFactory.getAbsPage(driver);
	}
}
