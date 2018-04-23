<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
          <div class="layui-tab-content">
            <div class="layui-tab-item layui-show">
                <div class="bs-docs-example">
                    <br>
                   <div class="tabbable"> <!-- Only required for left/right tabs -->
						  <ul class="nav nav-tabs">
						    <li class="active"><a href="#tab1" data-toggle="tab">收件邮箱</a></li>
						    <li><a href="#tab2" data-toggle="tab">未读邮箱</a></li>
						    <li><a href="#tab3" data-toggle="tab">重复邮箱</a></li>
						  </ul>
						  <div class="tab-content">
						    <div class="tab-pane active" id="tab1">
						      <div class="bs-docs-example">
				            <table class="table">
				              <thead>
				                <tr>
				                  <th>标题</th>
				                  <th>发送人</th>
				                  <th>时间</th>
				                </tr>
				              </thead>
				              <tbody>
				              <c:forEach var="f" items="${fr }">
					              <tr>
					                  <td>${f.title }</td>
					                  <td>${f.employee.name }</td>
					                  <td>${f.sendtime }</td>
					               </tr>
				              </c:forEach>
				              </tbody>
				            </table>
          					</div>
						    </div>
						    <div class="tab-pane" id="tab2">
						      <div class="bs-docs-example">
					            <table class="table">
					              <thead>
					                 <tr>
									       <th>标题</th>
									       <th>发送人</th>
									       <th>时间</th>
									 </tr>
					              </thead>
					              <tbody>
						           <c:forEach var="f" items="${fi }">
						              <tr>
						                  <td>${f.title }</td>
						                  <td>${f.employee.name }</td>
						                  <td>${f.sendtime }</td>
						               </tr>
					              </c:forEach>
					              </tbody>
					            </table>
					          </div>
						    </div>
						    <div class="tab-pane" id="tab3">
						      <div class="bs-docs-example">
					            <table class="table">
					              <thead>
					                 <tr>
									       <th>标题</th>
									       <th>发送人</th>
									       <th>时间</th>
									 </tr>
					              </thead>
					              <tbody>
						           <c:forEach var="f" items="${fd }">
						              <tr>
						                  <td>${f.title }</td>
						                  <td>${f.employee.name }</td>
						                  <td>${f.sendtime }</td>
						               </tr>
					              </c:forEach>
					              </tbody>
					            </table>
					          </div>
						    </div>
						  </div>
					</div>
					<div style="position: relative;">
					<div style="width: 50%;position: absolute;right: 0px;top: 0px;">
						 <div class="tabbable"> <!-- Only required for left/right tabs -->
						  <ul class="nav nav-tabs">
						    <li class="active"><a href="#tab4" data-toggle="tab">公告</a></li>
						    <li><a href="#tab5" data-toggle="tab">所属部门公告</a></li>
						  </ul>
						  <div class="tab-content">
						    <div class="tab-pane active" id="tab4">
						      <div class="bs-docs-example">
				            <table class="table">
				              <thead>
				                <tr>
				                  <th>主题</th>
				                  <th>开始时间</th>
				                  <th>结束时间</th>
				                </tr>
				              </thead>
				              <tbody>
				              <c:forEach var="a" items="${AnngetAll }">
					              <tr>
					                  <td>${a.title }</td>
					                  <td>${a.createtime }</td>
					                  <td>${a.lastedittime }</td>
					               </tr>
				              </c:forEach>
				              </tbody>
				            </table>
          					</div>
						    </div>
						    <div class="tab-pane" id="tab5">
						      <div class="bs-docs-example">
					            <table class="table">
					              <thead>
					                 <tr>
									       <th>主题</th>
						                  <th>开始时间</th>
						                  <th>结束时间</th>
									 </tr>
					              </thead>
					              <tbody>
						          <c:forEach var="a" items="${Anngetdid }">
						              <tr>
						                  <td>${a.title }</td>
						                  <td>${a.createtime }</td>
						                  <td>${a.lastedittime }</td>
						               </tr>
					              </c:forEach>
					              </tbody>
					            </table>
					          </div>
						    </div>
						  </div>
					</div>
					
					</div>
					
					<div style="width: 48%;">
						 <div class="tabbable"> <!-- Only required for left/right tabs -->
						  <ul class="nav nav-tabs">
						    <li class="active"><a href="#tab6" data-toggle="tab">会议</a></li>
						    <li><a href="#tab7" data-toggle="tab">今日日程</a></li>
						    <li><a href="#tab8" data-toggle="tab">个人日常</a></li>
						  </ul>
						  <div class="tab-content">
						    
						    <div class="tab-pane" id="tab6">
						      <div class="bs-docs-example">
					            <table class="table">
					              <thead>
					                 <tr>
									       <th>标题</th>
									       <th>发布时间</th>
									 </tr>
					              </thead>
					              <tbody>
						           <c:forEach var="a" items="${ActivitygetAll }">
						              <tr>
						                  <td>${a.title }</td>
						                  <td>${a.createtime }</td>
						               </tr>
					              </c:forEach>
					              </tbody>
					            </table>
					          </div>
						    </div>
						    <div class="tab-pane" id="tab7">
						      <div class="bs-docs-example">
					            <table class="table">
					              <thead>
					                 <tr>
									       <th>标题</th>
									       <th>发布时间</th>
									 </tr>
					              </thead>
					              <tbody>
						           <c:forEach var="a" items="${ActivitygetTime }">
						              <tr>
						                  <td>${a.title }</td>
						                  <td>${a.createtime }</td>
						               </tr>
					              </c:forEach>
					              </tbody>
					            </table>
					          </div>
						    </div>
						    <div class="tab-pane" id="tab8">
						      <div class="bs-docs-example">
					            <table class="table">
					              <thead>
					                 <tr>
									       <th>标题</th>
									       <th>发布时间</th>
									 </tr>
					              </thead>
					              <tbody>
						           <c:forEach var="a" items="${Activitygetcid }">
						              <tr>
						                  <td>${a.title }</td>
						                  <td>${a.createtime }</td>
						               </tr>
					              </c:forEach>
					              </tbody>
					            </table>
					          </div>
						    </div>
						  </div>
					</div>
					</div>
					</div>
                </div>
            </div>
          </div>
        </div>