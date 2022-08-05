import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.Connection;
//import com.sun.jdi.connect.spi.Connection;

public class Jdbc_config 
{
	static Connection con=null;
	public static Connection getConnection(Properties props)
	{
		
		
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/ecommercial";
		String username="root";
		String password="Ammu@21";
		
		try {
			// Load Driver
			Class.forName(driver);
			//get Connection and store it in con Object
			con = DriverManager.getConnection(url,username,password);
			if(con!=null)
			{
				System.out.println("Connection Established");
			}else {
				System.out.println("Error while making Connection");
			}
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		//create table eproduct  (id bigint primary  key auto_increment,name varchar(100),price decimal(10,2));

		//insert into eproduct(name,price) value(' mi mobile', 12000);
		
		return con;
		
	}
}
