$(function(){
	//清除提示信息
	$("#count_msg").html("");
	$("#password_msg").html("");
	//给按钮追加单击处理
	$("#login").click(function(){
		//获取请求数据
		var name = $("#count").val().trim();
		var password = $("#password").val().trim();
		//检查数据格式
		var ok = true;
		if(name==""){
			$("#count_msg").html("用户名不能为空");
			ok = false;
		}
		if(password==""){
			$("#password_msg").html("密码不能为空");
			ok = false;
		}
		if(ok){
		//发送ajax请求
		$.ajax({
			url:"http://localhost:8088/cloud_note/user/login.do",
			type:"post",//提交请求的方式建议用post
			data:{"name":name,"pwd":password},//要提交的数据
			dataType:"json",//返回的数据类型
			success:function(result){//回调函数
			  //result 是服务器返回的json结果
				if(result.status==0){//成功
					//获取用户id,写入cookie
					var userId = result.data;
					addCookie("uid",userId,2);//存储2小时
					window.location.href="edit.html";//跳转edit.html
				}else if(result.status==1){//用户名不存在
					$("#count_msg").html(result.msg);	
				}else if(result.status==2){
					$("#password_msg").html(result.msg);
				}									  					
			}
		});
		}// end if
	});		
});