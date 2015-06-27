package _common;

import org.openqa.selenium.WebDriver;


public class loginPage extends _common.absPage{
	
	WebDriver driver;
	public loginPage(WebDriver driver){
		this.driver = driver;
	}
	
	public homePage login(String user, String pass){
		waitForControl(driver, userNameTextbox);
		type(driver, userNameTextbox, user);
		type(driver, passwordTextbox, pass);
		click(driver, loginButton);
		return pageFactory.getHomePage(driver);
	}
		
	private String userNameTextbox = "//input[@id='mod-login-username']";
	private String passwordTextbox = "//input[@id='mod-login-password']";
	private String loginButton = "//a[contains(text(),'Log in')]";
}
