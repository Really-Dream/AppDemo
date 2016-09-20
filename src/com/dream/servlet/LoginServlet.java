package com.dream.servlet;

import java.io.DataOutputStream;
import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dream.DBUtil.JDBC;
import com.google.gson.Gson;


/**
 * µ«¬º√‹¬Î—È÷§
 * @author Dÿºream
 *
 */
@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
        String user="";
        String result="";
        String userid = request.getParameter("userid");
        String pwd = request.getParameter("pwd");
        DataOutputStream dos = new DataOutputStream(response.getOutputStream());
        JDBC jdbc = new JDBC();
        ResultSet rs;
        rs = jdbc.Select("select * from tb_user where userid='"+userid+"' and pwd = '"+pwd+"'  ");
        try {
            while(rs.next()){
                user = rs.getString("username");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(user!="" && user!=null){
             result = (new Gson()).toJson("true");
        }else{
             result = (new Gson()).toJson("false");
        }
        dos.write(result.getBytes("UTF-8"));
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
