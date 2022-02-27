package omecenTestCucumber.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static String Browser="chrome";
	
	public String getProperties(String key) throws IOException {
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\Anikm\\eclipse-workspace\\omecenTestCucumber\\src\\test\\resources\\resources\\Global.properties");
		prop.load(fis);
		return prop.getProperty(key);
	}
	
	
	public void openApp() throws IOException {
	if (Browser.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
	}

	else if (Browser.equalsIgnoreCase("Firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver= new FirefoxDriver();
	}
	else if (Browser.equalsIgnoreCase("IE")) {
		WebDriverManager.iedriver().setup();
		driver= new InternetExplorerDriver();
		
	}else {System.out.println("diver is null");}
	driver.get(getProperties("url"));
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
}
}
