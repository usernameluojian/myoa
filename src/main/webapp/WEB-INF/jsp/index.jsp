<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
          <ul class="layui-tab-title">
            <li>我的桌面<i class="layui-icon layui-unselect layui-tab-close">ဆ</i></li>
          </ul>
          <div class="layui-tab-content">
            <div class="layui-tab-item layui-show">
                <div class="bs-docs-example">
                    <br>
                    <div class="tabbable">
                        <ul class="nav nav-tabs">
                            <li class="active"><a href="#tab1" data-toggle="tab">收件箱 </a></li>
                            <li><a href="#tab2" data-toggle="tab">未读文件</a></li>
                            <li><a href="#tab3" data-toggle="tab">重要邮件</a></li>
                        </ul>
                        <div class="tab-content">
                            <div class="tab-pane active" id="tab1">
                                <table class="table table-striped">
                                    <thead>
                                    <tr>
                                        <th>标题</th>
                                        <th>发送人</th>
                                        <th>发送时间</th>

                                    </tr></thead>
                                    <tbody>
                                    <tr>
                                        <td>1</td>
                                        <td>Mark</td>
                                        <td>Otto</td>

                                    </tr>
                                    <tr>
                                        <td>2</td>
                                        <td>Jacob</td>
                                        <td>Thornton</td>

                                    </tr>
                                    <tr>
                                        <td>3</td>
                                        <td>Larry</td>
                                        <td>the Bird</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                            <div class="tab-pane" id="tab2">
                               <h1>未读邮件</h1>
                            </div>
                            <div class="tab-pane" id="tab3">
                                <h1>重要邮件</h1>
                            </div>
                        </div>
                    </div>

                    <div class="footers">

                        <div class="life">
                            <div class="tabbable">
                            <ul class="nav nav-tabs">
                                <li class="active"><a href="#tab4" data-toggle="tab">公告 </a></li>
                                <li><a href="#tab5" data-toggle="tab">所属部门公告</a></li>
                            </ul>
                            <div class="tab-content">
                                <div class="tab-pane active" id="tab4">
                                    <table class="table table-striped">
                                        <thead>
                                        <tr>

                                            <th>主题</th>
                                            <th>发布日期</th>

                                        </tr></thead>
                                        <tbody>
                                        <tr>

                                            <td>Mark</td>
                                            <td>Otto</td>

                                        </tr>
                                        <tr>
                                            <td>Jacob</td>
                                            <td>Thornton</td>

                                        </tr>
                                        <tr>
                                            <td>3</td>
                                            <td>Larry</td>

                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                                <div class="tab-pane" id="tab5">
                                    <h1>未读所属部门公告</h1>
                                </div>
                            </div>
                        </div>
                        </div>
                        <div class="right">
                            <div class="tabbable">
                                <ul class="nav nav-tabs">
                                    <li class="active"><a href="#tab6" data-toggle="tab">会议 </a></li>
                                    <li><a href="#tab7" data-toggle="tab">今日日程</a></li>
                                    <li><a href="#tab8" data-toggle="tab">个人日程</a></li>
                                </ul>
                                <div class="tab-content">
                                    <div class="tab-pane active" id="tab6">
                                        <table class="table table-striped">
                                            <thead>
                                            <tr>
                                                <th>标题</th>
                                                <th>开始时间</th>
                                                <th>结束时间</th>

                                            </tr></thead>
                                            <tbody>
                                            <tr>
                                                <th>月末总结会议</th>
                                                <td>2013-02-12&nbsp;09:30</td>
                                                <td>2013-02-12&nbsp;09:30</td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                    <div class="tab-pane" id="tab7">
                                        <h1>未读今日行程</h1>
                                    </div>
                                    <div class="tab-pane" id="tab8">
                                        <h1>未读今日个人行程</h1>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>


                </div>




            </div>
          </div>
        </div>