package com.dream.servlet;

import java.io.DataOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dream.DBUtil.JDBCInsert;
import com.google.gson.Gson;

/**
 * ´¢´æ³É¼¨
 * @author DØ¼ream
 *
 */
@SuppressWarnings("serial")
public class ResultServlet extends HttpServlet {
	public void init() throws ServletException{
        System.out.println("init");

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
    	DataOutputStream dos = new DataOutputStream(response.getOutputStream());
    	JDBCInsert jdbc = new JDBCInsert();
    	String userid = request.getParameter("userid");
    	String grade = request.getParameter("grade");
    	String result = "";
    	if(!userid.equals("meiyouren")){
    		String sql = "insert into tb_result values('"+userid+"','"+grade+"',sysdate())";
    		result = (new Gson()).toJson(jdbc.Update(sql));
    	}else{
    		result = (new Gson()).toJson("false");
    	}
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
