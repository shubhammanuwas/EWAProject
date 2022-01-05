package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {

public boolean check(String uname,String upass) throws SQLException {
		
		String sql="select * from user where uname=? and upass=?";
		String url="jdbc:mysql://localhost:3306/fproject";
		String username="root";
		String password="Shubham@123";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,username,password);
			
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, uname);
			pst.setString(2, upass);
			
			ResultSet rs=pst.executeQuery();
			if(rs.next()){
				return true;
			}
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}
	
}
