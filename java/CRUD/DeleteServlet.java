package CRUD;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteServlet
 */
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		try {
			
			String id = request.getQueryString();
			String[] ids = id.split("=");
			System.out.println(ids[1]);
			String query = ids[1];
			
//			System.out.println(id.split("="));
			
			Class.forName("com.mysql.cj.jdbc.Driver");
	         
    		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fproject","root","Shubham@123");
    		
    		// Delete statement
    		PreparedStatement pst = con.prepareStatement("delete from user where uname = ?");
    		pst.setString(1, query);
//    		
    		int record = pst.executeUpdate();
    		if(record == 1)
    				System.out.println("Deleted Succesfully!!!");
    		else {
    				System.out.println("Record not Found!!");
    		}
    		
    		response.sendRedirect("/RegProject/ViewServlet");
		
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
