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
 * ×¢²áÓÃ»§
 * @author DØ¼ream
 *
 */

@SuppressWarnings("serial")
public class CreateUserServlet extends HttpServlet {
	
	    @Override
	    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
	    	DataOutputStream dos = new DataOutputStream(response.getOutputStream());
	    	JDBCInsert jdbc = new JDBCInsert();
	    	String username = request.getParameter("username");
	    	String userid = request.getParameter("userid");
	    	String pwd = request.getParameter("pwd");
	    	String org = request.getParameter("org");
	    	String sql = "insert into tb_user values('"+userid+"','"+pwd+"','"+username+"','"+org+"',sysdate())";
	        String result = jdbc.Update(sql);
	        result = (new Gson()).toJson(result);
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