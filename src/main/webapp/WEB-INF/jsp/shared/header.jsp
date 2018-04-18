<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container">
        <div class="logo"><a href="./index.html">OA办公系统</a></div>
        <div class="left_open">
            <i title="展开左侧栏" class="iconfont"></i>
        </div>
        <ul class="layui-nav left fast-add" lay-filter="">
          <li class="layui-nav-item">
            <a href="javascript:;">添加<span class="layui-nav-more"></span></a>
            <dl class="layui-nav-child"> <!-- 二级菜单 -->
               <dd><a onclick="x_admin_show('用户','http://www.baidu.com')"><i class="iconfont"></i>用户</a></dd>
            </dl>
          </li>
        <span class="layui-nav-bar"></span></ul>
        <div class="username">
            <ul class="layui-nav right" lay-filter="">
              <li class="layui-nav-item">
                <a href="javascript:;">admin<span class="layui-nav-more"></span></a>
                <dl class="layui-nav-child layui-anim layui-anim-upbit"> <!-- 二级菜单 -->
                  <dd><a onclick="x_admin_show('个人信息','http://www.baidu.com')">个人信息</a></dd>
                  <dd><a onclick="x_admin_show('切换帐号','http://www.baidu.com')">切换帐号</a></dd>
                  <dd><a href="./login.html">退出</a></dd>
                </dl>
              </li>
            <span class="layui-nav-bar" style="left: 20px; top: 39px; width: 0px; opacity: 0;"></span></ul>
       </div>
        
    </div>