<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.dream.help.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="style/wincommon-style.css">
 <script src="style/jquery-3.0.0.min.js"></script>
</head>
<body>
<div style="background-color:#e4ebf6; padding:10px 2px; height:600px; border:#d8d8d8 1px solid;">
<table class="condition-table">
	<tr>
        	<td>需求编号：</td>
            <td><input type="text" style="width:160px;"></td>
            <td>需求名称：</td>
            <td><input type="text" style="width:160px;"></td>
            <td>流程状态：</td>
            <td><input type="text" style="width:160px;"></td>
        </tr>
	</table>
	<table border="1" style="position:absolute; top:40%; left:45%;">
    <tr>
        <th>用户ID</th>
        <th>用户姓名</th>
        <th>电话</th>
        <th>邮箱</th>
    </tr>
    <%
            List<Resulter> list=(List<Resulter>)request.getAttribute("list");
            for(Resulter p:list){
         %>
         <tr align="center">
             <td><%=p.getUserid() %></td>
             <td><%=p.getUsername() %></td>
             <td><%=p.getGrade() %></td>
             <td><%=p.getOrg() %></td>
             <td><%=p.getSettime() %></td>
         </tr>
         <%
             }
          %>
    <tr>
        <c:choose>
            <c:when test="${pager.currentPage > 1}">
                <th><a href="/select?currentPage=${pager.getFirst()}">首页</a>${pageResult.firstPage}</th>
                <th><a href="AppDemo/select?currentPage=${pager.getAhead()}">上一页</a>${pageResult.prePage}</th>
            </c:when>
        </c:choose>
        <c:choose>
            <c:when test="${pager.currentPage < pager.getPageCount()}">
                <th><a href="AppDemo/select?currentPage=${pager.getNext()}">下一页</a>${pageResult.nextPage}</th>
                <th><a href="AppDemo/select?currentPage=${pager.getPageCount()}">尾页</a>${pageResult.totalPage}</th>
            </c:when>
        </c:choose>
        <th>当前${pager.currentPage}/${pager.getPageCount()}页</th>
        <th>总条数:${pager.getTotal()}</th>
    </tr>
</table>
</div>
</body>
</html>