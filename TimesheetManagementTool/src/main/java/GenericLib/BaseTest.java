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
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest implements IAutoConstant {

	public WebDriver driver;
	public static WebDriver sdriver;

	@BeforeSuite(alwaysRun = true)
	public void beforeSuite() {
		Reporter.log("====to connect with databse====", true);
	}

	@BeforeTest(alwaysRun = true)
	public void beforeTest() {
		Reporter.log("====to connect with server====", true);
	}

	@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void setUp(@Optional("chrome") String browser) throws IOException {
		Flib lib = new Flib();
		// String browser = lib.getDataFromPropertyFile(PROP_PATH, "browser");
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
		sdriver=driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMESECONDS));
		driver.get(url);

	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

	@AfterTest(alwaysRun = true)
	public void afterTest() {
		Reporter.log("to close the connectionm with database", true);
	}

	@AfterSuite(alwaysRun = true)
	public void afterSuite() {
		Reporter.log("to close the connection  with server", true);
	}

}
