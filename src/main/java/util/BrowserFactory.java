package util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {
	
	 static WebDriver driver;
	
	public static WebDriver init() {
	
		System.setProperty("webdriver.chrome.drive", "driver/chromedrivernew.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);
		return driver;
		
		
	}
     public void tearDown() {
    	driver.close();
    	driver.quit();
     }
}
