package com.utils;

import java.sql.*;

public class JDBCConnectivity {

	public static void main(String ar[]){  
		 try{  
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
             String database = "jdbc:odbc:Driver={Microsoft Access Driver (*.accmdb)};DBQ=F:\\AccessDB\\TWSJobs.accmdb;";
	         Connection conn = DriverManager.getConnection(database, "", "");
	         Statement s = conn.createStatement();
	         
	      // Fetch table
             String selTable = "SELECT * FROM Job_Avg_Runtime";
             s.execute(selTable);
	         ResultSet rs = s.getResultSet();
	         while((rs!=null) && (rs.next()))
	         {
	                System.out.println(rs.getString(1) + " : " + rs.getString(2));
	         }
	         
		}catch(Exception ee){System.out.println(ee);}  
		  
		}
	
}