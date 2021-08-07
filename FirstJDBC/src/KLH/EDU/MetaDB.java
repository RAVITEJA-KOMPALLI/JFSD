package KLH.EDU;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class MetaDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String url= "jdbc:mysql://localhost:3306/KLU";
		String user = "root";
		String pass = "Raviteja@01";
		
		
		try {
			System.out.println("Connecting to Database..."+url);
			@SuppressWarnings("unused")
			Connection con = DriverManager.getConnection(url,user,pass);
			System.out.println("Successfully Connected");
			
			DatabaseMetaData db = con.getMetaData();
			System.out.println("Driver Name: "+db.getDriverName());
			System.out.println("Driver Version: "+db.getDriverVersion());
			System.out.println("User Name: "+db.getUserName());
			System.out.println("DataBase Product Name: "+db.getDatabaseProductName());
			System.out.println("DataBase Product Version: "+db.getDatabaseProductVersion());
			
			
				
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
