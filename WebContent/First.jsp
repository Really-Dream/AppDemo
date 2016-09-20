<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
<%@ page import="com.dream.help.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" class="no-js">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- 	<link href='http://fonts.useso.com/css?family=PT+Sans:400,700' rel='stylesheet' type='text/css'> -->

	<link rel="stylesheet" href="style/reset.css"> <!-- CSS reset -->
	<link rel="stylesheet" href="style/style.css"> <!-- Resource style -->
	<script src="style/modernizr.js"></script> <!-- Modernizr -->
	<script src="style/jquery-3.0.0.min.js"></script> <!-- Modernizr -->
	<script src="style/Calendar.js"></script> <!-- Modernizr -->
  	<style type="text/css">
table.imagetable {
	width:40%;
	font-family: verdana,arial,sans-serif;
	font-size:11px;
	color:#333333;
	border-width: 1px;
	border-color: #999999;
	border-collapse: collapse;
}
table.imagetable th {
	background:#b5cfd2 url('../images/blue.jpg');
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #999999;
}
table.imagetable td {
	background:#dcddc0 url('../images/grey.jpg');
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #999999;
}
</style>
<script>
var currentPage = ${pager.currentPage};
var pageCount = ${pager.getPageCount()};
	//查询
	function select(){
		var url = "Ajax?currentPage="+currentPage;
		var userid = $("#userid").val();
		var begintime = $("#begintime").val();
		var endtime = $("#endtime").val();
		if(userid.length>0){
			url += "&userid="+userid;
		}
		if(begintime.length>0){
			url += "&begintime="+begintime;
		}
		if(endtime.length>0){
			url += "&endtime="+endtime;
		}
		fuck(url);
	}
	function download(){
		var url = "download?currentPage="+currentPage;
		var userid = $("#userid").val();
		var begintime = $("#begintime").val();
		var endtime = $("#endtime").val();
		if(userid.length>0){
			url += "&userid="+userid;
		}
		if(begintime.length>0){
			url += "&begintime="+begintime;
		}
		if(endtime.length>0){
			url += "&endtime="+endtime;
		}
		var args = {"time":new Date()};
// 		$.post(url,args,function(data){
			
// 		})
		location.href=url;
	}
	
	//更新
	$(function(){
		$("a").click(function(){
			var  type = this.getAttribute('value');
			if(type=="first"){
				currentPage=1;
			}else if(type == "pre" && currentPage > 1){
				currentPage -= 1;
			}else if(type == "next" && currentPage < pageCount){
				currentPage += 1;
			}else if(type == "last"){
				currentPage = pageCount;
			}else{
				return;
			}
			var url="${pageContext.request.contextPath }/Ajax?currentPage="+currentPage;
			var userid = $("#userid").val();
			var begintime = $("#begintime").val();
			var endtime = $("#endtime").val();
			if(userid.length>0){
				url += "&userid="+userid;
			}
			if(begintime.length>0){
				url += "&begintime="+begintime;
			}
			if(endtime.length>0){
				url += "&endtime="+endtime;
			}
			fuck(url);
		})
	})
	
	//初始化
	$(function(){
		fuck("${pageContext.request.contextPath }/Ajax?currentPage=${pager.currentPage}");		
	})
	
	//动态刷新查询列表
	function fuck(url){
		var args = {"time":new Date()};
		var html="";
		$.getJSON(url,args,function(data){
			for(var i = 0;i<data.length;i++){
				html = html+"<tr><td>"+data[i].userid+"</td>"+"<td>"+data[i].username+"</td>"+"<td>"+data[i].grade+"</td>"+"<td>"+data[i].settime+"</td>"+"<td>"+data[i].org+"</td></tr>"
			}
			html="<table  style=\"position:absolute; top:25%; left:25%; \" class=\"imagetable\" ><tr><th>用户ID</th><th>用户姓名</th><th>成绩</th><th>测试时间</th><th>组织</th></tr>"+html;
			document.getElementById("table").innerHTML="";
			document.getElementById("table").innerHTML=html;
		})
			document.getElementById("all").innerHTML="<font size=\"3\" color=\"black\">当前"+currentPage+"/"+pageCount+"页&nbsp&nbsp&nbsp</font>";
	}
</script>
	<title>微课堂</title>
</head>
<body>
	<nav class="cd-side-navigation">
		<ul>
			<li>
				<a  class="selected" data-menu="index">
					<svg class="nc-icon outline" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" width="24px" height="24px" viewBox="0 0 24 24"><g transform="translate(0, 0)"> <polygon fill="none" stroke="#4a5261" stroke-width="2" stroke-linecap="square" stroke-miterlimit="10" points="12,2 3,10 3,23 9,23 9,16 15,16 15,23 21,23 21,10 " stroke-linejoin="miter"></polygon> </g></svg>
					成绩查询
				</a>
			</li>

			<li>
				<a  data-menu="services">
					<svg class="nc-icon outline" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" width="24px" height="24px" viewBox="0 0 24 24"><g transform="translate(0, 0)"> <polyline data-color="color-2" fill="none" stroke="#4a5261" stroke-width="2" stroke-linecap="square" stroke-miterlimit="10" points=" 16,7 16,2 8,2 8,7 " stroke-linejoin="miter"></polyline> <rect x="1" y="7" fill="none" stroke="#4a5261" stroke-width="2" stroke-linecap="square" stroke-miterlimit="10" width="22" height="15" stroke-linejoin="miter"></rect> <line fill="none" stroke="#4a5261" stroke-width="2" stroke-linecap="square" stroke-miterlimit="10" x1="5" y1="7" x2="5" y2="22" stroke-linejoin="miter"></line> <line fill="none" stroke="#4a5261" stroke-width="2" stroke-linecap="square" stroke-miterlimit="10" x1="19" y1="7" x2="19" y2="22" stroke-linejoin="miter"></line> </g></svg>
					Services
				</a>
			</li>

			<li>
				<a  data-menu="projects">
					<svg class="nc-icon outline" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" width="24px" height="24px" viewBox="0 0 24 24"><g transform="translate(0, 0)"> <rect x="1" y="1" fill="none" stroke="#4a5261" stroke-width="2" stroke-linecap="square" stroke-miterlimit="10" width="22" height="22" stroke-linejoin="miter"></rect> <rect data-color="color-2" x="5" y="5" fill="none" stroke="#4a5261" stroke-width="2" stroke-linecap="square" stroke-miterlimit="10" width="5" height="5" stroke-linejoin="miter"></rect> <rect data-color="color-2" x="14" y="5" fill="none" stroke="#4a5261" stroke-width="2" stroke-linecap="square" stroke-miterlimit="10" width="5" height="5" stroke-linejoin="miter"></rect> <rect data-color="color-2" x="5" y="14" fill="none" stroke="#4a5261" stroke-width="2" stroke-linecap="square" stroke-miterlimit="10" width="5" height="5" stroke-linejoin="miter"></rect> <rect data-color="color-2" x="14" y="14" fill="none" stroke="#4a5261" stroke-width="2" stroke-linecap="square" stroke-miterlimit="10" width="5" height="5" stroke-linejoin="miter"></rect> </g></svg>
					Projects
				</a>
			</li>

			<li>
				<a  data-menu="contact">
					<svg class="nc-icon outline" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" width="24px" height="24px" viewBox="0 0 24 24"><g transform="translate(0, 0)"> <polyline data-color="color-2" fill="none" stroke="#4a5261" stroke-width="2" stroke-linecap="square" stroke-miterlimit="10" points=" 19,7 12,14 5,7 " stroke-linejoin="miter"></polyline> <rect x="1" y="3" fill="none" stroke="#4a5261" stroke-width="2" stroke-linecap="square" stroke-miterlimit="10" width="22" height="18" stroke-linejoin="miter"></rect> <line data-color="color-2" fill="none" stroke="#4a5261" stroke-width="2" stroke-linecap="square" stroke-miterlimit="10" x1="7" y1="15" x2="5" y2="17" stroke-linejoin="miter"></line> <line data-color="color-2" fill="none" stroke="#4a5261" stroke-width="2" stroke-linecap="square" stroke-miterlimit="10" x1="17" y1="15" x2="19" y2="17" stroke-linejoin="miter"></line> </g></svg>
					</svg>
					Contact
				</a>
			</li>
		</ul>
	</nav> <!-- .cd-side-navigation -->
	
	<main class="cd-main">
		<section class="cd-section index visible">
			<header>
				<div style="position:absolute; top:15%; left:18%;">
						<tr>
				        	<td><font size="3" color="black">用户ID：</font></td>
				            <td><input type="text" style="width:160px;" id="userid"></td>
				            <td><font size="3" color="black">开始时间：</font></td>
				            <td><input type="text" style="width:160px;"  onClick="new Calendar().show(this);" readonly="readonly" id="begintime"></td>
				            <td><font size="3" color="black">结束时间：</font></td>
				            <td><input type="text" style="width:160px;"  onClick="new Calendar().show(this);" readonly="readonly" id="endtime"></td>
				        </tr>
				</div>
		        <div style="position:absolute; top:20%; left:40%;">
		        	<button onClick="select()">查询</button>
		        	<button onClick="download()">下载</button>
		        </div>
		        
				<div id="table"></div>
				
				<table style="position:absolute; top:85%; left:36%;">
<%-- 				        <c:choose> --%>
<%-- 				            <c:when test="${pager.currentPage > 1}"> --%>
				                <th><a value="first">首页&nbsp&nbsp&nbsp</a></th>
				                <th><a value="pre">上一页&nbsp&nbsp&nbsp</a></th>
<%-- 				            </c:when> --%>
<%-- 				        </c:choose> --%>
<%-- 				        <c:choose> --%>
<%-- 				            <c:when test="${pager.currentPage < pager.getPageCount()}"> --%>
				                <th><a value="next">下一页&nbsp&nbsp&nbsp</a></th>
				                <th><a value="last">尾页&nbsp&nbsp&nbsp</a></th>
<%-- 				            </c:when> --%>
<%-- 				        </c:choose> --%>
<%-- 				        <td id="all"><font size="3" color="black">当前${pager.currentPage}/${pager.getPageCount()}页&nbsp&nbsp&nbsp</font></td> --%>
<%-- 				        <th><font size="3" color="black">总条数:${pager.getTotal()}</font></th> --%>
				</table>
					
			</header>
		</section> 
	</main> 

<!-- <div id="cd-loading-bar" data-scale="1" class="index"></div>  -->
<script src="style/jquery-3.0.0.min.js"></script>
<script src="style/velocity.min.js"></script>
<script src="style/main.js"></script> 
</body>
</html>