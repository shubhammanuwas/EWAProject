package CRUD;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormHandler
 */
public class FormHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		
		
				String action = request.getServletPath();
				
				// Set the response message's MIME type
			      response.setContentType("text/html; charset=UTF-8");
			      // Allocate a output writer to write the response message into the network socket
			      PrintWriter out = response.getWriter();
			 
			      // Write the response message, in an HTML page
			      try {
			         out.println("<!DOCTYPE html>");
			         out.println("<html><head>");
			         out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
			         out.println("<title>Echo Servlet</title></head>");
			         out.println("<body><h2>You have entered</h2>");
			         
			         Class.forName("com.mysql.cj.jdbc.Driver");
			         
			         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fproject","root","Shubham@123");
			         
			         
			         
			         // Retrieve the value of the query parameter "username" (from text field)
			         String username = request.getParameter("uname");
			         if (username == null) {
			        	 System.out.println("Username is missing!");
			         }
			         else {
			        	 out.println("<p>Name: " + username + "</p>");
			         }
			      // Retrieve the value of the query parameter "password" (from password field)
			         String password = request.getParameter("upass");
			         if (password == null) {
			        	 System.out.println("Password is missing!!");
			         }
			         else {
			        	 out.println("<p>Password: " + password + "</p>");
			         }
			         // Retrieve the value of the query parameter "gender" (from radio button)
			         String email = request.getParameter("email");
			         if (email == null) {
			             System.out.println("Please enter your email!!");
			          } else {
			             out.println("<p>Email is: "+email+"</p>");
			          }
			      // Retrieve the value of the query parameter "age" (from pull-down menu)
			         String salary = request.getParameter("salary");
			         if (salary == null) {
			            System.out.println("Please enter your salary!!");
			         } else {
			            out.println("<p>Salary is: "+salary+"</p>");
			         }
			   
			         
			         String leaves = request.getParameter("leaves");
			      
			       
			         if (leaves == null) {
			            System.out.println(" None leaves!");
			         } else {
			        	 out.println("<p>Leaves is: "+leaves+"</p>");
			         }
			      
			       
			      // Hyperlink "BACK" to input page
			         out.println("<a href='record.jsp'>BACK</a>"+"  "+"<a href='ViewServlet'>View Details</a>");
			 
			         out.println("</body></html>");
			         
			         String insert_query = "insert into user values ('"+username+"', '"+password+"', '"+email+"', "+salary+", '"+leaves+"')";
			      
			         Statement stmt = con.createStatement();
			         
			         int record = stmt.executeUpdate(insert_query);
			         
			         if(record == 1) {
			        	 	out.println("<h2>Record Inserted Successfully</h2>");
			         }else {
			        	 out.println("<h2>Error in saving the record!!<h2>");
			         }
			         
			         out.println("</body></html>");
			      
			      } catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			      finally {
			          out.close();  // Always close the output writer
			       }
			}
		
		
	}


