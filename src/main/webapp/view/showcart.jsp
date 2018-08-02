<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="../cs/gouwuche.css" />
    <link rel="stylesheet" type="text/css" href="bootstrap.css" />
    <%--<style>--%>
        <%--.th1{--%>
            <%--padding: 8px;--%>
            <%--line-height: 1.42857143;--%>
            <%--vertical-align: center;--%>
            <%----%>
        <%--}--%>
    <%--</style>--%>
</head>

<body>
<div id="zhuce">
    <div id="top">
        <div id="top_logo">
            <img src="img/logo.png" style="margin-top: 20px;" />
        </div>
        <div id="top_center">
					<span style="font-size: 30px;">
						我的购物车
					</span>
        </div>
        <div id="top_center_1">
            <span>温馨提示：产品是否购买成功，以最终下单为准哦，请尽快结算</span>
        </div>
        <div id="top_right">
            <ul style="list-style: none;">
                <li>
                    <a href="gerenzhongxin.html">个人中心</a>
                </li>
                <li>
                    <a href="login.html">退出登录</a>
                </li>
            </ul>
        </div>
    </div>
    <div id="bottom_2">
<form action="cart" method="get">
	<table align="center" class="table table-bordered">
		<tr>
            <th class="th1">
                    全选
            </th>
			<th  class="th1">购物信息id</th>
			<th class="th1">商品id</th>
			<th class="th1">商品数量</th>
			<th class="th1">商品单价</th>
			<th class="th1">商品总价</th>
			<th class="th1">购物车操作</th>
		</tr>
		<c:forEach items="${pagemode.data}" var="cart">
			<tr>
                <td>
                    <form style="text-align: center;">
                        <input style="display: inline-block; " type="checkbox" />
                        <span class="span"></span>
                    </form>
                </td>
				<td>${cart.id}</td>
				<td>${cart.getProduct().getId()}</td>
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
<%--</form>--%>
    </div>
    <div id="bottom_3">
        <div id="bottom_3_1">
            <a href="index.html">继续购物</a>
        </div>
        <div id="bottom_3_2">
            <span>合计：899元</span>
        </div>
        <div id="bottom_3_3">
            <form action="">
                <a href="jiesuan.html"><input type="button" value="去结算" /></a>
            </form>
        </div>
    </div>
</body>
</html>
<script src="../js/jquery.js"></script>
