package GenericLib;

import java.util.Random;

public class WorkLib {
	
	public int getRandomNo()
	{
		Random r = new Random();
		return r.nextInt(10000);
	}

}
