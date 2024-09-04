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
 * Servlet implementation class StdRegister
 */
@WebServlet("/StdRegister")
public class StdRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StdRegister() {
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
            int stdid=Integer.parseInt(request.getParameter("t1"));
            String sname=request.getParameter("t2");
            int m1=Integer.parseInt(request.getParameter("t3"));
            int m2=Integer.parseInt(request.getParameter("t4"));
            int m3=Integer.parseInt(request.getParameter("t5"));
            int m4=Integer.parseInt(request.getParameter("t6"));
            int m5=Integer.parseInt(request.getParameter("t7"));
            int m6=Integer.parseInt(request.getParameter("t8"));
            
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            out.println("Driver is Loaded");
            
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/CollegeManagement2","root","tiger");
            out.println("Connection Established");
            
            java.sql.Statement st=con.createStatement();
            String query="insert into CollegeManagement2.student values ("+stdid+",'"+sname+"',"+m1+","+m2+","+m3+","+m4+","+m5+","+m6+");";
            
            st.execute(query);
            out.println("Record Inserted");
            
            con.close();
            out.println("Connection closed");
        }
        catch(Exception e) {
            out.println("Something Went Wrong!,Exception Occured");
        }
	}

}
