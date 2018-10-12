<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>选择考试科目</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/popper.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/vue.js"></script>
</head>
<body>
<%@include file="/WEB-INF/pages/jsp/navbar.jsp" %>

<div class="container" style="min-width: 756px">
    <div class="row" style="margin-top: 30px">
        <img src="${pageContext.request.contextPath}/images/xuanzekaoshikemu.png"
             class="img-fluid"/>
    </div>
    <div class="row" style="margin-top: 30px">
        <img src="${pageContext.request.contextPath}/images/kaoshikemu.png"  class="img-fluid"/>
    </div>

    <div id="selectSubject" class="row" style="min-height: 400px">
        <div class="col-12 col-sm-6 col-md-4 col-lg-3 col-xl-3 border border-primary rounded" style="padding-top:20px;padding-left:25px;height: 100px;"
        v-for="subject in subjects">
            <div>
                <img src="${pageContext.request.contextPath}/images/icon_pen.png" style="height: 44px;width: auto;"/>
                <a :href="'${pageContext.request.contextPath}/exam/selectPaper/'+subject.id"><span><strong>{{subject.name}}</strong></span></a>
            </div>
            <div style="margin-top:5px;background-color: #9fcdff">共有{{subject.paperCount}}份试题</div>
        </div>
    </div>
</div>

<%@include file="/WEB-INF/pages/jsp/footer.jsp" %>

<script>
var selectSubject = new Vue({
    el:'#selectSubject',
    data:{
        subjects:''
    },
    methods:{

    },
    created:function () {
        var self=this;
        $.get(
            '${pageContext.request.contextPath}/exam/getAllSubjects',
            function (response,status,xhr) {
                self.subjects = response;
            },
            'json'
        );
    }
});
</script>
</body>
</html>
