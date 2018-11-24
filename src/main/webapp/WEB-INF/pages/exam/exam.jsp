<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>exam</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/popper.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/vue.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/pdf.js"></script>

    <style>
        #answerArea .container .row {
            padding-left: 15px;
            padding-right: 5px;
        }

        #answerArea .container .row .col {
            padding-left: 0px;
            padding-right: 0px;
        }
    </style>
</head>
<body>
<div class="container-fluid" style="padding:0;">
    <%@ include file="/WEB-INF/pages/jsp/navbar.jsp" %>
</div>
<div class="container-fluid" style="padding:0;">
    <div class="row no-gutters" style="height: 750px">
        <div id="questionArea" class="col-12 col-sm-12 col-md  h-100"
             style=" margin:0px;padding:0px;overflow:auto;display:block;">

            </canvas>
        </div>
        <div class="col-auto col-sm-auto col-md-auto h-100"
             style="padding-left: 5px;padding-right: 5px;background-image: linear-gradient(to right, darkgray, gray, white)">
            &nbsp;&nbsp;&nbsp;&nbsp;
        </div>
        <div id="answerArea" class="col col-sm col-md-5 h-100" style="overflow-y: auto">

            <div class="container no-gutters">
                <div class="row justify-content-center">
                    <h3 class="text-center"><span>{{paperName}}（答题区）</span></h3>
                </div>
                <div id="timer" class="row justify-content-center text-danger">

                </div>
                <div class="row" v-if="panduanti>0"><h5>判断题</h5></div>
                <div class="row" v-if="panduanti>0">
                    <div class="col-auto" v-for="(item,index) in panduanti" v-if="index<panduanti">
                        <form>
                            <span>{{index+1}}:</span>
                            <label class="radio-inline"><input type="radio" :name="'panduanti'+(index+1)"
                                                               v-model="answer_panduanti[index]" value="t">√</label>
                            <label class="radio-inline"><input type="radio" :name="'panduanti'+(index+1)"
                                                               v-model="answer_panduanti[index]" value="f">×</label>
                        </form>
                    </div>
                </div>

                <div class="row" v-if="danxuanti>0"><h5>单选题</h5></div>
                <div class="row" v-if="danxuanti>0">
                    <div class="col-auto" v-for="(item,index) in danxuanti" v-if="index<danxuanti">
                        <form>
                            <span>{{index+1+panduanti}}:</span>
                            <label class="radio-inline"><input type="radio" :name="'danxuanti'+(index+1)"
                                                               v-model="answer_danxuanti[index]" value="a">A</label>
                            <label class="radio-inline"><input type="radio" :name="'danxuanti'+(index+1)"
                                                               v-model="answer_danxuanti[index]" value="b">B</label>
                            <label class="radio-inline"><input type="radio" :name="'danxuanti'+(index+1)"
                                                               v-model="answer_danxuanti[index]" value="c">C</label>
                            <label class="radio-inline"><input type="radio" :name="'danxuanti'+(index+1)"
                                                               v-model="answer_danxuanti[index]" value="d">D</label>
                        </form>
                    </div>
                </div>

                <div class="row" v-if="duoxuanti>0"><h5>多选题</h5></div>
                <div class="row" v-if="duoxuanti>0">
                    <div class="col-auto" v-for="(item,index) in duoxuanti" v-if="index<duoxuanti">
                        <form>
                            <span>{{index+1+panduanti+danxuanti}}:</span>
                            <label class="radio-inline"><input type="checkbox"
                                                               v-model="answer_duoxuanti[index]"
                                                               value="a">A</label>
                            <label class="radio-inline"><input type="checkbox"
                                                               v-model="answer_duoxuanti[index]"
                                                               value="b">B</label>
                            <label class="radio-inline"><input type="checkbox"
                                                               v-model="answer_duoxuanti[index]"
                                                               value="c">C</label>
                            <label class="radio-inline"><input type="checkbox"
                                                               v-model="answer_duoxuanti[index]"
                                                               value="d">D</label>
                            <label class="radio-inline"><input type="checkbox"
                                                               v-model="answer_duoxuanti[index]"
                                                               value="e">E</label>
                            <label class="radio-inline"><input type="checkbox"
                                                               v-model="answer_duoxuanti[index]"
                                                               value="f">F</label>
                        </form>
                    </div>
                </div>

                <div class="row" v-if="tiankongti>0"><h5>填空题</h5></div>
                <div class="row" v-if="tiankongti>0">
                    <div class="col-12" v-for="(item,index) in tiankongti" v-if="index<tiankongti">
                        <form>
                            <div class="form-group row">
                                <label class="col-auto col-form-label">{{index+1+panduanti+danxuanti+duoxuanti}}</label>
                                <div class="col">
                                    <input type="text" class="form-control" placeholder="请输入答案"
                                           :name="'tiankongti'+(index+1)"
                                           v-model="answer_tiankongti[index]">
                                </div>
                            </div>
                        </form>
                    </div>
                </div>

                <div class="row" v-if="jiedati>0"><h5>解答题</h5></div>
                <div class="row" v-if="jiedati>0">
                    <div class="col-12" v-for="(item,index) in jiedati" v-if="index<jiedati">
                        <form>
                            <div class="form-group row">
                                <label class="col-auto col-form-label">{{index+1+panduanti+danxuanti+duoxuanti+tiankongti}}</label>
                                <div class="col">
                                    <textarea class="form-control" rows="10" :name="'jiedati'+(index+1)"
                                              v-model="answer_jiedati[index]"
                                              style="overflow-x: auto"></textarea>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="row  justify-content-center">
                    <div class="col-10" style="padding-bottom: 20px">
                        <button type="button" class="btn btn-success btn-block" v-on:click="submitAnswer">
                            <span>提&nbsp;&nbsp;交</span>
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="container-fluid" style="padding:0;">
    <%@include file="/WEB-INF/pages/jsp/footer.jsp" %>
</div>


<script>
    var maxtime;
    $(function () {
        $.ajax({
            url: '${pageContext.request.contextPath}/exam/getPaper/${subjectId}/${paperId}',
            type: 'get',
            // data:JSON.stringify(data),
            contentType: 'application/x-www-form-urlencoded',
            dataType: 'json',
            success: function (result, status) {
                initAnswerArea(result.paperMessage);
                initQuestionArea(result.data, "questionArea");
            }
        });


        function initQuestionArea(pdfDate, displayId) {
            var data = atob(pdfDate);
            var pdfjsLib = window['pdfjs-dist/build/pdf'];


            pdfjsLib.GlobalWorkerOptions.workerSrc = '${pageContext.request.contextPath}/js/pdf.worker.js';


            var loadingTask = pdfjsLib.getDocument({data: data});
            loadingTask.promise.then(function (pdf) {

                for (var i = 1; i <= pdf.numPages; i++) {

                    pdf.getPage(i).then(function (page) {
                        var scale = 2;
                        var viewport = page.getViewport(scale);
                        var canvas = document.createElement('canvas');
                        canvas.setAttribute("style", "width:100%;height:auto;");
                        var context = canvas.getContext('2d');
                        canvas.height = viewport.height;
                        canvas.width = viewport.width;
                        var renderContext = {
                            canvasContext: context,
                            viewport: viewport
                        };
                        var renderTask = page.render(renderContext);
                        renderTask.then(function () {
                            console.log('Page rendered' + i);
                        });
                        var parent = document.getElementById(displayId);
                        parent.appendChild(canvas);
                    });

                }
            }, function (reason) {
                console.error(reason);
            });
        }


        function initAnswerArea(paperMessage) {
            maxtime = paperMessage.examTime * 60;
            var answerArea = new Vue({
                el: '#answerArea',
                data: {
                    paperName: paperMessage.paperName,
                    panduanti: paperMessage.panduanti,
                    danxuanti: paperMessage.danxuanti,
                    duoxuanti: paperMessage.duoxuanti,
                    tiankongti: paperMessage.tiankongti,
                    jiedati: paperMessage.jiedati,
                    examTime: paperMessage.examTime,
                    fullMark: paperMessage.fullMark,
                    answer_panduanti: [],
                    answer_danxuanti: [],
                    answer_duoxuanti: [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], []],
                    answer_tiankongti: [],
                    answer_jiedati: []
                },
                methods: {
                    submitAnswer: function () {
                        var answerData={
                            "userId":"${user.userId}",
                            "subjectId":"${subjectId}",
                            "paperId":"${paperId}",
                            "submitTime":new Date(),
                            "panduanti": this.answer_panduanti,
                            "danxuanti": this.answer_danxuanti,
                            "duoxuanti": this.answer_duoxuanti,
                            "tiankongti": this.answer_tiankongti,
                            "jiedati": this.answer_jiedati,
                        };
                        $.ajax({
                            type: 'POST',
                            url: "${pageContext.request.contextPath}/exam/submitAnswer",
                            contentType:"application/json;charset=utf-8",
                            data: JSON.stringify(answerData),
                            success: function (result,status,xhr) {
                                alert(result);
                            },
                            dataType: "json"
                        });
                    }
                }
            });
        }


    });


    timer = setInterval("CountDown()", 1000);

    function CountDown() {
        if (maxtime >= 0) {
            minutes = Math.floor(maxtime / 60);
            seconds = Math.floor(maxtime % 60);
            msg = "距离结束还有" + minutes + "分" + seconds + "秒";
            $("#timer").html(msg);
            if (maxtime == 5 * 60) alert("还剩5分钟");
            --maxtime;
        } else {
            clearInterval(timer);
            alert("时间到，结束!");
        }
    }


    window.onbeforeunload = function () {
        return false;
    }


</script>
</body>
</html>
