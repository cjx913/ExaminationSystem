<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<div class="container-fluid bg-dark">
    <div class="row align-items-center  justify-content-center text-white" style="height: 40px;margin-top: 20px">
        <div class="col-auto">~在线考试系统~cjx913@126.com~<shiro:hasAnyRoles name="administrator,admin"><a href="${pageContext.request.contextPath}/admin/toManage">管理</a>~</shiro:hasAnyRoles></div>
    </div>
</div>