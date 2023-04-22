package JDBC_package;

import java.util.*;
import java.sql.*;
//menudriven with CRUD operation
public class MenudrivenEg {
	Scanner sc=new Scanner(System.in);
	int emp_id,working_hour,salary;
	String ename,designation,dept,address;
	//saving employee details in database --- C stand for create
	public void saveMenuDriven() throws SQLException{
		System.out.println("Enter emp id: ");
		String emp_id=sc.next();
		System.out.println("Enter emp name: ");
		String ename=sc.next();
		System.out.println("Enter Designation: ");
		String designation=sc.next();
		System.out.println("Enter dept: ");
		String dept=sc.next();
		System.out.println("Enter Address: ");
		String address=sc.next();
		System.out.println("Enter working_hours: ");
		String working_hours=sc.next();
		System.out.println("Enter Salary: ");
		String salary=sc.next();
		
		Connection conn=Helper.con();//step 1 to 3
		PreparedStatement stmt=conn.prepareStatement
				("Inset into studentdemo values(?,?,?,?,?,?,?)");
		
		stmt.setString(1,emp_id);
		stmt.setString(2,ename);
		stmt.setString(3,designation);
		stmt.setString(4,dept);
		stmt.setString(5,address);
		stmt.setString(6,working_hours);
		stmt.setString(7,salary);
		stmt.execute();
	}
	//fetching employee details in the database (display) --- R stands for read
	public void fetchMenuDriven() throws SQLException{
		Connection conn=Helper.con();//step 1 to 3
		Statement stmt=conn.createStatement();
		//execute query fetch data from database
		ResultSet rs=stmt.executeQuery("select*from studentdemo");
		//iteration
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getInt(6)+" "+rs.getInt(7));
		}
	}
	//updating employee details in the database --- U stand for update
	public void updateMenuDriven() throws SQLException{
		Connection conn=Helper.con();
		Statement stmt=conn.createStatement();//create statement
		System.out.println("Enter employee dept: ");
		dept=sc.nextLine();
		stmt.executeUpdate
		("update studentdemo set dept="+dept+" where emp_id="+14);
	}
	//deleting employee detail in the database --- D stand for delete
	public void deleteMenuDriven() throws SQLException{
		Connection conn=Helper.con();
		Statement stmt=conn.createStatement();
		System.out.println("Enter employee Id: ");
		emp_id=sc.nextInt();
		stmt.executeUpdate("delete from studentdemo where emp_id="+emp_id);
	}
}

