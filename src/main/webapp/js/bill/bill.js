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
	var isSubmit = false;
	$("#billSubmit").submit(function(datas) { 
		if(isSubmit){
			return false;
		}
		isSubmit = true;
		if(!user_id){
			$("#no_login_alert").show();
			return false;
		}
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
			isSubmit = false;
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
				isSubmit = false;
				alert("添加成功");
				window.location.reload();
			}else if(datas && datas.code=="400"){
				alert(datas.status);
			}else{
				isSubmit = false;
				alert("提交错误");
			}
			
		});
		return false;
	});
	
	
	
	var currentDate = new Date();
	currentDate.setDate(1);
	var monthFirstDay = jQuery.formatter(currentDate,"yyyy-MM-dd");
	
	
	$("#startDate").datetimepicker({
		format:"yyyy-mm-dd",
		startView:2, 
		minView:2,
		initialDate:monthFirstDay,
		endDate:new Date(),
		autoclose:true,
		language:"zh-CN"
		
	});
	$("#startDate").find("input").val(monthFirstDay);
	
	$("#endDate").datetimepicker({
		format:"yyyy-mm-dd",
		startView:2, 
		minView:2,
		endDate:new Date(),
		autoclose:true,
		language:"zh-CN"
		
	});
	$("#endDate").find("input").val(jQuery.formatter(new Date(),"yyyy-MM-dd"));
	
	
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
	
	$("#loadData").on("click",function(){
		if(!user_id){
			$("#no_login_alert").show();
		}
		initBillDatas(getQueryParams());
	});
	
	function getQueryParams(){
		var params = {};
		params.startDate = $("#startDate").find("input").val();
		params.endDate = $("#endDate").find("input").val();
		params.userIds = $("#userSelect").val();
		console.log(params);
		return params;
	}
	
	if(user_id && user_id>0){
		
		initBillDatas(getQueryParams());
	}
	
	function initBillDatas(d){
		
		var d = {
			startDate:d.startDate,
			endDate:d.endDate,
			userIds:d.userIds
			
		};
		$.ajax({
			type:"get",
			url:"/listBill",
			data:d,
			cache:false,
			dataType:"json"
		}).done(function(datas){
			if(datas && datas.code=="200"){
				initBillTable(datas.result);
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
	
	
	function initBillTable(datas){
		
		if(datas && datas.length > 0){
			var htmlArr = ['<thead>',
			      '<tr>',
			        '<th>昵称</th>',
			        '<th>时间</th>',
			        '<th>账单描述</th>',
			        '<th>金额</th>',
			        '<th>操作</th>',
			      '</tr>',
			    '</thead>'];
			for(var i=0; i < datas.length; i++){
				var data = datas[i];
				var trHtml = ['<tr>'];
				trHtml.push('<td>',data.user.nickName,'</td>');
				trHtml.push('<td>',data.billDate,'</td>');
				trHtml.push('<td>',data.description,'</td>');
				trHtml.push('<td>',data.amount,'</td>');
				trHtml.push('<td>');
				if(user_id == data.userId){
					trHtml.push('<a href="javascript:void(0);" class="billDelete" bill_id="',data.billId,'">删除</a>');
				}
				trHtml.push('</td>');
				trHtml.push('</tr>');
				htmlArr.push(trHtml.join(''));
			}
			$("#dataTable").html(htmlArr.join(''));
		}else{
			$("#dataTable").html('无数据');
		}
		
	}
	

	$("table").on("click",".billDelete",function(){
		var _this = $(this);
		var billId = _this.attr("bill_id");
		var btn = $("#show-delete-dialog-button");
		btn.click();
		$("#delete-sure").off("click").on("click",function(){
			//console.log(billId);
			deleteBill(billId);
		});
		return false;
	});
	function deleteBill(billId){
		$.ajax({
			type:"post",
			url:"/deleteBill",
			data:{billId:billId},
			cache:false,
			dataType:"json"
		}).done(function(datas){
			if(datas && datas.code=="200"){
				alert("删除成功");
				initBillDatas(getQueryParams());
			}else if(datas && datas.code=="400"){
				alert(datas.status);
				if(datas.status=="noLogin"){
					window.location.reload();
				}
			}
			else{
				alert("error~");
			}
		}).fail(function(e){
			alert(e);
		});
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
/**日期格式化*/
jQuery.formatter = function(dt,format,languageLables){ 
      if(typeof dt=="undefined" || dt==""){
	    return "";
      }
  if(typeof dt=="string"){
	    if(isNaN(dt-0)){    		
		    dt=$.parseDate(dt);    		
	    }else{    		 
		    if(dt.length==8){
			    var yearstr=dt.substring(0,4);    			
			    var monstr=dt.substring(4,6);
			    var daystr=dt.substring(6,8);
			    var fullStr=yearstr+"-"+monstr+"-"+daystr;
			    dt=$.parseDate(fullStr);
		    }    		
	    }
   }
   languageLables=languageLables?languageLables:{};
   if(!languageLables.months){
 	languageLables.months= ["JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"];
   }
   if(!languageLables.weekDays){
 	languageLables.weekDays=["SUNDAY","MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY","SATURDAY"];
   }
   
   var o =
   {
     "M+" : dt.getMonth()+1, //month
     "d+" : dt.getDate(),    //day
     "h+" : dt.getHours(),   //hour
     "m+" : dt.getMinutes(), //minute
     "s+" : dt.getSeconds(), //second,           
     "q+" : Math.floor((dt.getMonth()+3)/3),  //quarter
     "S" : dt.getMilliseconds() //millisecond           
   }

   for(var k in o)
   if(new RegExp("("+ k +")").test(format))
   format = format.replace(RegExp.$1,RegExp.$1.length==1 ? o[k] : ("00"+ o[k]).substr((""+ o[k]).length));
 
   if(/(y+)/.test(format))
   format=format.replace(RegExp.$1,(dt.getFullYear()+"").substr(4 - RegExp.$1.length));

   if(/(w)/.test(format))
   format=format.replace(RegExp.$1,languageLables.weekDays[dt.getDay()]);        
 
   if(/(E)/.test(format))
   format=format.replace(RegExp.$1,languageLables.months[dt.getMonth()]);
 
   return format;
 }