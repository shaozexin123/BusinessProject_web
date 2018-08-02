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
        >> <a href="">订单管理</a>
        >> <a href="">显示订单</a>

    </div>
<form action="order" method="get">
	<table align="center" class="table table-bordered">
		<tr>
            <th>订单id</th>
            <th>订单号</th>
            <th>用户id</th>
            <th>地址id</th>
            <th>付款金额</th>
            <th>支付方式</th>
            <th>运费</th>
            <th>订单状态</th>
            <th>支付时间</th>
            <th>创建时间</th>
            <th>修改时间</th>
            <th>操作</th>
		</tr>
		<c:forEach items="${pagemode.data}" var="userorder">
		<tr>
            <td>${userorder.id}</td>
            <td>${userorder.order_no}</td>
            <td>${userorder.user_id}</td>
            <td>${userorder.shipping_id}</td>
            <td>${userorder.payment}</td>
            <td>${userorder.payment_type}</td>
            <td>${userorder.postage}</td>
            <td>${userorder.status}</td>
            <td>${userorder.payment_time}</td>
            <td>${userorder.create_time}</td>
            <td>${userorder.update_time}</td>
            <td><a href="order?operation=4&id=${userorder.id}">取消</a> <a href="order?operation=5&id=${userorder.id}">支付</a></td>
		</tr>
		</c:forEach>
	</table>
	<c:forEach var="pageno" begin="1" end="${pagemode.totalPage}" step="1">
	<c:choose>
	<c:when test="${pagemode.currentpage==pageno}">
	<a style="color:red" href="order?operation=2&pageno=${pageno}&pagesize=5">${pageno}</a>
	</c:when>
	<c:when test="${pagemode.currentpage!=pageno}">
	<a  href="order?operation=2&pageno=${pageno}&pagesize=5">${pageno}</a>
	</c:when>
	</c:choose>

	</c:forEach>
</form>
</body>
</html>