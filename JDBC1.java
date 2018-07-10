import java.sql.*;

public class JDBC1 
{
	public static void main(String[] args) throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection
				("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
		Statement st=con.createStatement();
		//st.execute("create table mphasis133 (empno number,name varchar2(30))");
		//st.execute("insert into mphasis133 values(1,'Rahul')");
		//System.out.println("Row Inserted");
		//System.out.println(st.execute("select * from mphasis133"));
		//ResultSet Rs=st.executeQuery("select * from EMPLOYEES where Department_Id=80");
		//System.out.printf("%-6s  %-30s  %-30s\n\n","Employeee Id","First Name","Last Name");
		//while (Rs.next())
		{
			//System.out.printf("%-15s  %-30s  %-10s\n",Rs.getString(1),Rs.getString(2),Rs.getString(3));
		}
		st.execute("truncate table mphasis133");
	}

}
