import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class JDBC3 extends JFrame implements ActionListener //for swing
//public class JDBC3 extends Frame implements ActionListener//for awt
{
	JLabel l1,l2;
	JTextField t1,t2;
	JButton b1,b2,b3,b4,b5,b6;
	JDBC3()
	{
		l1=new JLabel("Enter Employee Number");
		l2=new JLabel("Enter Employee Name");
		t1=new JTextField(20);
		t2=new JTextField(20);
		b1=new JButton("Insert");
		b2=new JButton("Update");
		b3=new JButton("Delete");
		b4=new JButton("Select");
		b5=new JButton("Select all");
		b6=new JButton("Delete all");
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		setLayout(new FlowLayout());
		add(l1);add(t1);
		add(l2);add(t2);
		add(b1);add(b2);
		add(b3);add(b4);
		add(b5);add(b6);
	}
	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		// TODO Auto-generated method stub
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
			if(ae.getSource()==(b1))
			{
				PreparedStatement ps=con.prepareStatement("insert into mphasis133 values(?,?)");
				String x=t1.getText();
				String y=t2.getText();
				int a=Integer.parseInt(x);
				ps.setInt(1, a);
				ps.setString(2, y);
				ps.execute();
				System.out.println("Row Inserted");
			}
			else if(ae.getSource()==(b2))
			{
				PreparedStatement ps1=con.prepareStatement("update mphasis133 set name=? where empno=?");
				String x=t1.getText();
				String y=t2.getText();
				int a=Integer.parseInt(x);
				ps1.setInt(2, a);
				ps1.setString(1, y);
				ps1.execute();
				System.out.println("Row Updated");
			}
			else if(ae.getSource()==(b3))
			{
				PreparedStatement ps3=con.prepareStatement("delete from mphasis133 where empno=?");
				//String x=t1.getText();
				String y=t1.getText();
				int a=Integer.parseInt(y);
				ps3.setInt(1, a);
				//ps3.setString(2, y);
				ps3.execute();
				System.out.println("Row Deleted");
			}
			else if(ae.getSource()==(b4))
			{
				PreparedStatement ps4=con.prepareStatement("select * from mphasis133 where empno=?");
				String y=t1.getText();
				int a=Integer.parseInt(y);
				ps4.setInt(1, a);
				ResultSet rs=ps4.executeQuery();
				System.out.printf("%-15s  %-30s\n","Employee Id","First Name");
				while (rs.next())
				{
					System.out.printf("%-15s  %-30s\n",rs.getString(1),rs.getString(2));
				}
			}
			else if(ae.getSource()==(b5))
			{
				PreparedStatement ps5=con.prepareStatement("select * from mphasis133");
				ResultSet rs=ps5.executeQuery();
				System.out.printf("%-15s  %-30s\n","Employee Id","First Name");
				while (rs.next())
				{
					System.out.printf("%-15s  %-30s\n",rs.getString(1),rs.getString(2));
				}
			}
			else if(ae.getSource()==(b6))
			{
				PreparedStatement ps6=con.prepareStatement("truncate table mphasis133");
				ps6.execute();
				System.out.println("Table Empty");
			}
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	public static void main(String[] args)
	{
		JDBC3 ob=new JDBC3();
		ob.setVisible(true);
		ob.setSize(400,400);
		ob.setTitle("Mphasis Batch 133");
	}

}
