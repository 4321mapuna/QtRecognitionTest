package QTRecognition;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import java.util.Properties;

import junit.framework.Assert;
@Test 
public class login extends base{
   public WebDriver dri;
   
   
   By user=By.xpath("//div[@class='container']//form//input[1]");
   By pass = By.xpath("//div[@class='container']//form//input[2]");
   By login=By.xpath("//div[@class='container']//form//button");
   
	public void verify() throws IOException, InterruptedException {
		dri=intial();
		dri.get(prop.getProperty("url"));
		
		//valid user login
		
		dri.findElement(user).sendKeys("anupam.ajith@qualitestgroup.com");
		dri.findElement(pass).sendKeys("P@ssw0rd");
		dri.findElement(login).click();
				
				
		//(1.3)Title check 
		Assert.assertEquals(dri.getTitle(), "QTRecognition");
		dri.close();
	}
		
	public void verifyColour() throws IOException {
		dri=intial();
		dri.get("https://qtrecognition.testqtwiz.com/");
		//Colour testing
		String colour = dri.findElement(By.xpath("//div[@class='myHeading']")).getCssValue("background-color");
		String c = Color.fromString(colour).asHex(); 
		String s ="#FECC160";
		//Assert.assertEquals(c, "#FECC160");
		Assert.assertTrue(c.contentEquals(s));
		String colourC = dri.findElement(By.xpath("	//div[@class='container']")).getCssValue("background-color");
		String cc = Color.fromString(colour).asHex(); 
		String ss="#2A2559";
		Assert.assertTrue(cc.contentEquals(ss));
		
		String colourCc = dri.findElement(By.xpath("//div[@class='container']/form/button")).getCssValue("background-color");
		String ccc = Color.fromString(colour).asHex();
		String sss="#939598";
		Assert.assertTrue(ccc.contentEquals(sss));
		
	
		
	
		
	   
	   
	   
	   
	}
	
	 @AfterClass
	public void exit() {
		dri.close();
	}
	

}
