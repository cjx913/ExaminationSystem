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
    <div class="row" style="padding-top:25px ">
        <%--left--%>
        <div id="left" class="col-6">
            <div style="padding:30px 5px 20px 20px">
                <div id="demo" class="carousel slide" data-ride="carousel">
                    <!-- 指示符 -->
                    <ul class="carousel-indicators">
                        <li data-target="#demo" data-slide-to="0" class="active"></li>
                        <li data-target="#demo" data-slide-to="1"></li>
                        <li data-target="#demo" data-slide-to="2"></li>
                    </ul>
                    <!-- 轮播图片 -->
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img class="img-fluid h-100" src="${pageContext.request.contextPath}/images/index02.png"/>
                        </div>
                        <div class="carousel-item">
                            <img class="img-fluid h-100" src="${pageContext.request.contextPath}/images/index03.png"/>
                        </div>
                        <div class="carousel-item">
                            <img class="img-fluid h-100" src="${pageContext.request.contextPath}/images/index04.png"/>
                        </div>
                    </div>
                    <!-- 左右切换按钮 -->
                    <a class="carousel-control-prev" href="#demo" data-slide="prev">
                        <span class="carousel-control-prev-icon"></span>
                    </a>
                    <a class="carousel-control-next" href="#demo" data-slide="next">
                        <span class="carousel-control-next-icon"></span>
                    </a>
                </div>
            </div>
        </div>
        <%--right--%>
        <div id="right" class="col-5">
            <div style="padding-top: 10px">
                <div class="container">
                    <br>
                    <!-- Nav pills -->
                    <ul class="nav nav-pills" sysRole="tablist">
                        <li class="nav-item">
                            <a class="nav-link active" data-toggle="pill" href="#accountLogin">账号登陆</a>
                        </li>
                        <span style="margin: 0px 5px;height: 35px;line-height: 35px">|</span>
                        <li class="nav-item">
                            <a class="nav-link" data-toggle="pill" href="#otherLogin">其他登陆 </a>
                        </li>
                        <span style="margin: 0px 5px;height: 35px;line-height: 35px">|</span>
                        <li class="nav-item">
                            <a class="nav-link" data-toggle="pill" href="#register">注　　册 </a>
                        </li>
                    </ul>

                    <!-- Tab panes -->
                    <div class="tab-content">
                        <div id="accountLogin" class="container tab-pane active"><br>
                            <div style="margin: 20px">
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
                        <div id="otherLogin" class="container tab-pane fade"><br>
                            <%--微信登陆--%>
                            <button type="button" class="btn btn-success btn-block" style="margin: 20px 10px"
                                    data-toggle="modal" data-target="#WeChatModal">使用微信账号登陆
                            </button>
                            <!-- 模态框 -->
                            <div class="modal fade" id="WeChatModal">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <!-- 模态框头部 -->
                                        <div class="modal-header">
                                            <h4 class="modal-title">微信登陆</h4>
                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        </div>
                                        <!-- 模态框主体 -->
                                        <div class="modal-body">
                                            <h5 class="text-center">请扫码登陆</h5>
                                        </div>
                                        <!-- 模态框底部 -->
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <%--QQ登陆--%>
                            <button type="button" class="btn btn-info btn-block" style="margin: 20px 10px"
                                    data-toggle="modal" data-target="#QQModal">使用QQ账号登陆
                            </button>
                            <!-- 模态框 -->
                            <div class="modal fade" id="QQModal">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <!-- 模态框头部 -->
                                        <div class="modal-header">
                                            <h4 class="modal-title">QQ登陆</h4>
                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        </div>
                                        <!-- 模态框主体 -->
                                        <div class="modal-body">
                                            <h5 class="text-center">请扫码登陆</h5>
                                        </div>
                                        <!-- 模态框底部 -->
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <%--微博登陆--%>
                            <button type="button" class="btn btn-secondary btn-block" style="margin: 20px 10px"
                                    data-toggle="modal" data-target="#WeiBoModal">使用微博账号登陆
                            </button>
                            <!-- 模态框 -->
                            <div class="modal fade" id="WeiBoModal">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <!-- 模态框头部 -->
                                        <div class="modal-header">
                                            <h4 class="modal-title">微博登陆</h4>
                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        </div>
                                        <!-- 模态框主体 -->
                                        <div class="modal-body">
                                            <h5 class="text-center">请扫码登陆</h5>
                                        </div>
                                        <!-- 模态框底部 -->
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <%--网易登陆--%>
                            <button type="button" class="btn btn-danger btn-block" style="margin: 20px 10px"
                                    data-toggle="modal" data-target="#WangYiModal">使用网易账号登陆
                            </button>
                            <!-- 模态框 -->
                            <div class="modal fade" id="WangYiModal">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <!-- 模态框头部 -->
                                        <div class="modal-header">
                                            <h4 class="modal-title">网易登陆</h4>
                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        </div>
                                        <!-- 模态框主体 -->
                                        <div class="modal-body">
                                            <h5 class="text-center">请扫码登陆</h5>
                                        </div>
                                        <!-- 模态框底部 -->
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div id="register" class="container tab-pane fade"><br/>
                            <div style="margin: 20px">
                                <form action="${pageContext.request.contextPath}/register" method="post">
                                    <div>
                                        <label for="username">用户名：</label><input name="username"
                                                                                 type="text" value=""/><br/>
                                    </div>
                                    <div>
                                        <label for="username">邮　箱：</label><input name="email"
                                                                                 type="email" value=""/><br/>
                                    </div>
                                    <div>
                                        <label
                                                for="password">密　码：</label><input name="password" type="password"
                                                                                  value=""/><br/>
                                    </div>
                                    <div>
                                        <label
                                                for="randomCode">验证码：</label><input name="randomCode"
                                                                                    type="text" value=""/>
                                        <input id="r-validateCode"
                                                name="validateCode" type="hidden"/>
                                        <canvas id="r-canvasVerifyCode" style="margin-bottom: -10px"
                                                height="30px" width="80px"
                                                onclick="verifycode('r-canvasVerifyCode','r-validateCode')"></canvas>
                                        <br/>
                                        <script type="text/javascript">
                                            $(function () {
                                                verifycode("r-canvasVerifyCode", "r-validateCode");
                                            });
                                        </script>
                                    </div>
                                    <div>
                                        <p>${registerMessage}</p>
                                    </div>
                                    <div class="text-center">
                                        <input type="submit" value="Sumit"/>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
