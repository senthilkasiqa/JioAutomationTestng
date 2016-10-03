package com.appium.screen.flows;

import com.appium.config.CommonAppiumTest;
import com.appium.config.DeviceInterface;
import com.appium.pages.LoginPage;
import com.appium.pages.MyFilesPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class AndroidFlow extends CommonAppiumTest implements DeviceInterface {

    public AndroidFlow(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public void login(LoginPage loginPage, String username, String password) {
    	loginPage.tapLoginButton();
        loginPage.enterUserAndPassword(username, password);
        driver.hideKeyboard();
        loginPage.signInBtn();
        loginPage.clickContinueBtn();
    }

	public void homePage(MyFilesPage myFilesPage) {
		// TODO Auto-generated method stub
		
	}

}
