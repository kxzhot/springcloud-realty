<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'fygj.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <script type="text/javascript">
 
  function xianshitiaoshu(){

     ts=$("#ts").val();
    	chaxun(1);
    }
     function tiaozhuanyeshu(){
         var pageyes=$("#ys").val();
         var zongye=${fy.zys};
         if(pageyes>zongye){
          alert("你输入的值超过总页数！");
       }else if(pageyes <=0){
          alert("你输入的值小于等于0！！！");
       }else{
       chaxun($("#ys").val());
       }
      }
      function quanxuan(){
      	$("[name='xz']").each(function(){
      		this.checked=true;
      	});
      }
      function quanbuxuan(){
      	$("[name='xz']").each(function(){
      		this.checked=false;
      	});
      }
      function fanxuan(){
      	$("[name='xz']").each(function(){
      		this.checked=!this.checked;
      	});
      }
      
      function piliangshanchu(){
         var idss="";
    	 var ids="";
    	 var a=0;
      	$("[name='xz']:checked").each(function(){
      		if(this.checked==true){
      			idss+=","+this.value;
      			a=a+1;
      		}
      	});
      		if(idss.length>0){
      			ids=idss.substring(1);
      			if(confirm("确认要删除这"+a+"条数据吗？")){
      			location.href="<%=basePath%>/job/deletep?ids="+ids;
      			}
      		}else{
      			alert("请正确操作");
      		}
      }
  </script>
  <body>
  <table border="1px"  cellspacing="0px" cellpadding="10px" bgcolor="#33ccff">
 	 <tr>
 		 <td>
    <c:if test="${fy.dqy==1}">
    	首页&nbsp;上一页
    </c:if>
    <c:if test="${fy.dqy!=1}">
    	<a  href="javascript:;" onclick="chaxun(1)">首页</a>
    	<a  href="javascript:;" onclick="chaxun(${fy.dqy-1})">上一页</a>
    </c:if>
    
     	当前第${fy.dqy},共${fy.zys}页,共${fy.zts}条
    	
    <c:if test="${fy.dqy>=fy.zys}">
    	下一页&nbsp;尾页 
    </c:if>
    <c:if test="${fy.dqy!=fy.zys&&fy.zys!=0}">
    	<a  href="javascript:;" onclick="chaxun(${fy.dqy+1})">下一页</a>
    	<a  href="javascript:;" onclick="chaxun(${fy.zys})">尾页</a>
    </c:if>	
    每页显示<input id="ts" type="number"><input type="button" value="确定" onclick="xianshitiaoshu()" class="btn btn-default">
    跳转到第<input id="ys" type="number">页<input type="button" value="确定" onclick="tiaozhuanyeshu()"class="btn btn-default">
		</td>
	</tr>
</table>
<br>
<br>

  </body>
</html>
