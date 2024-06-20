package TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import GenericLib.BaseTest;
import GenericLib.Flib;
import GenericLib.WorkLib;
import PomPages.ActiveProjectAndCustomers;
import PomPages.CreateNewCustomerPage;
import PomPages.HomePage;
import PomPages.LoginPage;
import PomPages.openTaskPage;

public class CreateProjectAndCustomerTest extends BaseTest {

	@Test(groups = "RT")
	public void createCustomerAndProject() throws EncryptedDocumentException, IOException {
		// login
		Flib lib = new Flib();
		String username = lib.getDataFromExcelSheet(EXCEL_PATH, SHEETNAME, 1, 0);
		String password = lib.getDataFromExcelSheet(EXCEL_PATH, SHEETNAME, 1, 1);
		LoginPage lp = new LoginPage(driver);
		lp.validLogin(username, password);

		// click on task link
		HomePage hp = new HomePage(driver);
		hp.clickOnTaskLink();

		// click on projectandCustomer
		openTaskPage otp = new openTaskPage(driver);
		otp.clickOnProjectAndCustomer();

		// click on create new customer button
		ActiveProjectAndCustomers apac = new ActiveProjectAndCustomers(driver);
		apac.clickOnCreateNewCustomerButton();

		// create customer and project
		WorkLib wlib = new WorkLib();
		String customerName = lib.getDataFromExcelSheet(EXCEL_PATH, CUSTPROJSHEET, 1, 0) + wlib.getRandomNo();
		String ProjectName = lib.getDataFromExcelSheet(EXCEL_PATH, CUSTPROJSHEET, 1, 1) + wlib.getRandomNo();
		CreateNewCustomerPage ancp = new CreateNewCustomerPage(driver);
		ancp.createCustomerAndProject(customerName, driver, ProjectName);

	}

}
