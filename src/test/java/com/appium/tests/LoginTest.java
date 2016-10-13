package com.appium.tests;

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

	// @Test(priority = 2)
	// public void loginWithValidUser() throws InterruptedException {
	// loginPage = new LoginPage(driver);
	// credentials = new
	// UserCredentials(PropertyHandler.getKeyValues("ios.properties","username"),
	// PropertyHandler.getKeyValues("ios.properties","password"));
	// loginPage.enterValidCredentails(credentials.get_username(),
	// credentials.get_password());
	// }
	//
	// @Test(priority = 1)
	// public void loginWithInValidUser() throws InterruptedException {
	// loginPage = new LoginPage(driver);
	// credentials = new
	// UserCredentials(PropertyHandler.getKeyValues("ios.properties","username"),
	// PropertyHandler.getKeyValues("ios.properties","invalidpassword"));
	// loginPage.invalidLogin(credentials.get_username(),
	// credentials.get_password());
	// }
	//
	// @Test(priority = 3)
	// public void myFilePageTest() throws InterruptedException {
	// myFilesPage = new MyFilesPage(driver);
	// myFilesPage.verifycountFiles();
	// }
//	@Test(priority = 3)
//	public void myFilePageTest() throws InterruptedException {
//		UploadFilesFromIcloud uploadFilesFromIcloud = new UploadFilesFromIcloud(driver);
//		uploadFilesFromIcloud.UploadFilesIcloud();
//		uploadFilesFromIcloud.uploadOtherFiles();
//		uploadFilesFromIcloud.uploadFiles(PropertyHandler.getKeyValues("configuration.properties", "MaxFileSize"),
//				PropertyHandler.getKeyValues("configuration.properties", "fileNo2"));
//	}

	 @Test(priority = 5)
	 public void verifyCreateFolderFunction() throws InterruptedException {
	 myFilesPage = new MyFilesPage(driver); 
      myFilesPage.verifyFolderName();
	// myFilesPage.verifyCreateFolderFunction(PropertyHandler.getKeyValues("iosuimessage.properties", "DELETE_POPUP_MSG"));
	 }

}
