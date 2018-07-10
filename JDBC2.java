import java.sql.*;
import java.util.*;
public class JDBC2 
{
	public static void main(String[] args) throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection
				("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
		Scanner ob=new Scanner(System.in);
		Statement st1=con.createStatement();
		//st1.execute("create table mphasis134 (empno number,name varchar2(30))");
		int c=1;
		while(c>0)
		{
			System.out.println("Enter Employee ID");
			int a=ob.nextInt();
			c=a;
			if(c>0)
			{
				System.out.println("Enter First name");
				String b=ob.next();
				//PreparedStatement st=con.prepareStatement("insert into mphasis133 values(?,?)");
				PreparedStatement st=con.prepareStatement("update mphasis133 set name=? where empno=?");
				//st.setInt(1, a);
				//st.setString(2, b);
				st.setString(1, b);
				st.setInt(2, a);
				st.execute();
			}
		}
		ResultSet rs=st1.executeQuery("select * from mphasis133");
		System.out.printf("%-15s  %-30s\n","Employee Id","First Name");
		while (rs.next())
		{
			System.out.printf("%-15s  %-30s\n",rs.getString(1),rs.getString(2));
		}

	}	
}
