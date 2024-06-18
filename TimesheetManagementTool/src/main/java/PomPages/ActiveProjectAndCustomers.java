package PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ActiveProjectAndCustomers extends BaseClass {

	public ActiveProjectAndCustomers(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[@value='Create New Customer']")
	private WebElement createNewCustomerButton;

	@FindBy(xpath = "//input[@value='Create New Project']")
	private WebElement createNewProjectButton;
	
	@FindBy(linkText = "All")
	private WebElement allLink;
	
	@FindBy(xpath = "//input[@value='Delete Selected']")
	private WebElement deleteSelectedButton;
	
	@FindBy(id = "deleteButton")
	private WebElement deleteButton;
	

	public WebElement getCreateNewCustomerButton() {
		return createNewCustomerButton;
	}

	public WebElement getCreateNewProjectButton() {
		return createNewProjectButton;
	}

	public void clickOnCreateNewCustomerButton() {
		createNewCustomerButton.click();
	}

	public void clickOnCreateNewProjectButton() {
		createNewProjectButton.click();
	}
	
	
	public void deleteProjectAndCustomer()
	{
		allLink.click();
		deleteSelectedButton.click();
		deleteButton.click();
	}

}
