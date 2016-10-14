package com.appium.screen.flows;

import java.util.logging.Logger;

import com.appium.config.CommonAppiumTest;
import com.appium.config.DeviceInterface;
import com.appium.page.objects.LoginPageObjects;
import com.appium.page.objects.MyFilesObjects;
import com.appium.pages.LogOutPage;
import com.appium.pages.LoginPage;
import com.appium.pages.MyFilesPage;
import com.appium.pages.UploadFilesFromIcloud;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class iOSFlow extends CommonAppiumTest implements DeviceInterface {
	
	static Logger log = Logger.getLogger(iOSFlow.class.getName());
	
	MyFilesObjects myFilesObjects=new MyFilesObjects();
	LoginPageObjects loginPageObjects=new LoginPageObjects();

	public iOSFlow(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	public void login(LoginPage loginPage, String username, String password) {
		loginPage.tapLoginButton();
		loginPage.enterUserAndPassword(username, password);
		loginPage.signInBtn();
	    loginPage.clickContinueBtn();
	}

	public void homePage(MyFilesPage myFilesPage) {
			myFilesPage.waitForHomePageToLoad();
			myFilesPage.verifyFileCount();
	
	}
	
	public void uploadFilesIcloud(UploadFilesFromIcloud uploadFilesFromIcloud) {
		uploadFilesFromIcloud.waitForHomePageToLoad();

}
	
	public void logOut(LogOutPage logOutPage){
		logOutPage.logOutFunction();
	}



  
}
