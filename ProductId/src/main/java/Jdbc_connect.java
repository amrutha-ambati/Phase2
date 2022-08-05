import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;;

@WebServlet("/fetchJDBC")
public class Jdbc_connect extends HttpServlet
{
	static int sid;
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		sid=Integer.parseInt(req.getParameter("sid"));
		
		
		PrintWriter out= res.getWriter();
		
		Properties props=new Properties();
		res.setContentType("text/html");
		
		InputStream in=getServletContext().getResourceAsStream("/WEB-INF/application.properties");
		
		props.load(in);
		

		Connection conn=Jdbc_config.getConnection(props);
		
		if(conn!=null)
		{
			// out.print("Connection is Done Successfully"+sid);
			
			try { 
				 Statement stmt = conn.createStatement(); 
				 ResultSet  rs=stmt.executeQuery("select * from eproduct where id="+sid); 
				  
				 while(rs.next()) 
				 { 
					 out.println(rs.getInt(1)+" ,"+rs.getString(2)+", " 
				 	 +rs.getBigDecimal(3)+"<br>"); 
				 } 
				 				 
	 			}
			catch (SQLException e) 
			{ 
				 // TODO Auto-generated catch block 
				e.printStackTrace(); 
			} 

			
			
		}
		else
		{
			out.print("Connection not Established");
		}
	}

	
}
