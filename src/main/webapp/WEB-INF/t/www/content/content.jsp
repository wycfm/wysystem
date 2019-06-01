<%@ page language="java" contentType="text/html; charset=UTF-8" import="cn.wycfm.core.util.CoreUtil,cn.wycfm.core.model.User"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	User user = CoreUtil.getUser(request);
%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <title>倾听~</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/bootstrap-theme.css" rel="stylesheet">
    <link href="css/main.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
   <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
      <a class="navbar-brand" href="index.html">倾听~博客</a>
      <ul class="navbar-nav">
        <li class="nav-item active"><a class="nav-link" href="#">首页</a></li>
        <li class="nav-item"><a class="nav-link" href="#">技术</a></li>
        <li class="nav-item"><a class="nav-link" href="#life">生活</a></li>
        <li class="nav-item"><a class="nav-link" href="#about">About</a></li>
        <li class="nav-item"><a class="nav-link" href="#contact">Contact</a></li>
      </ul>
  </nav>
   <div class="main">
    <div class="container">
    	
      <div class="row">
      <div class="col-sm-12">
      	<div class="content">
      		<h2>java servlet 简介</h2>
      		<hr>
      		<div class="content-text">
      			java servlet 简介 servlet 的生命周期，java servlet 简介 servlet 的生命周期，java servlet 简介 servlet 的生命周期，java servlet 简介 servlet 的生命周期
						java servlet 简介 servlet 的生命周期，java servlet 简介 servlet 的生命周期，java servlet 简介 servlet 的生命周期，java servlet 简介 servlet 的生命周期java servlet 简介 servlet 的生命周期，java servlet 简介 servlet 的生命周期，java servlet 简介 servlet 的生命周期，java servlet 简介 servlet 的生命周期
					</div>
					<div class="content-text-type">分类：<span>技术</span></div>
					<div class="content-text-tags">标签：<span>技术，java</span></div>
					<div class="content-text-meta">发布于&nbsp;2017-10-18 <span>阅读(368)</span></div>
      	</div>
      	</div>
      </div>
      <div class="row">
					<ul class="pager">
						<li  class="previous">
							<a href="#">上一篇</a>
						</li>
						
						<li class="next">
							<a href="#">下一篇</a>
						</li>
					</ul>
			</div>
    </div>
    
    <div class="comment">
    	<div class="container">
    		<div class="comment-title">评论列表</div>
    		<hr>
    		<div class="comment-list">
    			<div class="comment-item">
    				<div class="comment-item-meta">2017-10-18&nbsp;@&nbsp;wuyan</div>
    				<div class="comment-item-text">有时间学习一下，感谢分享经验</div>
    			</div>
    			
    			<div class="comment-item">
    				<div class="comment-item-meta">2017-10-18&nbsp;@&nbsp;wuyan</div>
    				<div class="comment-item-text">有时间学习一下，感谢分享经验</div>
    				
    			</div>
    			<div class="comment-item">
    				<div class="comment-item-meta">2017-10-18&nbsp;@&nbsp;wuyan</div>
    				<div class="comment-item-text">有时间学习一下，感谢分享经验</div>
    			</div>
    		</div>
    	</div>
    </div>
    
  </div> 
  
	<footer class="bolg-footer">
		<p>无烦恼，言生活！！</p>
		<p>©2017&nbsp;Design by Robert&nbsp;<a target="_blank" href="http://www.miitbeian.gov.cn/">豫ICP备17036506号-1</a></p>
	</footer>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>