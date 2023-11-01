package Practice;

import GenericUtilities.JavaUtility;

public class JavaUtilityPractice
{
	public static void main(String[] args)
	{
		JavaUtility jUtil = new JavaUtility();
		int rnum = jUtil.getRandomNumber();
		System.out.println(rnum);
		
		String date = jUtil.getSystemDate();
		System.out.println(date);
	}
}
