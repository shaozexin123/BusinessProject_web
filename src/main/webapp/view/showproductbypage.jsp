<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="bootstrap.css"/>

</head>

<body>
<div class="container-fluid"style="background-color: #EBEBEB;height: 800px;">
	<div class="row">
		<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
			<!--<img src="img/华为logo.png">-->
		</div>
		<div class="col-xs-8 col-xs-push-1 col-sm-8 col-sm-push-1 col-md-8 col-lg-4 col-lg-push-1">
			<p class="text-center">
			<h1>小米商城后台网站</h1></p>
		</div>

	</div>

	<div class="row"style="margin-bottom: 30px;">
		<a href="">
			<span class="glyphicon glyphicon-home" aria-hidden="true"style="margin-left: 20px;"></span></a>
		>> <a href="">后台</a>
		>> <a href="">商品管理</a>
		>> <a href="">显示商品</a>

	</div>
	<table align="center" class="table table-bordered">
		<tr>
            <th>商品id</th>
            <th>商品名称</th>
            <th>商品描述</th>
            <th>商品价格</th>
            <th>商品规格</th>
            <th>商品图片</th>
            <th>商品库存</th>
			<th>商品类别id</th>
            <th>商品操作</th>
		</tr>
		<c:forEach items="${pagemode.data}" var="product">
		<tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.desc}</td>
            <td>${product.price}</td>
            <td>${product.rule}</td>
            <td>${product.image}</td>
            <td>${product.stock}</td>
			<td>${product.categoryid}</td>
            <td><a href="product?operation=4&id=${product.id}">删除</a> <a href="product?operation=5&id=${product.id}">修改</a> 
            <a href="cart?operation=6&id=${product.id}" >添加到购物车</a></td>
		</tr>
		</c:forEach>
	</table>
	<c:forEach var="pageno" begin="1" end="${pagemode.totalPage}" step="1">
	<c:choose>
	<c:when test="${pagemode.currentpage==pageno}">
	<a style="color:red" href="product?operation=2&pageno=${pageno}&pagesize=5">${pageno}</a>
	</c:when>
	<c:when test="${pagemode.currentpage!=pageno}">
	<a  href="product?operation=2&pageno=${pageno}&pagesize=5">${pageno}</a>
	</c:when>
	</c:choose>
	
	</c:forEach>
</body>
</html>