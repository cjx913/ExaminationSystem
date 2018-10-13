<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>index</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/popper.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>

    <style>
        html {
            margin: 0;
            padding: 0;
        }

        body {
            margin: 0;
            padding: 0;
        }
    </style>
</head>
<body>

<%@include file="/WEB-INF/pages/jsp/navbar.jsp"%>

<div class="container-fluid" style="padding: 0">
    <div class="row no-gutters justify-content-center">
        <div class="col">
            <img class="img-fluid"
                 src="${pageContext.request.contextPath}/images/index01.png"/>
        </div>
    </div>
</div>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-10">
            <img class="img-fluid" src="${pageContext.request.contextPath}/images/index02.png"/>
        </div>
    </div>
    <div class="row justify-content-center">
        <div class="col-10"">
            <img class="img-fluid" src="${pageContext.request.contextPath}/images/index03.png"/>
        </div>
    </div>
    <div class="row justify-content-center">
        <div class="col-10">
            <img class="img-fluid" src="${pageContext.request.contextPath}/images/index04.png"/>
        </div>
    </div>
    <div class="row  justify-content-center">
        <div class="col-10">
            <button type="button" class="btn btn-success btn-block"
            onclick="window.location.href='${pageContext.request.contextPath}/exam/selectSubject'">
                立&nbsp;&nbsp;即&nbsp;&nbsp;考&nbsp;&nbsp;试</button>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/pages/jsp/footer.jsp"%>
</body>
</html>
