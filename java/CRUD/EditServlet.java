package CRUD;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditServlet
 */
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();
        String id = request.getQueryString();
		String[] ids = id.split("=");
		System.out.println(ids[1]);
		String selected_name = ids[1];
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	         
    		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fproject","root","Shubham@123");
    		
//    		Statement stmt = con.createStatement();
    		
    		String query = "select * from user where uname = ?";
    		
    		PreparedStatement pst = con.prepareStatement(query);
    		pst.setString(1, selected_name);
    		
    		ResultSet rs = pst.executeQuery();
    		
    		while(rs.next()) {
    			out.print("<form action='/RegProject/UpdateServlet?id="+rs.getString(1)+"' method='post'>");  
                out.print("<table>");  
                out.print("<tr><td>Name:</td><td><input type='text' name='uname' value='"+rs.getString(1)+"' disabled/></td></tr>");    
                out.print("<tr><td>Password:</td><td><input type='password' name='upass' value='"+rs.getString(2)+"'/></td></tr>");  
                out.print("<tr><td>Email:</td><td><input type='text' name='email' value='"+rs.getString(3)+"'/></td></tr>");  
                out.print("<tr><td>Salary:</td><td><input type='number' name='salary' value='"+rs.getString(4)+"'/></td></tr>");  
                out.print("<tr><td>Leaves:</td><td><input type='text' name='leaves' value='"+rs.getString(5)+"'/></td></tr>");
             
                out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
                out.print("</table>");  
                out.print("</form>");  
    		}
    		
    		
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
