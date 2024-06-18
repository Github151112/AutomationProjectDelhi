package TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import GenericLib.BaseTest;
import GenericLib.Flib;
import PomPages.LoginPage;

public class ValidLoginTest extends BaseTest {

	@Test()
	public void login() throws EncryptedDocumentException, IOException {

		Flib lib = new Flib();
		String username = lib.getDataFromExcelSheet(EXCEL_PATH, SHEETNAME, 1, 0);
		String password = lib.getDataFromExcelSheet(EXCEL_PATH, SHEETNAME, 1, 1);
		LoginPage lp = new LoginPage(driver);
		lp.validLogin(username, password);

	}

}
