package rideshare;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ReviewAccese {

	private static String URL = " ";		//add url
	public static String USERNAME = "";		//add uname
	public static String PASSWORD = "";		//add pwd
	public static String DRIVER = "com.mysql.jdbc.Driver";
	
	private String userName ;
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.println("Please type in the username you want to see the review ");
		String userName = in.nextLine();
		reviewSearch(String userName);
	}
	
	
	public static void reviewSearch(String userName){
		try {
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "select uName,comment,score FROM rideShare WHERE uName=username";
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery(sql);
			while(rs.next()){
				
				String name = rs.getString();		//	add #of username
				String comment = rs.getString();   //	add #of Comment
				int score = rs.getInt();			//  add #of Score
				System.out.println("Username :" + name + " Comment :" + comment + " Score ");
			}
			 rs.close();
			 state.close();
			 conn.close();            
			 } catch (ClassNotFoundException e) {
			 e.printStackTrace();
			 } catch (SQLException e) {
			 e.printStackTrace();
			}
		}
		
	}

