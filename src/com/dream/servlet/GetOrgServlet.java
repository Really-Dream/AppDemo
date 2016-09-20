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
import com.dream.DBUtil.Title;
import com.google.gson.Gson;

/**
 * 获取题目信息
 * @author D丶ream
 *
 */

@SuppressWarnings("serial")
public class GetOrgServlet extends HttpServlet{

    public void init() throws ServletException{
        System.out.println("init");

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
    	List<String> org = new ArrayList<String>();
        DataOutputStream dos = new DataOutputStream(response.getOutputStream());
        JDBC jdbc = new JDBC();
        ResultSet rs;
        rs = jdbc.Select("select * from tb_org  ");
        try {
            while(rs.next()){
            	String orgname = rs.getString("orgname");
            	org.add(orgname);
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
