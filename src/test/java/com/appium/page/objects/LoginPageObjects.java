package com.appium.page.objects;


import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class LoginPageObjects {

	@AndroidFindBy(id = "com.rjil.cloud.tej:id/login_username")
	@iOSFindBy(id = "jioid_textfield")
	public MobileElement username;

	@AndroidFindBy(id = "com.rjil.cloud.tej:id/login_password")
	@iOSFindBy(id = "pwd_textfield")
	public MobileElement password;

	@AndroidFindBy(id = "com.rjil.cloud.tej:id/btn_login")
	@iOSFindBy(id = "SignIn_Button")
	public MobileElement signIn_Btn;

	@AndroidFindBy(id = "org.wordpress.android:id/nux_url")
	@iOSFindBy(xpath = ".//*[@value='Site Address (URL)']")
	public MobileElement server_url;
	
	@AndroidFindBy(id = "org.wordpress.android:id/nux_url")
	@iOSFindBy(id = "return")
	public MobileElement return_keyboard;

	@AndroidFindBy(xpath = ".//*[@text='Sign in']")
	@iOSFindBy(id = "tutorial_login_Btn")
	public MobileElement tutorial_login_Btn;
	
	@AndroidFindBy(xpath = "")
	@iOSFindBy(id = "wifinetworkOnlyCell")
	public MobileElement wifinetworkOnly_Txt;
	
	@AndroidFindBy(xpath = "")
	@iOSFindBy(id = "wifiandcellularnetworkCell")
	public MobileElement wifiandcellularnetwork_Txt;
	
	@AndroidFindBy(xpath = "")
	@iOSFindBy(id = "Set up JioCloud")
	public MobileElement SetupJioCloud_Txt;
	
	@AndroidFindBy(xpath = "")
	@iOSFindBy(id = "Continue")
	public MobileElement contiue_Btn;
	
	@iOSFindBy(id = "identifierProfileIcon")
	public MobileElement Profile_Image_Button;
	
	@iOSFindBy(id = "OK")
	public MobileElement OkBtn;
	
	@iOSFindBy(id = "Jio Login")
	public MobileElement JioLoginErrorHead;
	
	@iOSFindBy(id = "Username or password you entered is incorrect.")
	public MobileElement JioLoginErrorMsg;
		
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[2]/UIATableView[1]/UIATableCell[2]")
	public MobileElement Settings_Screen;
	

	public MobileElement getOkBtn() {
		return OkBtn;
	}

	public MobileElement getJioLoginErrorHead() {
		return JioLoginErrorHead;
	}

	public MobileElement getJioLoginErrorMsg() {
		return JioLoginErrorMsg;
	}

	public MobileElement getUsername() {
		return username;
	}

	public MobileElement getPassword() {
		return password;
	}
	public MobileElement getSignIn_Btn() {
		return signIn_Btn;
	}

	public MobileElement getServer_url() {
		return server_url;
	}

	public MobileElement getReturn_keyboard() {
		return return_keyboard;
	}

	public MobileElement getTutorial_login_Btn() {
		return tutorial_login_Btn;
	}

	public MobileElement getWifinetworkOnly_Txt() {
		return wifinetworkOnly_Txt;
	}

	public MobileElement getWifiandcellularnetwork_Txt() {
		return wifiandcellularnetwork_Txt;
	}

	public MobileElement getSetupJioCloud_Txt() {
		return SetupJioCloud_Txt;
	}

	public MobileElement getContiue_Btn() {
		return contiue_Btn;
	}

	public MobileElement getProfile_Image_Button() {
		return Profile_Image_Button;
	}

	public MobileElement getSettings_Screen() {
		return Settings_Screen;
	}

}
