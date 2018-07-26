<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 style="text-align:center">修改商品类别</h1>

<form action="category" method="post">
  <input type="hidden" name="operation" value="3"/>
  <input type="hidden" name="id" value="${category.id}"/>
  <table align="center">
  	<tr>
  	<td>商品父类id</td>
  	<td><input type="text" name="parent_id" value="${category.parent_id}"/></td>
  </tr>
  <tr>
  	<td>商品类别名称</td>
  	<td><input type="text" name="name" value="${category.name}"/></td>
  </tr>
  <tr>
  	<td>商品类别状态</td>
  	<td><input type="text" name="status" value="${category.status}"/></td>
  </tr>
  <tr>
  	<td>排序编号</td>
  	<td><input type="text" name="sort_order" value="${category.sort_order}"/></td>
  </tr>
  <tr>
  	<td><input type="submit" value="修改商品类别"/></td>
  	</tr>
</form>

</body>
</html>