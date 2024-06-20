package TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.UsernameAndPassword;
import org.testng.annotations.Test;

import GenericLib.BaseTest;
import GenericLib.Flib;
import PomPages.LoginPage;

public class InvalidLoginTest extends BaseTest {

	@Test(groups = "FT")
	public void invalidLogin() throws EncryptedDocumentException, IOException {
		Flib lib = new Flib();
		LoginPage lp = new LoginPage(driver);
		int rowNo = lib.getLastRowNum(EXCEL_PATH, INVALIDSHEET);

		for (int i = 1; i < rowNo; i++) {
			String username = lib.getDataFromExcelSheet(EXCEL_PATH, INVALIDSHEET, i, 0);
			String password = lib.getDataFromExcelSheet(EXCEL_PATH, INVALIDSHEET, i, 1);
			lp.invalidLogin(username, password);
		}

	}

}
