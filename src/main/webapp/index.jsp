<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>

    <style>
        body {
            background-image: url("img/timg 2.jpg");
            background-size: 100%;
            background-repeat: no-repeat;
        }

        #login_frame {
            width: 400px;
            height: 260px;
            padding: 13px;
            position: absolute;
            left: 50%;
            top: 50%;
            margin-left: -200px;
            margin-top: -200px;
            background-color: rgba(240, 255, 255, 0.5);
            border-radius: 10px;
            text-align: center;
        }

        form p>* {
            display: inline-block;
            vertical-align: middle;
        }

        #image_logo {
            margin-top: 22px;
        }

        .label_input {
            font-size: 14px;
            font-family: 宋体;
            width: 65px;
            height: 28px;
            line-height: 28px;
            text-align: center;
            color: white;
            background-color: #3CD8FF;
            border-top-left-radius: 5px;
            border-bottom-left-radius: 5px;
        }

        .text_field {
            width: 278px;
            height: 28px;
            border-top-right-radius: 5px;
            border-bottom-right-radius: 5px;
            border: 0;
        }

        #btn_login {

            font-size: 14px;
            font-family: 宋体;
            width: 120px;
            height: 28px;
            line-height: 28px;
            text-align: center;
            color: white;
            background-color: #3BD9FF;
            border-radius: 6px;
            border: 0;
            float: left;
        }

        #forget_pwd {
            font-size: 12px;
            color: white;
            text-decoration: none;
            position: relative;
            float: right;
            top: 5px;
        }

        #forget_pwd:hover {
            color: blue;
            text-decoration: underline;
        }

        #login_control {
            padding: 20px 35%  28px 35%;

        }
    </style>
</head>

<body>
<div id="login_frame">

    <p id="image_logo">欢迎登录电商平台系统</p>

    <!--<form method="post" action="login.js">

        <p><label class="label_input">用户名</label><input type="text" id="username" class="text_field" /></p>
        <p><label class="label_input">密码</label><input type="text" id="password" class="text_field" /></p>

        <div id="login_control">
            <input type="button" id="btn_login" value="登录" onclick="login();" />
        </div>
    </form>-->
    <form action="login.do" method="post">
        <table align="center">
            <tr>
                <td class="label_input">用户名</td>
                <td><input type="text" name="username" class="text_field"/></td>
            </tr>
            <tr>
                <td class="label_input">密码</td>
                <td><input type="password" name="password" class="text_field"/></td></tr>

        </table>
        <div id="login_control" >
            <input  type="submit" id="btn_login" value="登录"  />
        </div>
    </form>
</div>

</body>

</html>