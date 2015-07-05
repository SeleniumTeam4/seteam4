package cleanup;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pages.absPage;
import pages.articleManagerArticlePage;
import pages.browser;
import pages.homePage;
import pages.loginPage;
import pages.articleContentPage;
import variables.commonVariables;


public class cleanUp {
	WebDriver driver;
	private loginPage objadminLogin = new loginPage(browser.getDriver());
	private absPage objAbsPage;
	private homePage objhomepage;
	private articleContentPage objNewArticlePage;
	private articleManagerArticlePage objArticleManagerArticle;
	
	@Test
	public void closeAllActiveSession(){
		browser.getDriver();
		browser.open(variables.commonVariables.initialPage);
		objAbsPage = objadminLogin.login(commonVariables.userNameValid, commonVariables.passwordValid);
		objArticleManagerArticle = objAbsPage.goToArticleManagerArticlePage();
		objArticleManagerArticle.searchArticle(null,commonVariables.userNameValid, "All");
		objArticleManagerArticle.deleteAllArticles();
		browser.close();
				
	}
	
	
}
