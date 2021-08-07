package KLH.EDU;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ScrollableResultSet {
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
			
			Statement smt =  con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			//InSensitive -> we cannot update ReadOnly -> cannot update
			ResultSet rs = smt.executeQuery("select * from CseStudents");
			
			//rs.beforeFirst();
			//rs.afterLast();
			rs.afterLast();
			rs.beforeFirst();
			
			rs.relative(4);//Start From a particular record 
			/*
			 * rs.relative
			 * rs.absolute
			 * rs.first
			 * rs.last
			 * */
			//System.out.println("Using Absolute method: "+rs.absolute(4));
			
			while(rs.next()) { //use rs.previous if rs.beforeFirst(); is written first and rs.afterLast();is kept last
		        System.out.println(rs.getInt(1)+" | "+rs.getString(2)+" | "+rs.getString(3)+" | "+rs.getString(4)+" | "+rs.getInt(5)+" | "+rs.getInt(6));
		      }
			System.out.println("\n\nUsing absolute() method:");
			rs.absolute(2);//get a particular record
			System.out.println(rs.getInt(1)+" | "+rs.getString(2)+" | "+rs.getString(3)+" | "+rs.getString(4)+" | "+rs.getInt(5)+" | "+rs.getInt(6));
			
			System.out.println("\n\nUsing first() method:");
			
			rs.first();
			while(rs.next()) { 
				System.out.println(rs.getInt(1)+" | "+rs.getString(2)+" | "+rs.getString(3)+" | "+rs.getString(4)+" | "+rs.getInt(5)+" | "+rs.getInt(6));
			}
			
			System.out.println("\n\nUsing last() method:");
			
			rs.last();
			while(rs.previous()) { 
				System.out.println(rs.getInt(1)+" | "+rs.getString(2)+" | "+rs.getString(3)+" | "+rs.getString(4)+" | "+rs.getInt(5)+" | "+rs.getInt(6));
			}
			
				
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
