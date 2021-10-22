package QTRecognition;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class kudosRecent extends base{
	public WebDriver dri;
	
	 By user=By.xpath("//div[@class='container']//form//input[1]");
	 By pass = By.xpath("//div[@class='container']//form//input[2]");
	 By login=By.xpath("//div[@class='container']//form//button");
	   
	@Test
	public void kudosrecentv() throws IOException, InterruptedException {
		dri=intial();
		
		dri.get(prop.getProperty("url"));
		
		dri.findElement(user).sendKeys(prop.getProperty("user"));
		dri.findElement(pass).sendKeys(prop.getProperty("pass"));
		dri.findElement(login).click();
		Thread.sleep(1000);
		activityPage a = new activityPage(dri);
	 
		a.recentkudos().click();
		
		kudosPage k = new kudosPage(dri);
		Thread.sleep(1000);
		k.cardv().click();
		k.commentv().sendKeys("Good");
		k.sendv().click();
	}
	
	 @AfterClass
	public void exit() {
		dri.close();
	}
}
