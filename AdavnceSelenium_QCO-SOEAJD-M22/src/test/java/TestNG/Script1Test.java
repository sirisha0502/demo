package TestNG;

import org.testng.annotations.Test;


public class Script1Test {

	@Test(invocationCount =3 )
	
	public void createProductTest()
	{
		
		System.out.println("Product created");
	}

	@Test
	public void modifyProduct()
	{
		System.out.println("Product modified");
	}
	
	@Test
	public void deleteProduct()
	{
		System.out.println("Product Deleted");
	}

}
