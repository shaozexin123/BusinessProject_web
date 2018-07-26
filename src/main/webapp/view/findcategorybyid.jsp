<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="category" method="post">
<input type="hidden" name="operation" value="6"/>
  <table align="center">
  <tr>
  	<td>商品编号</td>
  	<td><input type="text" name="id"/></td>
  	<td><input type="submit" value="查询"/></td>
  	</tr>
  	</table>
  	<table align="center">
  	<tr>
            <th>商品类别id</th>
            <th>商品父类id</th>
            <th>商品类别名称</th>
            <th>商品类别状态</th>
            <th>排序编号</th>
            <th>创建时间</th>
            <th>更新时间</th>
		</tr>
		<tr>
            <td>${category.id}</td>
            <td>${category.parent_id}</td>
            <td>${category.name}</td>
            <td>${category.status}</td>
            <td>${category.sort_order}</td>
            <td>${category.create_time}</td>
            <td>${category.update_time}</td>
		</tr>
  </table>
</form>
</body>
</html>