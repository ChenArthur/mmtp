var tableInit = {
    init : function () {
        this.initGrid();
        this.toolbarEvent();
    },
    initGrid: function() {
        $("#tb_datatables").bootstrapTable({
            url: 'http://localhost:8081/mmtp/database/gettableinfos',         //请求后台的URL（*）
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
            search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            strictSearch: true,
            showColumns: true,                  //是否显示所有的列
            showToggle:false,                    //是否显示详细视图和列表视图的切换按钮
            showRefresh: true,                  //是否显示刷新按钮
            minimumCountColumns: 2,             //最少允许的列数
            clickToSelect: true,                //是否启用点击选中行
            height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
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
            columns: [{
                checkbox: true,
                visible: true                  //是否显示复选框
            }, {
                field: 'table_schema',
                title: '数据库名'
            }, {
                field: 'table_name',
                sortable:true,
                title: '表名'
            }, {
                field: 'column_name',
                title: '列名称'
            }, {
                field: 'column_type',
                title: '列类型'
            }, {
                field: 'data_type',
                title: '列数据类型'
            },{
                field: 'column_comment',
                title: '列注释'
            },
            {
                field: 'operate',
                title: '操作',
                formatter: operateFormatter //自定义方法，添加操作按钮
            }]
        });
        /*$("#tb_datatables").bootstrapTable('getPager').pagination({
            displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录',
            layout : [ 'first', 'prev', 'links', 'next', 'last' ],// manual
            links : 10
        });*/
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
            search:params.search
        };
        console.info(temp);
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
            console.info("重新加载！");
            tableInit.reloadGrid();
        });
    }
};
/*$("#tb_datatables").bootstrapTable().on('load-success.bs.table', function (data) {//table加载成功后的监听函数
    console.log("load success");
    $(".pull-right").css("display", "block");
});*/

function operateFormatter(value, row, index) {//赋予的参数
    return [
        '<a class="btn active disabled" href="#">编辑</a>',
        '<a class="btn active" href="#">档案</a>',
        '<a class="btn btn-default" href="#">记录</a>',
        '<a class="btn active" href="#">准入</a>'
    ].join('');
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

$(function () {
    tableInit.init();
});