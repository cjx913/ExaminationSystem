<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>login</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/popper.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/vue.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/pdf.js"></script>

    <script src="${pageContext.request.contextPath}/js/verifycode.js"></script>

</head>
<body>
<div class="container" style="margin-top: 100px;height: 500px;min-width: 1020px;
box-shadow: 0 12px 16px 0 rgba(0, 0, 0, 0.24), 0 17px 50px 0 rgba(0, 0, 0, 0.19);">
    <div>
        <form action="${pageContext.request.contextPath}/login" method="post">
            <div>
                <label for="username">用户名：</label><input id="username" name="username"
                                                         type="text" value=""/><br/>
            </div>
            <div>
                <label
                        for="password">密　码：</label><input
                    id="password" name="password" type="password" value=""/><br/>
            </div>
            <div>
                <label
                        for="randomCode">验证码：</label><input id="randomCode" name="randomCode"
                                                            type="text" value=""/> <input
                    id="validateCode"
                    name="validateCode" type="hidden"/>
                <canvas id="canvasVerifyCode" style="margin-bottom: -10px"
                        height="30px" width="80px"
                        onclick="verifycode('canvasVerifyCode','validateCode')"></canvas>
                <br/>
                <script type="text/javascript">
                    $(function () {
                        verifycode("canvasVerifyCode", "validateCode");
                    });
                </script>
            </div>
            <div>
                <label for="rememberMe"><input id="rememberMe"
                                               name="rememberMe" type="checkbox"/>记住我</label>
            </div>
            <div>
                <p>${message}</p>
            </div>
            <div class="text-center">
                <input type="submit" value="Sumit"/>
            </div>
        </form>
    </div>
</div>

</body>
</html>
