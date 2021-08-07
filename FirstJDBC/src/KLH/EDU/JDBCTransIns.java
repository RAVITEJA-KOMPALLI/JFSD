package KLH.EDU;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCTransIns {
	private static final Connection NULL = null;

	public static void main(String[] args) {
		
		String url= "jdbc:mysql://localhost:3306/KLU";
		String user = "root";
		String pass = "Raviteja@01";
		
		String query = "insert into CseStudents(Student_ID, Department, First_Name, Last_Name, PassOutYear, UniversityRank)values(?, ?, ?, ?, ?, ?);";
		String query3 = "update CseStudents set First_Name = ? where Student_ID = ?";
		try {
			System.out.println("Connecting to Database..."+url);
			@SuppressWarnings("unused")
			Connection con = DriverManager.getConnection(url,user,pass);
			
			//Transaction setting AutoCommit as False
			con.setAutoCommit(false);
			System.out.println("Successfully Connected");
			
			//Inserting into table
			//Similarly we can do the update command also 
			PreparedStatement smt = con.prepareStatement(query);
			smt.setInt(1, 13);//1st question mark -> Student ID = 13
			smt.setString(2, "CSE");
			smt.setString(3,"Rakesh");
			smt.setString(4,"Apam");
			smt.setInt(5,2014);
			smt.setInt(6, 2);
			smt.executeUpdate();
			//
			
			PreparedStatement smt1 = con.prepareStatement(query3);
			smt1.setString(1, "Ramesh");//1st question mark -> First Name = Rajesh
			smt1.setInt(2, 13);
			smt1.executeUpdate();
			
			
			con.commit();
			//int records = smt.executeUpdate();
			//System.out.println(String.format("Records affected", records));
			System.out.println("Transaction Compleated Susscessfully");
			
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}
