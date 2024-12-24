package DDT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class InsertDataIntoDataBase {

	public static void main(String[] args) throws Throwable {

		// step1:- Register/Load mysql database
		Driver refDriver = new Driver();
		DriverManager.registerDriver(refDriver);

		// step2:- get connection to database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_info", "root", "root");

		// step3:- create SQL Statement
		Statement state = conn.createStatement();
		String query = "insert into students(id,first_name,last_name,address)values('4','sam','ram','goa')";

		int result = state.executeUpdate(query);

		if (result == 1) {
			System.out.println("data is passed");

		}

		else {
			System.out.println("Data is not passed");
		}

		conn.close();
	}

}
