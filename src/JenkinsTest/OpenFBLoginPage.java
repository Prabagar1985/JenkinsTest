package JenkinsTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import utility.Browser;
import utility.TakeSnap;



public class OpenFBLoginPage {
  @Test
  public void f() throws Exception {
	  System.out.println("In F method...");

	  WebDriver driver = Browser.openBrowser("firefox", "https://www.facebook.com/");
	  TakeSnap.captureSnap(driver, "FBloginTest");
	  driver.close();
	  
	  System.out.println("Browser Closed...");
  }
}
