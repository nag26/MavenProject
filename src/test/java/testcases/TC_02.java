package testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import ProjectSpecifications.Projectfunctions;
import configuration.StartBrowser;
import reuse.BusinessFunctions;

public class TC_02 extends StartBrowser{
	
@Test
public void Add_User() throws IOException, InterruptedException
{
	Projectfunctions pf=new Projectfunctions();
	BusinessFunctions bf=new BusinessFunctions();
	bf.login();
	pf.addUser();
	bf.logout();
}
	

}
