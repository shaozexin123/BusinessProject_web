<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
    <link rel="stylesheet" href="bootstrap.css"/>
    <style >
        body {
            background-image: url("../img/timg 2.jpg");
            background-size: 100%;
            background-repeat: no-repeat;
        }
    </style>
</head>
<body>
<h1 style="text-align:center; color: yellow">添加商品</h1>
<form action="product" method="post">
<input type="hidden" name="operation" value="1"/>
    <div class=" col-sm-8 col-sm-push-2 col-md-6 col-md-push-3 col-lg-4 col-lg-push-4 ">
    <div class="form-group ">
        <label style="color: yellow">商品名称:</label>
        <input type="text " class="form-control " name="pname"  placeholder="商品名称">
    </div>
    <div class="form-group ">
        <label style="color: yellow">商品描述:</label>
        <input type="text " class="form-control " name="pdesc"  placeholder="商品描述 ">
    </div>
    <div class="form-group ">
        <label style="color: yellow">商品价格:</label>
        <input type="text " class="form-control "  name="price" placeholder="商品价格 ">
    </div>
    <div class="form-group ">
        <label style="color: yellow">商品规格:</label>
        <input type="text " class="form-control " name="prule"  placeholder="商品规格">
    </div>
    <div class="form-group ">
        <label style="color: yellow">商品图片:</label>
        <input type="text " class="form-control " name="pimage"  placeholder="商品图片 ">
    </div>
    <div class="form-group ">
        <label style="color: yellow">商品库存:</label>
        <input type="text " class="form-control "  name="stock" placeholder="商品库存 ">
    </div>
    <div class="form-group ">
        <label style="color: yellow">商品类别id:</label>
        <input type="text " class="form-control "  name="categoryid" placeholder="商品类别id ">
    </div>
    <div class="form-group ">
        <input type="submit" value="添加商品"/>
    </div>
    </div>
</form>

  <%--<table align="center">--%>
  <%--<tr>--%>
  	<%--<td>商品名称</td>--%>
  	<%--<td><input type="text" name="pname"/></td>--%>
  <%--</tr>--%>
  <%--<tr>--%>
  	<%--<td>商品描述</td>--%>
  	<%--<td><input type="text" name="pdesc"/></td>--%>
  <%--</tr>--%>
  <%--<tr>--%>
  	<%--<td>商品价格</td>--%>
  	<%--<td><input type="text" name="price"/></td>--%>
  <%--</tr>--%>
  <%--<tr>--%>
  	<%--<td>商品规格</td>--%>
  	<%--<td><input type="text" name="prule"/></td>--%>
  <%--</tr>--%>
  <%--<tr>--%>
  	<%--<td>商品图片</td>--%>
  	<%--<td><input type="text" name="pimage"/></td>--%>
  <%--</tr>--%>
  <%--<tr>--%>
  	<%--<td>商品库存</td>--%>
  	<%--<td><input type="text" name="stock"/></td>--%>
  <%--</tr>--%>
      <%--<tr>--%>
          <%--<td>商品类别id</td>--%>
          <%--<td><input type="text" name="categoryid"/></td>--%>
      <%--</tr>--%>
  <%--<tr>--%>
  	<%--<td><input type="submit" value="添加商品"/></td>--%>
  	<%--</tr>--%>
  <%--</table>--%>
<%--</form>--%>

</body>
</html>