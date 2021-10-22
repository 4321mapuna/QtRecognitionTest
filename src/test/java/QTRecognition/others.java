package QTRecognition;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class others extends base{
	public WebDriver dri;
	By user=By.xpath("//div[@class='container']//form//input[1]");
	 By pass = By.xpath("//div[@class='container']//form//input[2]");
	 By login=By.xpath("//div[@class='container']//form//button");
	
	@Test
	public void other() throws IOException, InterruptedException, AWTException {
		dri=intial();
		dri.get(prop.getProperty("url"));
		dri.findElement(user).sendKeys(prop.getProperty("user"));
		dri.findElement(pass).sendKeys(prop.getProperty("pass"));
		activityPage a = new activityPage(dri);
		kudosPage kk = new kudosPage(dri);
		dri.findElement(login).click();  
		
		
		
		// Kudos from me button checking
		a.kudosm().click();
		Thread.sleep(1000);
		Assert.assertTrue(dri.findElement(By.xpath("//h5[@class='header-font-size'][1]/small[1]")).isDisplayed());
		//..........................................
		
		//Kudos to me checking
		a.kodosto().click();
		Thread.sleep(1000);
	    
		String str =dri.findElement(By.xpath("//h5[@class='header-font-size'][1]/small[1]")).getText();
        Assert.assertTrue(str.contains("received an appreciation from"));
        String strKudos =dri.findElement(By.xpath("//h5[@class='header-font-size'][1]/small[1]")).getText();
		Assert.assertTrue(strKudos.equalsIgnoreCase("received an appreciation from"));
		//..........................................
		
		
		// Activity button checking
		a.act().click();
		Thread.sleep(1000);
		String sdd=dri.findElement(By.xpath("//h5[@id='todayCount']")).getText();
		//Assert.assertTrue(stt.contentEquals(sdd));
		
		//..........................................
		
		//sample kudos send to check kudos count is updated.
		
        a.recentkudos().click();
		Robot r = new Robot();
		kudosPage ks = new kudosPage(dri);
		Thread.sleep(1000);
		ks.cardv().click();
		ks.commentv().sendKeys("Good");
		ks.sendv().click();
		r.delay(10000);
		if(	dri.findElement(By.xpath("//form[@name='shoutout_form']/div[2]/div/span/center")).getText().equalsIgnoreCase("Mailer Error: SMTP connect() failed."))
		{
			kk.canclev().click();
		}
		r.delay(1000);
		dri.navigate().refresh(); //Refreshing page
		a.act().click();
		String sd=dri.findElement(By.xpath("//h5[@id='todayCount']")).getText();
		Assert.assertFalse(sd.contentEquals(sdd)); //checking  count is updated. 
		
		//checking kudoscan be send to user himself
		kk.kudosv().click();
         r.delay(1000);
		
		kk.email().click();
		kk.email().sendKeys("anupam.ajith@qualitestgroup.com");
		
		r.delay(1000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.delay(1000);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.delay(1000);
		r.keyPress(KeyEvent.VK_ENTER);
	    r.delay(1000);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		kk.cardv().click();
		kk.commentv().sendKeys("Good Work");
		kk.sendv().click();
		r.delay(10000);
		if(	dri.findElement(By.xpath("//form[@name='shoutout_form']/div[2]/div/span/center")).getText().equalsIgnoreCase("Mailer Error: SMTP connect() failed."))
		{
			kk.canclev().click();
		}
		r.delay(1000);
		dri.navigate().refresh();
		a.kudosm().click();
		r.delay(1000);
		String n=dri.findElement(By.xpath("//h5[@class='header-font-size'][1]/b[2]")).getText();
		String nn=dri.findElement(By.xpath("//h5[@class='header-font-size'][1]/b[1]")).getText();
		Assert.assertFalse(n.contentEquals(nn));
		
	}
	
	
	@AfterTest
	public void exit() {
		dri.close();
	}
	
}
