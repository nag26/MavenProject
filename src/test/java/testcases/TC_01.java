package testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import configuration.StartBrowser;
import reuse.BusinessFunctions;


public class TC_01 extends StartBrowser {
	
@Test
public void Login_Logout() throws IOException 
{
BusinessFunctions bf=new BusinessFunctions();
bf.login();
bf.logout();
}

}
