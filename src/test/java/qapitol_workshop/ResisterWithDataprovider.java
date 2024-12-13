package qapitol_workshop;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ResisterWithDataprovider {
	Excelutil exutil;
@Test(dataProvider="excelData")
public void resisteronBookstore(String username,String name,String email,String password,String conformpassword) {
	WebDriver driver=new ChromeDriver();
	driver.get("http://139.59.27.246:3000/login");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
	driver.findElement(By.xpath("//input[@id='userName']")).sendKeys(username);
	driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(name);
	driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
	driver.findElement(By.xpath("//div[4]//input[1]")).sendKeys(password);
	driver.findElement(By.xpath("//div[5]//input[1]")).sendKeys(conformpassword);
	driver.findElement(By.xpath("//button[@type='submit']")).click();
}
@DataProvider(name = "excelData")
public Object[][] excelDataProvider() throws IOException {
    String filePath = "C:\\Users\\Qapitol QA\\Downloads\\Book 4.xlsx"; 
    String sheetName = "Sheet1";
	return exutil.getExcelData(filePath, sheetName);
}	
}
