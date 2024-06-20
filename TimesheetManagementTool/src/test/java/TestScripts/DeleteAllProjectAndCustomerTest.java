package TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import GenericLib.BaseTest;
import GenericLib.Flib;
import PomPages.ActiveProjectAndCustomers;
import PomPages.HomePage;
import PomPages.LoginPage;
import PomPages.openTaskPage;

public class DeleteAllProjectAndCustomerTest extends BaseTest {

	@Test(groups = {"RT","IT"})
	
	public void deleteCustomerAndProject() throws EncryptedDocumentException, IOException {

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

		// delete all
		ActiveProjectAndCustomers apac = new ActiveProjectAndCustomers(driver);
		apac.deleteProjectAndCustomer();

	}

}
