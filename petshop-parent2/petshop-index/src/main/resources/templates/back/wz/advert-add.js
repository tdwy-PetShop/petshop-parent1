var getCookie=readCookie("admin")
if(getCookie==""){
	location.href="login.html"
}
function addAdvert(){
	$.ajax({
		url:"http://localhost:8080/advert/add",
		type:"post",
		data:new FormData($("form")[0]),
		processData:false,
		contentType:false, 
	    dataType:"json",
		async:false,
		success:function(data){
			alert(data.msg)
			xadmin.close();
			
			// 可以对父窗口进行刷新 
			xadmin.father_reload();
		}
		
	})
	}