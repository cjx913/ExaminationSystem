
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>login</title>
<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.js"></script>
<script src="${pageContext.request.contextPath}/js/verifycode.js"></script>

</head>
<body>
	<form action="${pageContext.request.contextPath}/login" method="post">
		<label for="username">用户名：</label><input id="username" name="username"
			type="text" value="" /><br /> <label for="password">密&nbsp;码：</label><input
			id="password" name="password" type="password" value="" /><br />
			 <label
			for="randomCode">验证码：</label><input id="randomCode" name="randomCode"
			type="text" value="" /> <input id="validateCode"
			name="validateCode" type="hidden" />
		<canvas id="canvasVerifyCode" style="height: 40px; width: 100px"
			height="40px" width="100px"
			onclick="verifycode('canvasVerifyCode','validateCode')"></canvas><br />
		<script type="text/javascript">
			$(function() {
				verifycode("canvasVerifyCode", "validateCode");
			});
		</script>
		<label for="rememberMe"><input id="rememberMe"
			name="rememberMe" type="checkbox" />记住我</label>
		<p>${message}</p>
		<input type="submit" value="Sumit" />
	</form>
</body>
</html>
