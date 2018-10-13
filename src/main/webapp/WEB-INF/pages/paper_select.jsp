<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>选择试卷</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/popper.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/vue.js"></script>
</head>
<body>
<%@include file="/WEB-INF/pages/jsp/navbar.jsp" %>
<div class="container" style="padding: 0">

    <div class="row no-gutters" style="margin-top: 30px">
        <div class="w-100">
            <img class="img-fluid" src="${pageContext.request.contextPath}/images/xuanzekaoshishijuan.png"/>
        </div>
    </div>
    <div id="selectPapers" class="row no-gutters  jumbotron" style="margin-bottom:0 ">
        <label for="select" class="input-group-prepend col-auto">请选择试卷:</label></span>
        <select id="select" class="form-control col" v-model="selectedPaperId" >
            <option v-for="paper in papers" :value="paper.id">{{paper.name}}</option>
        </select>
        <button type="button" class=" col-auto input-group-append btn btn-success" @click="startExam">　开　始　考　试　</button>
    </div>

    <div class="row no-gutters">
        <div id="accordion" class="col" style="padding: 0">
            <div class="card">
                <div class="card-header">
                    <a class="card-link" data-toggle="collapse" href="#collapseOne">
                        <div>考场规定</div>
                    </a>
                </div>
                <div id="collapseOne" class="collapse show" data-parent="#accordion">
                    <div class="card-body">
                        <ol>
                            <li>不准携带与考试无关的东西</li>
                            <li>不准交头接耳</li>
                            <li>不准作弊</li>
                        </ol>
                    </div>
                </div>
            </div>
            <div class="card">
                <div class="card-header">
                    <a class="collapsed card-link" data-toggle="collapse" href="#collapseTwo">
                        <div>考场提示</div>
                    </a>
                </div>
                <div id="collapseTwo" class="collapse" data-parent="#accordion">
                    <div class="card-body">
                        <ol>
                            <li>考试发现违纪，本次考试成绩取消</li>
                            <li>如有问题可向监考老师提问</li>
                            <li>为保证考试顺利进行，请保持网络通畅</li>
                        </ol>
                    </div>
                </div>
            </div>
            <div class="card">
                <div class="card-header">
                    <a class="collapsed card-link" data-toggle="collapse" href="#collapseThree">
                        <div>有关考试成绩的通知</div>
                    </a>
                </div>
                <div id="collapseThree" class="collapse" data-parent="#accordion">
                    <div class="card-body">
                        <ul>
                            <li>客观题系统会自动评分，主观题需要老师批改</li>
                            <li>提交后，可以查看答案</li>
                            <li>查询成绩请等系统通知</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<%@include file="/WEB-INF/pages/jsp/footer.jsp" %>

<script>
    var selectPapers = new Vue({
        el: '#selectPapers',
        data: {
            papers: [{id: 0, name: '请选择'}],
            selectedPaperId: ''
        },
        methods: {
            startExam: function () {
                window.location.href="${pageContext.request.contextPath}/exam/${subjectId}/"+this.selectedPaperId;
            }
        },
        created: function () {
            var self=this;
            $.get(
                '${pageContext.request.contextPath}/exam/getAllPapers/${subjectId}',
                function (response,status,xhr) {
                    self.papers = response;
                    self.selectedPaperId = self.papers[0].id;
                },
                'json'
            );
        }
    });
</script>
</body>
</html>
