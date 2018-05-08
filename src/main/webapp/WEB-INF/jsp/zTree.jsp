<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/vendor/ztree/css/zTreeStyle.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/static/vendor/jquery/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/vendor/ztree/js/jquery.ztree.core.js"></script>
<script>
	$(function() {
		$("#selectt").click(function () {
			$.ajax({
				url:"${pageContext.request.contextPath}/selectlikename?",
				data:{folderId:$("#id").val(),name:$("#inputIcon").val()},
				type:"get",
				dataType:"json",
				success:function(json){
					$("#folderContent").empty();
					json.map(function(item, index){
						$("#folderContent").append("<tr><td>"+item.id+"</td><td>"+item.name+"</td><td><a class='btn' href='DownloadFile?id="+item.id+"'><i class='icon-download-alt'></i></a>&nbsp;<a class='btn' href='deleteid?id="+item.id+"'><i class='icon-remove'></i></a>&nbsp;<a class='btn' href='javascript:;' date-file='"+item.fileurl+"'><i class='icon-hand-up'></i></a></td><td>"+item.employee.name+"</td><td>"+item.employee.department.name+"</td></tr>");
					});
				}
			});
		});
		var zTree = null
		var setting = {
			callback: {
				onClick: function(event, treeId, treeNode, clickFlag){
					var folder = treeNode;
					$.ajax({
						url:"${pageContext.request.contextPath}/documents?",
						data:{folderId : folder.id},
						type:"get",
						dataType:"json",
						success:function(json){
							$("#folderContent").empty();
							json.map(function(item, index){
								$("#id").val(folder.id);
								$("#folderContent").append("<tr><td>"+item.id+"</td><td>"+item.name+"</td><td><a class='btn' href='DownloadFile?id="+item.id+"'><i class='icon-download-alt'></i></a>&nbsp;<a class='btn' href='deleteid?id="+item.id+"'><i class='icon-remove'></i></a>&nbsp;<a class='btn' href='javascript:;' date-file='"+item.fileurl+"'><i class='icon-hand-up'></i></a></td><td>"+item.employee.name+"</td><td>"+item.employee.department.name+"</td></tr>");
								
							});
							$("#folderContent tr td a").click(function () {
								if (typeof($(this).attr("date-file")) != "undefined") { 
									$.ajax({
										url:"${pageContext.request.contextPath}/openFile",
										data:{Filed : $(this).attr("date-file")},
										type:"get",
										dataType:"json",
										success:function(json){
											
										}
									});
								}
							});
						}
					});
					if(folder.fileurl==null){
						$("#ParentId").show();
						$("#ParentId").attr("href","DocmentSave?ParentId="+folder.id)
					}else{
						$("#ParentId").hide();
					}
				}
			}
		};
		$.ajax({
			url:"${pageContext.request.contextPath}/folders",
			type:"get",
			dataType:"json",
			success:function(json){
				console.log(json);
				$.fn.zTree.init($("#treeDemo"), setting, json);
				zTree = $.fn.zTree.getZTreeObj("treeDemo");
				zTree.expandAll(true);
			}
		});
		
	 });
</script>

   <div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
          <div class="layui-tab-content">
            <div class="layui-tab-item layui-show">
                <!-- zTREE -->
                <div style="height:100%;">
					<div style="float:left;width:30%;height:100%;">
						<ul id="treeDemo" class="ztree"></ul>
					</div>
					<div style="float:left;width:60%;height:100%;">
						<table class="table table-striped">
							    <thead>
							    <tr>
							        <th></th>
							        <th> 
							        	<div class="input-prepend">
									      <input class="span2" id="inputIcon" nama="name" type="text">
									      <input class="span2" id="id" nama="id" type="hidden">
									      <span class="add-on" id="selectt"><i class="icon-zoom-in"></i></span>
									    </div>
									</th>
							        <th></th>
							        <th></th>
							        <th><a class="btn" style="display: none;" href="DocmentSave?ParentId=" id="ParentId"><i class="icon-circle-arrow-up"></i></a></th>
							    </tr>
							    <tr>
							        <th>编号</th>
							        <th>文件名</th>
							        <th>操作</th>
							        <th>创建者</th>
							        <th>部门</th>
							    </tr>
							    </thead>
							    <tbody id="folderContent">
							    	
							    </tbody>
							</table>
					</div>
				</div>
            </div>
          </div>
       </div>
    </div>