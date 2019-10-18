$(function(){
	
	
	//-------bill table submit----
	var isSubmit = false;
	$("#crawlerSubmit").submit(function(datas) { 
		if(isSubmit){
			return false;
		}
		isSubmit = true;
		/*if(!user_id){
			$("#no_login_alert").show();
			return false;
		}*/
		var crawlerUrl = $("textarea[name=crawlerUrl]");
		var targetSelectStr = $("input[name=targetSelectStr]");
		
		var crawlerUrlV = crawlerUrl.val();
		var targetSelectStrV = targetSelectStr.val();
		
		var d = {
				crawlerUrl:crawlerUrlV,
				targetSelectStr:targetSelectStrV
		}
		
		$.ajax({
			type:"post",
			url:"/crawler/demo.do",
			data:d,
			dataType:"json",
			cache: false
		}).done(function(data){
			console.log(data);
			isSubmit = false;
			if(data.code=="200"){
				initShowTable(data.result);
			}else if(datas && datas.code=="400"){
				
			}else{
				
			}
			
		});
		return false;
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
			}
			else{
				alert("用户名不存在/密码错误");
			}
			
		});
	});
	
	
	function initShowTable(datas){
		
		if(datas && datas.length > 0){
			var htmlArr = ['<thead>',
			      '<tr>',
			        '<th>标题</th>',
			        '<th>链接</th>',
			      '</tr>',
			    '</thead>'];
			for(var i=0; i < datas.length; i++){
				var data = datas[i];
				var trHtml = ['<tr>'];
				trHtml.push('<td>',data.aText,'</td>');
				trHtml.push('<td>',data.href,'</td>');
				trHtml.push('</tr>');
				htmlArr.push(trHtml.join(''));
			}
			$("#dataTable").html(htmlArr.join(''));
		}else{
			$("#dataTable").html('无数据');
		}
		
	}
	

	
	
	$("#count-button").on("click",function(){
		if(user_id>0){
			countBillDatas(getQueryParams());	
		}
		
	});
	
	function countBillDatas(d){
		
		var d = {
			startDate:d.startDate,
			endDate:d.endDate,
			userIds:d.userIds
			
		};
		$.ajax({
			type:"get",
			url:"/sumBill",
			data:d,
			cache:false,
			dataType:"json"
		}).done(function(datas){
			if(datas && datas.code=="200"){
				initCountResult(datas.result);
			}else if(datas && datas.code=="400"){
				alert(datas.status);
				if(datas.status=="noLogin"){
					window.location.reload();
				}
			}else{
				alert("error~~");
			}
		}).fail(function(errors){
			alert(errors);
		});
	}
	function initCountResult(datas){
		if(datas && datas.length > 0){
			var htmlArr = [];
			var allTotal = 0;
			for(var i=0; i < datas.length; i++){
				var data = datas[i];
				allTotal = parseFloat(allTotal)+parseFloat(data.total);
				htmlArr.push(data.nickName+":<span class='sum-every-one'>"+Number(data.total)+"</span><br/>");
			}
			var avg = parseFloat(allTotal/datas.length);
			$("#count-show").html("总金额："+allTotal+"<br/>"+htmlArr.join('')+"<br/>平均："+Math.round(avg));
			$("#count-show").find(".sum-every-one").each(function(){
				var _this = $(this);
				var c = parseFloat(_this.text())-avg;
				_this.after("&nbsp;&nbsp;"+Math.round(c));
			});
			
		}else{
			$("#count-show").html('无数据');
		}
	}
	
});
