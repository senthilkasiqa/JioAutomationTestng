package com.appium.pages;

import org.openqa.selenium.support.PageFactory;

import com.annotation.values.PageName;
import com.appium.config.CommonAppiumTest;
import com.appium.config.DeviceInterface;
import com.appium.config.ViewFactory;
import com.appium.page.objects.LoginPageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

@PageName("Login Page")
public class LoginPage extends CommonAppiumTest {
    public ViewFactory viewFactory = new ViewFactory(driver);
    public DeviceInterface runnerInfo;
    public LoginPageObjects loginPageObjects = new LoginPageObjects();

    public LoginPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), loginPageObjects);
        runnerInfo = viewFactory.getMobilePlatform(driver.toString().split(":")[0].toString());
    }

    public MyFilesPage enterValidCredentails(String username, String password) {
        runnerInfo.login(this, username, password);
        return new MyFilesPage(driver);
    }
	public void tapLoginButton(){
		loginPageObjects.getTutorial_login_Btn().click();
	}

	  public boolean presentErrorMessage() {
		  
	        return loginPageObjects.getJioLoginErrorMsg() != null;
	    }
	  
    public String validateErrorMessage() {
        return loginPageObjects.getJioLoginErrorMsg().getText();
    }
    
    public void invalidLogin(String user, String pass){
    	tapLoginButton();
		enterUserAndPassword(user, pass);
		signInBtn();
    	String expectedResults =validateErrorMessage();
		verifyText(loginPageObjects.getJioLoginErrorMsg(), expectedResults);
		loginPageObjects.getOkBtn().click();
    }

    public boolean validateUserNameFieldIsDisplayed() {
        return loginPageObjects.username.isDisplayed();
    }

    public void enterUserAndPassword(String user, String pass) {
        // TODO Auto-generated method stub
    	waitForPageToLoad(loginPageObjects.getUsername());
		loginPageObjects.getUsername().click();
		loginPageObjects.getUsername().sendKeys(user);
		loginPageObjects.getReturn_keyboard().click();
		loginPageObjects.getPassword().click();
		loginPageObjects.getPassword().sendKeys(pass);
		loginPageObjects.getReturn_keyboard().click();
    }

    public void signInBtn() {
        loginPageObjects.getSignIn_Btn().click();
    }

    public void clickContinueBtn() {
      waitForPageToLoad(loginPageObjects.getContiue_Btn());
      loginPageObjects.getContiue_Btn().click();
    }

	public void waitForPageToLoad() {
		 waitForPageToLoad(loginPageObjects.getContiue_Btn());
	}

}
