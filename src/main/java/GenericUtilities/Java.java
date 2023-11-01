package GenericUtilities;

import java.util.Random;

public class Java
{
	public int getRandomNumber()
	{
		Random ran = new Random();
		int r = ran.nextInt(1000);
		return r;
	}
}
