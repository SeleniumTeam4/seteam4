package _common;

import java.util.concurrent.TimeUnit;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class absPage {
			
	public void waitForControl(WebDriver driver, String controlName){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement element = findElement(driver, controlName);
		
	}
	
	public void waitForPageLoad(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	public void click(WebDriver driver, String controlName){
		WebElement element = findElement(driver, controlName);
		element.click();
	}
	
	public void type(WebDriver driver, String controlName, String value){
		WebElement element = findElement(driver, controlName);
		element.sendKeys(value);
	}
	
	
	public WebElement findElement(WebDriver driver, String control){
		return driver.findElement(By.xpath(control));
	}
	
	public String getCurrentDate(){
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date = new Date();
		String date1= dateFormat.format(date);
		return date1;
	}
	 
}
