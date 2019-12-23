<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'pager.jsp' starting page</title>
    
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
    function page(){
        pagetiao=$("#zzz").val();        
         query(1);
         }
    
        function go(){
         var pageyes=$("#pageye").val();
         var zongye=${page.zongye};
         if(pageyes>zongye){
          alert("你输入的值超过总页数！");
       }else if(pageyes <=0){
          alert("你输入的值小于等于0！！！");
       }else{
       query(pageyes);
       };
      }
       function quanxuan(){
  $("[name='box']").each(function(){
        this.checked=true;
  });
  }
       function fuxuan(){
  $("[name='box']").each(function(){
        this.checked=!this.checked;
  });
  }
   function quanbuxuan(){
  $("[name='box']").each(function(){
        this.checked=false;
  });
  }
  
    function  piliangshanchu(){
  var ids="";
   $("[name='box']:checked").each(function(){
           ids +=","+this.value;
  });
  if(ids.length>0){
    var idsub=ids.substring(1);
	var a=idsub.split(",");
    if(confirm("确认要删除"+(a.length)+"条数据吗?")){
    location.href="<%=basePath%>materials/piliangshanchu?ids="+idsub;
    }
  
  }else{
   alert("请至少选择一个！");
  }
  
  }
    </script>
  <body >
 <table border="1px" cellpadding="3px" cellspacing="0px" bgcolor="#66ccff" width="700px">
 
 <tr><td>
 <center>
 	<input type="button" value="全选" onclick="quanxuan()">	
  		<input type="button" value="反选" onclick="fuxuan()"> 	
  	<!-- 	<input type="button" value="批量删除" onclick="piliangshanchu()"> -->
  		</center>
 </td></tr>
 <tr><td>
       <c:if test="${page.pageye!=1}">
    <a href="javascript:;" onclick="query(1)"> 首页</a>
    <a href="javascript:;" onclick="query(${page.pageye-1})"> 上一页</a>
   </c:if>
   <c:if test="${page.pageye==1||page.pageye<1}">
    首页   上一页
   </c:if>
   
    当前第${page.pageye}/${page.zongye} 页 共${page.zongtiao}条
    每页
    <select id="zzz" onchange="page()">
        <option value="3" ${page.pagetiao==3?"selected":""}>3</option>
        <option value="5" ${page.pagetiao==5?"selected":""}>5</option>
        <option value="10" ${page.pagetiao==10?"selected":""}>10</option>
    </select>
    条
  
  
   跳转到 <input type="number" id="pageye" style="width:30px">页,总共${page.zongye}页
     <input type="button" value="跳转" onclick="go()">
  
  
   <c:if test="${page.pageye!=page.zongye&&page.pageye<page.zongye}">
    <a href="javascript:;" onclick="query(${page.pageye+1})"> 下一页</a>
     <a href="javascript:;" onclick="query(${page.zongye})"> 尾页</a>
     </c:if>
     <c:if test="${page.pageye==page.zongye||page.pageye>page.zongye}">
        下一页  尾页
     </c:if>
 
 </td></tr>

 </table>
   
	  	  </body>
 
</html>
