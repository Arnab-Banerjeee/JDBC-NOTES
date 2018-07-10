import java.sql.*;
public class RSMD 
{
	public static void main(String[] args)
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
			PreparedStatement ps=con.prepareStatement("select * from mphasis133");
			ResultSet rs=ps.executeQuery();
			ResultSetMetaData rsmd=rs.getMetaData();
			System.out.println("Total Columns: "+rsmd.getColumnCount());
			System.out.println("Name of first Column: "+rsmd.getColumnName(1));
			System.out.println("Data Type of 1st Column: "+rsmd.getColumnTypeName(1));
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

}
