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
<form action="product" method="post">
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
            <th>商品id</th>
            <th>商品名称</th>
            <th>商品描述</th>
            <th>商品价格</th>
            <th>商品规格</th>
            <th>商品图片</th>
            <th>商品库存</th>
		</tr>
		<tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.desc}</td>
            <td>${product.price}</td>
            <td>${product.rule}</td>
            <td>${product.image}</td>
            <td>${product.stock}</td>
		</tr>
  </table>
</form>
</body>
</html>