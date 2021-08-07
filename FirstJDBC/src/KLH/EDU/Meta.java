package KLH.EDU;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.ResultSetMetaData;

public class Meta {

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
			
			PreparedStatement smt = con.prepareStatement("select * from CseStudents");
			ResultSet rs = smt.executeQuery();
			ResultSetMetaData r = rs.getMetaData();
			
			System.out.println("No of Columns in the table "+r.getColumnCount());
			System.out.println("Columns in the table are");
			int i = 0;
			while (i!=r.getColumnCount()){
				System.out.println(r.getColumnName(i+1)+" || "+r.getColumnTypeName(i+1)+" || "+r.getColumnDisplaySize(i+1));
				i = i+1;
			}
			
			
				
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
