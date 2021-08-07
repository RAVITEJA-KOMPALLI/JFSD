package KLH.EDU;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {
	private static final Connection NULL = null;

	public static void main(String[] args) {
		
		String url= "jdbc:mysql://localhost:3306/KLU";
		String user = "root";
		String pass = "Raviteja@01";
		String query = "select * from CseStudents;";
		String query1 = "delete from CseStudents where id = 1;";
		String query2 = "insert into CseStudents(Student_ID, Department, First_Name, Last_Name, PassOutYear, UniversityRank)values(?, ?, ?, ?, ?, ?);";
		String query3 = "update CseStudents set Student_ID = 5 where Student_ID=2";
		try {
			System.out.println("Connecting to Database... "+url);
			@SuppressWarnings("unused")
			Connection con = DriverManager.getConnection(url,user,pass);
			System.out.println("Successfully Connected");
			
			//Select statement
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery(query);
			System.out.println(result);
			
			//Printing the data
			String KLUData = "";
			while(result.next()) {
				
				for(int i =1; i<=6;i++) {
					KLUData += result.getString(i) +" : ";
				}
				KLUData +="\n";
				
			}
			System.out.println(KLUData);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}
