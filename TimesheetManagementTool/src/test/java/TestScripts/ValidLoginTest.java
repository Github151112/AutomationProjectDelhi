package TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericLib.BaseTest;
import GenericLib.CustomListener;
import GenericLib.Flib;
import PomPages.LoginPage;


@Listeners(CustomListener.class)
public class ValidLoginTest extends BaseTest {

	@Test(groups = "ST")
	public void login() throws EncryptedDocumentException, IOException {

		Flib lib = new Flib();
		String username = lib.getDataFromExcelSheet(EXCEL_PATH, SHEETNAME, 1, 0);
		String password = lib.getDataFromExcelSheet(EXCEL_PATH, SHEETNAME, 1, 1);
		LoginPage lp = new LoginPage(driver);
		lp.validLogin(username, password);

	}

}
