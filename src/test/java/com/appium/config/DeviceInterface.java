package com.appium.config;

import com.appium.pages.LoginPage;
import com.appium.pages.MyFilesPage;

public interface DeviceInterface {

	public void login(LoginPage loginPage, String username, String password);

	public void homePage(MyFilesPage myFilesPage);
}
