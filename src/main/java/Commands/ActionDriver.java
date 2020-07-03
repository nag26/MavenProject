package Commands;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.MediaEntityBuilder;

import configuration.StartBrowser;

public class ActionDriver {
	
	WebDriver driver;
	
public ActionDriver()
{
	driver=StartBrowser.driver;
}

public void navigateToUrl(String url, String eleName) throws IOException
{
	try {
		driver.get(url);
		StartBrowser.childTest.pass("Successfully navigated to: "+eleName+"  Data:"+url);
	} catch (Exception e) {
		StartBrowser.childTest.fail("Unable to naviagte: "+eleName+" Data: "+url,
		MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
		StartBrowser.childTest.info(e);
	}
}

public void type(By locator, String text, String eleName) throws IOException
{
	try {
		driver.findElement(locator).sendKeys(text);
		StartBrowser.childTest.pass("Successfully typed in: "+eleName+"  Data:"+text);
	} catch (Exception e) {
		StartBrowser.childTest.fail("Successfully typed in: "+eleName+"  Data:"+text,
				MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
		StartBrowser.childTest.info(e);
	}
}
public void click(By locator,String eleName) throws IOException
{
	try {
		driver.findElement(locator).click(); 
		StartBrowser.childTest.pass("Successfully clicked on: "+eleName);
	} catch (Exception e) {
		StartBrowser.childTest.fail("Unable to click on: "+eleName,
				MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
		StartBrowser.childTest.info(e);
		
	}
}
public void selectDd(By locator, String name, String ddName) throws IOException
{
	try {
		Select dd=new Select(driver.findElement(locator));
		dd.selectByVisibleText(name);
		StartBrowser.childTest.pass("Successfully selected from: "+ddName+" Data: "+name);
	} catch (Exception e) {
		StartBrowser.childTest.fail("Unable to select from: "+ddName+" Data: "+name,
				MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
		StartBrowser.childTest.info(e);
	}
}

public void alertAccept(String aleName) throws IOException
{
	try {
		/*WebDriverWait wait = new WebDriverWait(driver, 5);
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());*/
		Alert ale=driver.switchTo().alert();
		ale.accept();
		StartBrowser.childTest.pass("Successfully accepted Alert: "+aleName);
	} catch (Exception e) {
		StartBrowser.childTest.fail("Unable to accept Alert: "+aleName,
				MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
		StartBrowser.childTest.info(e);
		
	}
}
public void autoITUpload(String fpath,String fName) throws IOException{
	{
		try {
			Runtime.getRuntime().exec(fpath);
			StartBrowser.childTest.pass("Successfully Choose file: " + fName);
		} catch (Exception e) {
			StartBrowser.childTest.fail("Unable to Choose file: " + fName,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			StartBrowser.childTest.info(e);
		}
	}
}
public void autoITClick(By locator, String eleName) throws IOException
{
	try {
		WebElement button=driver.findElement(locator);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", button);
		StartBrowser.childTest.pass("Successfully Clicked on Choose file: " + eleName);
	} catch (Exception e) {
		StartBrowser.childTest.fail("Unable Click on Choose file: " + eleName,
				MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
		StartBrowser.childTest.info(e);
	}
}
public String screenShot()
{
	return((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
}
}
