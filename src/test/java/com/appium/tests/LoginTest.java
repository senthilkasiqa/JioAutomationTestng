package com.appium.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.appium.config.UserBaseTest;
import com.appium.config.UserCredentials;
import com.appium.pages.LoginPage;
import com.appium.pages.MyFilesPage;
import com.jio.common.utilities.PropertyHandler;

public class LoginTest extends UserBaseTest {

	LoginPage loginPage;
	UserCredentials credentials;
	MyFilesPage myFilesPage;

	@Test(priority = 2)
	public void loginWithValidUser() throws InterruptedException {
		loginPage = new LoginPage(driver);
		credentials = new UserCredentials(PropertyHandler.getKeyValues("ios.properties","username"),
				PropertyHandler.getKeyValues("ios.properties","password"));
		loginPage.enterValidCredentails(credentials.get_username(), credentials.get_password());
	}

	@Test(priority = 1)
	public void loginWithInValidUser() throws InterruptedException {
		loginPage = new LoginPage(driver);
		credentials = new UserCredentials(PropertyHandler.getKeyValues("ios.properties","username"),
				PropertyHandler.getKeyValues("ios.properties","invalidpassword"));
		loginPage.invalidLogin(credentials.get_username(), credentials.get_password());
	}

	@Test(priority = 3)
	public void myFilePageTest() throws InterruptedException {
		myFilesPage = new MyFilesPage(driver);
		myFilesPage.verifycountFiles();
	}

	@Test(priority = 4)
	public void uploadFiles() throws InterruptedException {
		myFilesPage = new MyFilesPage(driver);
		try {
			myFilesPage.uploadFiles(3);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
