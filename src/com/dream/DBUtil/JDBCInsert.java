package com.dream.DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * ≤Â»Î ˝æ› JDBC
 * @author Dÿºream
 *
 */
public class JDBCInsert {

//    private static String URL = "jdbc:mysql://localhost:3306/dream_title";
//    private static String ORACLEDRIVER="com.mysql.jdbc.Driver";
//    private static String USER = "root";
//    private static String PWD = "root";
    private static Connection conn;
//    String password=SaeUserInfo.getSecretKey();
    private static String URL="jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_1059141989";
    private static String USER="y25k54051k";
    private static String PWD="1iy1m2wk5x3zym3wlhzw5x3ml0x442435l3x111x";
    private static String ORACLEDRIVER="com.mysql.jdbc.Driver";

    private static void getConnection(){
        try {
            Class.forName(ORACLEDRIVER);
            conn= DriverManager.getConnection(URL,USER,PWD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unused")
	private static void close(Connection conn){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet Select(String sql) {
        JDBCInsert.getConnection();
        ResultSet rs = null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    public String Update(String sql){
        JDBCInsert.getConnection();
        try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate(sql);
			return "true";
		} catch (SQLException e) {
			if(e.getErrorCode()==1062){
				return "repeat";
			}
			System.out.println(e.getErrorCode());
			e.printStackTrace();
			return "false";
		}


    }
    
}
