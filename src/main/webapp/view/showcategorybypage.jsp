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