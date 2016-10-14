package com.appium.page.objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class LogOutPageObjects {

	@AndroidFindBy(id = "")
	@iOSFindBy(id = "More")
	public MobileElement MoreTab;
	
	@AndroidFindBy(id = "")
	@iOSFindBy(id = "r")
	public MobileElement SettingBtn;
	
	@AndroidFindBy(id = "")
	@iOSFindBy(id = "logout_btn")
	public MobileElement LogOutBtn;
	
	@AndroidFindBy(id = "")
	@iOSFindBy(id = "Yes")
	public MobileElement YesBtn;
	
	@AndroidFindBy(id = "")
	@iOSFindBy(id = "Manage")
	public MobileElement ManageBtn;
	
	@AndroidFindBy(id = "")
	@iOSFindBy(id = "Delete")
	public MobileElement DeleteBtn;

	public MobileElement getMoreTab() {
		return MoreTab;
	}

	public MobileElement getSettingBtn() {
		return SettingBtn;
	}

	public MobileElement getLogOutBtn() {
		return LogOutBtn;
	}

	public MobileElement getYesBtn() {
		return YesBtn;
	}

	public MobileElement getManageBtn() {
		return ManageBtn;
	}

	public MobileElement getDeleteBtn() {
		return DeleteBtn;
	}
	
	
	
	
	
	
	
}
