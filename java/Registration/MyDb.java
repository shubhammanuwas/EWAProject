package Registration;

import java.sql.*;

public class MyDb {
	public Connection con;
	public Connection getCon(){
	try {
	Class.forName("com.mysql.jdbc.Driver");
	con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/fproject", "root", "Shubham@123");
	} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	return con;
	}

}
