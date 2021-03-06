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
	
//	public MobileElement getFolderName(){
//		return driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAStaticText[3]"));
//	}

	public void waitForHomePageToLoad() {
		waitForElement(myFilesObjects.Home_Page);
	}

	public String verifyUserIsLoggedIn() {

		return myFilesObjects.getHome_Page().getText();
		
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

		String FolderName1 = StringUtility.GenerateRandomString(10, Mode.ALPHANUMERIC);
		if (verifyPresent(myFilesObjects.getUploadAddBtn())) {
			myFilesObjects.getUploadAddBtn().click();
			verifyPresent(myFilesObjects.getCreateFolderBtn());
			myFilesObjects.getCreateFolderBtn().click();
			try {
				enterTextInAppFieldIos(FolderName1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			myFilesObjects.getCreateFolderDoneBtn().click();
		}
		return FolderName1;

	}
	
	public String verifyFolderName() {
		
		String folderName = createFolder();
		waitForPresent(myFilesObjects.getBackBtn(), 3000);
		myFilesObjects.getBackBtn().click();
		//System.out.println("<<<>>>>><<<<>>>>"+getFolderName().getText());
		if (folderName.equalsIgnoreCase(myFilesObjects.getTitleTxt().getText())) {	
			verifyText(myFilesObjects.getTitleTxt(), folderName);
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
		verifyPresent(myFilesObjects.getUploadAddBtn());
		String FirstFolder1=verifyFolderName();
		deleteFolder(value);
		waitForPresent(myFilesObjects.getBackBtn(), 3000);
		myFilesObjects.getBackBtn().click();
		verifyText(myFilesObjects.getTitleTxt(), FirstFolder);
		
	}
	
}
