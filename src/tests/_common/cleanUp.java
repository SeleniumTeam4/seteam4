package _common;

import _common.browser;
import article.articleManagerArticlePage;
import article.newArticlePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import dataTest.commonVariables;

public class cleanUp {
	WebDriver driver;
	private loginPage objadminLogin = new loginPage(browser.getDriver());
	private absPage objAbsPage = new absPage();
	private homePage objhomepage;
	private newArticlePage objNewArticlePage;
	private articleManagerArticlePage objArticleManagerArticle;
	
	@Test
	public void closeAllActiveSession(){
		browser.getDriver();
		browser.open(dataTest.commonVariables.initialPage);
		objhomepage = objadminLogin.login(commonVariables.userNameValid, commonVariables.passwordValid);
		objArticleManagerArticle = objhomepage.goToArticleManagerArticlePage();
		objArticleManagerArticle.searchArticle(null,commonVariables.userNameValid, "All");
		objArticleManagerArticle.deleteAllArticles();
		browser.close();
				
	}
	
	
}
