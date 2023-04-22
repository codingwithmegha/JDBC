package JDBC_package;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Updatejdbc {
		public static void main(String[] args) {
			try {
		Class.forName("com.mysql.cj.jdbc.Driver");//register driver step 1
		// create connection
		Connection conn=DriverManager.getConnection
		("jdbc:mysql://localhost:3306/jdbcdb","root","root");//build connection step 2
		Statement stmt=conn.createStatement();//create statement step 3
		//updating an existing record
		stmt.executeUpdate
		("update studentDemo set ename='Ritu' where emp_id=10");//update
		//delete record
		stmt.executeUpdate("delete from studentdemo where emp_id = 12");//delete
		//execute query fetch data from database
		ResultSet rs=stmt.executeQuery("select * from studentdemo");//read (fetch)
		//iteration
		while(rs.next()) {
		System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getInt(6)+" "+rs.getInt(7));
		}
		//close database connection step 5
		conn.close();
		}
		catch(Exception e) {
		System.out.println(e);
		}
		}
	}

