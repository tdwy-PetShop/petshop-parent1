var getCookie=readCookie("admin")
if(getCookie==""){
	location.href="login.html"
}
//全局变量
var _pageIndex = 1	//当前页
var _pageSize=6 		//每页显示多少数据
var _quantity		//总记录
var _pageId			//分页所在的DIV
var _endPage		//最后一页


//----------------------分页

var vm=new Vue({
	el:"table",
	data:{
		slist:getData()
		
	},
	methods:{
		member_stop(id,dis){
			member_stop1(id,dis)
			},
		menber_del(id){
			 member_del(id)
		}
		
		}
})


	function search2(){
		var tel=$("#mytel").val()
		if(checked1()){
			
			vm.$data.slist=getTelUser(tel)
			
		}else{
			
			layer.msg('请输入手机号!',{icon: 5,time:1000});
		}
		
	}
	function getTelUser(tel){
		var arr=new Array()
		var list="";
		$.ajax({
			url:"http://localhost:8080/user/selectByTel",
			type:"post",
			data:{"tel":tel},
		    dataType:"json",
			async:false,
			success:function(data){
				
				list=data.data
				arr[0]=list
			}
			
		})
		//alert(arr)
		return arr
		
		
	}
	function checked1(){
		var flag=false
		var tel=$("#mytel").val()
		var regTel=/^1(3|4|5|6|7|8|9)\d{9}$/
		if(regTel.test(tel)){
			flag=true			
		}
		return flag
		}
	  /*用户-停用*/
	function member_stop1(id,dis){
				
	        if(dis==1){
					
					layer.confirm('确定解冻此用户？',function(index){
					var i=deleteUser(id,dis)
	          //发异步把用户状态进行更改
					if(i>0){
						var count = document.getElementById("table1").rows.length;
			
						if(count>2||_quantity==1){
							
							 vm.$data.slist=getData()
						}else{
							 vm.$data.slist=getTelUser($("#mytel").val())
							
						}
						
						layer.msg('已启用!',{icon: 6,time:1000});
					}else{
						layer.msg('服务器异常!',{icon: 5,time:1000});
					}
	         
			});
	        }else if(dis==5){
					layer.confirm('确定冻结此用户？',function(index){
					 var i=deleteUser(id,dis)
					 if(i>0){
						  
						 layer.msg('已停用!',{icon: 5,time:1000});
						 	var count = document.getElementById("table1").rows.length;
					
						 if(count>2||_quantity==1){
						 	
						 	 vm.$data.slist=getData()
						 }else{
						 	 vm.$data.slist=getTelUser($("#mytel").val())
						 	
						 }
						 
					 }else{
						 layer.msg('服务器异常!',{icon: 5,time:1000});
						 
					 }
	        });
	        }
	       
	   
	}
	
	/*用户-删除*/
	function member_del(id){
		
	   
	        //发异步删除数据
			layer.confirm('确认要删除吗？',function(index){
				  var i=deleteUser(id,0)
				  if(i>0){
					 
					//$(obj).parents("tr").remove();
	        layer.msg('已删除!',{icon:1,time:1000}); 
			 	var count = document.getElementById("table1").rows.length;
			 	var tel1= $("#mytel").val()
			if(!(tel1)&&count==2){
				
				_pageIndex=_pageIndex-1;
				 vm.$data.slist=getData()
			}
			 if((count>2||_quantity==1)){
				
			 	 vm.$data.slist=getData()
			 }else if($("#mytel").val()){
			 	 vm.$data.slist=getTelUser($("#mytel").val())
			 	
			 }
			 _quantity=getCount1();
			initPagin(_quantity,"page")
				  }else{
					 
					  layer.msg('服务器异常!',{icon:1,time:1000}); 
				  }
	        });
	   
	}
	
	
	
	


$(function(){
	//页面加载就获取用户数量
	_quantity=getCount1();
	initPagin(_quantity,"page")
	
	
})

function deleteUser(id,dis){
	
	var list="";
	$.ajax({
		url:"http://localhost:8080/user/updateDis",
		type:"post",
		data:{"id":id,"dis":dis},
	    dataType:"json",
		async:false,
		success:function(data){
			
			list=data.status
			
		}
		
	})
	
	return list
}
function getData(){
		var list="";
		$.ajax({
			url:"http://localhost:8080/user/selectAll",
			type:"post",
			data:{"pageNum":_pageIndex,"pageSize":_pageSize},
	        dataType:"json",
			async:false,
			success:function(data){
				
				list=data.data.list
				
			}
			
		})
		
		return list
}

function getCount1(){
		var list="";
		$.ajax({
			url:"http://localhost:8080/user/selectAll",
			type:"post",
	        dataType:"json",
			async:false,
			success:function(data){
				
				list=data.data.total
				
			}
			
		})
		
		return list
}



/**
 * 初始化分页方法，使用此工具调用此方法即可
 * quntity:数据数量
 * pageId:分页DIV的ID
 * pageSize:每页显示数量，不给的话默认为10
 * */
function initPagin(quantity,pageId,pageSize){
	_quantity = quantity
	_pageId = pageId
	/* if(pageSize)
		_pageSize = pageSize
	else
		_pageSize = 10 */
	_endPage = Math.ceil(_quantity/_pageSize)
	
	createPagin(_pageIndex,_pageSize,_endPage,_pageId)
}

/**
 * pageIndex:当前页
 * pageSize:每页记录条数
 * endPage:最后一页
 * pageId:分页div的id
 * */
 
/* <a class="prev" href="">&lt;&lt;</a>
 <a class="num" href="">1</a>
 <span class="current">2</span>
 <a class="num" href="">3</a>
 <a class="num" href="">489</a>
 <a class="next" href="">&gt;&gt;</a> */
function createPagin(pageIndex,pageSize,endPage,pageId){
	var pagin = document.querySelector("#"+pageId)
	pagin.innerHTML = " <a href='#' onclick='setPageIndex("+(pageIndex==1?1:pageIndex-1)+")' class='page'>&lt;&lt;</a> "
	pagin.innerHTML += " <a href='#' onclick='setPageIndex(1)' class='page'>1</a> "
	if(endPage<=12){
		pagin.innerHTML += createPaginFor(2,endPage-1)
	}else if(pageIndex<=7){
		pagin.innerHTML += createPaginFor(2,12)
		pagin.innerHTML += " ... "
	}else if(pageIndex>=endPage-6){
		pagin.innerHTML += " ... "
		pagin.innerHTML += createPaginFor(endPage-11,endPage-1)
	}else{
		pagin.innerHTML += " ... "
		pagin.innerHTML += createPaginFor(pageIndex-5,pageIndex+5)
		pagin.innerHTML += " ... "
	}
	if(endPage!=1)
		pagin.innerHTML += " <a href='#' onclick='setPageIndex("+endPage+")' class='page'>"+endPage+"</a> ";
	pagin.innerHTML += " <a href='#' onclick='setPageIndex("+(pageIndex==endPage?endPage:pageIndex+1)+")' class='page'>&gt;&gt;</a> "
	setPageCss()
}

function createPaginFor(begin,end){
	var msg = "";
	for(var i=begin;i<=end;i++){
		msg += " <a href='#' onclick='setPageIndex("+i+")' class='page'>"+i+"</a> "
	}
	return msg;
}

//分页触发的事件
function setPageIndex(pageIndex){
	_pageIndex = pageIndex
		
	vm.$data.slist=getData()
	
	createPagin(_pageIndex,_pageSize,_endPage,_pageId)
}

//设置分页样式
function setPageCss(){
	var pages = document.querySelectorAll("a[class='page']")
	for(var i=0;i<pages.length;i++){
		if(pages[i].innerHTML==_pageIndex)
			setAtStyle(pages[i])
		else
			setAllStyle(pages[i])
	}
}

//设置所有样式
function setAllStyle(aid){
	aid.style.color = "gray"
	aid.style.textDecoration = "none"
	aid.style.border = "1px solid gray"
	aid.style.paddingRight = "5px"
	aid.style.paddingLeft = "5px"
	aid.style.textAlign = "center"
}

//设置当前选择的样式
function setAtStyle(aid){
	aid.style.backgroundColor = "#009393"
	aid.style.color = "#6c6c6c"
	aid.style.textDecoration = "none"
	aid.style.border = "1px solid gray"
	aid.style.paddingRight = "5px"
	aid.style.paddingLeft = "5px"
	aid.style.textAlign = "center"
	
}

