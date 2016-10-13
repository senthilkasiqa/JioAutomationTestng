package com.appium.pages;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.appium.config.CommonAppiumTest;
import com.appium.config.DeviceInterface;
import com.appium.config.ViewFactory;
import com.appium.page.objects.MyFilesObjects;
import com.jio.common.utilities.PropertyHandler;
import com.jio.common.utilities.StringUtility;
import com.jio.common.utilities.StringUtility.Mode;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MyFilesPage extends CommonAppiumTest {

	public ViewFactory viewFactory = new ViewFactory(driver);

	static Logger log = Logger.getLogger(MyFilesPage.class.getName());

	public DeviceInterface runnerInfo;
	MyFilesObjects myFilesObjects = new MyFilesObjects();

	public MyFilesPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), myFilesObjects);
		runnerInfo = viewFactory.getMobilePlatform(driver.toString().split(":")[0].toString());
	}

	public enum uploadMethod {
		DEVICECAMERA, ICLOUD, LOCAL;
	}

	public MyFilesPage verifycountFiles() {
		runnerInfo.homePage(this);
		return new MyFilesPage(driver);
	}

//	public List<MobileElement> getStateItems() {
//			return driver.findelements("")
//					);
//
//		}
	
	public MobileElement getFolderName(String name){
		return driver.findElementById(name);
	}

	public void waitForHomePageToLoad() {
		waitForElement(myFilesObjects.Home_Page);
	}

	public String verifyUserIsLoggedIn() {

		return myFilesObjects.getHome_Page().getText();
		
	}

	public void uploadFilesFromDifferentSource(uploadMethod upload, int photoSlectionRows)
			throws InterruptedException, IOException {

		if (upload.equals("DEVICECAMERA")) {

			if (verifyPresent(myFilesObjects.getUploadAddBtn())) {
				myFilesObjects.getUploadAddBtn().click();
				myFilesObjects.getCameraBtn().click();
				myFilesObjects.getCameraCaptureBtn().click();
				verifyPresent(myFilesObjects.getUsePhotoBtn());
				myFilesObjects.getUsePhotoBtn().click();
				waitForHomePageToLoad();
			}
		} else if (upload.equals("ICLOUD")) {
			if (verifyPresent(myFilesObjects.getUploadAddBtn())) {
				myFilesObjects.getUploadAddBtn().click();

				myFilesObjects.getUploadBtn().click();
				waitForHomePageToLoad();
				
			} else if (upload.equals("LOCAL")) {
				if (verifyPresent(myFilesObjects.getUploadAddBtn())) {
					myFilesObjects.getUploadAddBtn().click();
					photoSelect(photoSlectionRows);
					myFilesObjects.getUploadBtn().click();
					waitForHomePageToLoad();
				}
			}
		} else {
			log.info("Couldnot able to upload files from any source");
		}

	}

	public void uploadFilesFromIcloud() {

	}

	public void verifyFileCount() {
		verifyPresent(myFilesObjects.getAll_Files_Count());
		String allfilesCount = myFilesObjects.getAll_Files_Count().getText();
		log.info("All file count ::" + allfilesCount);
		verifyPresent(myFilesObjects.getPhotos_File_Count());
		String photosfilesCount = myFilesObjects.getPhotos_File_Count().getText();
		log.info("All file count ::" + photosfilesCount);
		verifyPresent(myFilesObjects.getVideo_File_Count());
		String videosfilesCount = myFilesObjects.getVideo_File_Count().getText();
		log.info("All file count ::" + videosfilesCount);
		verifyPresent(myFilesObjects.getMusic_File_Count());
		String musicsfilesCount = myFilesObjects.getMusic_File_Count().getText();
		log.info("All file count ::" + musicsfilesCount);
		verifyPresent(myFilesObjects.getOther_File_Count());
		String otherfilesCount = myFilesObjects.getOther_File_Count().getText();
		log.info("All file count ::" + otherfilesCount);

	}

	public void uploadFiles(int photoSlectionRows) throws IOException, InterruptedException {
		if (verifyPresent(myFilesObjects.getUploadAddBtn())) {
			myFilesObjects.getUploadAddBtn().click();
			photoSelect(photoSlectionRows);
			myFilesObjects.getUploadBtn().click();
			waitForHomePageToLoad();
		}
	}

	public String createFolder() {

		String FolderName = StringUtility.GenerateRandomString(10, Mode.ALPHANUMERIC);
		if (verifyPresent(myFilesObjects.getUploadAddBtn())) {
			myFilesObjects.getUploadAddBtn().click();
			verifyPresent(myFilesObjects.getCreateFolderBtn());
			myFilesObjects.getCreateFolderBtn().click();
			try {
				enterTextInAppFieldIos(FolderName);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			myFilesObjects.getCreateFolderDoneBtn().click();
		}
		return FolderName;

	}
	
	public String verifyFolderName() {
		String folderName = createFolder();
		if (folderName.equalsIgnoreCase(getFolderName(folderName).getText())) {
			verifyText(getFolderName(folderName), folderName);
			waitForPresent(myFilesObjects.getBackBtn(), 300);
			myFilesObjects.getBackBtn().click();
		}
		return folderName;

	}
	
	public void deleteFolder(String value){
		
		verifyPresent(myFilesObjects.getMoreFileOptionBtn());
		
		myFilesObjects.getMoreFileOptionBtn().click();
		
		myFilesObjects.getDeleteBtn().click();
		
		verifyText(myFilesObjects.getDeletePopMsg(), value);
		
		myFilesObjects.getDeleteBtn().click();
		
		
	}

	public void photoSelect(int rows) throws InterruptedException, IOException {
		try {
			int rows1 = rows + 1;
			for (int i = 2; i <= rows1; i++) {
				Thread.sleep(500);
				driver.findElement(MobileBy.IosUIAutomation(".elements()[1].cells()[" + i + "].elements()[0]")).click();
				Thread.sleep(500);
			}

		} catch (Exception ex) {
			ex.printStackTrace();

		}
	}
	
	public void verifyCreateFolderFunction(String value){
		myFilesObjects.getAllFilesBtn().click();
		waitForPresent(myFilesObjects.getAllFilesBtn(), 300);
		String FirstFolder=verifyFolderName();
		waitForPresent(myFilesObjects.getSelectFirstFolder(), 1000);
		myFilesObjects.getSelectFirstFolder().click();
		verifyFolderName();
		deleteFolder(value);
		verifyText(getFolderName(FirstFolder), FirstFolder);
		
	}
	
}
