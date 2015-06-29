package _common;

import _common.browser;
import org.testng.annotations.Test;

public class cleanUp {
	browser browser = new browser();
	
	@Test
	public void closeAllActiveSession(){
		browser.getDriver();
		browser.close();
		
	}
	
	
}
