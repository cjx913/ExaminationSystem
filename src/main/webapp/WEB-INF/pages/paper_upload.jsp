<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>上传试题</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.js"></script>
</head>
<body>
<form action="${pageContext.request.contextPath}/paper/upload" method="post" enctype="multipart/form-data">
    <label>请选择文件<input id="upload" name="upload" type="file" placeholder="请上传word文档" /></label>
    <input type="submit" value="Upload"/>
</form>

<script>
    $(function () {
        $('#upload').change(function () {
            if (!/\.(doc|docx)$/.test(this.value)){
                this.value="";
                alert("请选择word文档！");
            }
        });
    });
</script>
</body>
</html>
