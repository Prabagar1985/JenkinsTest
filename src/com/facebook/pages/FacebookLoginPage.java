package com.facebook.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/*
 * 
 * This class has all the locators available in the facebook login page
 * 
 * 
 */

public class FacebookLoginPage {

	By loginUsername = By.id("email");
	By loginPassword = By.id("pass");
	By loginButton   = By.xpath("//*[@id='u_0_2']");
	
	By createUsername        = By.id("u_0_h");
	By createSurname         = By.id("u_0_j");
	By createMobileNo        = By.id("u_0_m");
	By createPwd             = By.id("u_0_t");
	By createDOB             = By.name("birthday_day");
	By createDOM             = By.name("birthday_month");
	By createDOY             = By.name("birthday_year");
	By createSexFemale       = By.id("u_0_6");
	By createSexMale         = By.id("u_0_7");
	By createAccountButton   = By.id("u_0_z");
	
	WebDriver driver;
	
	public FacebookLoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void loginFB(String uName , String pWord)
	{
		driver.findElement(loginUsername).sendKeys(uName);
		driver.findElement(loginPassword).sendKeys(pWord);
		driver.findElement(loginButton).submit();
		
	}
	
	public void createNewFBAccount(String uName,String surName,String mobileNo,String pwd,String dob,String dom,String doy,String sex)
	{
		driver.findElement(createUsername).sendKeys(uName);
		driver.findElement(createSurname).sendKeys(surName);
		driver.findElement(createMobileNo).sendKeys(mobileNo);
		driver.findElement(createPwd).sendKeys(pwd);
		driver.findElement(createDOB).sendKeys(dob);
		driver.findElement(createDOM).sendKeys(dom);
		driver.findElement(createDOY).sendKeys(doy);
		
		if(sex.equalsIgnoreCase(driver.findElement(By.xpath("//*[@id='u_0_x']/span[1]/label")).getText()))
		{
			driver.findElement(createSexFemale).click();
		}
		else if(sex.equalsIgnoreCase(driver.findElement(By.xpath("//*[@id='u_0_x']/span[2]/label")).getText()))
		{
			driver.findElement(createSexMale).click();
		}
		else
		{
			System.out.println("Enter valid sex name : [MALE or FEMALE] : ");
		}
		
		//driver.findElement(createAccountButton).click();
		
		
	}
}
