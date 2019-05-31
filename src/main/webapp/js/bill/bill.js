$(function(){
	//时间选择器初始化
	$('#billDate').datetimepicker({
		format: 'yyyy-mm-dd',
		startView:2, 
		minView:2,
		autoclose:true,
		language: 'zh-CN' 
		
	});
	
	
	//-------bill table submit----
	$("#billSubmit").submit(function(datas) { 
		if(!user_id){return false;}
		var _billDate = $("input[name=billDate]");
		var _desc = $("input[name=description]");
		var _amount = $("input[name=amount]");
		var billDateV = _billDate.val();
		var descV = _desc.val();
		var amountV = _amount.val();
		if(!billDateV || !descV || !amountV){
			_billDate.parent().parent().find(".tip-wrap").show();
			_desc.parent().parent().find(".tip-wrap").show();
			_amount.parent().parent().find(".tip-wrap").show();
			return false;
		}
		var d = {
				billDate:billDateV,
				description:descV,
				amount:amountV
		}
		$.ajax({
			type:"post",
			url:"/addBill",
			data:d,
			dataType:"json",
			cache: false
		}).done(function(data){
			console.log(data);
			if(data.code=="200"){
				alert("添加成功");
				window.location.reload();
			}else{
				alert("提交错误");
			}
			
		});
		return false;
	});
	/*$("#billSubmit").on("click", function(){
		var _billDate = $("input[name=billDate]");
		var _desc = $("input[name=description]");
		var _amount = $("input[name=amount]");
		var billDateV = _billDate.val();
		var descV = _desc.val();
		var amountV = _amount.val();
		if(!billDateV || !descV || !amountV){
			_billDate.parent().find(".tip-wrap").show();
			_desc.parent().find(".tip-wrap").show();
			_amount.parent().find(".tip-wrap").show();
			return ;
		}
		var d = {
				billDate:billDateV,
				description:descV,
				amount:amountV
		}
		$.ajax({
			type:"post",
			url:"/addBill",
			data:d,
			dataType:"json",
			cache: false
		}).done(function(data){
			console.log(data);
			if(data.code=="200"){
				alert("添加成功");
				window.location.reload();
			}else{
				alert("提交错误");
			}
			
		});
	});*/
	
	
	
	
	
	$("#yearmonthSelect").datetimepicker({
		format:"yyyy-mm",
		startView:3, 
		minView:3,
		autoclose:true,
		language:"zh-CN"
		
	});
	
	
	//---登陆------
	$("#loginSubmit").on("click", function(){
		var _username = $("input[name=username]");
		var _password = $("input[name=password]");
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
		var d = {
				username:username,
				password:password
		}
		$.ajax({
			type:"post",
			url:"/login",
			data:d,
			dataType:"json",
			cache: false
		}).done(function(data){
			console.log(data);
			if(data.code=="200"){
				window.location.reload();
			}else{
				alert("用户名不存在/密码错误");
			}
			
		});
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
	
	
	
	
	
	
	/*
	$.ajax({
		type:"get",
		url:"",
		data:{},
		cache:false,
		dataType:"json"
	}).done(function(datas){
		
		
	}).error(function(errors){
		alert(errors);
	});
	*/
	
	
});