package dataprovider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WorkingWithDataProvider {
	
	
	@DataProvider(name = "TestData")
	public Object[][] testData()
	{
		Object[][] o = new Object[5][2];
		o[0][0] = "admin8454564";
		o[0][1] = "admin8454564";
		
		o[1][0] = "admin8454564";
		o[1][1] = "admin8454564";
		
		o[2][0] = "admin8454564";
		o[2][1] = "admin8454564";
		
		o[3][0] = "admin8454564";
		o[3][1] = "admin8454564";
		
		o[4][0] = "admin8454564";
		o[4][1] = "admin8454564";
		
		return o;
		
		
	}
	
	@Test(dataProvider = "TestData")
	public void loginWithDataProvider(String username, String password)
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://laptop-eeas1cv9/login.do");
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("pwd")).sendKeys(password);
		driver.findElement(By.id("loginButton")).click();
		driver.close();
	}

}
