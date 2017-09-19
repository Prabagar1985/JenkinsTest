package fblogin;

import org.testng.annotations.Test;

import com.facebook.pages.FacebookLoginPage;

import utility.Browser;
import utility.TakeSnap;

import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class FBLoginTest {
	
	String tD1[] = null;
	String url = null;
	int rowNo=10;
	WebDriver d;
	
  @Test
  public void f() throws Exception {
	  System.out.println("TESTING");
	  getTestData();
	  System.out.println("TESTING");
	  
	  d = Browser.openBrowser("firefox", url);
	  
	  FacebookLoginPage fb = new FacebookLoginPage(d);
	  fb.loginFB(tD1[0], tD1[1]);
	  
	  String pageTitle = d.getTitle();
	  System.out.println("Page Title : "+pageTitle);
	  if(pageTitle.contains("log in")) {
		  System.out.println("Username or Password are incorrect...");
		  TakeSnap.captureSnap(d, "FB login using Excel data is Fail...");
		  
		  setTestStatus("FAIL");
	  }
	  else {
		  TakeSnap.captureSnap(d, "FB login using Excel data is success...");
		  System.out.println("Login success..");
		  
		  setTestStatus("PASS");
	  }
	  
	  
	  System.out.println("Test Method Completed...");
  }
  
  public void setTestStatus(String TestStatus) throws Exception
  {
	  
	  System.out.println("Inside setdata method...");
	  File f = new File ("D:\\Selenium\\JenkinsTest\\Test.xlsx");
	  FileInputStream fin = new FileInputStream(f);
	  XSSFWorkbook wb1 = new XSSFWorkbook(fin);
	  System.out.println("TEST");
	  XSSFSheet sheet1 = wb1.getSheet("Sheet1");
	  XSSFRow row1 = sheet1.getRow(rowNo);
	  XSSFCell cell = row1.createCell(9);
	  
	  fin.close();
	  cell.setCellValue("PASS");
	  
	  
	  System.out.println("TEST 5...");
	  FileOutputStream fos = new FileOutputStream(new File ("D:\\Selenium\\JenkinsTest\\Test.xlsx"));
	  wb1.write(fos);
	  fos.close();
	  
	  
	
  }
  
  
  public void getTestData() throws Exception {
	  System.out.println("TESTING1");
	  File f = new File("D:\\Selenium\\JenkinsTest\\Test.xlsx");
	  System.out.println("TESTING2");
	  FileInputStream fis = new FileInputStream(f);
	  System.out.println("TESTING3");
	  XSSFWorkbook wb = new XSSFWorkbook(fis);
	  System.out.println("TESTING4");
	  XSSFSheet sheet = wb.getSheet("Sheet1");
	  System.out.println("TESTING5");
	  XSSFRow row = sheet.getRow(rowNo);
	  System.out.println("TESTING6");
	  url = row.getCell(4).getStringCellValue();
	  System.out.println("TESTING7");
	  String tD = row.getCell(5).getStringCellValue();
	  		
	  tD1 = tD.split("\n");
	  for(int i =0;i<tD1.length;i++) System.out.println(tD1[i]);
	  
	  System.out.println(url);
	  fis.close();
  }

  
  @BeforeTest
  public void beforeTest() throws Exception {
	  	  
  }

  @AfterTest
  public void afterTest() {
	  d.close();
  }

}
