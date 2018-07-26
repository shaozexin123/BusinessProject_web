<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<P>欢迎${acc.username}登录电商平台管理系统</P>
<a href="view/addproduct.jsp" >添加商品</a>

<a href="view/product?operation=2&pageno=1&pagesize=5">显示商品</a>   

<br/>
<a href="view/addcategory.jsp" >添加商品类别</a>   

<a href="view/category?operation=2" >显示商品类别</a>   

<br>
<a href="view/cart?operation=2">显示购物车</a> 
</body>
</html>