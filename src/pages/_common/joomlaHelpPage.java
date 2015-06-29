package _common;

import org.openqa.selenium.WebDriver;

public class joomlaHelpPage extends _common.absPage {
	WebDriver driver;
	public joomlaHelpPage(WebDriver driver){
		this.driver = driver;
	}
	
	public String getPageTitle(){
		String title = driver.getTitle();
		return title;
	}
}
