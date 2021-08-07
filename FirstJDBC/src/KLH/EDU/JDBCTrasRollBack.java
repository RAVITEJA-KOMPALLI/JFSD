package KLH.EDU;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCTrasRollBack {
	private static final Connection NULL = null;

	public static void main(String[] args) {
		
		String url= "jdbc:mysql://localhost:3306/KLU";
		String user = "root";
		String pass = "Raviteja@01";
		
		//String query = "insert into CseStudents(Student_ID, Department, First_Name, Last_Name, PassOutYear, UniversityRank)values(?, ?, ?, ?, ?, ?);";
		String query3 = "update CseStudents set First_Name = ? where Student_ID = ?";
		try {
			System.out.println("Connecting to Database..."+url);
			@SuppressWarnings("unused")
			Connection con = DriverManager.getConnection(url,user,pass);
			
			//Transaction setting AutoCommit as False
			con.setAutoCommit(false);
			
			System.out.println("Successfully Connected");
			
			
			PreparedStatement smt1 = con.prepareStatement(query3);
			smt1.setString(1, "Teja");//1st question mark -> First Name = Rajesh
			smt1.setInt(2, 13);
			System.out.println(smt1);
			//Making Transaction to roll back
			con.rollback();
			
			
			
			//int records = smt.executeUpdate();
			//System.out.println(String.format("Records affected", records));
			System.out.println("Transaction Failure");
			
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}
