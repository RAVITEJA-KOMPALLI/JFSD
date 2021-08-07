package KLH.EDU;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.CallableStatement;

public class JDBCcallable {
	private static final Connection NULL = null;

	public static void main(String[] args) {
		
		String url= "jdbc:mysql://localhost:3306/KLU";
		String user = "root";
		String pass = "Raviteja@01";
		
		//String query = "insert into CseStudents(Student_ID, Department, First_Name, Last_Name, PassOutYear, UniversityRank)values(?, ?, ?, ?, ?, ?);";
		//String query = "update CseStudents set First_Name = ? where Student_ID = ?";
		try {
			System.out.println("Connecting to Database..."+url);
			@SuppressWarnings("unused")
			Connection con = DriverManager.getConnection(url,user,pass);
			System.out.println("Successfully Connected");
			
			
			
			CallableStatement smt = con.prepareCall("{call Proc5(?,?,?)}");
			smt.setString(1,"Rakesh");
			smt.setInt(2, 1);
			smt.setString(3,"Hyderabad");
			smt.execute();
			
			smt.setString(1,"Ramesh");
			smt.setInt(2, 2);
			smt.setString(3,"Hyderabad");
			smt.execute();
			
			smt.setString(1,"Rajesh");
			smt.setInt(2, 3);
			smt.setString(3,"Hyderabad");
			smt.execute();
			
			System.out.println("Records inserted Successfully");	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}
