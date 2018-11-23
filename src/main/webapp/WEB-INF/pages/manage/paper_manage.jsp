<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="userManage" class="container">
    <div class="row">
        <div class="col-12">
            <div id="toolbar">
                <button id="remove" class="btn btn-danger"><i class="fa fa-trash" aria-hidden="true"></i></button>
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
            url: "${pageContext.request.contextPath}/admin/getAllUserIdentities",
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
                    title: '序号',
                    formatter: function (value, row, index, field) {
                        return index + 1;
                    },
                    halign: "center",
                    align: 'center',
                    width: 'col-auto'
                },
                {
                    title: 'id',
                    field: 'id',
                    halign: "center",
                    align: 'left',
                    width: 'col-auto'
                },
                {
                    title: '科目',
                    field: 'subject_id',
                    halign: "center",
                    align: 'right',
                },
                {
                    title: '试题',
                    field: 'name',
                    halign: "center",
                    align: 'center',
                },
                {
                    title: '修改',
                    formatter: function () {
                        return "<a href='#'>修改</a>";
                    },
                    halign: "center",
                    align: 'center',
                },
                {
                    title: '删除',
                    formatter: function () {
                        return "<a href='#'>删除</a>";
                    },
                    halign: "center",
                    align: 'center',
                },
            ],
            sortable: true,
            uniqueId: 'id',
            clickToSelect: true,
            singleSelect: false,
            minimumCountColumns:5,
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
