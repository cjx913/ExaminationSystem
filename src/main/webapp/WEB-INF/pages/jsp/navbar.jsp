<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<div class="container-fluid" style="padding: 0;min-width: 576px">
    <div class="row no-gutters text-white">
        <nav class="col navbar navbar-expand-md bg-dark navbar-dark ">
            <!-- Brand -->
            <div class="col-auto navbar-brand">
                <img src="${pageContext.request.contextPath}/images/exam.png" style="width: 40px;height: auto">
            </div>
            <!-- Navbar links -->
            <div class="col-auto collapse navbar-collapse " id="collapsibleNavbar">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/index">首页</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/exam/selectSubject">在线考试</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/user/consultScore">成绩查询</a>
                    </li>
                </ul>
            </div>

            <div class="col"></div>


            <div class="col-auto">

                <shiro:notAuthenticated>
                    <a href="${pageContext.request.contextPath}/toLogin">登陆</a>
                    <a href="${pageContext.request.contextPath}/toRegister">注册</a>
                </shiro:notAuthenticated>
                <shiro:authenticated>
                    <span>您好！<strong><shiro:principal property="username"/></strong></span>
                    <a href="${pageContext.request.contextPath}/logout">退出</a>
                </shiro:authenticated>
            </div>

            <button class="col-auto navbar-toggler" type="button" data-toggle="collapse"
                    data-target="#collapsibleNavbar">
                <span class="navbar-toggler-icon"></span>
            </button>
        </nav>
    </div>
</div>