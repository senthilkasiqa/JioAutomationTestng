package com.appium.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.appium.config.UserBaseTest;
import com.appium.config.UserCredentials;
import com.appium.pages.LogOutPage;
import com.appium.pages.LoginPage;
import com.appium.pages.MyFilesPage;
import com.appium.pages.UploadFilesFromIcloud;
import com.jio.common.utilities.PropertyHandler;

public class LoginTest extends UserBaseTest {

//	@Test(priority = 1)
//	public void loginWithInValidUser() throws InterruptedException {
//		LoginPage loginPage = new LoginPage(driver);
//		UserCredentials credentials = new UserCredentials(PropertyHandler.getKeyValues("ios.properties", "username"),
//				PropertyHandler.getKeyValues("ios.properties", "invalidpassword"));
//		loginPage.invalidLogin(credentials.get_username(), credentials.get_password());
//	}

	@Test(priority = 2)
	public void loginWithValidUser() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		UserCredentials credentials = new UserCredentials(PropertyHandler.getKeyValues("ios.properties", "username"),
				PropertyHandler.getKeyValues("ios.properties", "password"));
		loginPage.enterValidCredentails(credentials.get_username(), credentials.get_password());
	}
//
//	@Test(priority = 3)
//	public void verifycountFiles() throws InterruptedException {
//		MyFilesPage myFilesPage = new MyFilesPage(driver);
//		myFilesPage.verifycountFiles();
//	}

	@Test(priority = 4)
	public void uploadFiles() throws InterruptedException {
		UploadFilesFromIcloud uploadFilesFromIcloud = new UploadFilesFromIcloud(driver);
		uploadFilesFromIcloud.UploadFilesIcloud();
		uploadFilesFromIcloud.uploadOtherFiles();
		uploadFilesFromIcloud.uploadFiles(PropertyHandler.getKeyValues("configuration.properties", "MaxFileSize"),
				PropertyHandler.getKeyValues("configuration.properties", "fileNo2"));
	}

	@Test(priority = 5)
	public void verifyCreateFolderFunction() throws InterruptedException {
		MyFilesPage myFilesPage = new MyFilesPage(driver);
		myFilesPage.verifyCreateFolderFunction(
				PropertyHandler.getKeyValues("iosuimessage.properties", "DELETE_POPUP_MSG"));
	}

	@Test(priority = 6)
	public void verifyUploadFilesFromCamera() throws InterruptedException, IOException {
		UploadFilesFromIcloud uploadFilesFromIcloud = new UploadFilesFromIcloud(driver);
		uploadFilesFromIcloud.verifyUploadFilesFromCamera(
				PropertyHandler.getKeyValues("iosuimessage.properties", "UPLOAD_SUCCESSFULL_MSG"));
		MyFilesPage myfiles = new MyFilesPage(driver);
		myfiles.uploadFiles(3);
	}

	@Test(priority = 7)
	public void verifyLogoutPage() throws InterruptedException {
		LogOutPage logOutPage = new LogOutPage(driver);
		logOutPage.logOutIdamAccount();
	}

}
