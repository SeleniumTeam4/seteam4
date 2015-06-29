package _common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class browser {
	public static final WebDriver driver = new FirefoxDriver();

	public static WebDriver getDriver()
	{
		return driver;
	}
	public static void open(String url)
	{
		driver.get(url);
		driver.manage().window().maximize();
	}
	public static void close()
	{
		driver.close();
	}
	
}
