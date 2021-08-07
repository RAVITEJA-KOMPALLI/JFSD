package KLH.EDU;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCupdate {
	private static final Connection NULL = null;

	public static void main(String[] args) {
		
		String url= "jdbc:mysql://localhost:3306/KLU";
		String user = "root";
		String pass = "Raviteja@01";
		
		//String query = "insert into CseStudents(Student_ID, Department, First_Name, Last_Name, PassOutYear, UniversityRank)values(?, ?, ?, ?, ?, ?);";
		String query = "update CseStudents set First_Name = ? where Student_ID = ?";
		try {
			System.out.println("Connecting to Database..."+url);
			@SuppressWarnings("unused")
			Connection con = DriverManager.getConnection(url,user,pass);
			System.out.println("Successfully Connected");
			
			//Updating into table
			
			PreparedStatement smt = con.prepareStatement(query);
			smt.setString(1, "Rajesh");//1st question mark -> First Name = Rajesh
			smt.setInt(2, 11);//2nd Question mark -> Student_ID = 10
			
			int records = smt.executeUpdate();
			System.out.println(String.format("Records affected", records));	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}
