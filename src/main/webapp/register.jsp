<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 style="text-align:center">欢迎注册</h1>

<form action="register.do" method="post">
  <table align="center">
  <tr>
  	<td>用户名</td>
  	<td><input type="text" name="username"/></td>
  </tr>
  <tr>
  <td>密码</td>
  	<td><input type="text" name="password"/></td></tr>
  	<tr>
  <td>IP</td>
  	<td><input type="text" name="ip"/></td></tr>
  	<tr>
  <td>性别</td>
  	<td><select name="sex" >
  	<option value="男" >男</option>
  	<option value="女">女</option>
</select></td></tr>
  <tr>
  	<td><input type="submit" value="注册"/></td>
  	</tr>
  </table>
</form>
</body>
</html>