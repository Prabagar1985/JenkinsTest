package utility;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeSnap {
	WebDriver driver ;
	
	public static void captureSnap(WebDriver driver,String dest) throws Exception
	{
		TakesScreenshot ts = ((TakesScreenshot)driver);
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		DateFormat DtFrmt = new SimpleDateFormat("MM_dd_HH_mm_ss");
		Calendar cal = Calendar.getInstance();
		String CurTime = DtFrmt.format(cal.getTime());
		
		org.apache.commons.io.FileUtils.copyFile(src,new File(".\\screenshots\\"+dest+"_"+CurTime+".png"));
		System.out.println("Screenshot taken...");
	}
}
