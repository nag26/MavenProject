package testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import ProjectSpecifications.Projectfunctions;
import configuration.StartBrowser;
import reuse.BusinessFunctions;



public class TC_03 extends StartBrowser {

@Test
public void deleteUser() throws IOException, InterruptedException 
  {
	Projectfunctions pf=new Projectfunctions();
	BusinessFunctions bf=new BusinessFunctions();
	bf.login();
	pf.deleteUser();
	bf.logout();
  }
}
