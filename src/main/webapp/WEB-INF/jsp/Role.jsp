<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script>
			$(function () {
				$("td button:eq(0)").click(function(){
						$.ajax({
							url:"${pageContext.request.contextPath}/Roleid",
							data:{id:$(this).attr("date-id")},
							type:"get",
							dataType:"json",
							success:function(json){
								$("#editPanel1 #id").val(json.id);
								$("#editPanel1 #name").val(json.name);
							}
						});
						$("#editPanel1").modal("show");	
				});
				$("td button:eq(1)").click(function(){
					$("#rid").val($(this).attr("date-id"));
					$("#editPanel2").modal("show");			
				});
				$(".functionid").click(function () {
					var rtype = 0;
					if($(this).prop('checked')){
						rtype = 1;
					}
					$.ajax({
						url:"${pageContext.request.contextPath}/Roledeleteoradd",
						data:{functionid:$(this).val(),roleid:$("#rid").val(),type:rtype},
						type:"get",
						dataType:"json",
						success:function(json){}
					});
				})
			})
		</script>
<div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
    <div class="layui-tab-content">
        <div class="layui-tab-item layui-show">
    		<div class="bs-docs-example" style="padding: 40px;">
            <table class="table table-condensed" style="width: 700px;">
              <thead>
                <tr>
                  <th>编号</th>
                  <th>名称</th>
                  <th>操作</th>
                </tr>
              </thead>
              <tbody>
              <c:forEach var="r" items="${listRole }">
	                <tr>
	                  <td>${r.id }</td>
	                  <td>${r.name }</td>
	                  <td>
	                  	<button class="btn btn-danger" date-id="${r.id }" type="button">编辑</button>&nbsp;
	                  	<button class="btn btn-danger" date-id="${r.id }" type="button">编辑权限</button>
	                  </td>
	                </tr>
                </c:forEach>
              </tbody>
            </table>
          </div>,
        </div>
    </div>
</div>