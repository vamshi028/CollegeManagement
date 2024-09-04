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
 * Servlet implementation class StdResult
 */
@WebServlet("/StdResult")
public class StdResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StdResult() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
        try {
            int id=Integer.parseInt(request.getParameter("rid"));
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            out.println("Driver is Loaded");
            
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/CollegeManagement2","root","tiger");
            out.println("Connection Established");
            
            java.sql.Statement st=con.createStatement();
            String query="select * from CollegeManagement2.student where stdid="+id+"; ";
            
            ResultSet rs=st.executeQuery(query);
            int i=0,t1=0,t2=0,t3=0,t4=0,t5=0,t6=0;
            String n="";

            
            while(rs.next()) {
            	i=rs.getInt(1);
            	n=rs.getString(2);
                t1=rs.getInt(3);
                t2=rs.getInt(4);
                t3=rs.getInt(5);
                t4=rs.getInt(6);
                t5=rs.getInt(7);
                t6=rs.getInt(8);
            }
            
            
            
            out.println("M1 Marks : "+ t1);
            out.println("M1 Grade : "+ getGrade(t1));
            
            out.println("M2 Marks : "+ t2);
            out.println("M2 Grade : "+ getGrade(t2));
            
            out.println("M3 Marks : "+ t3);
            out.println("M3 Grade : "+ getGrade(t3));
            
            out.println("M4 Marks : "+ t4);
            out.println("M4 Grade : "+ getGrade(t4));
            
            out.println("M5 Marks : "+ t5);
            out.println("M5 Grade : "+ getGrade(t5));
            
            out.println("M6 Marks : "+ t6);
            out.println("M6 Grade : "+ getGrade(t6));
            
            out.println("Over All Grade : "+ getOverAllGrade(t1,t2,t3,t4,t5,t6));
            
            out.println("Record Fetched Successfully...");
            
            con.close();
            out.println("Connection closed");
        }
        catch(Exception e) {
            out.println("Something Went Wrong!,Exception Occured"+e);
        }
	}
	
	 private String getOverAllGrade(int m1, int m2, int m3, int m4, int m5, int m6) {
	        // TODO Auto-generated method stub
		 	if(m1<60 || m2<60 || m3<60 || m4<60 || m5<60 || m6<60) {
	    		return "F";
	    	}else {
	    		int ans=(m1+m2+m3+m4+m5+m6)/6;
		        return getGrade(ans);
	    	}
	        
	    }

	    private String getGrade(int marks) {
	        // TODO Auto-generated method stub
	    	
	    	
	        if(marks>=90)
	            return "A";
	        else if(marks >= 80)
	            return "B";
	        else if(marks >= 70)
	            return "C";
	        else if(marks >= 60)
	            return "D";
	        else 
	            return "Fail";
	    }
}