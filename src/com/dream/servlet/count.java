package com.dream.servlet;

import java.io.DataOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dream.DBUtil.JDBC;
import com.google.gson.Gson;

/**
 * 获取题目信息
 * @author D丶ream
 *
 */

@SuppressWarnings("serial")
public class count extends HttpServlet{

    public void init() throws ServletException{
        System.out.println("init");

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
    	List<String> org = new ArrayList<String>();
        DataOutputStream dos = new DataOutputStream(response.getOutputStream());
        JDBC jdbc = new JDBC();
        ResultSet rs;
        rs = jdbc.Select("select count(*)+1 count from tb_result where username = '"+request.getParameter("userid")+"'  ");
        try {
            while(rs.next()){
            	int orgname = rs.getInt("count");
            	org.add(String.valueOf(orgname));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        final int size = org.size();
        String[] arr = (String[])org.toArray(new String[size]);
        String result = (new Gson()).toJson(arr);
        System.out.println(result);
        dos.write(result.getBytes("UTF-8"));
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    public void destroy() {
        System.out.println("destory");
        super.destroy();
    }
}
