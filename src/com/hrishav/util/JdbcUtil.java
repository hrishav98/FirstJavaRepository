package com.hrishav.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;


//Using hikaricp configuration for the connection pooling 
public class JdbcUtil {

	private JdbcUtil() {
		
	}
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getJdbcConnection() throws SQLException,IOException{
		HikariConfig config=new HikariConfig("src\\com\\hrishav\\properties\\db.properties");
		HikariDataSource dataSource=new HikariDataSource(config);
		Connection connection=dataSource.getConnection();
		return connection;
		
	}
	@SuppressWarnings("unused")
	private static Connection physicalConnection() throws SQLException, IOException {
		//Creating FileInputStrem and putting the location of the db.properties file in it which is copied from the properties
		FileInputStream fis=new FileInputStream("src\\com\\hrishav\\properties\\db.properties");
		Properties properties=new Properties();
		properties.load(fis);
		
		//Getting all the properties from the file
		String url=properties.getProperty("url");
		String username=properties.getProperty("user");
		String password=properties.getProperty("password1");
		
		//Creating t
		Connection connection=DriverManager.getConnection(url, username, password);
		return connection;
		
	}
}
