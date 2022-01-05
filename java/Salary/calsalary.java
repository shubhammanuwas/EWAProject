package Salary;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class calsalary
 */
public class calsalary extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public calsalary() {
        super();
        // TODO Auto-generated constructor stub
    }

//	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		PrintWriter out=res.getWriter();
		
		int salary=Integer.parseInt(req.getParameter("salary"));
		
		
		int tax,nsal;
		
		if(salary>50000) {
			tax=salary*(10/100);
		}
		else if(salary>30000) {
			
			tax=salary*(5/100);
		}
		else {
			tax=0;
		}
		
		out.println("Employee tax: "+tax);
		
		nsal=salary-tax; 
		
		out.println("Employee NetSalary: "+nsal);
	
		
		
	}

}
