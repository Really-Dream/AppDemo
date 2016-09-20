package com.dream.DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ≤È—ØSQL£¨JDBC
 * @author Dÿºream
 *
 */
public class JDBC {

//    private static String URL = "jdbc:mysql://localhost:3306/dream_title";
//    private static String ORACLEDRIVER="com.mysql.jdbc.Driver";
//    private static String USER = "root";
//    private static String PWD = "root";
    private static Connection conn;

    private static String URL="jdbc:mysql://r.rdc.sae.sina.com.cn:3307/app_1059141989";
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
        JDBC.getConnection();
        ResultSet rs = null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    public ResultSet getRS(String sql, Object[] o) {
    	sql += " LIMIT "+o[1]+","+o[0];
    	getConnection();
        ResultSet rs = null;
        try {
             PreparedStatement pre = conn.prepareStatement(sql);
             rs = pre.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
//        close(conn);
    }
    
}
