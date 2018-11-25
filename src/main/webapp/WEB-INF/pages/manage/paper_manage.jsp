<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="paperManage" class="container">
    <div class="row">
        <div class="col-12">
            <div id="toolbar">
                <button onclick="deleteSelectPapers()" id="remove" class="btn btn-danger"><i class="fa fa-trash" aria-hidden="true"></i></button>
                <button onclick="addPaper()" id="addUser" class="btn btn-success"><i class="fa fa-plus-square " aria-hidden="true"></i>
                </button>
            </div>
            <table id="paperTable">
            </table>
        </div>
    </div>

</div>
<script>
    var $table;
    $(function () {
        $table = initScoreListTable("#paperTable", "#toolbar");
    });

    function deleteSelectPapers() {
        alert("delete");
        var getSelectRows = $("#paperTable").bootstrapTable('getSelections', function (row) {
            return row;
        });
        for (var v of getSelectRows) {
            //${pageContext.request.contextPath}/admin/paper/deletePaperByPaperId
            //模拟删除ajax
            alert(v.paperId+"已删除(模拟)");
        }
    }

    function addPaper() {
        alert("add");
    }


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
            url: "${pageContext.request.contextPath}/admin/paper/getAllPapers",
            dataType: "json",
            queryParams: function (params) {
                return {
                    size: params.limit,
                    start: params.offset,
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
            pageList: [5, 10, 15, 25, 50, 100],

            // 列
            columns: [
                {
                    field: 'state',
                    checkbox: true,
                    align: 'center',
                    valign: 'middle'
                },
                {
                    title: 'id',
                    field: 'paperId',
                    halign: "center",
                    align: 'left',
                    width: 'col-auto',
                    visible: false
                },
                {
                    title: '序号',
                    formatter: function (value, row, index, field) {
                        return index + 1;
                    },
                    halign: "center",
                    align: 'center',
                },
                {
                    title: '试题',
                    field: 'paperName',
                    halign: "center",
                    align: 'left',
                    class: 'col-auto'

                },
                {
                    title: '科目',
                    field: 'subjectName',
                    halign: "center",
                    align: 'left',
                    class: 'col-auto'
                },
                {
                    title: '考试时间',
                    field: 'examTime',
                    halign: "center",
                    align: 'center',
                },
                {
                    title: '总分',
                    field: 'fullMark',
                    halign: "center",
                    align: 'center',
                },
                {
                    title: 'pdf路径',
                    field: 'pdfPath',
                    halign: "center",
                    align: 'left',
                    width: '250px'
                },
                {
                    title: 'word路径',
                    field: 'wordPath',
                    halign: "center",
                    align: 'left',
                    width: '250px'
                },
                {
                    title: '修改',
                    field: 'paperId',
                    formatter: function (value) {
                        return "<a href='${pageContext.request.contextPath}/admin/paper/findAllScoresByPaperId/" + value + "'>查看成绩</a>";
                    },
                    halign: "center",
                    align: 'center',
                },
                {
                    title: '修改',
                    field: 'paperId',
                    formatter: function (value) {
                        return "<a href='${pageContext.request.contextPath}/admin/paper/updatePaperByPaperId/" + value + "'>修改</a>";
                    },
                    halign: "center",
                    align: 'center',
                },
                {
                    title: '删除',
                    field: 'paperId',
                    formatter: function (value) {
                        return "<a href='${pageContext.request.contextPath}/admin/paper/deletePaperByPaperId/" + value + "'>删除</a>";
                    },
                    halign: "center",
                    align: 'center',
                },
            ],
            sortable: true,
            uniqueId: 'id',
            clickToSelect: true,
            singleSelect: false,
            minimumCountColumns: 3,
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
