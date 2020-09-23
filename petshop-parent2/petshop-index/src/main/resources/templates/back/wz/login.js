
function login(){
	var username=$("#username").val()
	var pwd=$("#pwd").val()
	$.ajax({
		url:"http://localhost:8080/admin/login",
		type:"post",
		data:{
			"username":username,
			"password":pwd
			},
	    dataType:"json",
		async:false,
		success:function(data){
			if(data.status==1){
				
				setCookie("admin", "true")
				location.href="index.html"
			}else{
				layui.use('layer', function(){
					var layer = layui.layer;
					 layer.msg(data.msg);
				});
			}
		}
		
	})
}

