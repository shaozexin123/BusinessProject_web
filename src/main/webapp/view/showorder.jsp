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
</body>
</html>