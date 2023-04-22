package JDBC_package;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Helper {
static {
	try {
		//register my sql driver
		Class.forName("com.mysql.cj.jdbc.Driver"); //driver class
		} catch(Exception e) {
		  System.out.println(e);
		}
    }
public static Connection con() throws SQLException{
	return DriverManager.getConnection //connection build up
       ("jdbc:mysql://localhost:3306/jdbcdb","root","root");
    }
 }

