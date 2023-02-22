package edu.jdbctestone;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTestOne {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/" 
					+ "malldb?useSSL=" +
							"false&serverTimezone=Asia/Seoul",
							"root", "895029qaz");
			
			if(conn != null) {
				System.out.println("DB 연결 완료");
				stmt = conn.createStatement();
				ResultSet srs = stmt.executeQuery(
						"select * from userTbl");
				printData(srs, "userID", "name", "birthYear", "addr", "mobile1", "mobile2", "height", "mDate");
				ResultSet srs1 = stmt.executeQuery(
						"select * from buyTbl");
				
				printData1(srs1, "num", "userID", "prodName", "groupName", "price", "amount");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로드 오류");
		} catch (SQLException e) {
			System.out.println("DB 연결 오류");
		}
	}


	   private static void printData(
		         ResultSet srs, 
		         String col1, String col2, String col3,
		         String col4, String col5, String col6, String col7, String col8) throws SQLException {
		      while (srs.next()) {
		         if (!col1.equals(""))
		            System.out.println(srs.getString("userID")); 
		         if (!col2.equals(""))
		            System.out.print("\t|\t" + 
		                  srs.getString("name"));
		         if (!col3.equals(""))
		            System.out.print("\t|\t" + 
		                  srs.getString("birthYear"));
		         if (!col4.equals(""))
			            System.out.print("\t|\t" + 
			                  srs.getString("addr"));
		         if (!col5.equals(""))
			            System.out.print("\t|\t" + 
			                  srs.getString("mobile1"));
		         if (!col6.equals(""))
			            System.out.print("\t|\t" + 
			                  srs.getString("mobile2"));
		         if (!col7.equals(""))
			            System.out.print("\t|\t" + 
			                  srs.getString("height"));
		         if (!col8.equals(""))
			            System.out.print("\t|\t" + 
			                  srs.getString("mDate"));
		         else 
		            System.out.println();
		      }
	   }
	
		private static void printData1(
		        ResultSet srs, 
		        String col1, String col2, String col3,
		        String col4, String col5, String col6) throws SQLException {
		     while (srs.next()) {
		        if (!col1.equals(""))
		           System.out.println(srs.getString("num")); 
		        if (!col2.equals(""))
		           System.out.print("\t|\t" + 
		                 srs.getString("userID"));
		        if (!col3.equals(""))
		            System.out.print("\t|\t" + 
		                  srs.getString("prodName"));
		        if (!col4.equals(""))
		           System.out.print("\t|\t" + 
		                 srs.getString("groupName"));
		        if (!col5.equals(""))
			            System.out.print("\t|\t" + 
			                  srs.getString("price"));
		        if (!col6.equals(""))
		        	System.out.print("\t|\t" + srs.getString("amount"));
		        
		       
		        else 
		           System.out.println();
		     }
		}
	}


		
