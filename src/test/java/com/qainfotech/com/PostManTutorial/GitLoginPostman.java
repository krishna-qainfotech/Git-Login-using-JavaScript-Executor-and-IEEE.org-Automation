package com.qainfotech.com.PostManTutorial;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GitLoginPostman {
WebDriver driver; 
JavascriptExecutor jse;
	public GitLoginPostman() {
		driver = new ChromeDriver();
		jse= (JavascriptExecutor)driver;
	}
	
	@BeforeTest
  public void openGit() {
		String url = "https://github.com/";
		driver.get(url);
    }
	
  @Test
  public void signInWithCorrectCredential() {
	  String url = "https://github.com/";
		driver.get(url);
		jse.executeScript("document.querySelector(\"a[href='/login']\").click();;");
        jse.executeScript("document.getElementsByName(\"login\")[0].value='krishna-qainfotech'");
		jse.executeScript("document.getElementById('password').value='Krishna@321#'");
		jse.executeScript("document.querySelector(\".btn.btn-primary.btn-block\").click();");
	}
  
  @Test(dependsOnMethods= {"signInWithCorrectCredential"})
  public void createNewRepo() throws InterruptedException {
	  jse.executeScript("document.getElementsByClassName('HeaderNavlink')[4].click();");
	  jse.executeScript("document.querySelector('[href=\"/new\"]').click();");
	  jse.executeScript("document.getElementById(\"repository_name\").value='delete this repo2';");
	  Thread.sleep(10000);
	  jse.executeScript("document.getElementById('repository_description').value='delete this repo'");
	  jse.executeScript("document.querySelector('[data-disable-with=\"Creating repository…\"]').click()");
  }
  @Test(dependsOnMethods= {"createNewRepo"})
  public void openTerminalAndUpoadCodeOnGit() {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ALT);
			robot.keyPress(KeyEvent.VK_T);
		} catch (AWTException e) {
			System.out.println("hello");
			e.printStackTrace();
		}
  }
}
