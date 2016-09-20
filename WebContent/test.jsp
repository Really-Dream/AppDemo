<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: D丶ream
  Date: 2015/12/13
  Time: 0:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test</title>
</head>
<body>
    ${requestScope.test}<br>
    ${sessionScope.test1}<br>
    ${param.get("username")}<br>
    ${requestScope.username}<br>
<%
    ArrayList showList = (ArrayList)(getServletConfig().getServletContext().getAttribute("list"));
    out.print("在线人数"+showList.size()+"<br>");
    for(int i = 0; i<showList.size();i++){
        out.print(showList.get(i)+"在线"+"<br>");
    }
%>
    <a href="second" method="post" style="text-decoration:none">
        退出
    </a>
</body>
</html>
