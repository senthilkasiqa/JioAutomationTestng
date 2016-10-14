package com.appium.pages;

import org.openqa.selenium.support.PageFactory;

import com.appium.config.CommonAppiumTest;
import com.appium.config.DeviceInterface;
import com.appium.config.ViewFactory;
import com.appium.page.objects.LogOutPageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LogOutPage extends CommonAppiumTest {
	
	public ViewFactory viewFactory = new ViewFactory(driver);
	public DeviceInterface runnerInfo;
	public LogOutPageObjects logOutPageObjects = new LogOutPageObjects();

	public LogOutPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), logOutPageObjects);
		runnerInfo = viewFactory.getMobilePlatform(driver.toString().split(":")[0].toString());
	}

	public LogOutPage logOutIdamAccount() {
		runnerInfo.logOut(this);
		return new LogOutPage(driver);
	}
	
	public void logOutFunction(){
		logOutPageObjects.getMoreTab().click();
		logOutPageObjects.getSettingBtn().click();
		scrollTo();
		logOutPageObjects.getLogOutBtn().click();
		logOutPageObjects.getYesBtn().click();
		logOutPageObjects.getManageBtn().click();
		logOutPageObjects.getDeleteBtn().click();
		logOutPageObjects.getDeleteBtn().click();
	}

}
