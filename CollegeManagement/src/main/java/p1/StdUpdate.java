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

/**
 * Servlet implementation class StdUpdate
 */
@WebServlet("/StdUpdate")
public class StdUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StdUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
        try {
            int uid=Integer.parseInt(request.getParameter("uid"));
            int marks=Integer.parseInt(request.getParameter("marks"));
            String sub=request.getParameter("sub");
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            out.println("Driver is Loaded");
            
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/CollegeManagement2","root","tiger");
            out.println("Connection Established");
            
            java.sql.Statement st=con.createStatement();
            String query="update CollegeManagement2.student "
            		+ "set "+sub+"="+marks+" where stdid="+uid+"; ";
            
            st.execute(query);
            out.println("Record Updated");
            
            con.close();
            out.println("Connection closed");
        }
        catch(Exception e) {
            out.println("Something Went Wrong!,Exception Occured");
        }
	}

}
