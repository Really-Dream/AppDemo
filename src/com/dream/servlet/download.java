package com.dream.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dream.DBUtil.JDBC;
import com.dream.help.Resulter;

import jxl.write.WriteException;

public class download extends HttpServlet{
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sql = "SELECT a.username,a.org,a.userid,b.grade,b.settime FROM tb_user a,tb_result b where a.userid=b.username";
		String userid;
		String begintime;
		String endtime;
		if(req.getParameter("userid") != null){
			userid = req.getParameter("userid");
			sql+=" and a.userid='"+userid+"'";
		}
		if(req.getParameter("begintime") != null){
			begintime = req.getParameter("begintime");
			sql+=" and Date(b.settime)>=Date('"+begintime+"')";
		}
		if(req.getParameter("endtime") != null){
			endtime = req.getParameter("endtime");
			sql+=" and Date(b.settime)<=Date('"+endtime+"')";
		}
        JDBC dbUtil = new JDBC();
        List<Resulter> list  = new ArrayList<>();
        ResultSet r = dbUtil.Select(sql);
        try {
            while(r.next()){
            	Resulter user = new Resulter();
                user.setUserid(r.getString("userid"));
                user.setUsername(r.getString("username"));
                user.setOrg(r.getString("org"));
                user.setGrade(r.getString("grade"));
                user.setSettime(r.getString("settime"));
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String fname = "成绩统计";
        OutputStream os = resp.getOutputStream();//取得输出流
        resp.reset();//清空输出流
        
        //下面是对中文文件名的处理
        resp.setCharacterEncoding("UTF-8");//设置相应内容的编码格式
        fname = java.net.URLEncoder.encode(fname,"UTF-8");
        resp.setHeader("Content-Disposition","attachment;filename="+new String(fname.getBytes("UTF-8"),"GBK")+".xls");
        resp.setContentType("application/msexcel");//定义输出类型
        SimpleExcelWrite sw = new SimpleExcelWrite();
        try {
			sw.createExcel(os,list);
		} catch (WriteException e) {
			e.printStackTrace();
		}
        
//        String result = (new Gson()).toJson(list);
//        resp.setContentType("application/json");
//        resp.getWriter().print(result);
    }
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
}	
