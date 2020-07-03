package reuse;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import Commands.ActionDriver;
import configuration.StartBrowser;
import pageobjectmodel.HomePage;
import pageobjectmodel.LoginPage;

public class BusinessFunctions {
	
	WebDriver driver;
	ActionDriver aDriver;
	
public BusinessFunctions()
{
	driver=StartBrowser.driver;
	aDriver=new ActionDriver();
}

public void login() throws IOException 
{
	StartBrowser.childTest=StartBrowser.parentTest.createNode("Login to application");
	aDriver.navigateToUrl("https://opensource-demo.orangehrmlive.com/", "URL");
	aDriver.type(LoginPage.txtUserName, "Admin", "Username");
	aDriver.type(LoginPage.txtPassword, "admin123", "Password");
	aDriver.click(LoginPage.btnLogin, "Login");
}

public void logout() throws IOException
{
	StartBrowser.childTest=StartBrowser.parentTest.createNode("Logout from application");
	aDriver.click(HomePage.btnwelcomeAdmin, "Welcome Admin");
	aDriver.click(HomePage.btnLogout, "Logout");
}


}
