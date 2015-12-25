<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="<%=path %>/scripts/jquery/jquery-1.7.1.js"></script>
<link href="<%=path %>/style/authority/basic_layout.css" rel="stylesheet" type="text/css">
<link href="<%=path %>/style/authority/common_style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=path %>/scripts/authority/commonAll.js"></script>
<script type="text/javascript" src="<%=path %>/scripts/fancybox/jquery.fancybox-1.3.4.js"></script>
<script type="text/javascript" src="<%=path %>/scripts/fancybox/jquery.fancybox-1.3.4.pack.js"></script>
<link rel="stylesheet" type="text/css" href="<%=path %>/style/authority/jquery.fancybox-1.3.4.css" media="screen"></link>
<script type="text/javascript" src="<%=path %>/scripts/artDialog/artDialog.js?skin=default"></script>
<title>用户管理</title>
<script type="text/javascript">
	$(document).ready(function(){
		/** 新增   **/
	    $("#addBtn").fancybox({
	    	'href'  : 'addAnnounce.jsp',
	    	'width' : 733,
	        'height' : 530,
	        'type' : 'iframe',
	        'hideOnOverlayClick' : true,
	        'showCloseButton' : true,
	        'onClosed' : function() { 
	        	window.location.href = 'announceList.jsp';
	        }
	    });
		
		
	    /**编辑   **/
	    $("a.edit").fancybox({
	    	'width' : 733,
	        'height' : 530,
	        'type' : 'iframe',
	        'hideOnOverlayClick' : true,
	        'showCloseButton' : true,
	        'onClosed' : function() { 
	        	window.location.href = 'house_list.html';
	        }
	    });
	});
	/** 用户角色   **/
	var userRole = '';

	/** 模糊查询来电用户  **/
	function search(){
		$("#submitForm").attr("action", "house_list.html?page=" + 1).submit();
	}

	/** 新增   **/
	function add(){
		$("#submitForm").attr("action", "/xngzf/archives/luruFangyuan.action").submit();	
	}
	 
	/** Excel导出  **/
	function exportExcel(){
		if( confirm('您确定要导出吗？') ){
			var fyXqCode = $("#fyXq").val();
			var fyXqName = $('#fyXq option:selected').text();
//	 		alert(fyXqCode);
			if(fyXqCode=="" || fyXqCode==null){
				$("#fyXqName").val("");
			}else{
//	 			alert(fyXqCode);
				$("#fyXqName").val(fyXqName);
			}
			$("#submitForm").attr("action", "/xngzf/archives/exportExcelFangyuan.action").submit();	
		}
	}
	
	/** 删除 **/
	function del(uid){
		// 非空判断
		if(uid == '') return;
		if(confirm("您确定要删除吗？")){
			$("#submitForm").attr("action", "<%=basePath%>common/user_deleteUser?uid=" +uid ).submit();			
		}
	}
	
	/** 批量删除 **/
	function batchDel(){
		if($("input[name='IDCheck']:checked").size()<=0){
			art.dialog({icon:'error', title:'友情提示', drag:false, resize:false, content:'至少选择一条', ok:true,});
			return;
		}
		// 1）取出用户选中的checkbox放入字符串传给后台,form提交
		var allIDCheck = "";
		$("input[name='IDCheck']:checked").each(function(index, domEle){
			bjText = $(domEle).parent("td").parent("tr").last().children("td").last().prev().text();
// 			alert(bjText);
			// 用户选择的checkbox, 过滤掉“已审核”的，记住哦
			//if($.trim(bjText)=="已审核"){
// 				$(domEle).removeAttr("checked");
				//$(domEle).parent("td").parent("tr").css({color:"red"});
				//$("#resultInfo").html("已审核的是不允许您删除的，请联系管理员删除！！！");
// 				return;
			//}else{
				allIDCheck += $(domEle).val() + ",";
			//}
		});
		// 截掉最后一个","
		if(allIDCheck.length>0) {
			allIDCheck = allIDCheck.substring(0, allIDCheck.length-1);
			// 赋给隐藏域
			$("#allIDCheck").val(allIDCheck);
			if(confirm("您确定要批量删除这些记录吗？")){
				// 提交form
				$("#submitForm").attr("action", "<%=basePath%>common/user_batchDeleteUser?data="+allIDCheck).submit();
			}
		}
	}

	/** 普通跳转 **/
	function jumpNormalPage(page){
		$("#submitForm").attr("action", "<%=basePath%>common/user_getUserByGid?page=" + page).submit();
	}
	
	/** 输入页跳转 **/
	function jumpInputPage(totalPage){
		// 如果“跳转页数”不为空
		if($("#jumpNumTxt").val() != ''){
			var pageNum = parseInt($("#jumpNumTxt").val());
			// 如果跳转页数在不合理范围内，则置为1
			if(pageNum<1 | pageNum>totalPage){
				art.dialog({icon:'error', title:'友情提示', drag:false, resize:false, content:'请输入合适的页数，\n自动为您跳到首页', ok:true,});
				pageNum = 1;
			}
			$("#submitForm").attr("action", "house_list.html?page=" + pageNum).submit();
		}else{
			// “跳转页数”为空
			art.dialog({icon:'error', title:'友情提示', drag:false, resize:false, content:'请输入合适的页数，\n自动为您跳到首页', ok:true,});
			$("#submitForm").attr("action", "house_list.html?page=" + 1).submit();
		}
	}
</script>
<style>
	.alt td{ background:black !important;}
</style>
</head>
<body>
	<form id="submitForm" name="submitForm" action="" method="post">
		<!-- <input type="hidden" name="data" value="" id="allIDCheck"/> -->
		<input type="hidden" name="gid" value="" id="gid"/>
		<div id="container">
			<div class="ui_content">
				<div class="ui_text_indent">
					<div id="box_border">
						<div id="box_bottom">
							<input type="button" value="新增" class="ui_input_btn01" id="addBtn" />
							<input type="button" value="删除" class="ui_input_btn01" onclick="batchDel();" /> 
						</div>
					</div>
				</div>
			</div>
			<s:if test="#request.count==0">
			没有数据
			</s:if>
			<s:else>
			<div class="ui_content">
				<div class="ui_tb">
					<table class="table" cellspacing="0" cellpadding="0" width="100%" align="center" border="0">
						<tr>
							<th width="2%"><input type="checkbox" id="all" onclick="selectOrClearAllCheckbox(this);" />
							</th>
							<th width="2%">昵称</th>
							<th width="20%">真实姓名</th>
							<th width="20%">电话</th>
							<th width="20%">操作</th>
						</tr>
							<s:iterator value="#request.userList">
							<tr>
								<td><input type="checkbox" name="IDCheck" value="<s:property value="uid"/>" class="acb" /></td>
								<td><s:property value="nickname"/></td>
								<td><s:property value="realname"/></td>
								<td><s:property value="username"/></td>
								<td>
									<!-- <a href="announceEdit.jsp?fyID=14458619251417" class="edit">编辑</a>  -->
									<a href="javascript:del('<s:property value="uid"/>');">删除</a>
								</td>
							</tr>
						</s:iterator>
					</table>
				</div>
				<div class="ui_tb_h30">
					<div class="ui_flt" style="height: 30px; line-height: 30px;">
						共有
						<span class="ui_txt_bold04"><s:property value="#request.count"/></span>
						条记录，当前第
						<span class="ui_txt_bold04"><s:property value="#request.page"/>
						/
						<s:property value="#request.pageNum"/></span>
						页
					</div>
					<s:if test="#request.pageNum==1"></s:if>
						<s:else>
					<div class="ui_frt">
						<!--    如果是第一页，则只显示下一页、尾页 -->
							<s:if test="#request.page==1"></s:if>
							<s:elseif test="#request.page>1">
							<input type="button" value="首页" class="ui_input_btn01" onclick="jumpNormalPage(1,<s:property value="#request.userList[0].garden.gid"/>);"/>
							<input type="button" value="上一页" class="ui_input_btn01" onclick="jumpNormalPage(<s:property value="#request.page"/>-1,<s:property value="#request.userList[0].garden.gid"/>);"/>
							</s:elseif>
								<s:if test="#request.pageNum==#request.page"></s:if>
								<s:else>
							<input type="button" value="下一页" class="ui_input_btn01"
								onclick="jumpNormalPage(<s:property value="#request.page"/>+1,<s:property value="#request.userList[0].garden.gid"/>);" />
							<input type="button" value="尾页" class="ui_input_btn01"
								onclick="jumpNormalPage(<s:property value="#request.pageNum"/>,<s:property value="#request.userList[0].garden.gid"/>);" />
							</s:else>
						
						
						<!--     如果是最后一页，则只显示首页、上一页 -->
						
						转到第<input type="text" id="jumpNumTxt" class="ui_input_txt01" />页
							 <input type="button" class="ui_input_btn01" value="跳转" onclick="jumpInputPage(9);" />
							 
					</div>
				</div>
				</s:else>
			</div>
			</s:else>
		</div>
	</form>
</body>
</html>

