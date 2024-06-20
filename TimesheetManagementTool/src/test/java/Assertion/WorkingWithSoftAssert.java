package Assertion;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WorkingWithSoftAssert {
	
	@Test
	public void login()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://laptop-eeas1cv9/login.do");
	
		SoftAssert as = new SoftAssert();
		as.assertEquals(driver.getTitle(),"actiTIME - Lo");
		
		
		driver.findElement(By.name("username")).sendKeys("admin");
		as.assertAll();
	}

}
