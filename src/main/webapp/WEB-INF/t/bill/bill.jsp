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
</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
      <a class="navbar-brand" href="index.html">账单管理</a>
     <!--  <ul class="navbar-nav">
        <li class="nav-item"><a class="nav-link" href="#">首页</a></li>
        <li class="nav-item"><a class="nav-link" href="technology.html">技术</a></li>
        <li class="nav-item"><a class="nav-link" href="#life">生活</a></li>
        <li class="nav-item"><a class="nav-link" href="#about">About</a></li>
        <li class="nav-item active"><a class="nav-link" href="#contact">Contact</a></li>
      </ul> -->
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
			        <th>用户名</th>
			        <th>手机</th>
			        <th>昵称</th>
			        <th>时间</th>
			        <th>账单描述</th>
			        <th>金额</th>
			        <th>添加时间</th>
			        <th>更新时间</th>
			      </tr>
			    </thead>
			    <tbody>
			      <tr>
			        <td>John</td>
			        <td>Doe</td>
			        <td>john@example.com</td>
			        <td>John</td>
			        <td>Doe</td>
			        <td>john@example.com</td>
			        <td>John</td>
			        <td>Doe</td>
			      </tr>
			      <tr>
			        <td>John</td>
			        <td>Doe</td>
			        <td>john@example.com</td>
			        <td>John</td>
			        <td>Doe</td>
			        <td>john@example.com</td>
			        <td>John</td>
			        <td>Doe</td>
			      </tr>
			      <tr>
			        <td>John</td>
			        <td>Doe</td>
			        <td>john@example.com</td>
			        <td>John</td>
			        <td>Doe</td>
			        <td>john@example.com</td>
			        <td>John</td>
			        <td>Doe</td>
			      </tr>
			    </tbody>
			</table>
		</div>
	</div>
</div>
</body>
<script type="text/javascript">
$(function(){
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
});
</script>


    <!-- Include all compiled plugins (below), or include individual files as needed -->
 <script src="/js/bootstrap.js"></script>
 <script src="/js/bootstrap-datetimepicker.js"></script>
 <script src="/js/bootstrap-datetimepicker.zh-CN.js"></script>
</html>