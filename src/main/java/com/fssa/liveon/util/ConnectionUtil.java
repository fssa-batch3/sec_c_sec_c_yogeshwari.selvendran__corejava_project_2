package com.fssa.liveon.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.fssa.liveon.exceptions.DAOException;

import io.github.cdimascio.dotenv.Dotenv;

public class ConnectionUtil {
	static Logger logger = new Logger();
	public static Connection getConnection() throws DAOException {
        Connection con = null;

        String url;
        String userName;
        String passWord;

        if (System.getenv("CI") != null) {
            url = System.getenv("DATABASE_HOST");
            userName = System.getenv("DATABASE_USERNAME");
            passWord = System.getenv("DATABASE_PASSWORD");
        } else {
            Dotenv env = Dotenv.load();
            url = env.get("DATABASE_HOST");
            userName = env.get("DATABASE_USERNAME");
            passWord = env.get("DATABASE_PASSWORD");
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, userName, passWord);
            logger.info("success");
         
        } catch (Exception e) {
            e.printStackTrace();
            throw new DAOException("Unable to connect to the database");
        }
        return con;
    } 
	    public static void close(Connection conn , Statement stmt, PreparedStatement ps, ResultSet rs){
	         
	        try{
	            if ( rs != null ){
	                rs.close();
	            }
	            if ( stmt != null ) {
	                stmt.close();
	            }
	            if ( ps != null ) {
	                ps.close();
	            }
	            if ( conn != null ){
	                conn.close();
	            }
	        }
	        catch(SQLException e){
	             e.printStackTrace();
	        }
	    }
	    
}
