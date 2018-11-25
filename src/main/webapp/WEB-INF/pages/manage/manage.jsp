<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>管理</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-table.css"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/font-awesome/css/font-awesome.css"/>

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/popper.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-table.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-table-zh-CN.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/vue.js"></script>
    <style>
    </style>
</head>
<body>
<div id="container" class="container-fluid" style="padding: 0px;padding-bottom: 10px">
    <div class="row no-gutters justify-content-center bg-info">
        <div class="col-auto">
            <h2>在线考试系统后台管理</h2>
        </div>
    </div>
    <div class="row no-gutters">
        <div id="leftMenu" class=" col-sm-4 col-md-3 col-lg-2"
             　 style="box-shadow: 5px 5px 2px #aaa">
            <div>
                <ul>
                    <li><a href="${pageContext.request.contextPath}/">首页</a></li>
                    <li data-toggle="collapse" data-target="#collapse_manage"><a
                            href="#">管理</a></li>
                    <div id="collapse_manage" class="collapse">
                        <ul>
                            <li><a href="#"
                                   onclick="meunClick('${pageContext.request.contextPath}/admin/userManage')">用户管理</a>
                            </li>
                            <li data-toggle="collapse" data-target="#collapse_exam_manage"><a
                                    href="#">考试管理</a></li>
                            <div id="collapse_exam_manage" class="collapse">
                                <ul>
                                    <li><a href="#"
                                           onclick="meunClick('${pageContext.request.contextPath}/admin/subjectManage')">科目管理</a>
                                    </li>
                                    <li><a href="#"
                                           onclick="meunClick('${pageContext.request.contextPath}/admin/paperManage')">试题管理</a>
                                    </li>
                                    <li><a href="${pageContext.request.contextPath}/#">成绩管理</a></li>
                                </ul>
                            </div>
                            <li><a href="${pageContext.request.contextPath}/#" >考试发布</a></li>
                        </ul>
                    </div>
                </ul>
            </div>
        </div>
        <div class="col-sm-8 col-md-9 col-lg-10" id="rightContent" >
        </div>
    </div>
</div>
</div>


<script>

    function meunClick(url) {
        $.ajax({
            url: url,
            success: function (result, status) {
                $('#rightContent').html(result);
            }
        });
    }


</script>
</body>
</html>
