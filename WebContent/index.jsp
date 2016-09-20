<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<html>
<head>
<title>微课堂</title>
<link rel="stylesheet" type="text/css" href="style/Login_style.css" />
<script type="text/javascript" src="style/Login_javascript.js"></script>
</head>
<body>
<h2 align="center">微课堂管理系统</h2>
<div class="login_frame"></div>
<div class="LoginWindow">
  <div>
    <form method="post" action="select" onsubmit="return user_input()" class="login">
    <p>
      <label for="login">帐号:</label>
      <input type="text" name="id" id="id" value="">
    </p>

    <p>
      <label for="password">密码:</label>
      <input type="password" name="password" id="password" value="">
    </p>

    <p class="login-submit">
      <button type="submit" class="login-button">Login</button>
    </p>

    </form>
<!--     <p class="registration"><a href="http://www.jq22.com">Registration</a></p> -->
  </div>
</div>

<div id="timeArea"><script> LoadBlogParts();</script></div>

</body>
<script>
function user_input(){
	var name = $("id").value;
	var password = $("password").value;
	if(name=="" || password==""){
		alert("用户名或密码不能为空！");
		return false;
		}else{
			return true;
			}	
	}
</script>
</html>