<%@ page language="java" contentType="text/html; charset=UTF-8" import="cn.wycfm.core.util.CoreUtil,cn.wycfm.core.model.User"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	User user = CoreUtil.getUser(request);
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>"> 
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<title>账单管理</title>

<link href="/css/bootstrap.css" rel="stylesheet">
<link href="/css/bootstrap-datetimepicker.css" rel="stylesheet">
<link href="/css/bootstrap-theme.css" rel="stylesheet">
<link href="/css/main.css" rel="stylesheet">
<script  type="text/javascript"  src="/js/jquery-3.3.1.js"></script>
<style>
	.color-red{color:#EF1300!important}
	.tip-wrap{display:none;}
	.form-submit{display: flex;justify-content: flex-end;}
</style>	
 <script  type="text/javascript" >
 	var user_id=null;
 	<%if(user!=null){ %>
 		user_id=<%=user.getUserId()%>;
 	<%}%>
 </script>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
      <a class="navbar-brand" href="/bill">账单管理</a>
      
     <!-- <ul class="navbar-nav" style="width:100%;">
        <li class="nav-item"><a class="nav-link"></a></li>
      </ul> -->
      <%if(user!=null){ %>
      	<a class="navbar-brand pull-right" href="javascript:void(0);"><%=user.getUserName()%></a>
       <%}else{ %>
      		<a class="navbar-brand pull-right" href="javascript:void(0);" data-toggle="modal" data-target="#loginModal" id="doLogin">登陆</a>
  		<%}%>
  </nav>
<div class="main">
    <div class="container">
		<form id="billSubmit" action="" method="post" class="form-inline">
			<table class="table table-light">
		     
					<tr>
					  <th scope="row">时间：</th>
					  <td>
						  <input type="text" id="billDate" class="form-control" autocomplete="off" name="billDate" readonly>
						  <p class="tip-wrap errorHint color-red" data-error-hint="必填">必填</p>
					  </td>
					  <td></td>
					  <td></td>
					</tr>
					<tr>
					  <th scope="row">账单描述：</th>
					  <td>
					  <input type="text" name="description" class="form-control" autocomplete="off" maxlength="200">
					  <p class="tip-wrap errorHint color-red" data-error-hint="必填">必填</p>
					  </td>
					  <td></td>
					  <td></td>
					</tr>
					<tr>
					  <th scope="row">金额：</th>
					  <td>
					  <input type="number" name="amount" class="form-control" autocomplete="off" maxlength="200">
					  <p class="tip-wrap errorHint color-red" data-error-hint="必填">必填</p>
					  </td>
					  <td></td>
					  <td></td>
					</tr>
					 
					<tr>
					  <th scope="row"></th>
					  <td><input type="submit" value="submit" class="btn btn-info" ></td>
					  <td></td>
					  <td></td>
					</tr>
					
			</table>
		</form>
		<div class="row m-auto">
			<div id="no_login_alert" style="display:none;"
				class="col-sm-12 alert alert-danger alert-dismissible fade show">
				<button type="button" class="close" data-dismiss="alert">&times;</button>
				<strong>请登录！</strong>
			</div>
		</div>
		<div class="row m-auto">
			<div class="col-sm-3">
				<div class="row">
					<span>时间：</span>
					<div class="input-append date" id="startDate" data-date="" data-date-format="yyyy-mm-dd">
					    <input class="span2" size="16" type="text" readonly >
					    <span class="add-on"><i class="icon-remove"></i></span>
					    <span class="add-on"><i class="icon-th"></i></span>
					</div>  
				</div>  
			</div>
			<div class="col-sm-3">
				<div class="row">
					<span>时间：</span>
					<div class="input-append date" id="endDate" data-date="" data-date-format="yyyy-mm-dd">
					    <input class="span2" size="16" type="text" readonly >
					    <span class="add-on"><i class="icon-remove"></i></span>
					    <span class="add-on"><i class="icon-th"></i></span>
					</div>  
				</div>  
			</div>
			<div class="col-sm-3">
				<div class="row ">
				      <select class="form-control" id="userSelect">
				        <option value="-1">全部</option>
				        <option value="5">wu</option>
				        <option value="10">gao</option>
				        <option value="11">gu</option>
				      </select>
				</div>
			</div>
			
			<div class="col-sm-3">
				<div class="row text-center">
					<div class="col-md-6 col-md-offset-3">
					</div>
					<div class="col-md-6">
					<button type="button" id="loadData" class="btn btn-primary">加载数据</button>
					</div>
				</div>
			</div>
			<!-- <div id="yearmonthSelect"></div> -->
		</div>
		<div class="row " style="height:20px;">
			
		</div>
		<div class="table-responsive">
			<table id="dataTable" class="table table-dark table-striped">
			    <thead>
			      <tr>
			        <th>昵称</th>
			        <th>时间</th>
			        <th>账单描述</th>
			        <th>金额</th>
			      </tr>
			    </thead>
			    <!-- <tbody>
			      <tr>
			        <td>John</td>
			        <td>Doe</td>
			        <td>john@example.com</td>
			        <td>John</td>
			      </tr>
			      <tr>
			        <td>John</td>
			        <td>Doe</td>
			        <td>john@example.com</td>
			        <td>John</td>
			      </tr>
			      <tr>
			        <td>John</td>
			        <td>Doe</td>
			        <td>john@example.com</td>
			        <td>John</td>
			      </tr>
			    </tbody> -->
			</table>
		</div>
		<div class="row">
			<div class="col-sm-1">
				<button type="button" id="count-button" class="btn btn-primary">计算</button>
			</div>
			<div class="col-sm-5 m-auto" id="count-show">
				
			</div>
			<div class="col-sm-3">
				
			</div>
			<div class="col-sm-3">
				
			</div>
		</div>
	</div>
</div>


<div class="modal fade" id="loginModal">
  <div class="modal-dialog">
    <div class="modal-content">
 
      <!-- 模态框头部 -->
      <div class="modal-header">
        <h4 class="modal-title">登录</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>
 
      <!-- 模态框主体 -->
      <div class="modal-body">
         <form id="loginForm" action="/login" method="post">
		    <div class="form-group">
		      <label for="usr">用户名:</label>
		      <input type="text" class="form-control" maxlength="36" name="username" id="username" autocomplete="off" placeholder="用户名/手机号">
		      <p class="tip-wrap errorHint color-red" data-error-hint="请输入正确的邮箱或手机号">请输入正确的邮箱或手机号</p>
		    </div>
		    <div class="form-group">
		      <label for="pwd">密码:</label>
		      <input type="password" class="form-control" name="password" id="pwd" data-validate="require-password" maxlength="16" autocomplete="off" placeholder="6-16位密码，区分大小写，不能用空格">
		      <p class="tip-wrap errorHint color-red " data-error-hint="请输入6-16位密码，区分大小写，不能使用空格！">请输入6-16位密码，区分大小写，不能使用空格！</p>
		    </div>
		    <div class="form-check">
		      <label class="form-check-label">
		        <input class="form-check-input" type="checkbox">记住密码
		      </label>
		    </div>
		    <div class="form-submit m-auto">
		    <input type="hidden" name="backUrl" value="/bill">
		      <button type="button" id="loginSubmit" class="btn btn-primary">登录</button>
		    </div>
		    
		</form>
      </div>
 
      <!-- 模态框底部 -->
      <div class="modal-footer">
      	
      </div>
 
    </div>
  </div>
</div>

<button style="display:none" id="show-delete-dialog-button" type="button" class="btn btn-primary" data-toggle="modal" data-target="#deleteDialog"></button>
<div class="modal fade" id="deleteDialog">
  <div class="modal-dialog">
    <div class="modal-content">
 
      <!-- 模态框头部 -->
      <div class="modal-header">
        <h4 class="modal-title">删除</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>
 
      <!-- 模态框主体 -->
      <div class="modal-body">
     	确定删除吗？
      </div>
 
      <!-- 模态框底部 -->
      <div class="modal-footer">
      	<button type="button" class="btn btn-secondary" id="delete-sure" data-dismiss="modal">确定</button>
        <button type="button" class="btn btn-secondary" id="delete-colse" data-dismiss="modal">关闭</button>
      </div>
 
    </div>
  </div>
</div>

	
	<div id="success_alert"  style="display:none;"
		class="alert alert-success alert-dismissible fade show">
		<button type="button" class="close" data-dismiss="alert">&times;</button>
		<strong>成功!</strong>
	</div>
</body>


    <!-- Include all compiled plugins (below), or include individual files as needed -->
 <script src="/js/bootstrap.js"></script>
 <script src="/js/bootstrap-datetimepicker.js"></script>
 <script src="/js/bootstrap-datetimepicker.zh-CN.js"></script>
 <script src="/js/bill/bill.js"></script>
</html>