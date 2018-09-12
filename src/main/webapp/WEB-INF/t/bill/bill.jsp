<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
      <a class="navbar-brand" href="/bill">账单管理</a>
      
     <!-- <ul class="navbar-nav" style="width:100%;">
        <li class="nav-item"><a class="nav-link"></a></li>
      </ul> -->
      <a class="navbar-brand pull-right" href="javascript:void(0);" data-toggle="modal" data-target="#loginModal" id="doLogin">登陆</a>
  </nav>
<div class="main">
    <div class="container">
		<form id="billSubmit" action="/bill" method="post" class="form-inline">
			<table class="table table-light">
		     
					<tr>
					  <th scope="row">时间：</th>
					  <td>
						  <input type="text" id="billDate" class="form-control" name="billDate">
					  </td>
					  <td></td>
					  <td></td>
					</tr>
					<tr>
					  <th scope="row">账单描述：</th>
					  <td><input type="text" name="description" class="form-control" maxlength="200"></td>
					  <td></td>
					  <td></td>
					</tr>
					<tr>
					  <th scope="row">金额：</th>
					  <td><input type="number" name="amount" class="form-control" maxlength="200"></td>
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
			<div class="col">
				<div class="row">
					<span>时间：</span>
					<div class="input-append date" id="yearmonthSelect"  data-date-format="yyyy-mm">
					    <input class="span2" size="16" type="text" >
					    <span class="add-on"><i class="icon-remove"></i></span>
					    <span class="add-on"><i class="icon-th"></i></span>
					</div>  
				</div>  
			</div>
			<div class="col">
				<div class="row ">
					<span class="m-1">用户：</span>
					<div class="form-check m-1">
					  <label class="form-check-label">
					    <input type="checkbox" class="form-check-input" value="1">吴
					  </label>
					</div>
					<div class="form-check m-1">
					  <label class="form-check-label">
					    <input type="checkbox" class="form-check-input" value="2">高
					  </label>
					</div>
					<div class="form-check m-1">
					  <label class="form-check-label">
					    <input type="checkbox" class="form-check-input" value="3">古
					  </label>
					</div>
				</div>
			</div>
			<!-- <div id="yearmonthSelect"></div> -->
		</div>
		<div class="row " style="height:20px;">
			
		</div>
		<div class=table-responsive">
			<table class="table table-dark table-striped">
			    <thead>
			      <tr>
			        <th>昵称</th>
			        <th>时间</th>
			        <th>账单描述</th>
			        <th>金额</th>
			      </tr>
			    </thead>
			    <tbody>
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
			    </tbody>
			</table>
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
         <form id="loginForm" action="/loginServlet" method="post">
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
</body>
<script type="text/javascript">
$(function(){
	//时间选择器初始化
	$('#billDate').datetimepicker({
		format: 'yyyy-mm-dd',
		startView:2, 
		minView:2,
		autoclose:true,
		language: 'zh-CN' 
		
	});
	
	$("#yearmonthSelect").datetimepicker({
		format:"yyyy-mm",
		startView:3, 
		minView:3,
		autoclose:true,
		language:"zh-CN"
		
	});
	
	$("#loginSubmit").on("click", function(){
		var _username = $("input [name=username]");
		var _password = $("input [name=password]");
		var username = _username.val();
		var password = _password.val();
		
		if(username==null || username=="" || !_username.attr("validate")){
			_username.parent().find(".tip-wrap").show();
			return ;
		}
		if(_password==null || _password=="" || !_password.attr("validate")){
			_password.parent().find(".tip-wrap").show();
			return ;
		}
		$("#loginForm").submit();
	});
	
	$("input[name=username]").on("blur",function(){
		var _this = $(this);
		var v = _this.val();
		var reg = /(^1[3,5,8]\d{9}$)|(^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$)|(^\w+$)/;
		if(!reg.test(v)){
			_this.parent().find(".tip-wrap").show();
			_this.attr("validate","false");
		}else{
			_this.parent().find(".tip-wrap").hide();
			_this.attr("validate","true");
		}
		
	});
	
	$("input[name=password]").on("blur",function(){
		var _this = $(this);
		var v = _this.val();
		var reg = /\s/;
		if(reg.test(v) || v.length < 6){
			_this.parent().find(".tip-wrap").show();
			_this.attr("validate","false");
		}else{
			_this.parent().find(".tip-wrap").hide();
			_this.attr("validate","true");
		}
		
	});
});
</script>


    <!-- Include all compiled plugins (below), or include individual files as needed -->
 <script src="/js/bootstrap.js"></script>
 <script src="/js/bootstrap-datetimepicker.js"></script>
 <script src="/js/bootstrap-datetimepicker.zh-CN.js"></script>
</html>