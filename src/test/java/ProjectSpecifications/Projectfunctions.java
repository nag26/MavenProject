package ProjectSpecifications;

import java.io.IOException;


import org.openqa.selenium.WebDriver;

import Commands.ActionDriver;
import configuration.StartBrowser;
import pageobjectmodel.Job;
import pageobjectmodel.UserMngmnt;

public class Projectfunctions {
	
	WebDriver driver;
	ActionDriver aDriver;
	
public Projectfunctions()
{
	driver=StartBrowser.driver;
	aDriver=new ActionDriver();
}

public void addUser() throws IOException, InterruptedException
{
	StartBrowser.childTest=StartBrowser.parentTest.createNode("Add system user");
	aDriver.click(UserMngmnt.btnAdmin, "Admin");
	aDriver.click(UserMngmnt.btnAdd, "Add");
	aDriver.selectDd(UserMngmnt.selUserRole, "ESS", "User Role");
	Thread.sleep(2000);
	aDriver.type(UserMngmnt.txtEmployeeName, "Fiona Grace", "Employee Name");
	Thread.sleep(2000);
	aDriver.type(UserMngmnt.txtUsername, "kick.kick", "Username");
	Thread.sleep(2000);
	aDriver.selectDd(UserMngmnt.selStatus, "Enabled", "Status");
	aDriver.type(UserMngmnt.txtPassword, "AddUser@799", "Password");
	Thread.sleep(2000);
	aDriver.type(UserMngmnt.txtConfirmPwd, "AddUser@799", "Confirm Password");
	Thread.sleep(2000);
	aDriver.click(UserMngmnt.btnSave, "Save Button");
	Thread.sleep(2000);
}

public void deleteUser() throws IOException, InterruptedException
{
	StartBrowser.childTest=StartBrowser.parentTest.createNode("Delete system user");
	aDriver.click(UserMngmnt.btnAdmin, "Admin");
	aDriver.type(UserMngmnt.txtSystemUsrName, "rick.rick", "System User");
	aDriver.selectDd(UserMngmnt.selSysUserRole, "ESS", "System User Role");
	aDriver.type(UserMngmnt.txtSystemEmpName, "Fiona Grace", "System Employee Name");
	aDriver.selectDd(UserMngmnt.selSysStatus, "Enabled", "System status");
	aDriver.click(UserMngmnt.btnSysSearch, "Search button");
	aDriver.click(UserMngmnt.btnSysCheck, "System Check box");
	aDriver.click(UserMngmnt.btnSysDelete, "System delete");
	aDriver.alertAccept(" System Alert");
	
	
}

public void addJobTitle() throws IOException, InterruptedException
{
	StartBrowser.childTest=StartBrowser.parentTest.createNode("Add job Title");
	aDriver.click(UserMngmnt.btnAdmin, "Admin");
	aDriver.click(Job.btnJob, "Job");
	aDriver.click(Job.btnJobTitle, "Job Title");
	aDriver.click(Job.btnAdd, "Add");
	aDriver.type(Job.txtJobTitle, "Account Maintainer", "Job Title");
	aDriver.type(Job.txtJobDescr, "Account Maintainer", "Job Description");
	Thread.sleep(2000);
	aDriver.autoITClick(Job.btnChoosefile, "Choose button");
	 
	aDriver.autoITUpload("‪‪E:\\Excel\\UploadFile.exe","Text1");
	Thread.sleep(3000);
	aDriver.type(Job.txtNote, "Account Maintainerr", "Note");
	aDriver.click(Job.btnJobsave, "save");
}

}
