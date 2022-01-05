package CRUD;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	PrintWriter out=response.getWriter();
		String id = request.getQueryString();
		String[] ids = id.split("=");
		System.out.println(ids[1]);
	
		try{  
			Connection con=null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			
	         
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fproject","root","Shubham@123");
           
    		String username = request.getParameter("uname");
    		String password = request.getParameter("upass");
    		String email = request.getParameter("email");
    		String salary = request.getParameter("salary");
    		String leaves = request.getParameter("leaves");
    		
    		if(con!=null) {
    		
    			String update_query = "UPDATE user SET uname=? , upass = ?, email = ?, salary = ?, leaves = ? where uname=?;";
    			
    		//String sql="UPDATE user SET upass=?, email=?, salary=?, leaves=? WHERE uname = ?;";
           PreparedStatement ps=con.prepareStatement(update_query); 
    		  	  
            ps.setString(1, username);
            ps.setString(2,password);  
            ps.setString(3,email);  
             
            ps.setString(4,salary);
            ps.setString(5, leaves);
            ps.setString(6, username);
           
              System.out.println("running");
              ps.executeUpdate();
            System.out.println("updated ");
            response.sendRedirect("ViewServlet");
              
            con.close();  
    		}
    		else {
    			out.println("<html><body>Connection not established</body></html>");
    		}
        }catch(Exception ex){ex.printStackTrace();} 
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
