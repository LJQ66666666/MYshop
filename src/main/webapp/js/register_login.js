//页面加载完成后执行
$(document).ready(function(){
	//绑定用户注册
	$("#button1").off('click').on('click',function(){
		save();
	});
	//绑定用户登录
	$('#button2').off('click').on('click',function(){
		$.ajax({
			type:'post',
			url:'user/login',
			data:{
				"userCode":$('#userCode').val(),
				"userPass":$('#userPass').val()
			},
			dataType:'json',
			success : function(result) {
				if (result == 0) {
					if (confirm("账号或密码错误，请重新输入!")) {
					}
				} else {
					window.location.href = "index";

				}

			}
		});
	});
	//绑定管理员登录
	$('#button3').off('click').on('click',function(){
		$.ajax({
			type:'post',
			url:'user/adminlogin',
			data:{
				"adminCode":$('#adminCode').val(),
				"adminPass":$('#adminPass').val()
			},
			dataType:'json',
			success:function(result){
				if(result){
					window.location.href = "index2";
				}else{
					alert('管理员用户或密码错误，请重新输入');
				}
			}
		});
	});
//绑定退出登录
	$('#exit').off('click').on('click',function(){
		if(confirm("你确定要退出吗？")){
			$.ajax({
				type:'post',
				url:'user/exit',
				success:function(result){
					if(result){
						window.location.href='index';
					}
				}
			});
		}
	});
	
});
//上边是绑定事件，下边是书写方法
function save(){
	$.ajax({
		type:'post',
		url:'user/add',
		data:$('#form_user_add').serialize(),
		dataType:'json',
		success:function(result){
			if(result){
				$('#form_user_add').submit();
				window.location.href = 'login';
				alert("注册成功，请登录");
			}
		}
		
	});
}

