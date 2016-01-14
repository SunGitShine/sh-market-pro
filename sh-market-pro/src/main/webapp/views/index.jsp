<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
    <title>二手商城管理后台</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
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

    

    <script type="text/javascript">
    
    function getclassname(obj){
		if(document.getElementsByClassName('link_onclick').length==0){
			obj.className='link_onclick';
			obj.id='link_onclick';
			}else{
				var obj1=document.getElementById('link_onclick');
				obj1.className='111';
				obj1.id='1';
				obj.className='link_onclick';
			   obj.id='link_onclick';
			}

		
		}
    
    function subData(){
    	var appid=document.getElementById('appid').value;
    	if(appid!=null){
    		var div=document.getElementById('turn')
    		div.setAttribute("href","/find.htm?appId="+appid+"&type=image");
    		//$("turn").attr("herf","image.html?"+appid);
    	}
    }
    
    function send(){
    	var openId=document.getElementById('openId').value;
    	if(openId!=null){
    		var div=document.getElementById('send')
    		div.setAttribute("href","/sendMessage.htm?openId="+openId);
    		//$("turn").attr("herf","image.html?"+appid);
    	}
    }
    </script>
  </head>

  <body>

    <header class="dark_grey">
     <!-- Header start -->
       <div class="top">
    <div class="logo">
    <!-- <input type="text" name="appid" id="appid">
    <a href="" id="turn" target="right" onClick="subData()"><input type="button" value="æ¥è¯¢"></a>&nbsp&nbsp&nbsp&nbsp&nbsp
    <input type="text" name="openId" id="openId" value="openId" onclick="if(value==defaultValue){value='';this.style.color='#000'}" onBlur="if(!value){value=defaultValue;this.style.color='#999'}" style="color:#999">
    <a href="" id="send" target="right" onClick="send()"><input type="button" value="åé"></a> -->
    </div>
     <div class="login">
    <img src="<%=path %>/image/login.png"  />
    </div>
    <div class="username">
       Hi 
    </div>
    <div class="user">
    <img src="<%=path %>/image/user.png" />
    </div>
   

</div>
       
    </header>

    <div id="main_navigation" class="dark_navigation"> <!-- Main navigation start -->
        <div class="inner_navigation" >
            <ul class="main" >
                <li><a href="<%=path%>/user/findAll.htm?pageNo=1" target="right" onClick="getclassname(this)"><i class="icon-reorder"></i>&nbsp;&nbsp;用户管理</a></li>
                <!-- <li><a href="/find.htm?type=voice" target="right" onClick="getclassname(this)"><i class="icon-reorder"></i>&nbsp;&nbsp;商品管理</a></li> -->
                <li ><a class="expand"  href="dashboard.html"><i class="icon-home"></i>&nbsp;&nbsp;商品管理</a>
                    <ul class="sub_main" style="background-color: #20477C;">
                          <div style=" height:8px; width:100%;"></div>
                          <li><a href="<%=path%>/goods/findAll.htm?classify=1" target="right" onClick="getclassname(this)">学习&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font style="float:right;font-size:20px;">></font></a></li>
                          <li><a href="<%=path%>/goods/findAll.htm?classify=2" target="right" onClick="getclassname(this)">生活&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font style="float:right;font-size:20px;">></font></a></li>
                          <li><a href="<%=path%>/goods/findAll.htm?classify=3" target="right" onClick="getclassname(this)">其他&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font style="float:right;font-size:20px;">></font></a></li>
                           <div style=" height:8px; width:100%;"></div>
                    </ul>
                </li>
            </ul>
        </div>
    </div>

    <div id="content" class="no-sidebar">
     <!-- Content start -->
 
            <iframe  class="inner_navigation1" name="right" src="<%=path%>/user/findAll.htm?pageNo=1" frameborder="0" width="100%" scrolling="auto" height="100%"></iframe>

               <!-- Content END --> 
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

    <script src="<%=path %>/js/flatpoint_core.js"></script>

    <script>
        jQuery('#vmap').vectorMap({
            map:"world_en",
            backgroundColor:null,
            color:"#ffffff",
            hoverOpacity:.7,
            selectedColor:"#2d91ef",
            enableZoom:0,
            showTooltip:1,
            values:sample_data,
            scaleColors:["#8cc3f6","#5c86ac"],
            normalizeFunction:"polynomial",
            onRegionClick:function(){alert("This Region has "+(Math.floor(Math.random()*10)+1)+" users!"
            )}
        });

        jQuery(document).ready(function($) {
            $('.footable').footable();
            $('.responsive_table_container').mCustomScrollbar({
                set_height: 400,
                advanced:{
                  updateOnContentResize: true,
                  updateOnBrowserResize: true
                }
            });

            $('.responsive_table_container_2').mCustomScrollbar({
                set_height: 520,
                advanced:{
                  updateOnContentResize: true,
                  updateOnBrowserResize: true
                }
            });
        });
    </script>

    <script src="<%=path %>/js/calendar.js"></script>
    <script src="<%=path %>/js/forms.js"></script>
    <script src="<%=path %>/js/dashboard.js"></script>
    
  </body>
</html>
