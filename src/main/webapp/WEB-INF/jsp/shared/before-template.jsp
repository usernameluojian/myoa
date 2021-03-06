<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en"><head>
	<meta charset="UTF-8">
	<title>OA办公系统</title>
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi">
    <meta http-equiv="Cache-Control" content="no-siteapp">

    <link rel="shortcut icon" href="${pageContext.request.contextPath }/static/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/font.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/xadmin.css">
    <link href="${pageContext.request.contextPath }/static/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <script src="https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190"></script>
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath }/static/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/static/js/xadmin.js"></script>
    <script src="http://code.jquery.com/jquery.js"></script>
    <script src="${pageContext.request.contextPath }/static/js/bootstrap.min.js"></script>
    <style type="text/css">
        .container{
            width: 100%;
        }
        .footers{
            width: 100%;
            height: 40%;

            position: relative;
            top: 10px;
        }
        .life{
            width: 40%;
            height: 60%;

            position: absolute;
            left: 20px;
            top: 10px;

        }
        .right{
            width: 50%;
            height: 40%;

            position: absolute;
            left: 550px;
            top: 20px;
        }
     .username{
         position: absolute;
         top: -20px;







     }
    </style>
<link id="layuicss-layer" rel="stylesheet" href="http://localhost:63342/S2%E9%A1%B9%E7%9B%AE%E9%9D%99%E6%80%81%E9%A1%B5%E9%9D%A2/OA_coreadmin/lib/layui/css/modules/layer/default/layer.css?v=3.0.3" media="all"></head>
<body>
    <!-- 顶部开始 -->
    <tiles:insertAttribute name="header" /> 
    <!-- 顶部结束 -->
    <!-- 中部开始 -->
     <!-- 左侧菜单开始 -->
     <tiles:insertAttribute name="footer" /> 
    <!-- <div class="x-slide_left"></div> -->
    <!-- 左侧菜单结束 -->
    <!-- 右侧主体开始 -->
    <div class="page-content">
             <tiles:insertAttribute name="main" /> 
    </div>
    <div class="page-content-bg"></div>
    <!-- 右侧主体结束 -->
    <!-- 中部结束 -->
    <!-- 底部开始 -->

    <!-- 底部结束 -->
    <script>
    //百度统计可去掉
    var _hmt = _hmt || [];
    (function() {
      var hm = document.createElement("script");
      hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
      var s = document.getElementsByTagName("script")[0]; 
      s.parentNode.insertBefore(hm, s);
    })();
    </script>
    <script>
    	$(function() {
			
		})
    </script>

</body></html>
<div id="editPanel" class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">邮件信息</h4>
					</div>
					<div class="modal-body">
						 <table style="position: relative;">
				                <tr style="margin: 10px;">
				                  <td>发件人：</td>
				                  <td id="CreatorId"></td>
				                </tr>
				                <tr>
				                	<td style="height: 10px;"></td>
				                	<td></td>
				                </tr>
				                <tr>
				                  <td>标题：</td>
				                  <td><input id="Title"type="text" class="input-medium search-query"></td>
				                </tr>
				                 <tr>
				                	<td style="height: 10px;"></td>
				                	<td></td>
				                </tr>	
				                <tr>
				                  <td>内容：</td>
				                  <td><textarea id="Content" name="Content" rows="3"></textarea></td>
				                </tr>
				                <tr>
				                	<td style="height: 10px;"></td>
				                	<td></td>
				                </tr>
				                <tr>
				                  <td>重要度：</td>
				                  <td style="width: 90%;">
					                 <select name="Level">
						              <option id="LEVEL">普通</option>
						            </select>
						    	  </td>
				                </tr>
				                <tr>
				                  <td></td>
				                  <td style="width: 90%;">
					                 <a id="Reply" class="btn btn-primary" href="#">回复</a>
						    	  </td>
				                </tr>
				            </table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					</div>
				</div>
			</div>
		</div>
		<div id="editPanel1" class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">邮件信息</h4>
					</div>
					<div class="modal-body">
						<form action="Roleupdate">
						 	<table style="position: relative;">
						 		<input name="id" type="hidden" value="" id="id"/>
				                <tr style="margin: 10px;">
				                  <td>发件人：</td>
				                  <td><input name="name" value="" id="name"/></td>
				                </tr>
				                <tr style="margin: 10px;">
				                  <td></td>
				                  <td></td>
				                </tr>
				                <tr style="margin: 10px;">
				                  <td></td>
				                  <td><button class="btn btn-danger" type="submit">保存</button></td>
				                </tr>
				            </table>
				        </form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					</div>
				</div>
			</div>
		</div>
		<div id="editPanel2" class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">权限</h4>
					</div>
					<div class="modal-body">
						<input type="hidden" id="rid"/>
						<c:forEach var="fnull" items="${function }">
						<div>
							
							<div style="padding: 10px;color: red;">${fnull.name }</div>
							<c:forEach var="infunction" items="${IsNotfunction }">
								<c:if test="${infunction.parentId==fnull.id }">
									 <span><input class="functionid" type="checkbox"
									<c:forEach var="frid" items="${functionRoleId }">
				                			<c:if test="${infunction.id == frid.id}">
							                   checked="checked"
						                    </c:if>
					                </c:forEach>
					                 value="${infunction.id }">${infunction.name }</span>
					            </c:if>
			                </c:forEach>
			            </div>
						</c:forEach>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					</div>
				</div>
			</div>
		</div>