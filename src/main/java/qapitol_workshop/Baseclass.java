package qapitol_workshop;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

 

public class Baseclass {
	@BeforeSuite
	public void beforesuite() {
		System.out.println("beforesuite executed");
	}
	@BeforeTest
	public void beforetest() {
		System.out.println("beforetest executed");
	}
	
	public static WebDriver driver;
  
	fileutility fileutil;
    @BeforeClass
    public void launchbrowser() throws Throwable {
    	fileutil=new fileutility();
  	  String browser1 = fileutil.readfiledata("browser");
  	  if(browser1.equalsIgnoreCase("chrome")) {
  		
  		  ChromeOptions option = new ChromeOptions();
  		  option.addArguments("--disable-notifications");
//  		  option.addArguments("--headless");
//  		  option.addArguments("--incognito");

  		 driver=new ChromeDriver(option);
  		
  	  }
  	  else if(browser1.equalsIgnoreCase("edge")) {
  		  driver=new EdgeDriver();
  	  }
  	  else {
  		  System.out.println("invalid browser");
  	  }
  	  driver.manage().window().maximize();
    }
    @BeforeMethod
    public void login() throws Throwable {
  	  String url = fileutil.readfiledata("url");
  	  System.out.println(url);
  	  driver.get(url);
  	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  		driver.manage().deleteAllCookies();
    }
}
