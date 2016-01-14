<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>商品详情</title>
  
    <!-- <meta name="description" content="">
    <meta name="author" content=""> -->

    <!-- Le styles -->
    <link href="<%=path %>/css/bootstrap.css" rel="stylesheet">
    <link href="<%=path %>/css/bootstrap-responsive.css" rel="stylesheet">
    <link href="<%=path %>/css/stylesheet.css" rel="stylesheet">
    <link href="<%=path %>/css/index.css" rel="stylesheet">
    <link href="<%=path %>/icon/font-awesome.css" rel="stylesheet">
    

    <!-- Le fav and touch icons -->
    <%-- <link rel="apple-touch-icon-precomposed" sizes="144x144" href="<%=path %>/img/apple-touch-icon-144-precomposed.html">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="<%=path %>/img/apple-touch-icon-114-precomposed.html">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="<%=path %>/img/apple-touch-icon-72-precomposed.html">
    <link rel="apple-touch-icon-precomposed" href="<%=path %>/img/apple-touch-icon-57-precomposed.html"> --%>
                                  

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="js/html5shiv.js"></script>
    <![endif]-->
    
  </head>

  <body>

    <!-- <img alt="图片" src="http://wxdv.berbon.com/pic/1-0.jpg" id="17" width="80px" height="80px"> -->
    <div id="content"> <!-- Content start -->
      <div class="inner_content">
          <div class="widgets_area">
                <div class="row-fluid">
                    <div class="span12">
                         <div  class="daohanglink" style="">
                           <span class="daohang"></span>
                           <span>首页</span><span>></span>
                           <span>商品管理</span><span>></span>
                           <span>商品详情</span>
                           
                         </div>
                        <div class="well brown">
                         <form action="#">
                         	
                         		<div id="img"></div>
                         	
                         	<script type="text/javascript">
                         		var pic=new Array();
                         		var imgs="${goods.picture}";
                         		pic=imgs.split(",");
                         		var el=document.getElementById("img");
                         		for(var i=0;i<pic.length;i++){
                         			el.innerHTML +="<img width='80px' height='80px' src='http://wxdv.berbon.com/pic/"+pic[i]+"'>";
                         		}
                         	</script>
                            <div class="form_list"><label class="lable_title">商品标题</label><font style="margin-left:20px" size="3px">${goods.title}</font></div>
                            <div class="form_list"><label class="lable_title">商品价格</label><font style="margin-left:20px" size="3px">${goods.price}</font></div>
                            <div class="form_list"><label class="lable_title">发布时间</label><font style="margin-left:20px" size="3px">${goods.publishTime}</font></div>
                            <div class="form_list"><label class="lable_title">联系人</label><font style="margin-left:20px" size="3px">${goods.contacts}</font></div>
                            <div class="form_list"><label class="lable_title">电话</label><font style="margin-left:20px" size="3px">${goods.phone}</font></div>
                            <div class="form_list"><label class="lable_title">QQ</label><font style="margin-left:20px" size="3px">${goods.QQ}</font></div>
                            <div class="form_list"><label class="lable_title">商品描述</label><textarea style="margin-left:20px" cols="100" rows="5" readonly="readonly">${goods.describe}</textarea></div>
                         </form>   
                        </div>
                    </div>
                </div>

            
            </div>
        </div>
    </div>

    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
   
    <script src="<%=path %>/js/jquery-ui-1.10.3.js"></script>
    <script src="<%=path %>/js/jquery-1.10.2.js"></script>
    <script src="<%=path %>/js/bootstrap.js"></script>

    <script src="<%=path %>/js/flatpoint_core.js"></script>

  </body>
  
 
</html>
