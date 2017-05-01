$(function(){
	$("#regist_button").click(function(){
		//TODO清除原有提示信息
		
		//获取表单信息
		var name = $("#regist_username").val().trim();
		var nick = $("#nickname").val().trim();
		var password = $("#regist_password").val().trim();
		var final_password = $("#final_password").val().trim();
		//检测表单信息格式
		//发送ajax请求
		$.ajax({
			url:"http://localhost:8088/cloud_note/user/regist.do",
			type:"post",
			data:{"name":name,"password":password,"nickname":nick},
			dataType:"json",
			success:function(result){				
				if(result.status==0){
					alert(result.msg);
					$("#back").click();//触发返回按钮的单击
				}else if(result.status==1){//用户名被占用					
					$("#warning_1 span").html(result.msg);
					$("#warning_1").show();//显示提示div消息区
				}
			},
			error:function(){
				alert("注册发生异常");
			}
		});
	});

});