package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StdDelete
 */
@WebServlet("/StdDelete")
public class StdDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StdDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
        try {
            int id=Integer.parseInt(request.getParameter("id"));
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            out.println("Driver is Loaded");
            
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/CollegeManagement2","root","tiger");
            out.println("Connection Established");
            
            java.sql.Statement st=con.createStatement();
            String query="delete from CollegeManagement2.student where stdid="+id+"; ";
            
            st.execute(query);
            out.println("Record Deleted");
            
            con.close();
            out.println("Connection closed");
        }
        catch(Exception e) {
            out.println("Something Went Wrong!,Exception Occured");
        }
	}

}
