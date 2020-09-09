package utility;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.*;

public class Connectionmanager {

	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=null;
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","ayrus","root");
		if(con!=null)
			System.out.println("Established");
		else
			System.out.println("not connected");
			
	}

}
