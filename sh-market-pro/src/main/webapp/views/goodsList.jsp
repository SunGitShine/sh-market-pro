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
    <title></title>
  
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le styles -->
    <link href="<%=path %>/css/bootstrap.css" rel="stylesheet">
    <link href="<%=path %>/css/bootstrap-responsive.css" rel="stylesheet">
    <link href="<%=path %>/css/stylesheet.css" rel="stylesheet">
    <link href="<%=path %>/css/index.css" rel="stylesheet">
    <link href="<%=path %>/icon/font-awesome.css" rel="stylesheet">
    

    <!-- Le fav and touch icons -->
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="<%=path %>/img/apple-touch-icon-144-precomposed.html">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="<%=path %>/img/apple-touch-icon-114-precomposed.html">
      <link rel="apple-touch-icon-precomposed" sizes="72x72" href="<%=path %>/img/apple-touch-icon-72-precomposed.html">
                    <link rel="apple-touch-icon-precomposed" href="<%=path %>/img/apple-touch-icon-57-precomposed.html">
                                  

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="js/html5shiv.js"></script>
    <![endif]-->
  
  </head>

  <body>

    
    <div id="content"> <!-- Content start -->
      <div class="inner_content">
          <div class="widgets_area">
                <div class="row-fluid">
                    <div class="span12">
                         <div  class="daohanglink" style="">
                           <span class="daohang"></span>
                           <span>首页</span><span>></span>
                          
                           <span>商品管理</span>
                          <!--  <a  href="客户管理tab.html" class="label label-warning" style="float:right; margin:8px;">添加</a> -->
                         </div>
                        <div class="well brown">
                            
                           
                            <div class="well-content" style="border:0px;">
                                <table class="table table-striped table-bordered table-hover datatable">
                                    <thead>
                                        <tr>
                                            <th width="10%">图片</th>
                                            <th width="10%">发布人</th>
                                            <th width="15%">标题</th>
                                            <th width="10%">价格</th>
                                            <th width="15%">联系人</th>
                                            <th width="10%">电话</th>
                                            <th width="10%">QQ</th>
                                            <th width="10%">发布时间</th>
                                            <th width="25%">操作</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="goods" items="${goodsList }">
                                        <tr>
                                            <td>${goods.picture }</td>
                                            <td>${goods.memo }</td>
                                            <td>${goods.title }</td>
                                            <td>${goods.price }</td>
                                            <td>${goods.contacts }</td>
                                            <td>${goods.phone }</td>
                                            <td>${goods.QQ }</td>
                                            <td>${goods.publishTime }</td>
                                           <td>
                                            <a class="btn" href="<%=path %>/goods/delete.htm?goodsId=${goods.goodsId}" title="删除"><i class="icon-trash"></i></a>
                                            <a class="btn" href="#" title="查看"><i class="icon-exclamation"></i></a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>

            
            </div>
        </div>
    </div>

    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="<%=path %>/js/jquery-1.10.2.js"></script>
    <script src="<%=path %>/js/jquery-ui-1.10.3.js"></script>
    <script src="<%=path %>/js/bootstrap.js"></script>

    <script src="<%=path %>/js/library/jquery.collapsible.min.js"></script>
    <script src="<%=path %>/js/library/jquery.mCustomScrollbar.min.js"></script>
    <script src="<%=path %>/js/library/jquery.mousewheel.min.js"></script>
    <script src="<%=path %>/js/library/jquery.uniform.min.js"></script>

   
    <script src="<%=path %>/js/library/jquery.sparkline.min.js"></script>
    <script src="<%=path %>/js/library/chosen.jquery.min.js"></script>
    <script src="<%=path %>/js/library/jquery.easytabs.js"></script>
    <script src="<%=path %>/js/library/flot/excanvas.min.js"></script>
    <script src="<%=path %>/js/library/flot/jquery.flot.js"></script>
    <script src="<%=path %>/js/library/flot/jquery.flot.pie.js"></script>
    <script src="<%=path %>/js/library/flot/jquery.flot.selection.js"></script>
    <script src="<%=path %>/js/library/flot/jquery.flot.resize.js"></script>
    <script src="<%=path %>/js/library/flot/jquery.flot.orderBars.js"></script>
    <script src="<%=path %>/js/library/maps/jquery.vmap.js"></script>
    <script src="<%=path %>/js/library/maps/maps/jquery.vmap.world.js"></script>
    <script src="<%=path %>/js/library/maps/data/jquery.vmap.sampledata.js"></script>
    <script src="<%=path %>/js/library/jquery.autosize-min.js"></script>
    <script src="<%=path %>/js/library/charCount.js"></script>
    <script src="<%=path %>/js/library/jquery.minicolors.js"></script>
    <script src="<%=path %>/js/library/jquery.tagsinput.js"></script>
    <script src="<%=path %>/js/library/fullcalendar.min.js"></script>
    <script src="<%=path %>/js/library/footable/footable.js"></script>
    <script src="<%=path %>/js/library/footable/data-generator.js"></script>

    <script src="<%=path %>/js/library/bootstrap-datetimepicker.js"></script>
    <script src="<%=path %>/js/library/bootstrap-timepicker.js"></script>
    <script src="<%=path %>/js/library/bootstrap-datepicker.js"></script>
    <script src="<%=path %>/js/library/bootstrap-fileupload.js"></script>
    <script src="<%=path %>/js/library/jquery.inputmask.bundle.js"></script>

    <script src="<%=path %>/js/library/jquery.dataTables.js"></script>

    <script src="<%=path %>/js/flatpoint_core.js"></script>

    <script src="<%=path %>/js/datatables.js"></script>

  </body>
</html>
