package DDT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class FetchingDataFromDataBase {

	public static void main(String[] args) throws Throwable {

        //step1:- Register/Load mysql database
		Driver refDriver = new Driver();
		DriverManager.registerDriver(refDriver);

		// step2:- get connection to database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_info", "root", "root");

		// step3:- create SQL Statement
		Statement state = conn.createStatement();
		String Query = "select * from students";

		// step4:- execute statement / Query
		ResultSet result = state.executeQuery(Query);

		while (result.next()) {
			System.out.println(result.getInt(1) + "\t" + result.getString(2) + "\t" + result.getString(3) + "\t"
					+ result.getString(4));
		}
		// step5:- close the connection
		conn.close();
	}

}
