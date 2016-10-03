package com.appium.page.objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class MyFilesObjects {

	@AndroidFindBy(id = "")
	@iOSFindBy(id = "My files")
	public MobileElement Home_Page;

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
