package KLH.EDU;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ScrollableDelete {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/KLU";
		String pass = "Raviteja@01";
		String user = "root";
		
		try {
			Connection con = DriverManager.getConnection(url,user,pass);
			
			Statement smt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet r= smt.executeQuery("Select * from CseStudents");
			
			r.absolute(3);
			r.deleteRow();
			System.out.println("Deleted Successfully");
			
		}catch(Exception e) {
			
		}
	}
}
