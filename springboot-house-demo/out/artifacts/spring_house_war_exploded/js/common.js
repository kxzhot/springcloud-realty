$(document).ready(function(){
	var htmlCode = '<table class="table table-hover"><tbody><tr><td><a onclick="goFirst()"><span class="label label-info">首页</span></a></td><td><a onclick="goPri()"><span class="label label-info">上一页</span></a></td>'+
				   '<td>第<span id="cpage">1</span>页&nbsp;共<span id="totalPage">0</span>页</td>'+
				   '<td><a onclick="goNext()"><span class="label label-info">下一页</span></a></td><td><a onclick="goLast()"><span class="label label-info">尾页</span></a></td><td>展示<select id="pageSize" onchange="changePageSize()"><option value="2">2</option><option value="4">4</option><option value="6">6</option></select>条</td><td>选择第<input type="text" id="targetPage" style="width: 60px">页'+
				   '<a onclick="goToPage()"><span class="label label-info">跳转</span></a></td>'+
				   '</tr></tbody></table><center><span id="pager_tips" style="color:red;"></span></center>';
	$("#pager_tools").html(htmlCode);
});

//下一页
function goNext(){
	var cpage = Number($("#cpage").html());
	var totalPage = Number($("#totalPage").html());
	
	if(cpage + 1 > totalPage){
		$("#pager_tips").html("已经是最后一页");
	}else{
		$("#pager_tips").html("");
		$("#cpage").html(cpage+1);
		getData(cpage+1);
	}
}
//上一页
function goPri(){
	var cpage = Number($("#cpage").html());
	if(cpage - 1 < 1){
		$("#pager_tips").html("已经是第一页");
	}else{
		$("#pager_tips").html("");
		$("#cpage").html(cpage-1);
		getData(cpage-1);
	}
}
//首页
function goFirst(){
	$("#pager_tips").html("");
	$("#cpage").html(1);
	getData(1);
}
//尾页
function goLast(){
	$("#pager_tips").html("");
	var totalPage = Number($("#totalPage").html());
	$("#cpage").html(totalPage);
	getData(totalPage);
}

function changePageSize(){
	$("#pager_tips").html("");
	$("#cpage").html(1);
	getData(1);
}

function goToPage(){
	var targetPage = Number($("#targetPage").val());
	var totalPage = Number($("#totalPage").html());
	if( targetPage > totalPage){
		targetPage = totalPage;
	}
	$("#pager_tips").html("");
	$("#cpage").html(targetPage);
	$("#targetPage").val(targetPage);
	getData(targetPage);
}

Date.prototype.format = function(format) {
    var o = {
        "M+" : this.getMonth() + 1, // 月
        "d+" : this.getDate(), // 日
        "h+" : this.getHours(), // 小时
        "m+" : this.getMinutes(), // 分钟
        "s+" : this.getSeconds(), // 秒
        "q+" : Math.floor((this.getMonth() + 3) / 3), // 季度
        "S" : this.getMilliseconds() //毫秒
    };
    if (/(y+)/.test(format)){
        format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    }
    for ( var k in o){
        if (new RegExp("(" + k + ")").test(format)){
            format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k]: ("00" + o[k]).substr(("" + o[k]).length));
        }
    }
    return format;//返回字符串"2019-06-21 10:40:00"
};
