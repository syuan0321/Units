/**************************************************************************
 ConnectionPool
 
 Self-defined Connection Pool
 
 Connections usually do:
 1.Load corresponding DataBase Drivers
 2.Open a connection
 3.Operate transaction in connection
 4.Close connection
 Step 1,2,4 are duplicated in all operation process, so could use pool to Add/Release them all.
 

***************************************************************************/
package com.syuan0321.unitseed.JDBCConnection;

import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

public class MyConnectionPool{
	public static int POOL_SIZE = 5;
	
	private DataSource ds;

	private static Properties props = new Properties();
	private List<Connection> list = new ArrayList<Connection>(POOL_SIZE);
	private MyConnectionPool mpool = null;

	static {
		InputStream in = MyConnectionPool.class.getClassLoader().getResourceAsStream("dbconfig.properties");
		try {
			props.load(in);
			Class.forName(props.getProperty("driverClassName"));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// Ini Pools
	private MyConnectionPool() {
		for (int i = 0; i < POOL_SIZE; i++) {
			try {
				Connection con;
				//1.
				con = DriverManager.getConnection(props.getProperty("url"), props.getProperty("username"),
						props.getProperty("password"));
				/*2.
				 * con = ds.getConnection();
				 * 
				 * 
				*/
				this.add(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public MyConnectionPool getInstance(){
		return mpool == null ? new MyConnectionPool() : mpool;
	}

	public void add(Connection con) {
		list.add(con);
	}

	public Connection getConnection() throws SQLException {
		if (list.size() > 0) {
			return list.remove(0);
		}
		throw new SQLException("No Conn in pool is available, please wait...");
	}


}
