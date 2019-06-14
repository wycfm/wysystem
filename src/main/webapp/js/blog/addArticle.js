$(function(){
	
	
	
	//-------content table submit----
	var isSubmit = false;
	$("#articleSubmit").submit(function(datas) { 
		if(isSubmit){
			return false;
		}
		isSubmit = true;
		/*if(!user_id){
			$("#no_login_alert").show();
			return false;
		}*/
		var _title = $("input[name=title]");
		var _desc = $("textarea[name=description]");
		var _tag = $("input[name=contentTag]");
		var titleV = _title.val();
		var descV = _desc.val();
		var tagV = _tag.val();
		var txt = getContent();
		var typeId = $("input[name='content_type']:checked").val();
		if(!titleV || !descV || !tagV || !txt){
			
			isSubmit = false;
			return false;
		}
		/*
		 * 
		c.setTitle(request.getParameter("title"));
		c.setTxt(request.getParameter("txt"));
		c.setDescription(request.getParameter("description"));
		c.setTypeId(Integer.valueOf(request.getParameter("typeId")));
		c.setContentTag(request.getParameter("tagName"));
		 */
		var d = {
				title:titleV,
				description:descV,
				tagName:tagV,
				typeId:typeId,
				txt:txt
		}
		console.log(d);
		
		//return false;
		$.ajax({
			type:"post",
			url:"/content/add",
			data:d,
			dataType:"json",
			cache: false
		}).done(function(datas){
			console.log(datas);
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