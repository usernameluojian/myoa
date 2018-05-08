<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/kartik-v-bootstrap-fileinput-61c9523/css/fileinput.min.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/static/kartik-v-bootstrap-fileinput-61c9523/js/fileinput.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/kartik-v-bootstrap-fileinput-61c9523/js/locales/zh-TW.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/vendor/ztree/css/zTreeStyle.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/static/vendor/jquery/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/vendor/ztree/js/jquery.ztree.core.js"></script>
<script>
	$(function() {
		var zTree = null
		var setting = {
				callback: {
					onClick: function(event, treeId, treeNode, clickFlag){
						var folder = treeNode;
						if (typeof(folder.nr) != "undefined") { 
							var bool = true;
							for (var i = 0; i < $("#checkboxspan span").length; i++) {
								if($("#checkboxspan span").eq(i).text()==folder.name){
									$("#checkboxspan span").eq(i).remove();
									bool = false;
								}
							}
							if(bool){
								$("#checkboxspan").html($("#checkboxspan").html()+"<span><input style='display: none;' type='checkbox' checked='checked' name='EmployeeId' value="+folder.id+"><input type='checkbox' checked='checked' name='Employeename'  value="+folder.name+">"+folder.name+"</span>");
							}
						}
					
					}
				}
		};
		$.ajax({
			url:"${pageContext.request.contextPath}/Departmentztree",
			type:"get",
			dataType:"json",
			success:function(json){
				console.log(json);
				$.fn.zTree.init($("#treeDemo"), setting, json);
				zTree = $.fn.zTree.getZTreeObj("treeDemo");
				zTree.expandAll(true);
			}
		});
	   $("#fasong").click(function () {
			$("input[name='IsSent']").val(1);
			$("#from").submit();
		})
		 $("#cungao").click(function () {
			$("input[name='IsSent']").val(0);
			$("#from").submit();
		})
	 });
</script>
<div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
    <div class="layui-tab-content">
       <div class="layui-tab-item layui-show">
           <form class="form-search" id="from"  action="messageadd" enctype="multipart/form-data" method="post">
           					<input name="CreatorId" value="${user.id }" type="hidden" class="input-medium search-query">
           				 	<input name="IsSent" value="1" type="hidden" class="input-medium search-query">
           			<div style="border: 1px solid #000;width: 100%;padding: 20px;float: left;position: absolute;">
           				 <table style="position: relative;">
           				 
			                <tr style="margin: 10px;">
			                  <td>收件人：</td>
			                  <td id="checkboxspan">
			                  	<c:if test="${ReplyEmployee!=null }">
			                  		<span><input style='display: none;' type='checkbox' checked='checked' name='EmployeeId' value="${ReplyEmployee.id }"><input type='checkbox' checked='checked' name='Employeename'  value="${ReplyEmployee.name }">${ReplyEmployee.name }</span>
			                  	</c:if>
			                  	</td>
			                </tr>
			                <tr>
			                	<td style="height: 10px;"></td>
			                	<td></td>
			                </tr>
			                <tr>
			                  <td>标题：</td>
			                  <td><input name="Title" type="text" class="input-medium search-query"></td>
			                </tr>
			                <tr>
			                	<td style="height: 10px;"></td>
			                	<td></td>
			                </tr>
			                <tr>
			                  <td>内容：</td>
			                  <td><textarea name="Content" rows="3"></textarea></td>
			                </tr>
			                <tr>
			                	<td style="height: 10px;"></td>
			                	<td></td>
			                </tr>
			                <tr>
			                  <td>附件：</td>
			                  <td style="width: 90%;">
				                  <input name="fileurl" type="file" id="input-1" class="file"/>
					    	  </td>
			                </tr>
			                 <tr>
			                	<td style="height: 10px;"></td>
			                	<td></td>
			                </tr>
			                <tr>
			                  <td>重要程度：</td>
			                  <td style="width: 90%;">
				                 <select name="Level">
					              <option value="1">普通</option>
					              <option value="2">重要</option>
					              <option value="3">紧急</option>
					            </select>
					    	  </td>
			                </tr>
			                <tr>
			                	<td style="height: 10px;"></td>
			                	<td></td>
			                </tr>
			                <tr>
			                  <td></td>
			                  <td style="width: 90%;">
				                 <button type="button" id="fasong" class="btn btn-primary">发送</button>&nbsp;
				                 <button type="button" id="cungao" class="btn btn-danger">存稿</button>
					    	  </td>
			                </tr>
			            </table>
			            <c:if test="${ReplyEmployee==null }">
				            <div style="position: absolute;top: 100px;right: 200px;">
			           			<div>
										<div style="float:right;width:300px;">
											<ul id="treeDemo" class="ztree"></ul>
										</div>
			           			</div>
	           				</div>
           				</c:if>
           			</div>
           			
           </form>
       </div>
    </div>
</div>
