package com.cugb.javaee.onlinefoodcourt.utils;


import java.sql.*;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

//import org.apache.tomcat.dbcp.dbcp2.BasicDataSourceFactory;

import java.io.*;

public class JDBCUtils {
	private static String drivername;
	private static String url;
	private static String username;
	private static String password;
	private static DataSource myds = null;
	private JDBCUtils(){}
	
	static{
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			myds = (DataSource)envCtx.lookup("jndi/OnlineFoodCourt");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConnection() throws SQLException{
		Connection conn = null;
		conn = myds.getConnection();
		System.out.println("正在生成: "+conn);
		return conn;
	}
	
}
