package org.wenb.ems.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
	private static final String DBDRIVER = "org.git.mm.mysql.driver" ;
	private static final String DBURL = "jdbc:mysql://localhost:3306/ems" ;
	private static final String DBUSER = "root" ;
	private static final String DBPASS = "123456" ;
	private Connection conn = null ;
	public DataBaseConnection (){
		try {
			Class.forName(DBDRIVER) ;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS) ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	public Connection getConnection (){
		return this.conn ;
	}
	public void close(){
		if(this.conn != null){
			try {
				this.conn.close() ;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
  