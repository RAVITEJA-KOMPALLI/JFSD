package KLH.EDU;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCinsert {
	private static final Connection NULL = null;

	public static void main(String[] args) {
		
		String url= "jdbc:mysql://localhost:3306/KLU";
		String user = "root";
		String pass = "Raviteja@01";
		
		String query = "insert into CseStudents(Student_ID, Department, First_Name, Last_Name, PassOutYear, UniversityRank)values(?, ?, ?, ?, ?, ?);";
		//String query3 = "update CseStudents set Student_ID = 5 where Student_ID=2";
		try {
			System.out.println("Connecting to Database..."+url);
			@SuppressWarnings("unused")
			Connection con = DriverManager.getConnection(url,user,pass);
			System.out.println("Successfully Connected");
			
			//Inserting into table
			//Similarly we can do the update command also 
			PreparedStatement smt = con.prepareStatement(query);
			smt.setInt(1, 10);//1st question mark -> Student ID = 10
			smt.setString(2, "CSE");
			smt.setString(3,"Ramu");
			smt.setString(4,"Kaja");
			smt.setInt(5,2010);
			smt.setInt(6, 2);
			
			int records = smt.executeUpdate();
			System.out.println(String.format("Records affected", records));
			
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}
