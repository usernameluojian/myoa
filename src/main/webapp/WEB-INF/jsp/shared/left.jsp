<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="left-nav">
      <div id="side-nav">
        <ul id="nav">
        		<li>
	                <a href="index?id=${user.id }">
	                    <i class="iconfont"></i>
	                    <cite>首页</cite>
	                    <i class="iconfont nav_right"></i>
	                </a>
	            </li>
        <c:forEach var="fnull" items="${function }">
	            <li>
	                <a href="javascript:;">
	                    <i class="iconfont"></i>
	                    <cite>${fnull.name }</cite>
	                    <i class="iconfont nav_right"></i>
	                </a>
	                 
	                <ul class="sub-menu">
	                		<c:forEach var="frid" items="${functionRoleId }">
	                			<c:if test="${fnull.id == frid.parentId}">
				                    <li>
						                <a href="javascript:;">
						                    <i class="iconfont"></i>
						                    <cite>${fnull.name }</cite>
						                    <i class="iconfont nav_right"></i>
						                </a>
						               </li>
			                    </c:if>
			                </c:forEach>
	                </ul>
	            </li>
		</c:forEach>
        </ul>
      </div>
    </div>