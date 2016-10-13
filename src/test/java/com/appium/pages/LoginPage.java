package com.appium.pages;

import org.openqa.selenium.support.PageFactory;

import com.annotation.values.PageName;
import com.appium.config.CommonAppiumTest;
import com.appium.config.DeviceInterface;
import com.appium.config.ViewFactory;
import com.appium.page.objects.LoginPageObjects;
import com.jio.common.utilities.PropertyHandler;

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

	public void tapLoginButton() {
		loginPageObjects.getTutorial_login_Btn().click();
	}

	public boolean presentErrorMessage() {

		return loginPageObjects.getJioLoginErrorMsg() != null;
	}

	public String validateErrorMessage() {
		return loginPageObjects.getJioLoginErrorMsg().getText();
	}

	public void invalidLogin(String user, String pass) {
		tapLoginButton();
		enterUserAndPassword(user, pass);
		signInBtn();
		String expectedResults = validateErrorMessage();
		verifyText(loginPageObjects.getJioLoginErrorMsg(), expectedResults);
		loginPageObjects.getOkBtn().click();
	}

	public void firstTutorialPage() {
		waitForPageToLoad(loginPageObjects.getTutorial_login_Btn());
		verifyText(loginPageObjects.getJioLoginTutorialFirstHead(),
				PropertyHandler.getKeyValues("iosuimessage.properties", "JIOLOGIN_FIRST_HEAD_MSG"));
	}

	public void SecondTutorialPage() {
		swipeDirection(SWIPE_DIRECTION_CUSTOM.LEFT);
		verifyText(loginPageObjects.getJioLoginTutorialFirstHead(),
				PropertyHandler.getKeyValues("iosuimessage.properties", "JIOLOGIN_FIRST_HEAD_MSG"));
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

	public boolean swipeTillElementPresent(MobileElement element, int retry, SWIPE_DIRECTION_CUSTOM swipe) {
		boolean flagPresent = false;
		int i = 0;
		while (i < retry) {
			swipeDirection(swipe);

			if (!element.isDisplayed() && !element.isEnabled()) {
				i++;
				continue;
			} else if (element.isDisplayed() && element.isEnabled()) {
				return true;
			}
		}
		return flagPresent;
	}

	public void VerifyOnLoginTutorialPageUI() {
		MobileElement[] arrLoginTutorialPageTitles = { loginPageObjects.getJioLoginTutorialFirstHead(),
				loginPageObjects.getJioLoginTutorialSecondHead(), loginPageObjects.getJioLoginTutorialThirdHead() };
		MobileElement[] arrLoginTutorialPageContents = { loginPageObjects.getJioLoginTutorialFirstMsg(),
				loginPageObjects.getJioLoginTutorialSecondMsg(), loginPageObjects.getJioLoginTutorialThirdMsg() };
		int totalOnboardingScreen = 3;

		for (int i = 0; i < totalOnboardingScreen; i++) {

			String expectedTitleText = PropertyHandler.getKeyValues("iosuimessage.properties",
					"JIOLOGIN_CONTENT_HEAD_MSG_" + (i + 1));
			String actualTitleText = arrLoginTutorialPageTitles[i].getText().replaceAll("[\\t\\n\\r]", "");

			verifyTrue(expectedTitleText.compareTo(actualTitleText) == 0,
					"\"" + expectedTitleText + "\" Title Is Displayed For LoginTutorial Page",
					"Expected Title :: \"" + expectedTitleText + "\" :: Actual Title :: \"" + actualTitleText + "\"");

			String expectedContentText = PropertyHandler.getKeyValues("iosuimessage.properties",
					"JIOLOGIN_CONTENT_DETAILS_MSG_" + (i + 1));
			String actualContentText = arrLoginTutorialPageContents[i].getText().replaceAll("[\\t\\n\\r]", "");
			verifyTrue(expectedContentText.compareTo(actualContentText) == 0,
					"\"" + expectedContentText + "\" Content Is Displayed For LoginTutorial Page",
					"Expected Content :: \"" + expectedContentText + "\" :: Actual Content :: \"" + actualContentText
							+ "\"");
			if (i < totalOnboardingScreen - 1)
				swipeTillElementPresent(arrLoginTutorialPageTitles[i + 1], 3, SWIPE_DIRECTION_CUSTOM.LEFT);
		}
	}

}
