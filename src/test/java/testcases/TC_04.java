package testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import ProjectSpecifications.Projectfunctions;
import configuration.StartBrowser;
import reuse.BusinessFunctions;

public class TC_04 extends StartBrowser {
  @Test
  public void addJobTitle() throws IOException, InterruptedException
  {
	 BusinessFunctions bf=new BusinessFunctions();
	 Projectfunctions pf=new Projectfunctions();
	 bf.login();
	 pf.addJobTitle();
	 bf.logout();
  }
}
