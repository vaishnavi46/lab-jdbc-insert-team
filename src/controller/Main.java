
package controller;
import java.util.*;
import java.sql.*;

public class Main
{
	public static void main(String[] args) throws SQLException, ClassNotFoundException
	{
		Connection con=null;
		Statement stmt = null;
		
		Class.forName("oracle.jdbc.OracleDriver");

		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","ayrus","root");
		if(con!=null)
			System.out.println("Established");
		else
			System.out.println("not connected");
		
		stmt = con.createStatement();
		
		Scanner play=new Scanner(System.in);
		System.out.println("Enter team name");
		String team=play.nextLine();
		System.out.println("Enter coach name");
		String coach=play.nextLine();
		System.out.println("Enter city name");
		String city=play.nextLine();
		System.out.println("Team has been created");
		System.out.println("Team details are");
		System.out.println("name          coach          city");
		
		String sql = "INSERT INTO team_test (id,name,coach,home_city) VALUES (1,'"+team+"', '"+coach+"', '"+city+"')";
		stmt.executeUpdate(sql);
		
		String sq="SELECT * FROM team_test";
		ResultSet rs = stmt.executeQuery(sq);
		
	      //STEP 5: Extract data from result set
	      while(rs.next()){
	         //Retrieve by column name
	         String name=rs.getString("name");
	         String coach1=rs.getString("coach");
	         String city1=rs.getString("home_city");

	         //Display values
	         System.out.print(name+"          ");
	         System.out.print(coach1+"          ");
	         System.out.println(city1+"          ");
	      }
	      rs.close();
		//System.out.println(sql);
	}
}