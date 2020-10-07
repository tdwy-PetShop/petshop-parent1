/*var getCookie=readCookie("admin")
if(getCookie==""){
	location.href="login.html"
}*/
function addType(){
	$.ajax({
		url:"http://localhost:8080/type/add",
		type:"post",
		data:$("form").serialize(),
		
	    dataType:"json",
		async:false,
		success:function(data){
			alert(data.msg)
			xadmin.close();
			
		}
		
	})
}