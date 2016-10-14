package com.appium.page.objects;

import org.openqa.selenium.support.FindBy;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class MyFilesObjects {

	@AndroidFindBy(id = "")
	@iOSFindBy(id = "My files")
	public MobileElement Home_Page;
	
	@AndroidFindBy(id = "")
	@iOSFindBy(id = "All Files")
	public MobileElement AllFilesBtn;
	
	@AndroidFindBy(id = "")
	@iOSFindBy(id = "Photos")
	public MobileElement PhotosBtn;
	
	@AndroidFindBy(id = "")
	@iOSFindBy(id = "Videos")
	public MobileElement VideosBtn;
	
	@AndroidFindBy(id = "")
	@iOSFindBy(id = "Music")
	public MobileElement MusicBtn;
	
	@AndroidFindBy(id = "")
	@iOSFindBy(id = "Other files")
	public MobileElement OtherFilesBtn;

	@AndroidFindBy(id = "")
	@iOSFindBy(id = "all_item_count")
	public MobileElement All_Files_Count;

	@AndroidFindBy(id = "")
	@iOSFindBy(id = "photos_file_count")
	public MobileElement Photos_File_Count;

	@AndroidFindBy(id = "")
	@iOSFindBy(id = "video_file_count")
	public MobileElement Video_File_Count;

	@AndroidFindBy(id = "")
	@iOSFindBy(id = "music_file_count")
	public MobileElement Music_File_Count;

	@AndroidFindBy(id = "")
	@iOSFindBy(id = "other_file_count")
	public MobileElement Other_File_Count;
	
	@AndroidFindBy(id = "")
	@iOSFindBy(id = "container_add_button")
	public MobileElement UploadAddBtn;
	
	@AndroidFindBy(id = "")
	@iOSFindBy(id = "upload_fileview_uploadbutton")
	public MobileElement UploadBtn;
	
	@AndroidFindBy(id = "")
	@iOSFindBy(id = "cancel_btn")
	public MobileElement CancelBtn;
	
	@AndroidFindBy(id = "")
	@iOSFindBy(id = "create_folder_bar_btn")
	public MobileElement CreateFolderBtn;
	
	@AndroidFindBy(id = "")
	@iOSFindBy(id = "Done")
	public MobileElement CreateFolderDoneBtn;
	
	@AndroidFindBy(id = "")
	@iOSFindBy(id = "back_btn")
	public MobileElement BackBtn;
	
	
	
	@AndroidFindBy(id = "")
	@FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAStaticText[3]")
	public MobileElement TitleTxt;
	
	@AndroidFindBy(id = "")
	@FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAButton[1]")
	public MobileElement MoreFileOptionBtn;
	
	@AndroidFindBy(id = "")
	@iOSFindBy(id = "Delete")
	public MobileElement DeleteBtn;
	
	@AndroidFindBy(id = "")
	@iOSFindBy(id = "Are you sure you want to delete this item?")
	public MobileElement DeletePopMsg;
	
	@AndroidFindBy(id = "")
	@iOSFindBy(id = "Cancel")
	public MobileElement DeleteCancelBtn;
	
	@AndroidFindBy(id = "")
	@FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]")
	public MobileElement SelectFirstFolder;
	

	public MobileElement getTitleTxt() {
		return TitleTxt;
	}

	public MobileElement getSelectFirstFolder() {
		return SelectFirstFolder;
	}

	public MobileElement getMoreFileOptionBtn() {
		return MoreFileOptionBtn;
	}

	public MobileElement getDeleteBtn() {
		return DeleteBtn;
	}

	public MobileElement getDeletePopMsg() {
		return DeletePopMsg;
	}

	public MobileElement getDeleteCancelBtn() {
		return DeleteCancelBtn;
	}

	public MobileElement getBackBtn() {
		return BackBtn;
	}

	public MobileElement getCreateFolderDoneBtn() {
		return CreateFolderDoneBtn;
	}

	public MobileElement getUploadAddBtn() {
		return UploadAddBtn;
	}

	public MobileElement getUploadBtn() {
		return UploadBtn;
	}

	public MobileElement getCancelBtn() {
		return CancelBtn;
	}

	public MobileElement getCreateFolderBtn() {
		return CreateFolderBtn;
	}

	public MobileElement getHome_Page() {
		return Home_Page;
	}

	public MobileElement getAll_Files_Count() {
		return All_Files_Count;
	}

	public MobileElement getAllFilesBtn() {
		return AllFilesBtn;
	}

	public MobileElement getPhotosBtn() {
		return PhotosBtn;
	}

	public MobileElement getVideosBtn() {
		return VideosBtn;
	}

	public MobileElement getMusicBtn() {
		return MusicBtn;
	}

	public MobileElement getOtherFilesBtn() {
		return OtherFilesBtn;
	}

	public MobileElement getPhotos_File_Count() {
		return Photos_File_Count;
	}

	public MobileElement getVideo_File_Count() {
		return Video_File_Count;
	}

	public MobileElement getMusic_File_Count() {
		return Music_File_Count;
	}

	public MobileElement getOther_File_Count() {
		return Other_File_Count;
	}

}
