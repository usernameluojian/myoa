<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
    <div class="layui-tab-content">
        <div class="layui-tab-item layui-show">
    		<div class="bs-docs-example">
    		<div style="width: 100%;height: 20px;">
    			<span style="color: red;">（共${Listcount }封），第${page}页</span>
    		</div>
    			<div style="width: 100%;height: 20px;padding: 40px;">
	            <table class="table">
	              <thead>
	                <tr>
	                  <td>标题</td>
	                  <td>发送人</td>
	                  <td>时间</td>
	                  <td>操作</td>
	                </tr>
	              </thead>
	              <tbody>
	              <c:forEach var="m" items="${ListMessage }">
	              	<tr>
	                  <td>${m.title }</td>
	                  <td>${m.employee.name }</td>
	                  <td>${m.sendtime }</td>
	                  <td>
	                  	<a class="btn btn-success" href="messagedraftsfasong?id=${m.id }">发送</a>
	                  	<a class="btn" href="messagesendingboxdelete?id=${m.id }"><i class="icon-remove"></i></a>&nbsp;
	                  	<c:if test="${m.mstch.id!=null }">
	                  		<a class="btn" href="MessageloadFile?id=${m.id }"><i class="icon-download-alt"></i></a>&nbsp;
	                  	</c:if>
	                  </td>
	                </tr>
	              </c:forEach>
	              </tbody>
	            </table>
	            <div style="width: 100%;text-align: center;">
    				<div class="pagination">
					  <ul>
						<c:if test="${page!=1 }">
					    	<li><a href="messagedrafts?page=${page-1}">上一页</a></li>
					    </c:if>
					    <c:forEach var="i" begin="1" end="${pagecount }">
						    <li><a href="messagedrafts?page=${i }">${i }</a></li>
					    </c:forEach>
					    <c:if test="${page+1<=pagecount}">
					    	<li><a href="messagedrafts?page=${page+1}">下一页</a></li>
					    </c:if>
					  </ul>
					</div>
    			</div>
    			</div>
          </div>
        </div>
    </div>
</div>