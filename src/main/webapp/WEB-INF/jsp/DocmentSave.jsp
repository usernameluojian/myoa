<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="${pageContext.request.contextPath}/static/ckeditor/ckeditor.js"></script>
<div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
          <div class="layui-tab-content">
            <div class="layui-tab-item layui-show" style="padding-top: 20px;">
               <form class="form-horizontal"  action="Docmentadd" enctype="multipart/form-data" method="post">
				  <div class="control-group">
				    <label class="control-label" for="inputEmail">文件描述：</label>
				    <div class="controls">
				      <input type="hidden" value="1" name="userid">
				      <input type="hidden" value="${ParentId==null?3:ParentId }" name="ParentId">
				      <textarea name="editor1" id="editor1" rows="10" cols="80">
                			
            		  </textarea>
            		  <script type="text/javascript">CKEDITOR.replace('editor1')</script>
				    </div>
				  </div>
				  <div class="control-group">
				    <div class="controls">
				      <input type="file" id="inputPassword" name="file" placeholder="">
				    </div>
				  </div>
				  <div class="control-group">
				    <div class="controls">
				      <button type="submit" class="btn">提交</button>
				    </div>
				  </div>
				</form>
            </div>
          </div>
       </div>
</div>
   
    