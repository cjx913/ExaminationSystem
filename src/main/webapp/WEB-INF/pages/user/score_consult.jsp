<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>查看成绩</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-table.css"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/font-awesome/css/font-awesome.css"/>

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/popper.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-table.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-table-zh-CN.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/vue.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/pages/jsp/navbar.jsp" %>

<div class="container" >
    <div class="row no-gutters" style="margin-top: 30px">
        <div class="w-100">
            <img class="img-fluid" src="${pageContext.request.contextPath}/images/kaoshengchengjidan.png"/>
        </div>
    </div>

    <div class="row" style="margin-top: 30px">
        <img src="${pageContext.request.contextPath}/images/chengjiliebiao.png" class="img-fluid"/>
    </div>

    <div class="row">
        <div class="col-12">
            <div id="toolbar">
            </div>
            <table id="table">
            </table>
        </div>
    </div>

</div>

<%@include file="/WEB-INF/pages/jsp/footer.jsp" %>

<script>
    $(function () {
        var $table = initScoreListTable("#table", "#toolbar");
    });

    function initScoreListTable(tableId, toolbarId) {

        var table = $(tableId).bootstrapTable({
            //工具栏
            toolbar: toolbarId,
            search: true,
            showRefresh: true,
            showToggle: true,
            showPaginationSwitch: true,
            showColumns: true,
            //数据设置
            dataField: "rows",
            totalField: "total",
            method: 'get',
            contentType: "application/json;charset=UTF-8",
            url: "${pageContext.request.contextPath}/user/getScoreList",
            dataType: "json",
            queryParams: function (params) {
                    return {
                        size: params.limit,
                        start: params.offset + 1,
                        searchtext: params.search,
                        sortorder: params.order
                    }
            },
            responseHandler: function (res) {
                return {
                    rows: res.rows,
                    total: res.total
                };
            },
            onLoadSuccess: function (data) {
            },
            pagination: true,
            sidePagination: "server",
            pageNumber: 1,
            pageSize: 10,
            pageList: [1,10, 15, 25, 50, 100],

            // 列
            columns: [
                {
                    title: '序号',
                    formatter: function (value, row, index, field) {
                        return index + 1;
                    },
                    halign: "center",
                    align: 'center',
                },
                {
                    title: '科目',
                    field: 'subjectName',
                    halign: "center",
                    align: 'center',
                },
                {
                    title: '试题',
                    field: 'paperName',
                    halign: "center",
                    align: 'left',
                },
                {
                    title: '考试时间',
                    field: 'commitTime',
                    // formatter: function (value, row, index, field) {
                    //
                    //     return new Date(value);
                    // },
                    halign: "center",
                    align: 'center',
                },
                {
                    title: '成绩',
                    field: 'score',
                    halign: "center",
                    align: 'center',
                }
            ],
            uniqueId: 'id',
            //事件
            //先触发列事件再触发行时间
            /*点击某一列触发的事件*/
            onClickCell: function (field, value, row, $element) {
                /*
                field：点击列的 field 名称，
                value：点击列的 value 值，
                row：点击列的整行数据，
                $element：td 元素。
                 */
            },
            /*点击某一行触发的事件*/
            onClickRow: function (row, $element, field) {
                /*row：行中的数据；$element：tr标签；field：所点击单元格的字段名*/
            },

        });


        return table;
    }
</script>
</body>
</html>
