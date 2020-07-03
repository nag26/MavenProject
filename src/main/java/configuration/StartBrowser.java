package configuration;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.remote.CapabilityType;
//import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StartBrowser {
public static WebDriver driver;

ExtentHtmlReporter htmlreporter;
public static ExtentReports extent;
public static ExtentTest parentTest;
public static ExtentTest childTest;

@BeforeTest
public void extentreport()
{
	Date date=new Date();
	SimpleDateFormat df=new SimpleDateFormat("dd-MM-yy_hh-mm-ss");
	String report=df.format(date);
	htmlreporter=new ExtentHtmlReporter("./Reports/Myreport_"+report+".html");
	extent=new ExtentReports();
	extent.attachReporter(htmlreporter);
	extent.setSystemInfo("user","Nagaraj");
	htmlreporter.config().setTheme(Theme.DARK);
}
@BeforeMethod
public void method(Method method)
{
	parentTest=extent.createTest(method.getName());
}

//@Parameters("browser")
@BeforeClass
public void setUp()
{
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
/*	if (br.equals("ie"))
{
	DesiredCapabilities cap=DesiredCapabilities.internetExplorer();
	cap.setCapability(CapabilityType.BROWSER_NAME, "IE");
	cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
	WebDriverManager.iedriver().setup();
	driver=new InternetExplorerDriver();
 
}
	else if(br.equals("chrome"))
{
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	
}
	else if (br.equals("firefox"))
{
	WebDriverManager.firefoxdriver().setup();
	driver=new FirefoxDriver();
}*/
	
}

@AfterClass
public void tearDown()
{
	driver.quit();
	extent.flush();
}
	
	

}
