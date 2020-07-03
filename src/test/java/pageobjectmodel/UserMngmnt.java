package pageobjectmodel;

import org.openqa.selenium.By;

public class UserMngmnt {
	//Admin_Adduser
		public static By btnAdmin=By.xpath("//a[@id='menu_admin_viewAdminModule']");
		public static By btnAdd=By.id("btnAdd");
		public static By selUserRole=By.id("systemUser_userType");
		public static By txtEmployeeName=By.id("systemUser_employeeName_empName");
		public static By txtUsername=By.id("systemUser_userName");
		public static By selStatus=By.id("systemUser_status");
		public static By txtPassword=By.id("systemUser_password");
		public static By txtConfirmPwd=By.id("systemUser_confirmPassword");
		public static By btnSave=By.id("btnSave");
		
		//Admin_DeleteUser
		public static By txtSystemUsrName=By.id("searchSystemUser_userName");
		public static By selSysUserRole=By.id("searchSystemUser_userType");
		public static By txtSystemEmpName=By.id("searchSystemUser_employeeName_empName");
		public static By selSysStatus=By.id("searchSystemUser_status");
		public static By btnSysSearch=By.id("searchBtn");
		public static By btnSysCheck=By.id("ohrmList_chkSelectRecord_16");
		public static By btnSysDelete=By.id("btnDelete");

}
