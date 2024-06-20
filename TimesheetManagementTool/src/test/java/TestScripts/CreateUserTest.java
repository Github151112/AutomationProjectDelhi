package TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericLib.BaseTest;
import GenericLib.CustomListener;
import GenericLib.Flib;
import GenericLib.WorkLib;
import PomPages.CreateNewUserPage;
import PomPages.HomePage;
import PomPages.LoginPage;
import PomPages.UserListPage;

@Listeners(CustomListener.class)
public class CreateUserTest extends BaseTest {

	@Test(groups = "RT")
	public void createUser() throws EncryptedDocumentException, IOException, InterruptedException {

		// login
		Flib lib = new Flib();
		String username = lib.getDataFromExcelSheet(EXCEL_PATH, SHEETNAME, 1, 0);
		String password = lib.getDataFromExcelSheet(EXCEL_PATH, SHEETNAME, 1, 1);
		LoginPage lp = new LoginPage(driver);
		lp.validLogin(username, password);

		// click on user link
		HomePage hp = new HomePage(driver);
		hp.clickOnUserLink();

		// click on create new user button
		UserListPage usp = new UserListPage(driver);
		usp.clickOnCreateNewCustomer();

		// fill all the details and click on create user button
		WorkLib wlib = new WorkLib();
		String usn = lib.getDataFromExcelSheet(EXCEL_PATH, USERSHEET, 1, 0) + wlib.getRandomNo();
		String pwd = lib.getDataFromExcelSheet(EXCEL_PATH, USERSHEET, 1, 1) + wlib.getRandomNo();
		String fn = lib.getDataFromExcelSheet(EXCEL_PATH, USERSHEET, 1, 2) + wlib.getRandomNo();
		String ln = lib.getDataFromExcelSheet(EXCEL_PATH, USERSHEET, 1, 3) + wlib.getRandomNo();

		CreateNewUserPage cnup = new CreateNewUserPage(driver);
		cnup.createNewUser(usn, pwd, fn, ln);

	}

}
