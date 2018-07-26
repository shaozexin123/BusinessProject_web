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
	<table align="center">
		<tr>
			<th>购物信息id</th>
			<th>商品id</th>
			<th>商品数量</th>
			<th>商品单价</th>
			<th>商品总价</th>
			<th>购物车操作</th>
		</tr>
		<c:forEach items="${pagemode.data}" var="cart">
			<tr>
				<td>${cart.id}</td>
				<td>${cart.productid}</td>
				<td>${cart.productNum}</td>
				<td>${cart.productprice}</td>
				<td>${cart.totalprice}</td>
				<td><a href="cart?operation=4&id=${cart.id}">删除</a> 
				    <a href="cart?operation=5&id=${cart.id}">修改</a> 
			        <a href="order?operation=1&id=${cart.id}&totalprice=${cart.totalprice}">下单</a>
					</td>
			</tr>
		</c:forEach>
	</table>
	<c:forEach var="pageno" begin="1" end="${pagemode.totalPage}" step="1">
		<c:choose>
			<c:when test="${pagemode.currentpage==pageno}">
				<a style="color: red"
					href="cart?operation=2&pageno=${pageno}&pagesize=5">${pageno}</a>
			</c:when>
			<c:when test="${pagemode.currentpage!=pageno}">
				<a href="cart?operation=2&pageno=${pageno}&pagesize=5">${pageno}</a>
			</c:when>
		</c:choose>

	</c:forEach>
</body>
</html>