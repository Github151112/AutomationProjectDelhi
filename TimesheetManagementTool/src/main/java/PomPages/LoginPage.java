package PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseClass {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// userNameText field
	@FindBy(name = "username")
	private WebElement usernameTextField;

	@FindBy(name = "pwd")
	private WebElement passwordTextField;

	@FindBy(id = "loginButton")
	private WebElement loginButton;

	@FindBy(linkText = "Logout")
	private WebElement logoutLink;

	public WebElement getUsernameTextField() {
		return usernameTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public void validLogin(String username, String password) {
		usernameTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
		loginButton.click();

	}

	public void invalidLogin(String username, String password) {
		usernameTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
		loginButton.click();
		usernameTextField.clear();
	}

}
