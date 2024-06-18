package PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import GenericLib.WorkLib;

public class CreateNewCustomerPage extends BaseClass {

	public CreateNewCustomerPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(name = "name")
	private WebElement nameTextField;
	
	@FindBy(name = "createCustomerSubmit")
	private WebElement createCustomerButton;
	
	
	@FindBy(name = "customerId")
	private WebElement customerDropdown;
	
	@FindBy(xpath = "//input[@name='name']")
	private WebElement ProjectNameTextField;
	
	
	@FindBy(name = "createProjectSubmit")
	private WebElement createProjectButton;


	public WebElement getNameTextField() {
		return nameTextField;
	}


	public WebElement getCreateCustomerButton() {
		return createCustomerButton;
	}


	public WebElement getCustomerDropdown() {
		return customerDropdown;
	}


	public WebElement getProjectNameTextField() {
		return ProjectNameTextField;
	}


	public WebElement getCreateProjectButton() {
		return createProjectButton;
	}
	
	
	public void createCustomerAndProject(String customerName,WebDriver driver,String projectName)
	{
		nameTextField.sendKeys(customerName);
		createCustomerButton.click();
		ActiveProjectAndCustomers apac = new ActiveProjectAndCustomers(driver);
		apac.clickOnCreateNewProjectButton();
		WorkLib wlib = new WorkLib();
		wlib.selecByVisibleText(customerDropdown, customerName);
		ProjectNameTextField.sendKeys(projectName);
		createProjectButton.click();
	}
	

}
