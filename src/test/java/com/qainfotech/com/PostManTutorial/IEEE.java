package com.qainfotech.com.PostManTutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class IEEE {
	JavascriptExecutor jse;
	WebDriver driver;
	WebDriverWait wait;
	public IEEE() {
		driver = new ChromeDriver();
		jse= (JavascriptExecutor)driver;
		wait = new WebDriverWait(driver, 10);
		driver.get("https://www.ieee.org/");
	}
	
  @Test
  public void IEEE_ORG() {
	  driver.findElement(By.className("ieee-home")).click();
	  Assert.assertTrue("https://www.ieee.org/".equals(driver.getCurrentUrl()));
  }
  
  @Test(dependsOnMethods= {"IEEE_ORG"})
  public void  Digital_Library() throws InterruptedException {
	  driver.findElement(By.xpath("//a[@href=\"http://ieeexplore.ieee.org\"]")).click();
	  String currenturl = driver.getCurrentUrl();
	  Assert.assertTrue("https://ieeexplore.ieee.org/Xplore/home.jsp".equals(driver.getCurrentUrl()));
	  Thread.sleep(5000);
	  driver.findElement(By.className("ieeeorg")).click();
  }
  
  @Test(dependsOnMethods= {"Digital_Library"})
  public void IEEE_Standards() throws InterruptedException {
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//a[text()='IEEE Standards']")).click();
	  Assert.assertTrue("http://standards.ieee.org/".equals(driver.getCurrentUrl()));
	  driver.findElement(By.xpath("//a[text()='IEEE.org']")).click();
  }
  
  @Test(dependsOnMethods= {"IEEE_Standards"})
  public void IEEE_Spectrum() throws InterruptedException {
	  driver.findElement(By.xpath("//a[text()='IEEE Spectrum']")).click();
	  Thread.sleep(10000);
	  System.out.println("http://spectrum.ieee.org"+"  "+driver.getCurrentUrl());
	  //Assert.assertNotNull(driver.findElement(By.id("topics")));
	  Assert.assertTrue("https://spectrum.ieee.org/".equals(driver.getCurrentUrl()));
	  System.out.println("Success in assertion");
	  Thread.sleep(5000);
	 // driver.findElement(By.xpath("//a[text()='Continue to site']")).click();
	  System.out.println("Success in xpath");
	  driver.findElement(By.xpath("//a[text()='IEEE.org']")).click();
  }
  
  @Test(dependsOnMethods= {"IEEE_Spectrum"})
	  public void MoreSite() {
		  driver.findElement(By.xpath("//a[text()='More Sites']")).click();
		  System.out.println("https://www.ieee.org/sitemap.html"+"  "+driver.getCurrentUrl());
		//  Assert.assertTrue("https://www.ieee.org/sitemap.html".equals(driver.getCurrentUrl()));
		  driver.findElement(By.xpath("//a[text()='IEEE.org']")).click();
	  }
  
  @Test(dependsOnMethods = {"MoreSite"})
  public void Cart() throws InterruptedException {
//	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='util-right']/span[1]/a")));
	  driver.get("https://www.ieee.org");
	  jse.executeScript("document.querySelector(document.querySelector(\"a[href*=myCart]\").click())");
	 // driver.findElement(By.cssSelector("a[href*=myCart]")).click();
	 //driver.findElement(By.cssSelector("#util-right > span.cart-count-link > a")).click();
	  System.out.println("https://www.ieee.org/cart/public/myCart/page.html"+"   "+driver.getCurrentUrl());
	  driver.findElement(By.xpath("//a[text()='IEEE.org']")).click();
  }
@Test(dependsOnMethods= {"Cart"})
public void Sign_in_SignOut() {
//	  driver.findElement(By.className("sign-in-cls")).click();
//	  driver.findElement(By.id("username")).sendKeys("krishnachauhan@qainfotech.com");
//	  driver.findElement(By.id("password")).sendKeys("Krishna@321#");
//	  driver.findElement(By.cssSelector("[value=\"Sign in\"]")).click();

	jse.executeScript("document.querySelector(\".sign-in-cls\").click()");
	jse.executeScript("document.querySelector('#username').value = 'Krishnachauhan@qainfotech.com'");
	jse.executeScript("document.querySelector('#password').value = 'Krishna@321#'");
	jse.executeScript("document.querySelector('[value=\"Sign in\"]').click()");
    //Assert.assertTrue(jse.executeScript("document.querySelector('#mn-signout-link')")!=null);
	jse.executeScript("document.querySelector('#mn-signout-link').click()");
}


@Test(dependsOnMethods= {"Sign_in_SignOut"})
public void Create_Account() {
	System.out.println("1");
	jse.executeScript("document.querySelector('#mn-calink-link').click()");
	System.out.println("2");
	jse.executeScript("document.querySelector('#firstName').value = 'krrrishna'");
	System.out.println("3");
	jse.executeScript("document.querySelector('#middleName').value = 'kp'");
	System.out.println("4");
	jse.executeScript("document.querySelector('#lastName').value = 'chauhan'");
	System.out.println("5");
	jse.executeScript("document.querySelector('#emailId').value = 'Krishnachauhan1994@gmail.com'");
	System.out.println("6");
	jse.executeScript("document.querySelector('#confirmEmailId').value = 'Krishnachauhan1994@gmail.com'");
	jse.executeScript("document.querySelector('#accountRegStep2Password').value = 'deepu1994'");
	jse.executeScript("document.querySelector('#confirmPassword').value = 'deepu1994'");
	jse.executeScript("document.querySelector('#privacyConsent').click()");
	jse.executeScript("document.querySelector('#modalWindowRegisterStep1CreateAcctBtn').click()");
	if((Boolean) jse.executeScript("document.querySelector('#mn-user-name-text').click()")) {
		System.out.println("Success");
	}
		////span[text()='krrrishna chauhan']
//  driver.findElement(By.xpath("//a[text()='Create Account']")).click();
//  System.out.println("https://www.ieee.org/profile/public/createwebaccount/showCreateAccount.html?url=https%3A%2F%2Fwww.ieee.org%2F"+"   "+driver.getCurrentUrl());
//  Assert.assertTrue("https://spectrum.ieee.org/".equals(driver.getCurrentUrl()));
//  driver.findElement(By.id("firstName")).sendKeys("krishna");
//  driver.findElement(By.id("middleName")).sendKeys(" ");
//  driver.findElement(By.id("lastName")).sendKeys("chauhan");
//  driver.findElement(By.id("emailId")).sendKeys("krishnachauhan9650434495@gmail.com");
//  driver.findElement(By.id("confirmEmailId")).seepu1994'"endKeys("krishnachauhan9650434495@gmail.com");
//  driver.findElement(By.id("accountRegStep2Password")).sendKeys("krishna1994");
//  driver.findElement(By.id("confirmPassword")).sendKeys("krishna1994");
//  driver.findElement(By.id("privacyConsent")).click();
//  driver.findElement(By.id("modalWindowRegisterStep1CreateAcctBtn")).click();
//
}


  }
  


