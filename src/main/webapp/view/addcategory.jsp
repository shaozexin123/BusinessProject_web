<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="bootstrap.css"/>
	<style >
		body {
			background-image: url("../img/timg 2.jpg");
			background-size: 100%;
			background-repeat: no-repeat;
		}
	</style>
</head>
<body>
<h1 style="text-align:center;color: yellow">添加类别</h1>
<form action="category" method="post">
<input type="hidden" name="operation" value="1"/>
	<div class=" col-sm-8 col-sm-push-2 col-md-6 col-md-push-3 col-lg-4 col-lg-push-4 ">
		<div class="form-group ">
			<label style="color: yellow">父类id:</label>
			<input type="text " class="form-control " name="parent_id"  placeholder="父类id">
		</div>
		<div class="form-group ">
			<label style="color: yellow">类别名称:</label>
			<input type="text " class="form-control " name="name"  placeholder="类别名称 ">
		</div>
		<div class="form-group ">
			<label style="color: yellow">类别状态:</label>
			<input type="text " class="form-control "  name="status" placeholder="类别状态 ">
		</div>
		<div class="form-group ">
			<label style="color: yellow">排序编号:</label>
			<input type="text " class="form-control " name="sort_order"  placeholder="排序编号">
		</div>
		<div class="form-group ">
			<input type="submit" value="添加类别"/>
		</div>
	</div>
  <%--<table align="center">--%>
  <%--<tr>--%>
  	<%--<td>父类id</td>--%>
  	<%--<td>--%>
  	<%--<select name="parent_id" >--%>
  	<%--<option value="0" >0</option>--%>
  	<%--<option value="1">1</option>--%>
  	<%--<option value="2">2</option>--%>
  	<%--<option value="3">3</option>--%>
  	<%--<option value="4">4</option>--%>
<%--</select>--%>
<%--</td>--%>
  <%--</tr>--%>
  <%--<tr>--%>
  	<%--<td>类别名称</td>--%>
  	<%--<td><input type="text" name="name"/></td>--%>
  <%--</tr>--%>
  <%--<tr>--%>
  	<%--<td>类别状态</td>--%>
  	<%--<td><input type="text" name="status"/></td>--%>
  <%--</tr>--%>
  <%--<tr>--%>
  	<%--<td>排序编号</td>--%>
  	<%--<td><input type="text" name="sort_order"/></td>--%>
  <%--</tr>--%>
  <%--<tr>--%>
  	<%--<td><input type="submit" value="添加商品类别"/></td>--%>
  	<%--</tr>--%>
  <%--</table>--%>
</form>
</body>
</html>