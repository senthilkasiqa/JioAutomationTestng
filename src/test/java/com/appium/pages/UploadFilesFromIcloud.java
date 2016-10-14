package com.appium.pages;

import java.util.logging.Logger;

import org.openqa.selenium.support.PageFactory;

import com.appium.config.CommonAppiumTest;
import com.appium.config.DeviceInterface;
import com.appium.config.ViewFactory;
import com.appium.page.objects.UploadFilesFromIcloudPageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class UploadFilesFromIcloud extends CommonAppiumTest {
	
	public ViewFactory viewFactory = new ViewFactory(driver);

	static Logger log = Logger.getLogger(MyFilesPage.class.getName());

	public DeviceInterface runnerInfo;
	UploadFilesFromIcloudPageObject uploadFilesFromIcloudPageObject = new UploadFilesFromIcloudPageObject();

	public void waitForHomePageToLoad() {
		waitForElement(uploadFilesFromIcloudPageObject.getHome_Page());
	}
	
	public UploadFilesFromIcloud(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), uploadFilesFromIcloudPageObject);
		runnerInfo = viewFactory.getMobilePlatform(driver.toString().split(":")[0].toString());
	}

	public UploadFilesFromIcloud UploadFilesIcloud() {
		runnerInfo.uploadFilesIcloud(this);
		return new UploadFilesFromIcloud(driver);
	}
	
	public void uploadFileFromCamera(String value){
		if (verifyPresent(uploadFilesFromIcloudPageObject.getUploadAddBtn())) {
			uploadFilesFromIcloudPageObject.getUploadAddBtn().click();
			uploadFilesFromIcloudPageObject.getCameraBtn().click();
			uploadFilesFromIcloudPageObject.getCameraCaptureBtn().click();
			verifyPresent(uploadFilesFromIcloudPageObject.getUsePhotoBtn());
			uploadFilesFromIcloudPageObject.getUsePhotoBtn().click();
			waitForPresent(uploadFilesFromIcloudPageObject.getUploadSuccessTxt(), 3000);
			verifyText(uploadFilesFromIcloudPageObject.getUploadSuccessTxt(), value);
		}
	}
	
	public void uploadOtherFiles(){
		
		if (verifyPresent(uploadFilesFromIcloudPageObject.getUploadAddBtn())) {
			uploadFilesFromIcloudPageObject.getUploadAddBtn().click();
			uploadFilesFromIcloudPageObject.getOtherFilesOptn().click();
			verifyPresent(uploadFilesFromIcloudPageObject.getIcloudDriveBtn());
			uploadFilesFromIcloudPageObject.getIcloudDriveBtn().click();
			verifyPresent(uploadFilesFromIcloudPageObject.getIcloudDriveTxt());
		}
	}

	public void uploadFiles(String files, String fileNo) {

		if (files.equalsIgnoreCase("Documents")) {
			uploadFilesFromIcloudPageObject.getDocumentsFolder().click();
			verifyPresent(uploadFilesFromIcloudPageObject.getDocumentsTxt());
			if (fileNo.equalsIgnoreCase("One"))
				uploadFilesFromIcloudPageObject.getDocumentsFirstFile().click();
			else if (fileNo.equalsIgnoreCase("Two"))
				uploadFilesFromIcloudPageObject.getDocumentsSecondFile().click();
			else if (fileNo.equalsIgnoreCase("Three"))
				uploadFilesFromIcloudPageObject.getDocumentsThirdFile().click();
			else if (fileNo.equalsIgnoreCase("Four"))
				uploadFilesFromIcloudPageObject.getDocumentsFourthFile().click();
			else if (fileNo.equalsIgnoreCase("Five"))
				uploadFilesFromIcloudPageObject.getDocumentsFithFile().click();
			else if (fileNo.equalsIgnoreCase("Six"))
				uploadFilesFromIcloudPageObject.getDocumentsSixthFile().click();
			else if (fileNo.equalsIgnoreCase("Seven"))
				uploadFilesFromIcloudPageObject.getDocumentsSeventhFile().click();
			else
				uploadFilesFromIcloudPageObject.getDocumentsSecondFile().click();
		} else if (files.equalsIgnoreCase("Photos")) {
			uploadFilesFromIcloudPageObject.getPhotosFolder().click();
			verifyPresent(uploadFilesFromIcloudPageObject.getPhotosTxt());
			if (fileNo.equalsIgnoreCase("Third"))
				uploadFilesFromIcloudPageObject.getPhotosThirdFile().click();
			else if (fileNo.equalsIgnoreCase("Fourth"))
				uploadFilesFromIcloudPageObject.getPhotosFourthFile().click();
			else if (fileNo.equalsIgnoreCase("Fith"))
				uploadFilesFromIcloudPageObject.getPhotosFithFile().click();
		} else if (files.equalsIgnoreCase("MaxFile")) {
			uploadFilesFromIcloudPageObject.getMaxSizeFolder().click();
			verifyPresent(uploadFilesFromIcloudPageObject.getMaxSizeFileTxt());
			if (fileNo.equalsIgnoreCase("One")){
				uploadFilesFromIcloudPageObject.getMaxFirstFile().click();
				pause(500);
			}
			else if (fileNo.equalsIgnoreCase("Two"))
				uploadFilesFromIcloudPageObject.getMaxSecondFile().click();
			else if (fileNo.equalsIgnoreCase("Three"))
				uploadFilesFromIcloudPageObject.getMaxThirdFile().click();

		} else if (files.equalsIgnoreCase("MinFile")) {
			uploadFilesFromIcloudPageObject.getMinSizeFolder().click();
			verifyPresent(uploadFilesFromIcloudPageObject.getMinSizeFileTxt());
			if (fileNo.equalsIgnoreCase("One"))
				uploadFilesFromIcloudPageObject.getMinSizeFileFirstFile().click();

		} else if (files.equalsIgnoreCase("Musics")) {
			uploadFilesFromIcloudPageObject.getMusicsFolder().click();
			verifyPresent(uploadFilesFromIcloudPageObject.getMusicsTxt());
			if (fileNo.equalsIgnoreCase("One"))
				uploadFilesFromIcloudPageObject.getMusicsFirstFile().click();
			else if (fileNo.equalsIgnoreCase("Two"))
				uploadFilesFromIcloudPageObject.getMusicsSecondFile().click();
			else if (fileNo.equalsIgnoreCase("Three"))
				uploadFilesFromIcloudPageObject.getMusicsThirdFile().click();
			else if (fileNo.equalsIgnoreCase("Four"))
				uploadFilesFromIcloudPageObject.getMusicsFourthFile().click();
			else
				uploadFilesFromIcloudPageObject.getMusicsFirstFile().click();
		}

		else if (files.equalsIgnoreCase("Videos")) {
			uploadFilesFromIcloudPageObject.getVideosFolder().click();
			verifyPresent(uploadFilesFromIcloudPageObject.getVideosTxt());
			if (fileNo.equalsIgnoreCase("One"))
				uploadFilesFromIcloudPageObject.getVideosFirstFile().click();
			else if (fileNo.equalsIgnoreCase("Two"))
				uploadFilesFromIcloudPageObject.getVideosSecondFile().click();
			else if (fileNo.equalsIgnoreCase("Three"))
				uploadFilesFromIcloudPageObject.getVideosThirdFile().click();
			else if (fileNo.equalsIgnoreCase("Four"))
				uploadFilesFromIcloudPageObject.getVideosFourthFile().click();
			else if (fileNo.equalsIgnoreCase("Fith"))
				uploadFilesFromIcloudPageObject.getVideosFithFile().click();
			else
				uploadFilesFromIcloudPageObject.getVideosFirstFile().click();
		}

		waitForHomePageToLoad();
	}
	
	public void verifyUploadFilesFromCamera(String value){
		uploadFilesFromIcloudPageObject.getPhotosBtn().click();
		verifyPresent(uploadFilesFromIcloudPageObject.getPhotosTxt());
		uploadFileFromCamera(value);
		
	}

}
