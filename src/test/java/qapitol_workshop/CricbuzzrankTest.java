package qapitol_workshop;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CricbuzzrankTest extends Baseclass {
	
	@Test
	public void rankTest() {
	
	 
	  List<WebElement> teams = driver.findElements(By.xpath("//table//tr//td[@class='cb-srs-pnts-name']"));
	  List<WebElement> points = driver.findElements(By.xpath("//table//tr//td[@class='cb-srs-pnts-td text-bold']"));
	  for (int i = 0; i < points.size(); i++) {
	      String pointsText = points.get(i).getText();    
	      int points1 = Integer.parseInt(pointsText); 
	  
	  if (points1 >= 9) {
		  String teamName = teams.get(i).getText();     
		  System.out.println(teamName +":"+ points1);    
		  }
	  }
	  driver.quit();
}

	}
