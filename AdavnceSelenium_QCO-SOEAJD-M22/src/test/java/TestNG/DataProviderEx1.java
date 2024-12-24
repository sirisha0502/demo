package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx1 {

	@Test(dataProvider = "getData")
	public void bookTickets(String src, String dest,int numOfPpl) {
		System.out.println("Book Tickets from " + src + " to " + dest+","+numOfPpl+"");
	}

	@DataProvider
	public Object[][] getData() {

		Object[][] obj = new Object[3][3];

		obj[0][0] = "Banglore";
		obj[0][1] = "Goa";
		obj[0][2]=2;

		obj[1][0] = "Banglore";
		obj[1][1] = "mysore";
		obj[1][2]=3;

		obj[2][0] = "Banglore";
		obj[2][1] = "chennai";
		obj[2][2]=4;

		return obj;
}

}
