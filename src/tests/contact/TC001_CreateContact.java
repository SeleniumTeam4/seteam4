package contact;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.absPage;
import pages.contactManagerPage;
import pages.browser;
import pages.loginPage;
import pages.newContactPage;
import pages.joomlaHelpPage;
import variables.commonVariables;

public class TC001_CreateContact {
	WebDriver driver;
	private loginPage objadminLogin = new loginPage(browser.getDriver());
	private absPage objAbsPage = new absPage(driver);
	private newContactPage objNewContactPage;
	private contactManagerPage objContactManagerPage;
//	private joomlaHelpPage objJoomlaHelpPage;
	String currentDate = objAbsPage.getCurrentDate();
	String articleTitle = "Selenium Team 4" + currentDate;
	String articleTitleUpdated = "Test Article 123" + currentDate;
	
	@BeforeClass
	public void beforeMethod(){
		browser.getDriver();
		browser.open(variables.commonVariables.initialPage);
				
	}
	
	@Test(description = "user can create new contact with valid information")
	public void TC001_createNewContact(){	
		objAbsPage = objadminLogin.login(commonVariables.userNameValid, commonVariables.passwordValid);
		objNewContactPage = objAbsPage.clickAddNewContact();		
		objNewContactPage.createNewContact(articleTitle, "- Sample Data-Contact");
		objContactManagerPage = objNewContactPage.clickSaveAndCloseButton();
		Assert.assertEquals(objContactManagerPage.checkContactSavedMessageAppear(), true, "Contact saved message appears");
		objContactManagerPage.searchContact(articleTitle);
		Assert.assertEquals(objContactManagerPage.checkContactExists(articleTitle), true, "Contact saved successfully");
	}
	
	@Test(description = "user can edit contact with valid information")
	public void TC002_editContact(){
		objNewContactPage = objContactManagerPage.openContact();
		objNewContactPage.editContact(articleTitleUpdated, "- - Park Site", "Unpublished");
		objContactManagerPage = objNewContactPage.clickSaveAndCloseButton();
		Assert.assertEquals(objContactManagerPage.checkContactSavedMessageAppear(), true, "Contact saved message appears");
		objContactManagerPage.searchContact(articleTitleUpdated);
		Assert.assertEquals(objContactManagerPage.checkContactExists(articleTitleUpdated), true, "Contact saved successfully");		
	}
	
	@Test(description = "user can publish contact")
	public void TC003_publishContact(){
		objContactManagerPage.publishContact();
		Assert.assertEquals(objContactManagerPage.checkContactPublishedMessageAppear(), true, "Contact published message appears");
		Assert.assertEquals(objContactManagerPage.getContactState(), "state publish", "Contact is published");
	}	
	
	@Test(description = "user can unpublish a published contact")
	public void TC004(){
		objContactManagerPage.unPublishContact();
		Assert.assertEquals(objContactManagerPage.checkContactUnPublishedMessageAppear(), true, "Contact unpublished message appears");
		Assert.assertEquals(objContactManagerPage.getContactState(), "state unpublish", "Contact is unpublished");
	}
	
	@Test(description = "user can archive contact")
	public void TC005(){
		objContactManagerPage.archiveContact();
		Assert.assertEquals(objContactManagerPage.checkContactManagerPageMessage("1 contact successfully archived"), true, "Contact archived successfully");
		objContactManagerPage.searchContactByStatus("Archived");
		Assert.assertEquals(objContactManagerPage.checkContactExists(articleTitleUpdated), true, "Contact archived successfully");
	}
	
	@Test(description = "user can trash contact")
	public void TC007(){
		objContactManagerPage.deleteContact();
		Assert.assertEquals(objContactManagerPage.checkContactManagerPageMessage("1 contact successfully trashed"), true, "Contact trashed message appears");
	}
	
//	@Test(description = "user can open help contact")
//	public void TC008(){
//		objContactManagerPage.goToJoomlaHelpPage();
//		String titleHelpPage = objJoomlaHelpPage.getPageTitle();
//		Assert.assertEquals(objContactManagerPage.checkContactManagerPageMessage("How to access"), true, "Help page appears");
//		driver.close();
//		objJoomlaHelpPage.returnMainPage();
//	}
	
	@Test(description = "user can search contact")
	public void TC009(){
	objContactManagerPage.searchContactByStatus("Trashed");
	objContactManagerPage.searchContact(articleTitleUpdated);
	Assert.assertEquals(objContactManagerPage.checkContactExists(articleTitleUpdated), true, "Contact exists in trash folder");
	}

	@Test(description = "user can search for contact using the filter dropdown lists")
	public void TC010(){
		objContactManagerPage.searchContactByCategory("- Park Site");
		objContactManagerPage.searchContactByStatus("Trashed");
		Assert.assertEquals(objContactManagerPage.checkContactExists(articleTitleUpdated), true, "Contact exists");
	}
	
	@AfterClass
	public void afterMethod(){
		driver = browser.getDriver();
		driver.manage().deleteAllCookies();
		//driver.quit();
	}
}
