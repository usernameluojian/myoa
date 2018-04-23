<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container">
    <style type="text/css">
    	#yuanxing{
    		width:40px;
			height:40px;
			margin: 30px auto;
			text-align: center;
			font-weight: bold;
			border-radius: 50%;//圆角百分比
    	}
    </style>
        <div class="logo"><a href="./index.html">OA办公系统</a></div>
        <div class="left_open">
            <i title="展开左侧栏" class="iconfont"></i>
        </div>
         
        <span class="layui-nav-bar"></span></ul>
        <div class="username" style="width: 100%;height: 100%;">
            <ul class="layui-nav right" lay-filter="" style="width: 100%;">
              	<li class="layui-nav-item" style="position: absolute;right: 700px;top: 0px;">
                	<span>${user.name }</span>
              	</li>
              	 <li class="layui-nav-item" style="position: absolute;top: -28px;right: 650px;">
           			<img  id="yuanxing"  src="${pageContext.request.contextPath }/static/images/bg.png">
          		</li>
            	<span class="layui-nav-bar" style="left: 20px; top: 39px; width: 0px; opacity: -100;"></span>
            </ul>
       </div>
</div>