package com.sandy.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sandy.qa.util.Testutil;

public class TestBase {
	public	static WebDriver driver;
	public	static Properties prop;
	//config.properties file 
	public TestBase() {
		prop=new Properties();
		try {
			FileInputStream ip=new FileInputStream("D:\\MyWorkspace\\sandy\\src\\main\\java\\com\\sandy\\qa\\config\\config.proporties");
		prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}	
	}
	//browser launching
	public static void initilization() {
		String browserName=prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\New folder (2)\\ChromeDriver.exe");
			 driver = new ChromeDriver();
		}else if(browserName.equals("FF")) {
		System.setProperty("WebDriver.chrome.driver","D:\\LIBRARY\\geckodriver\\geckodriver.exe");
		driver=new FirefoxDriver();
	}
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	//dynamic wait
	driver.manage().timeouts().pageLoadTimeout(Testutil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(Testutil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	
	driver.get (prop.getProperty("url"));	
		
}

}
