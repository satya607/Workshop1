package qapitol_workshop;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import qapitol_workshop.Excelutil;


public class LoginWithDataProvider extends Baseclass {
	Excelutil exutil;
	@Test (dataProvider="excelData")
	public void resister(String username,String password) {
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@id='userNameOrEmail']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
	}
	@DataProvider(name = "excelData")
	public Object[][] excelDataProvider() throws IOException {
	    String filePath = "C:\\Users\\Qapitol QA\\Downloads\\Book 3 (3).xlsx"; 
	    String sheetName = "Sheet1";
		return exutil.getExcelData(filePath, sheetName);
	}	
}
	
	

