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
    <link href="/css/bootstrap.css" rel="stylesheet">
    <link href="/css/bootstrap-theme.css" rel="stylesheet">
    <link href="/css/main.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>

  <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
      <a class="navbar-brand" href="/">倾听~博客</a>
      <ul class="navbar-nav">
        <li class="nav-item active"><a class="nav-link" href="/">首页</a></li>
        <li class="nav-item"><a class="nav-link" href="#">技术</a></li>
        <li class="nav-item"><a class="nav-link" href="#life">生活</a></li>
        <li class="nav-item"><a class="nav-link" href="#about">About</a></li>
        <li class="nav-item"><a class="nav-link" href="#contact">Contact</a></li>
      </ul>
  </nav>
   <div class="blog-header">
   	<div class="container">
        <h1 class="blog-title">首页</h1>
        <p class="lead blog-description">倾听雨落~</p>
    </div>
  </div>
   <div class="main">
    <div class="container">
    	
      <div class="row">
      <div class="col-8 bolg-main">
      	<div class="content-item">
      		<h3>linux centos7 tomcat8 配置成服务启动</h3>
      		<hr>
      		<p class="content-item-desc">
      			 linux centos7 tomcat8 配置成服务启动.
						<a class="btn" href="/content/1001.html">查看更多 »</a>
					</p>
					<div class="content-item-meta"><a href="#">wuyan</a>&nbsp;发布于&nbsp;2017-10-18 <span>阅读(368)</span> 标签：<span>技术</span></div>
      	</div>
      	<div class="content-item">
      		<h3>postgresql update from</h3>
      		<hr>
      		<p class="content-item-desc">
      			 1，update from 关联表的更新 update table a set name=b.name from table B b where a.id=b.id; update test set info=tmp.info from (values (1,'new1'),(2,'new2')
						<a class="btn" href="/content/1002.html">查看更多 »</a>
					</p>
					<div class="content-item-meta"><a href="#">wuyan</a>&nbsp;发布于&nbsp;2017-10-18 <span>阅读(368)</span> 标签：<span>技术</span></div>
      	</div>
      	<div class="content-item">
      		<h3>Java对Redis基本使用</h3>
      		<hr>
      		<p class="content-item-desc">
      			 java是通过Jedis对redis的基本操作
						<a class="btn" href="/content/1003.html">查看更多 »</a>
					</p>
					<div class="content-item-meta"><a href="#">wuyan</a>&nbsp;发布于&nbsp;2017-10-18 <span>阅读(368)</span> 标签：<span>技术</span></div>
      	</div>
      	<div class="content-item">
      		<h3>maven基本基础知识及命令学习-1</h3>
      		<hr>
      		<p class="content-item-desc">
      			maven基本基础知识及命令学习-1
						<a class="btn" href="/content/1004.html">查看更多 »</a>
					</p>
					<div class="content-item-meta"><a href="#">wuyan</a>&nbsp;发布于&nbsp;2017-10-18 <span>阅读(368)</span> 标签：<span>技术</span></div>
      	</div>
      	<div class="content-item">
      		<h3>Redis基本认识和基础学习-基本命令</h3>
      		<hr>
      		<p class="content-item-desc">
      			redis 初步学习和简单命令的使用 REmote DIctionary Server(Redis) 是一个由Salvatore Sanfilippo写的key-value存储系统。 Redis是一个开源的使用ANSI C语言编写、遵守BSD协议、支持网络、可基于内存亦可持久化的日志型、Key-Value数据库，并提供多种语言的API。 它通常被称为数据结构服务器，因为值（value）可以是 字符串(String), 哈希(Map), 列表(list), 集合(sets) 和 有序集合(sorted sets)等类型。
						<a class="btn" href="/content/1005.html">查看更多 »</a>
					</p>
					<div class="content-item-meta"><a href="#">wuyan</a>&nbsp;发布于&nbsp;2017-10-18 <span>阅读(368)</span> 标签：<span>技术</span></div>
      	</div>
      </div>
      
      <div class="col-4 col-sm-offset-1 blog-sidebar">
      	<div class="sidebar-module-introduce">
      		<h4>个人介绍</h4>
      		<ul class="list-unstyled">
      			<li>无言</li>
      			<li>男</li>
      			<li>毕业于郑州大学</li>
      		</ul>
      	</div>
      	<div class="sidebar-module">
            <h4>常用链接</h4>
            <ol class="list-unstyled">
              <li><a href="#">March 2017</a></li>
              <li><a href="#">February 2017</a></li>
              <li><a href="#">January 2017</a></li>
              <li><a href="#">December 2017</a></li>
              <li><a href="#">November 2017</a></li>
              <li><a href="#">October 2017</a></li>
              <li><a href="#">September 2017</a></li>
              <li><a href="#">August 2017</a></li>
              <li><a href="#">July 2017</a></li>
              <li><a href="#">June 2017</a></li>
              <li><a href="#">May 2017</a></li>
              <li><a href="#">April 2017</a></li>
            </ol>
          </div>
          <div class="sidebar-module">
            <h4>我的标签</h4>
            <ol class="list-unstyled">
              <li><a href="#">March 2017</a></li>
              <li><a href="#">February 2017</a></li>
              <li><a href="#">January 2017</a></li>
              <li><a href="#">December 2017</a></li>
              <li><a href="#">November 2017</a></li>
              
            </ol>
          </div>
           <div class="sidebar-module">
            <h4>阅读排行</h4>
            <ol class="list-unstyled">
              <li><a href="#">March 2017</a></li>
              <li><a href="#">February 2017</a></li>
              <li><a href="#">January 2017</a></li>
              <li><a href="#">December 2017</a></li>
              <li><a href="#">November 2017</a></li>
              
            </ol>
          </div>
          <div class="sidebar-module">
            <h4>最新文章</h4>
            <ol class="list-unstyled">
              <li><a href="#">March 2017</a></li>
              <li><a href="#">February 2017</a></li>
              <li><a href="#">January 2017</a></li>
              <li><a href="#">December 2017</a></li>
              <li><a href="#">November 2017</a></li>
              
            </ol>
          </div>
      </div>
      </div>
      	<div class="row row-centered">
					<ul class="pagination pagination-centered">
						<li class="page-item">
							<a class="page-link" href="#">上一页</a>
						</li>
						<li class="page-item">
							<a class="page-link" href="#">1</a>
						</li>
						<li class="page-item">
							<a class="page-link" href="#">2</a>
						</li>
						<li class="page-item">
							<a class="page-link" href="#">3</a>
						</li>
						<li class="page-item">
							<a class="page-link" href="#">4</a>
						</li>
						<li class="page-item">
							<a class="page-link" href="#">5</a>
						</li>
						<li class="page-item">
							<a class="page-link" href="#">下一页</a>
						</li>
					</ul>
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
    <script src="/js/bootstrap.min.js"></script>
  </body>
</html>