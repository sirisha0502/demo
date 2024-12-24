package TestNG;

import java.util.Date;

import org.testng.annotations.Test;

public class SystemData {

	
	@Test
	public void m1()
	{
		Date date = new Date();
		System.out.println(date);
	}
}
