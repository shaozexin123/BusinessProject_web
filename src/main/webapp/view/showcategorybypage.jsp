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
		>> <a href="">类别管理</a>
		>> <a href="">显示类别</a>

	</div>
	<table align="center" class="table table-bordered">
		<tr>
            <th>商品类别id</th>
            <th>商品父类id</th>
            <th>商品类别名称</th>
            <th>商品类别状态</th>
            <th>排序编号</th>
            <th>创建时间</th>
            <th>更新时间</th>
            <th>类别操作</th>
		</tr>
		<c:forEach items="${pagemode.data}" var="category">
		<tr>
            <td>${category.id}</td>
            <td>${category.parent_id}</td>
            <td>${category.name}</td>
            <td>${category.status}</td>
            <td>${category.sort_order}</td>
            <td>${category.create_time}</td>
            <td>${category.update_time}</td>
            <td><a href="category?operation=4&id=${category.id}">删除</a> <a href="category?operation=5&id=${category.id}">修改</a></td>
		</tr>
		</c:forEach>
	</table>
	<c:forEach var="pageno" begin="1" end="${pagemode.totalPage}" step="1">
	<c:choose>
	<c:when test="${pagemode.currentpage==pageno}">
	<a style="color:red" href="category?operation=2&pageno=${pageno}&pagesize=5">${pageno}</a>
	</c:when>
	<c:when test="${pagemode.currentpage!=pageno}">
	<a  href="category?operation=2&pageno=${pageno}&pagesize=5">${pageno}</a>
	</c:when>
	</c:choose>
	
	</c:forEach>
</body>
</html>