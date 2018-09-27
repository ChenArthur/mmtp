//自定义函数处理queryParams的批量增加
$.fn.serializeJsonObject = function () {
    var json = {};
    var form = this.serializeArray();
    $.each(form, function () {
        if (json[this.name]) {
            if (!json[this.name].push) {
                json[this.name] = [json[this.name]];
            }
            json[this.name].push();
        } else {
            json[this.name] = this.value || '';
        }
    });
    return json;
}

//判断数组中是否包含某内容
Array.prototype.contains = function ( needle ) {
    for (i in this) {
        if (this[i] == needle) return true;
    }
    return false;
}

function dateTimeFormate(date){
    if(!date){
        return
    }else{
        var d = new Date(date);
        var year = d.getFullYear();
        var month = ('0' + (d.getMonth() + 1)).slice(-2);
        var day = ('0' + (d.getDate())).slice(-2);
        var hour = ('0' + (d.getHours())).slice(-2);
        var minutes = ('0' + (d.getMinutes())).slice(-2);
        var seconds = ('0' + (d.getSeconds())).slice(-2);
        return year + "-" + month + "-" + day + " " + hour + ":" + minutes + ":" + seconds;
    }
}