<%--
  Created by IntelliJ IDEA.
  User: lee
  Date: 2016/2/26
  Time: 21:28

  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome to Field</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jquery-easyui-1.4.4/themes/metro/easyui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jquery-easyui-1.4.4/themes/icon.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jquery-easyui-1.4.4/themes/mobile.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.4.4/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.4.4/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.4.4/jquery.easyui.mobile.js"></script>
    <script type="text/javascript">

    $(function(){
        $.ajax({
            type:"POST",
            url:"${pageContext.request.contextPath}/login/findMeum.action",
            success:function(data){
                console.info(data);
            }
        });
    });

    </script>
</head>
<body>
    <div class="easyui-navpanel">
        <header>
            <div class="m-toolbar">
                <span class="m-title">Field Memu</span>
            </div>
        </header>
        <div class="easyui-accordion" fit="true" border="false">
            <div class="List">
                <ul>
                    <li>WLAN</li>
                    <li>Memory</li>
                    <li>Screen</li>
                    <li>more...</li>
                </ul>
            </div>
            <div class="AJAX">
                <ul>
                    <li>WLAN</li>
                    <li>Memory</li>
                    <li>Screen</li>
                    <li>more...</li>
                </ul>
            </div>
        </div>
    </div>
</body>
</html>
