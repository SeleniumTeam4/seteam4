package pages;

import org.openqa.selenium.WebDriver;

import commonActions.commonActions;


public class loginPage extends commonActions{
	
	WebDriver driver;
	public loginPage(WebDriver driver){
		this.driver = driver;
	}
	
	public absPage login(String user, String pass){
		waitForControl(driver, userNameTextbox);
		type(driver, userNameTextbox, user);
		type(driver, passwordTextbox, pass);
		click(driver, loginButton);
		return pageFactory.getAbsPage(driver);
	}
		
	private String userNameTextbox = "//input[@id='mod-login-username']";
	private String passwordTextbox = "//input[@id='mod-login-password']";
	private String loginButton = "//a[contains(text(),'Log in')]";
}
