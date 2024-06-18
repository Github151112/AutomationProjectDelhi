package PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class openTaskPage  extends BaseClass{

	public openTaskPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(linkText = "Projects & Customers")
	private WebElement projectAndCustomerLink;

	public WebElement getProjectAndCustomerLink() {
		return projectAndCustomerLink;
	}
	
	
	public void clickOnProjectAndCustomer()
	{
		projectAndCustomerLink.click();
	}

}
