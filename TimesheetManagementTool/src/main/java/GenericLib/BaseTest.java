package GenericLib;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseTest implements IAutoConstant {

	public WebDriver driver;

	@BeforeSuite(enabled = false)
	public void beforeSuite() {
		Reporter.log("====to connect with databse====", true);
	}

	@BeforeTest
	public void beforeTest() {
		Reporter.log("====to connect with server====", true);
	}

	@BeforeClass
	public void setUp() throws IOException {
		Flib lib = new Flib();
		String browser = lib.getDataFromPropertyFile(PROP_PATH, "browser");
		Reporter.log("=====Launching " + browser + " browser====", true);
		String url = lib.getDataFromPropertyFile(PROP_PATH, "url");
		if (browser.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
		else if (browser.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		else if (browser.equalsIgnoreCase("edge"))
			driver = new EdgeDriver();
		else
			Reporter.log("Invalid Browser", true);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMESECONDS));
		driver.get(url);

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	@AfterTest
	public void afterTest() {
		Reporter.log("to close the connectionm with database", true);
	}

	@AfterSuite
	public void afterSuite() {
		Reporter.log("to close the connection  with server", true);
	}

}
