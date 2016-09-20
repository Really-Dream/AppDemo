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
public class ServletTest extends HttpServlet{

    public void init() throws ServletException{
        System.out.println("init");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        List<Title> list = new ArrayList<>();
        DataOutputStream dos = new DataOutputStream(response.getOutputStream());
        JDBC jdbc = new JDBC();
        ResultSet rs;
        rs = jdbc.Select("select * from question  ");
        try {
            while(rs.next()){
                Title title = new Title();
                title.setTitle(rs.getString("title"));
                title.setQue1(rs.getString("que1"));
                title.setQue2(rs.getString("que2"));
                title.setQue3(rs.getString("que3"));
                title.setQue4(rs.getString("que4"));
                title.setAnswer1(rs.getString("answer1"));
                title.setAnswer2(rs.getString("answer2"));
                title.setAnswer3(rs.getString("answer3"));
                title.setAnswer4(rs.getString("answer4"));
                list.add(title);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
         String result = (new Gson()).toJson(list);
//        list = (new Gson()).toJson(result);
//        Title fromJson = (new Gson()).fromJson( result.toString() ,Title.class );
//        List<Title> persons2 = (new Gson()).fromJson(result, new TypeToken<List<Title>>(){}.getType());
        dos.write(result.getBytes("UTF-8"));
//        dos.writeUTF(result);
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
