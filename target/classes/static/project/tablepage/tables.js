var tableInit = {
    init : function () {
        this.initGrid();
        this.toolbarEvent();
    },
    initGrid: function() {
        $("#tb_datatables").bootstrapTable({
            url: 'http://localhost:8081/mmtp/database/getdatabasetables',         //请求后台的URL（*）
            method: 'get',                      //请求方式（*）
            toolbar: '#toolbar',                //工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            undefinedText: "空",//当数据为 undefined 时显示的字符
            sortable: false,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            queryParams: tableInit.queryParams,//传递参数（*）
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber:1,                       //初始化加载第一页，默认第一页
            pageSize: 10,                       //每页的记录行数（*）
            pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
            search: false,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            strictSearch: true,
            showColumns: true,                  //是否显示所有的列
            showToggle:false,                    //是否显示详细视图和列表视图的切换按钮
            showRefresh: true,                  //是否显示刷新按钮
            minimumCountColumns: 2,             //最少允许的列数
            clickToSelect: true,                //是否启用点击选中行
            singleSelect: true,                 //设置 true 将禁止多选。
            height: 600,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            //uniqueId: "ID",                     //每一行的唯一标识，一般为主键列
            cardView: false,                    //是否显示详细视图
            detailView: false,                   //是否显示父子表
            showExport: true,                     //是否显示导出
            exportDataType: "basic",              //basic', 'all', 'selected'.
            exportTypes:[ 'csv', 'txt',  'excel', 'pdf'],  //导出文件类型
            Icons:'glyphicon-export',
            data_local: "zh-US",//表格汉化
            onLoadSuccess: function(){
                console.info("加载成功");
            },
            onLoadError: function(){
                console.info("加载数据失败");
            },
            onEditableSave: function (field, row, oldValue, $el) {
                $.ajax({
                    type: "post",
                    url: "",
                    data: { strJson: JSON.stringify(row) },
                    success: function (data, status) {
                        if (status == "success") {
                            alert("编辑成功");
                        }
                    },
                    error: function () {
                        alert("Error");
                    },
                    complete: function () {

                    }
                });
            },
            columns: [
                {checkbox: true, visible: true},                  //是否显示复选框
                {field: 'number',title: '序号', formatter: showNumber},
                {field: 'table_schema',align: 'center', title: '数据库名'},
                {field: 'table_name',align: 'center', sortable:true, title: '表名'},
                {field: 'table_type',align: 'center', title: '表类型'},
                {field: 'table_comment',align: 'center', title: '表描述'},
                {field: 'table_rows',align: 'center', title: '表数据行数'},
                {field: 'engine',align: 'center', title: '数据检索引擎'},
                {field: 'operate',align: 'center', title: '操作', formatter: operateFormatter } //自定义方法，添加操作按钮
            ]
        });
    },
    queryParams : function (params) {
        //console.info(params);
        var databasename = $("#txt_search_databasename").val();
        if (databasename == null || databasename == "")
            databasename = "sys";
        var temp = {
            rows: params.limit,   //页面大小
            page: (params.offset / params.limit) + 1,  //页码
            order: params.order,
            sort: params.sort,
            dataBaseName: databasename,
            tableName: $("#txt_search_tablename").val(),
            search: params.search
        };
        //console.info(temp);
        return temp;
    },
    reloadGrid: function () {
        $("#tb_datatables").bootstrapTable("load", tableInit.queryParams);
    },
    toolbarEvent: function () {
        $("#toolbar").find("button").each(function (i, el) {
            switch (el.id) {
                case "btn_add":
                    $(el).on("click", function () {
                        _add();
                    });
                    break;
                case "btn_edit":
                    $(el).on("click", function () {
                        _update();
                    });
                    break;
                case "btn_delete":
                    $(el).on("click", function () {
                        _delete();
                    });
            }
        });
        $("#btn_query").on("click", function () {
            tableInit.reloadGrid();
            console.info("重新加载！");
        });
        /*$("#btn_create_sql").on("click", function () {
            console.info("加载 _getCreateTableSql！");
            _getCreateTableSql();
        });*/
    }
};
/*$("#tb_datatables").bootstrapTable().on('load-success.bs.table', function (data) {//table加载成功后的监听函数
    console.log("load success");
    $(".pull-right").css("display", "block");
});*/

function operateFormatter(value, row, index) {//赋予的参数
    return [
        '<a class="btn btn-primary" id="btn_create_sql" onclick="_getCreateTableSql();" href="#" data-toggle="modal" data-target="#mySqlModal">查看表创建语句</a> ',
        '<a class="btn btn-danger" id="btn_table_info" onclick="_getTableInfo()" href="#" data-toggle="modal" data-target="#myTableInfoModal">查看表结构</a> ',
        '<a class="btn btn-info" id="btn_table_structure" onclick="_getTableStructure()" href="#" data-toggle="modal" data-target="#myTableStructureModal">查看表属性</a>',
    ].join('');
}
function showNumber(value, row, index) {
    return index+1;
}
function _add(){
    alert("添加！");
}
function _update(){
    alert("修改！");
}
function _delete(){
    var ids = "";//得到用户选择的数据的ID
    var rows = $("#tb_datatables").bootstrapTable('getSelections');
    for (var i = 0; i < rows.length; i++) {
        ids += rows[i].ID + ',';
    }
    ids = ids.substring(0, ids.length - 1);

    alert("删除！"+ids);
    //DeleteByIds(ids);
}
function _getCreateTableSql(){
    var rows = $("#tb_datatables").bootstrapTable('getSelections');
    if (rows.length > 0 && rows.length < 2) {
        $.getJSON("http://localhost:8081/mmtp/database/getcreatetablesql?tableName="+rows[0].table_name, function (data) {
            $.each(data, function (field, val) {
                if (field == 'Table') {
                    $("#dt_tablename").html(val);
                } else {
                    $("#dt_createTableSql").html(val);
                }
            })
        });
    } else {
        console.info(rows);
    }
}
function _getTableInfo(){
    var rows = $("#tb_datatables").bootstrapTable('getSelections');
    if (rows.length > 0 && rows.length < 2) {
        $("#tb_table_info").bootstrapTable('destroy');
        $("#tb_table_info").bootstrapTable({
            url: 'http://localhost:8081/mmtp/database/gettableinfos',         //请求后台的URL（*）
            method: 'get',                      //请求方式（*）
            //toolbar: '#toolbar',                //工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            undefinedText: "空",//当数据为 undefined 时显示的字符
            sortable: false,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            queryParams: function (params) {
                var req = {
                    rows: params.limit,   //页面大小
                    page: (params.offset / params.limit) + 1,  //页码
                    order: params.order,
                    sort: params.sort,
                    tableName: rows[0].table_name,
                };
                console.info(req);
                return req;
            },//传递参数（*）
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber:1,                       //初始化加载第一页，默认第一页
            pageSize: 10,                       //每页的记录行数（*）
            pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
            columns: [
            {field: 'number',title: '序号', formatter: showNumber},
            {field: 'table_schema',align: 'center', title: '数据库名'},
            {field: 'table_name',align: 'center', sortable:true, title: '表名'},
            {field: 'column_name',align: 'center', title: '字段名'},
            {field: 'column_type',align: 'center', title: '字段类型'},
            {field: 'data_type',visible: false,align: 'center', title: '数据类型'},
            {field: 'column_comment',align: 'center', title: '字段描述'},
        ]
        });
    }
}
function _getTableStructure(){
    var rows = $("#tb_datatables").bootstrapTable('getSelections');
    if (rows.length > 0 && rows.length < 2) {
        $("#tb_table_structure").bootstrapTable('destroy');
        $("#tb_table_structure").bootstrapTable({
            url: 'http://localhost:8081/mmtp/database/gettablestructure',         //请求后台的URL（*）
            method: 'get',                      //请求方式（*）
            //toolbar: '#toolbar',                //工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            undefinedText: "空",//当数据为 undefined 时显示的字符
            sortable: false,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            queryParams: function (params) {
                var req = {
                    rows: params.limit,   //页面大小
                    page: (params.offset / params.limit) + 1,  //页码
                    order: params.order,
                    sort: params.sort,
                    tableName: rows[0].table_name,
                };
                return req;
            },//传递参数（*）
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber:1,                       //初始化加载第一页，默认第一页
            pageSize: 10,                       //每页的记录行数（*）
            pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
            columns: [
                {field: 'number',title: '序号', formatter: showNumber},
                {field: 'Field',align: 'center', title: '字段名称'},
                {field: 'Type',align: 'center', sortable:true, title: '字段类型'},
                {field: 'Null',align: 'center', title: '是否为空'},
                {field: 'Key',align: 'center', title: '是否主键'},
                {field: 'Default',visible: false,align: 'center', title: '默认结果'},
                {field: 'Extra',align: 'center', title: '其他属性'},
            ]
        });
    }
}
$(function () {
    tableInit.init();
});