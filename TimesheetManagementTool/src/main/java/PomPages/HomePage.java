package PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BaseClass{

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//idenitfy user link
	@FindBy(xpath = "//a[@class='content users']")
	private WebElement usersLink;
	
	@FindBy(xpath = "//a[@class='content tasks']")
	private WebElement tasksLink;

	public WebElement getTasksLink() {
		return tasksLink;
	}


	public WebElement getUsersLink() {
		return usersLink;
	}
	
	
	public void clickOnUserLink()
	{
		usersLink.click();
	}
	
	public void clickOnTaskLink()
	{
		tasksLink.click();
	}
	

}
