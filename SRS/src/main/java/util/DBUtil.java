package util;

import java.sql.*;


public class DBUtil {
	
	public static Connection getSqliteConnection(){
		String driver="org.sqlite.JDBC";
		String conStr="jdbc:sqlite:../../JavaWork/GuitarSearchV3/db/GuitarSearchV3.db";
		Connection conn=null;
		try{
			Class.forName(driver);
			conn = DriverManager.getConnection(conStr);
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;			
	}
	
}
