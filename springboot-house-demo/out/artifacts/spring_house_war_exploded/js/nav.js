var isLogin=false;
var name;
$(function () {
    var v_navHtml = "<nav class=\"navbar navbar-inverse\">\n" +
        "    <div class=\"container-fluid\">\n" +
        "        <!-- Brand and toggle get grouped for better mobile display -->\n" +
        "        <div class=\"navbar-header\" >\n" +
        "           <ul> <li onclick='Location.'><a class=\"navbar-brand\"href=\"/index-student.html\" >亿点细节商城</a></li></ul>\n" +
        "        </div>\n" +
        "\n" +
        "        <!-- Collect the nav links, forms, and other content for toggling -->\n" +
        "        <div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">" +
        "            <ul class=\"nav navbar-nav navbar-right\" id='nav_ul'>" +
        "                <li><a href=\"/login.html\">登录</a></li>" +
        "                <li><a href=\"/addhouse.html\">注册</a></li>" +
        "                <li><a href=\"/cart-student.html\">购物车</a></li>" +
        "            </ul>\n" +
        "        </div><!-- /.navbar-collapse -->\n" +
        "    </div><!-- /.container-fluid -->\n" +
        "</nav>";

    $("#navDiv").html(v_navHtml);

    $.ajaxSetup({
        beforeSend: function(xhr) {
            var token = window.localStorage.getItem("token");
            xhr.setRequestHeader("x-auth", token)
            if(token!=null&&token!=""){
                isLogin=true;
            }
        }
    })
        $.ajax({
            url: "http://localhost:8083/member/getMenmberMessage",

            success: function (data) {
                if (data.status == 200) {
                    var data = data.data;
                    name = data.memberName;
                    isLogin = true;
                    var str = '<li ><a>欢迎：' + data.memberName + '</a></li>" +\n' +
                        '   <li><a href="/getOrderInfo-student.html">我的订单</a></li>" +\n' +
                        '   <li onclick="outLogin()"><a >退出</a></li>"+\n' +
                        '   <li><a href="/cart-student.html">我的购物车</a></li>';
                    $("#nav_ul").html(str);
                }
            }
        })

})
function outLogin() {
    window.localStorage.clear();
    location.href="/index-student.html";
}







