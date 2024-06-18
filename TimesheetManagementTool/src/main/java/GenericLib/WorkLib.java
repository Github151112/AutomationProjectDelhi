package GenericLib;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WorkLib {
	
	public int getRandomNo()
	{
		Random r = new Random();
		return r.nextInt(10000);
	}
	
	
	public void selecByVisibleText(WebElement element,String text)
	{
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}

}
