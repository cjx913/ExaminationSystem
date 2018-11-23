<%@ page contentType="text/html;charset=UTF-8" language="java" %>



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

