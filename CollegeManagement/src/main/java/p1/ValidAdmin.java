package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class ValidAdmin
 */
@WebServlet("/ValidAdmin")
public class ValidAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String username=request.getParameter("t1");
		String password=request.getParameter("t2");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			out.println("Driver Loaded");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/CollegeManagement2","root","tiger");
			out.println("Connection established");
			
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("Select * from Admin where username='"+username+"' And password='"+password+"'");
			
			if(rs.next()) {
				response.sendRedirect("AdminIndex.html");
			}else {
				out.println("Invalid UserName and Password");
			}
			
			con.close();
			out.println("Connection Closed");
		}catch(Exception e) {
			out.println("Error"+e);
		}
	}

}
