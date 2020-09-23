var sumpage=0
var vm = new Vue({
	el:"#c_table",
	data:{
		list:getAllcomment()
	}
})

window.onload = function(){
	getPage(sumpage,test)
	//vm.list = selectPl(pageIndex)
	//getPage(sumpage1,test)
	//alert(sumpage1)
}
function test(){
	vm.$data.list=getAllcomment()
	//vm1.$data.L_list=selectLoseIntegral()
}
function getAllcomment(){
	var list
	$.ajax({
		url:"http://localhost:8080/comment/selectAdmin",
		async:false,
		dataType:"json",
		data:{"pageNum":pageIndex,"pageSize":6},
		success:function(data){
			getAllcomment1()
			list=data.data.list
			//alert(data)
		}
	})
	return list
}

function getAllcomment1(){
	$.ajax({
		url:"http://localhost:8080/comment/selectAdmin",
		async:false,
		dataType:"json",
		success:function(data){
			sumpage = Math.ceil(data.data.list.length/6)
			// sumpage=data.data.length
			//alert(data)
		}
	})
}

function deleteComment(id){
	$.ajax({
		url:"http://localhost:8080/comment/updateDis",
		async:false,
		dataType:"json",
		data:{"id":id,"dis":"0"},
		success:function(data){
			alert(data.msg)
			//alert(data)
			vm.$data.list = getAllcomment()
		}
	})
}

//禁用
function getCantComment(id){
	$.ajax({
		url:"http://localhost:8080/comment/updateDis",
		async:false,
		dataType:"json",
		data:{"dis":"5","id":id},
		success:function(data){
			alert(data.msg)
			//alert(data)
			vm.$data.list = getAllcomment()
		}
	})
}

//解禁
function LoseCantComment(id){
	$.ajax({
		url:"http://localhost:8080/comment/updateDis",
		async:false,
		dataType:"json",
		data:{"dis":"1","id":id},
		success:function(data){
			alert(data.msg)
			//alert(data)
			vm.$data.list = getAllcomment()
		}
	})
}