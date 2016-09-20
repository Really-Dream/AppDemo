package com.dream.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dream.DBUtil.JDBC;
import com.dream.help.Pager;
import com.dream.help.Resulter;

public class resultQuery extends HttpServlet{
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sql = "SELECT a.username,a.org,a.userid,b.grade,b.settime FROM tb_user a,tb_result b where a.userid=b.username";
		int currentPage = 1;
		String userid;
		String begintime;
		String endtime;
		if(req.getParameter("currentPage") != null){
			currentPage = Integer.parseInt(req.getParameter("currentPage"));
		}
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
        Pager pager = null;
        List<Resulter> list  = new ArrayList<>();
        String sqlTotal = "select count(*) grade from tb_result";
        ResultSet r = dbUtil.Select(sqlTotal);
        try {
            if(r.next()){
            pager = new Pager(r.getInt("grade"),15);
            }
            pager.setCurrentPage(currentPage);
            Object[] o = {pager.getPageSize(),(pager.getCurrentPage()-1)*pager.getPageSize()};
            ResultSet rs = dbUtil.getRS(sql,o);
            while(rs.next()){
            	Resulter user = new Resulter();
                user.setUserid(rs.getString("userid"));
                user.setUsername(rs.getString("username"));
                user.setOrg(rs.getString("org"));
                user.setGrade(rs.getString("grade"));
                user.setSettime(rs.getString("settime"));
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setCharacterEncoding("UTF-8");
        req.setAttribute("list",list);
        req.setAttribute("pager",pager);
//        resp.setContentType("text/javascript");
//        resp.getWriter().print(list.toString());
        req.getRequestDispatcher("/First.jsp").forward(req,resp);
    }
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
}	
