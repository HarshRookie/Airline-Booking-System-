//RegisterServlet.
import java.io.*;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;
 

import javax.servlet.*;

import javax.servlet.http.*;

 
public class RegisterServlet extends HttpServlet 
{
		
	
public void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException 
{ 



String url = "jdbc:mysql://localhost:3306/airlinedb";
	
String username = "root";
	
String password = "root";

    
response.setContentType("text/html");
    
PrintWriter out=response.getWriter();

		
 String fromAirport = req.getParameter("fromAirport");
               String toAirport = req.getParameter("toAirport");
               String fromDay = req.getParameter("fromDay");
               String fromMonth = req.getParameter("fromMonth");
               String fromYear = req.getParameter("fromYear");
              
               String toDay = req.getParameter("toDay");
               String toMonth = req.getParameter("toMonth");
               String toYear = req.getParameter("toYear");
               String dep = fromYear+'-'+fromMonth+'-'+fromDay;
               String arr = toYear+'-'+toMonth+'-'+toDay;

		
try {

Class.forName("com.mysql.jdbc.Driver");
		
Connection con = DriverManager.getConnection(url, username, password);
	
PreparedStatement ps = con.prepareStatement("insert into book values(?,?,?,?)");
ps.setString(1,fromAirport);
ps.setString(2,toAirport);
ps.setString(3,dep);
ps.setString(4,arr);
			
			
int result = ps.executeUpdate();
			
			
if(result == 1)
{
                            
				
response.sendRedirect("success.html");
	
}
		
else
{
			
response.sendRedirect("error.html");
	
}
		
}
 catch(Exception e)
 {
		
	out.print(e);

}
	

}

}

