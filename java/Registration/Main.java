package Registration;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Main
 */
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Main() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		String name = request.getParameter("name");

		String pass = request.getParameter("pass");

		String email = request.getParameter("email");
		

		MyDb db = new MyDb();

		Connection con = db.getCon();

		try {

		Statement stmt =  con.createStatement();

		stmt.executeUpdate("insert into user (uname,upass,email)values('"+name+"','"+pass+"','"+email+"')");

		System.out.println("data inserted sucessfully");

		} catch (SQLException e) {

		// TODO Auto-generated catch block

		e.printStackTrace();

		}
		
		
	}

}
