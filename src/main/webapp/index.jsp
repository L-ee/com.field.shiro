<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Field Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="application/x-javascript">
        addEventListener("load", function () {
            setTimeout(hideURLbar, 0);
        }, false);

        function hideURLbar() {
            window.scrollTo(0, 1);
        }
    </script>
    <meta name="keywords"
          content="Flat Dark Web Login Form Responsive Templates,
          Iphone Widget Template, Smartphone login forms,Login form,
          Widget Template, Responsive Templates, a Ipad 404 Templates, Flat Responsive Templates"/>

    <link href="css/style.css" rel='stylesheet' type='text/css'/>
    <script type="text/javascript" src="js/jquery.min.js"></script>
</head>
<body>
<script>
//    $(document).ready(function (c) {
//        $('.close').on('click', function (c) {
//            $('.login-form').fadeOut('slow', function (c) {
//                $('.login-form').remove();
//            });
//        });
//    });
</script>
<h1>Field Login</h1>
<div class="login-form">
    <%--关闭窗口--%>
    <%--<div class="close"></div>--%>
    <div class="head-info">
        <label class="lbl-1"> </label>
        <label class="lbl-2"> </label>
        <label class="lbl-3"> </label>
    </div>
    <div class="clear"></div>
    <div class="avtar">
        <img src="images/avtar.png"/>
    </div>
    <form action="${pageContext.request.contextPath}/login/load.action" id="login">
        <input type="text" name="username" class="text" placeholder="手机号" >
        <div class="key">
            <input type="password" name="password" placeholder="密码">
        </div>
    </form>
    <div class="signin">
        <input type="submit" value="Login" form="login">
    </div>
</div>
<div class="copy-rights">
    <p>Copyright &copy; 2015.Company name All rights reserved.<a target="_blank" href="http://www.17sucai.com/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a>
    </p>
</div>

</body>
</html>